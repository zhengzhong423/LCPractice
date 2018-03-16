package staticClassTryout;

import lombok.*;

public class App {
    private @Getter int num = 100;
    
    class innerClass {
        int k = num;
        public innerClass() {
            System.out.println(k);
        }
    }
    
	public static void main(String[] args) {
	    String[] a = {"abc", "cde"};
	    System.out.println(a);
		new CarPart.Wheel();
		new CarPart.Wheel();
		new CarPart.Wheel();
		new Engine(10);
		new App().new innerClass();
		
		CarPart cp = new Engine(10);
		System.out.println(cp.getClass().equals(Engine.class));
	}
}
