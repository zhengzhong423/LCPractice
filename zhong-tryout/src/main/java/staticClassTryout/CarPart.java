package staticClassTryout;

public class CarPart {
	
    private static int factoryID = 1;
    
    public static class Wheel {
    	private static int wheelId = 1;
    	
        public Wheel() {
            System.out.println("Wheel factory ID: " + factoryID++);
            System.out.println("CarParts ID: " + wheelId++);
        }
    }

    public CarPart() {
        System.out.println("Car Parts object created!");
    }
    

}
