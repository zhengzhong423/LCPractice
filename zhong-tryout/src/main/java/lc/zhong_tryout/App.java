package lc.zhong_tryout;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main( String[] args )
    {
	    List<String> a1 = Arrays.asList("2009-05-18", "2009-05-19", "2009-05-21");
	    List<String> a2 = Arrays.asList("2009-05-18", "2009-05-18", "2009-05-19", "2009-05-19", "2009-05-20", "2009-05-21","2009-05-21", "2009-05-22");

	    List<String> result = a2.stream().filter(elem -> !a1.contains(elem)).collect(Collectors.toList());
	    System.out.println(a1);
	    System.out.println(a2);
	    System.out.println(result);
	    
	    System.out.println(Math.round(10000 * 255/272)/ 100.0d);
	    StringBuilder sb = new StringBuilder();
	    sb.append("\"");
	    System.out.println(sb);
        Pattern p = Pattern.compile("A(BC)(B*)(B*)");
        String str = "ABCBBBC";
        
        Matcher m = p.matcher(str);
        m.find();
        System.out.println(m.group(2));
        
        for(int i = 0 ;i < 10; i++) {
            final int val = i;
            System.out.println(i);
        }
    }
}
