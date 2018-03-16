package reflectFeilds;

import java.lang.reflect.Field;

import lombok.Getter;

public class Dummy {
    @Getter private Integer a;
    @Getter private Integer b;
    public final int c;
    
    public Dummy(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Dummy du = new Dummy(1, 2, 3);
        du.reflectGo();
    }

    public void reflectGo() throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            System.out.println(f.getType().equals(int.class));
        }
    }
}
