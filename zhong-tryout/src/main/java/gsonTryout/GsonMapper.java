package gsonTryout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonMapper {
    Gson gson = new Gson();
    private final static String PATH = "src/main/resource/Person.json";
    
    public static void main(String[] args) throws IOException {
        GsonMapper gm = new GsonMapper();
        String str = getStringFromFile(PATH);
        Person[] people = gm.gson.fromJson(str, Person[].class);
        System.out.println(people[0].friends);
    }

    private static String getStringFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
    
}
