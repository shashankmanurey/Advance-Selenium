package selenium.advance.Examples;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingPropertiesFile {
    public static void main(String[] args) throws Exception{
        FileInputStream f = new FileInputStream("src/main/resources/DDT/commondata.properties");
        Properties p = new Properties();
        p.load(f);

        String Browser = p.getProperty("browser");
        String URL = p.getProperty("url");
        String USERNAME = p.getProperty("Username");
        String PASSWORD = p.getProperty("Password"); 

          //Browser openings
        WebDriver d = null;
        if(Browser.equals("chrome"))
        {
            d = new ChromeDriver();
        }
        if(Browser.equals("edge"))
        {
            d = new EdgeDriver();
        }
        if(Browser.equals("firefox"))
        {
            d = new FirefoxDriver();
        }

        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get(URL);
        d.findElement(By.id("user-name")).sendKeys(USERNAME);
        d.findElement(By.id("password")).sendKeys(PASSWORD);
        d.findElement(By.id("login-button")).click();
    }
}
