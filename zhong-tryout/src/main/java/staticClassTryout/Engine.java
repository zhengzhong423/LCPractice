package staticClassTryout;

public class Engine extends CarPart{
    private int id ;
    public Engine(int id) {
        this.id = id;
        System.out.println(this.getClass().getName() + " : " + id);
    }
}
