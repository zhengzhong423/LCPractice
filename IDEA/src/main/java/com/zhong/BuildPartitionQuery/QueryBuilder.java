package com.zhong.BuildPartitionQuery;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class QueryBuilder {
    public static void main(String[] args) {
        List<String> columnList = Arrays.asList(
            new String[]{"id" ,"version" , "created_d", "modified_d", "cr_model_run_id", "stage_cd", "run_data"});
        LocalDate date = LocalDate.of(2016, 12,01);
        LocalDate tillDate = LocalDate.of(2017, 12, 01);
        for (; date.isBefore(tillDate); date = date.plusDays(10)) {
            generateScriptByMonth(columnList, date);
        }
    }

    private static void generateScriptByMonth(List<String> columnList, LocalDate date) {
        String str = "insert into lcuser_zhzheng.zhong_cr_model_run_data partition(`partition_date`) select ";
        for (String col: columnList) {
            str += ("`" + col + "`, ");
        }
        str += "date_format(`created_d`, 'yyyy-MM-dd') from lc20_cds_history.cr_model_run_data_2017_08_01 where ";
        str += "created_d > '" + date + "' and created_d <= '" + date.plusDays(10) + "' distribute by date_format(`created_d`, 'yyyy-MM-dd');";
        System.out.println(str);
    }
}