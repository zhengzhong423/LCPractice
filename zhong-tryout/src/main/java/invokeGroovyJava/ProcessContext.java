package invokeGroovyJava;

import java.math.BigDecimal;

public class ProcessContext {
    public BigDecimal getRowCount(String tableName, Number num) {
        System.out.println(tableName);
        return new BigDecimal(num.doubleValue());
    }

    public boolean NotNullColumn(String fieldName) {
        return false;
    }
    
    public StatsObj getStats(String tableName) {
        return new StatsObj(tableName + "Stats");
    }
}
