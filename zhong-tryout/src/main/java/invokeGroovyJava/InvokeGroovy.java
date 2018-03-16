package invokeGroovyJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class InvokeGroovy {
    private final String SCRIPT_PATH = "src/main/resource/script.groovy";
    private final String INIT_METHOD_NAME = "init";
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        GroovyClass groovyClass = new GroovyClass();
        String[] strs = groovyClass.swapValues("abc", "cba");
        System.out.println(strs[0] + "," + strs[1]);

        System.out.println(groovyClass.getRowCount("tlc.lc_loan"));

        System.out.println(groovyClass.checkNotNullColumns(strs)[0] + "," +
                groovyClass.checkNotNullColumns(strs)[1]);
    }
    
    public Script initScript() throws FileNotFoundException, IOException {
        Binding binding = new Binding();
        binding.setVariable("ctx", new ProcessContext());
        GroovyShell shell = new GroovyShell(binding);
        File scriptPath = new File(SCRIPT_PATH);

        try (Reader reader = new InputStreamReader(new FileInputStream(scriptPath))) {
            Script script = shell.parse(reader);
            // call the init() method if present
            Method[] methods = script.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().equals(INIT_METHOD_NAME)) {
                    script.invokeMethod(INIT_METHOD_NAME, null);
                    break;
                }
            }
            return script;
        }
    }
}
