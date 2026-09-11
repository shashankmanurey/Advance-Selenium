package selenium.advance.Examples;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DemoJson {
    public static void main(String[] args) throws Exception {

        FileReader f = new FileReader("src/main/resources/DDT/Data.json");
        JSONParser j = new JSONParser();
        Object obj = j.parse(f);
        JSONObject json = (JSONObject) obj;
        
        String browser = json.get("browser").toString();
        String url = json.get("url").toString();
        String username = json.get("username").toString();
        String password = json.get("password").toString();

        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        f.close();
    }
}