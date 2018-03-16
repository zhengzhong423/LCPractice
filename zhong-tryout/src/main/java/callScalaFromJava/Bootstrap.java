package callScalaFromJava;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
        ScalaGreeting sg = new ScalaGreeting();
        List<String> arr = new ArrayList<>();
        arr.add("Zhong");
        arr.add("Xinyu");
        System.out.println("\n" + sg.greet(arr.toArray(new String[2])));
    }
}
