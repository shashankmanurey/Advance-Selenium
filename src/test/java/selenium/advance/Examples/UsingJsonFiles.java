package selenium.advance.Examples;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingJsonFiles {

    public static void main(String[] args) throws Exception {

        // Read JSON file
        FileReader f = new FileReader("src/main/resources/DDT/Data.json");

        JSONParser j = new JSONParser();

        Object obj = j.parse(f);

        JSONObject json = (JSONObject) obj;

        // Read values from JSON
        String browser = json.get("browser").toString();
        String url = json.get("url").toString();
        String username = json.get("username").toString();
        String password = json.get("password").toString();

        // Print values
        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        // Close JSON file
        f.close();

        // Browser opening
        WebDriver d = null;

        if (browser.equalsIgnoreCase("chrome")) {

            d = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            d = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            d = new FirefoxDriver();

        } else {

            System.out.println("Invalid browser: " + browser);
            return;
        }

        // Browser settings
        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open URL
        d.get(url);

        // Login
        d.findElement(By.id("user-name")).sendKeys(username);

        d.findElement(By.id("password")).sendKeys(password);

        d.findElement(By.id("login-button")).click();

        // Close browser
        Thread.sleep(2000);
        d.quit();
    }
}
