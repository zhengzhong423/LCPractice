package groovyDemo;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

public class GroovyMain {
    public static void main(String[] args) throws MalformedURLException {
        ConfigObject conf = new ConfigSlurper().
                parse((Paths.get("src", "main/resource/lc.groovy").toFile()).toURI().toURL());
        System.out.println(conf);
        
        ArrayList<?> tables = (ArrayList<?>) conf.get("tablesToRunTableLevelValidation");
        ConfigObject vConf = (ConfigObject) conf.get("validation");
        for (Object table: tables) {
            ConfigObject tableConf = (ConfigObject) vConf.get(table);
            if (tableConf != null) {
                System.out.println(tableConf.get("groovyScript"));
            }
        }
    }
}
