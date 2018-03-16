package lc.zhong_tryout;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ZhongDate {

    public static void main(String[] args) {
//        String str = "2017-04-18 18:28:58.789678";
//        LocalDateTime ldt = GoldenGateHiveUtils.convertMaxOrMinTimestampValueToLocalDateTime(str);
//        System.out.println(ldt);
//        
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String maxDateStr = ldt.format(formatter);
//        System.out.println(maxDateStr);
        String str1 = "2017-04-25 00:04:28.424936";
        String str2 = "2017-04-24 19:59:58.062843";
        
        if (str1.compareTo(str2) >= 0) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        
        LocalDateTime ldt = LocalDateTime.now();//2017-05-18T12:17:00.628
        LocalDateTime parsed = LocalDateTime.parse("2017-05-18T12:17:00.628");
        System.out.println(parsed.getHour());
        
    }

}
