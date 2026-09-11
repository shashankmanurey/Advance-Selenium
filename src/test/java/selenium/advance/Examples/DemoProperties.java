package selenium.advance.Examples;

import java.io.FileInputStream;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception {
        //step 1
        FileInputStream file = new FileInputStream("src/main/resources/DDT/commondata.properties");
        //step 2
        Properties p = new Properties();
        p.load(file);
        //step 3
        System.out.println(p.getProperty("url"));
        
    }
}
