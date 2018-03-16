package outputStreamTRY;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) {
        byte[] b = "HAHAHA".getBytes();
        try {
            // create a new output stream
            DataOutputStream os = new DataOutputStream(new FileOutputStream("src/main/resource/Person.csv"));
//
//            // craete a new input stream
//            InputStream is = new FileInputStream("test.txt");

            // write something
            
            os.writeBytes("AAAABBBB,BBB");
            os.write('\n');
            os.writeBytes("AAAABBBB,BBB\n");
            os.writeBytes("AAAAA\n");
            os.writeBytes("AAAABBBB,BBB");

         } catch (Exception ex) {
            ex.printStackTrace();
         }
    }
}
