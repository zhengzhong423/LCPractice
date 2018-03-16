package instance;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InstanceTRY {
    private static final DecimalFormat DF2 = new DecimalFormat("###.######");

    public static void main(String[] args) {
        System.out.println(DF2.format((double) 234*1000000d/23466345d));
//        System.out.println(new BigDecimal("324894375873486"));
//        System.out.println(LocalDateTime.now().minusDays(10).toLocalDate().toString());
//        System.out.println((double)10L/(double)4L);
//        List<String> list1 = new LinkedList<>();
//        System.out.println(LinkedList.class.isInstance(list1));
//
//        Object[] inputRow = new Object[2];
//        inputRow[0] = new Object();
//        inputRow[1] = new Object();
//        String[] strs = (String[]) Arrays.copyOf(inputRow, inputRow.length, Object[].class);
//        System.out.println(inputRow[0]);
    }

}
