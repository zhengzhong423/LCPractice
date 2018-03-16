package invokeGroovyJava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import groovy.lang.Script;

public class GroovyClass {
    public Script script;

    private final String GO_GROOVY = "swapValues";
    private final String ROW_COUNT = "getRowCount";
    private final String CHECK_NULL = "notNullColumns";
    private final String STATS_OBJ = "statsObj";
    
    public GroovyClass() throws FileNotFoundException, IOException {
        script = new InvokeGroovy().initScript();
    }

    public String[] swapValues(String str1, String str2) {
        return (String[]) script.invokeMethod(GO_GROOVY, new Object[] {
                str1, str2});
    }
    
    public BigDecimal getRowCount(String tableName) {
        return (BigDecimal)script.invokeMethod(ROW_COUNT, new Object[]{tableName}); 
    }
    
    public String[] checkNotNullColumns(String[] strs) {
        return (String[])script.invokeMethod(CHECK_NULL, Arrays.copyOf(strs, strs.length, Object[].class)); 
    }

    public StatsObj getStats(String tableName) {
        System.out.println("hahaha");
        return (StatsObj)script.invokeMethod(STATS_OBJ, new Object[]{tableName}); 
    }

}
