package invokeGroovyJava;

public class StatsObj {
    String tableName;
    public StatsObj(String str) {
        this.tableName = str;
    }

    public String toString() {
        return "STATS OBJ:" + tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
