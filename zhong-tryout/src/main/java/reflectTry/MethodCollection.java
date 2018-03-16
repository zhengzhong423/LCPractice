package reflectTry;

import java.util.List;

public class MethodCollection {

    public MethodCollection() {
        // TODO Auto-generated constructor stub
    }
    
    public void method1() {
        System.out.println("M1");
    }
    
    public void method2(List<?> args) {
        System.out.println("M1 " + args.get(0) + args.get(1));
    }
    
    public void method3(String name) {
        System.out.println("M1 " + name);
    }

}
