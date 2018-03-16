package reflectTry;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        MethodCollection mc = new MethodCollection();
        Method s = mc.getClass().getMethod("method2", List.class);
        List<String> strs = Arrays.asList(new String("-1, YYYY-DD-MM").split(",")).
                stream().map(k -> k.trim()).collect(Collectors.toList());
        s.invoke(mc, (List<String>)strs);
    }

}
