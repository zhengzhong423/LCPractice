package com.zhong.xmlToJson;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlToJson {
    public static void main(String[] args) {
        XmlToJson parser = new XmlToJson();
        parser.ExcelReader("/Users/zhzheng/Desktop/encrypt.xlsx");
    }

    public void ExcelReader(String path)  {
        JSONObject json = new JSONObject();
        try (FileInputStream fs = new FileInputStream(path)) {
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            rows.next();
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                List<String> cellList = new ArrayList<>();

                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    cellList.add(cell.toString());
                }
                if (cellList.get(0).trim().isEmpty()) {
                    break;
                }
                System.out.println(cellList);
                String key = "edh.enc_" + cellList.get(0).toLowerCase().trim() + "." + cellList.get(1).toLowerCase().trim();
                JSONObject keyInfo = new JSONObject();
                keyInfo.put("key_name", cellList.get(2));
                keyInfo.put("locator_sig", "");
                keyInfo.put("current_version", 1);
                json.put(key, keyInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}
