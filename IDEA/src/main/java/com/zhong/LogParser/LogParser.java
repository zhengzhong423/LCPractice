package com.zhong.LogParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogParser {
    public static void main(String[] args) {
        LogParser lp = new LogParser();
        lp.getExceptionLine().stream()
            .map(l -> l.substring(l.indexOf("rt_cdc")))
            .filter(l -> l.length() > 6 && l.charAt(6) == '/')
            .map(l -> l.split("/"))
            .map(arr -> arr[1] + "_rt_cdc." + arr[2])
            .distinct()
            .map(l -> "alter table " + l + " drop partition( op_ts_date='2017-06-06');")
            .forEach(System.out::println);
    }

    private List<String> getExceptionLine() {
        String filePath = "/Users/zhzheng/Desktop/LS.log";
        List<String> rs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                if (line.contains("java.io.FileNotFoundException")) {
                    rs.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs;
    }
}