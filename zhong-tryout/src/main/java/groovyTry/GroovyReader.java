package groovyTry;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

public class GroovyReader {
//    private Map<String, Map<String, ConfigObject>> globalTableConf = new HashMap<>();
//    private Map<String, Map<String, ConfigObject>> schemaTableConf = new HashMap<>();
    private Map<String, Map<String, ConfigObject>> tableConf = new HashMap<>();

    public static void main(String[] args) throws MalformedURLException {
        GroovyReader groovyReader = new GroovyReader();

        ConfigObject ingestionConf = new ConfigSlurper("Ingestion").
                parse(new File("src/main/resource/conf.groovy").toURI().toURL());
        groovyReader.initTableConf(ingestionConf);

        System.out.println(groovyReader.readCombinedTableConf("tlc", "lc$pd"));
        System.out.println(groovyReader.readCombinedTableConf("tlc", "*"));
        System.out.println(groovyReader.readCombinedTableConf("wm", "*"));
        System.out.println(groovyReader.readCombinedTableConf("tlc", "lc$offer"));
        System.out.println();

        ConfigObject validatorList = groovyReader.readCombinedTableConf("tlc", "lc$pd");
        for (Object validator: validatorList.keySet()) {
            System.out.println("VALIDATOR: " + (String) validator);
            ConfigObject vConf = (ConfigObject) validatorList.get(validator);
            Properties prop = vConf.toProperties();
            System.out.println("tableName: " + prop.getProperty("tableName"));
            System.out.println("skipValidation " + prop.getProperty("skipValidation"));
            System.out.println("sendEmailIfFailed " + prop.getProperty("sendEmailIfFailed"));
//            for (Object key: prop.keySet()) {
//                System.out.println(prop.get(key));
//            }
            System.out.println();
        }
        ConfigObject qaConf = new ConfigSlurper("QA").
                parse(new File("src/main/resource/conf.groovy").toURI().toURL());
        System.out.println(qaConf);
        ConfigObject qaList = ((ConfigObject) qaConf.get("tlc.lc$lead"));
        for (Object validator: qaList.keySet()) {
            System.out.println("VALIDATOR: " + (String) validator);
            ConfigObject vConf = (ConfigObject) qaList.get(validator);
            for (Object key: vConf.keySet()) {
                System.out.print(Arrays.asList(vConf.get(key).toString().split(",")).stream().map(str -> str.trim()).collect(Collectors.joining("\n")));
                System.out.println();
            }
        }
    }

    private ConfigObject readCombinedTableConf(String schema, String tableName) {
        ConfigObject conf = deepcopy(getTableConf("*", "*"));
        conf.merge(getTableConf(schema, "*"));
        conf.merge(getTableConf(schema, tableName));
        return conf;
    }

    private ConfigObject getTableConf(String schemaName, String tableName) {
        if (tableConf.containsKey(schemaName)) {
            if (tableConf.get(schemaName).containsKey(tableName)) {
                return tableConf.get(schemaName).get(tableName);
            } else if (tableConf.get(schemaName).containsKey("*")){
                return tableConf.get(schemaName).get("*");
            } else {
                return new ConfigObject();
            }
        } else {
            if (tableConf.containsKey("*") && tableConf.get("*").containsKey("*")) {
                return tableConf.get("*").get("*");
            } else {
                return new ConfigObject();
            }
        }
    }

    private void initTableConf(ConfigObject conf) {
        for(Object tableFullNameObj: conf.keySet()) {
            String tableFullName = (String)tableFullNameObj;
            StringTokenizer st = new StringTokenizer(tableFullName, "\\.");
            String schemaName = st.nextToken();
            String tableName = st.nextToken();
            ConfigObject confObj = (ConfigObject) conf.get(tableFullName);
            if (!tableConf.containsKey(schemaName)) {
                tableConf.put(schemaName, new HashMap<String, ConfigObject>());
            }
            tableConf.get(schemaName).put(tableName, confObj);
        }
    }

    private ConfigObject deepcopy(ConfigObject orig) {
        ConfigObject copy = new ConfigObject();
        for (Object key: orig.keySet()) {
            Object val = orig.get(key);
            if (val instanceof ConfigObject) {
                val = deepcopy((ConfigObject)val);
            }
            copy.put(key, val);
        }
        return copy;
    }

//  private void initGlobalTableConf(ConfigObject conf) {
//  ConfigObject tableConf = (ConfigObject)conf.get("*.*");
//  globalTableConf.put("*", new HashMap<>());
//  globalTableConf.get("*").put("*", tableConf);
//}

//    private void writeTableConf(String tableFullName, ConfigObject conf,
//            Map<String, Map<String, ConfigObject>> schemaOrSpecTableConf) {
//        StringTokenizer st = new StringTokenizer(tableFullName, "\\.");
//        String schemaName = st.nextToken();
//        String tableName = st.nextToken();
//        ConfigObject tableConf = (ConfigObject) conf.get(tableFullName);
//        schemaOrSpecTableConf.put(schemaName, new HashMap<>());
//        schemaOrSpecTableConf.get(schemaName).put(tableName, tableConf);
//    }
}
