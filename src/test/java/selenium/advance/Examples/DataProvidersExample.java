package selenium.advance.Examples;

import java.time.Duration;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProvidersExample {
    @DataProvider
    public Object[][] LoginDetails() {

        Object[][] obj = new Object[3][2];

        obj[0][0] = "radha";
        obj[0][1] = "radha123";

        obj[1][0] = "shank";
        obj[1][1] = "shank123";

        obj[2][0] = "shhh";
        obj[2][1] = "shhh123";
        
        return obj;
    }
    @Test(dataProvider = "LoginDetails")
    public void Login(String un, String pw) throws Exception {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        d.get("https://www.saucedemo.com/");

        // Login
        d.findElement(By.id("user-name")).sendKeys(un);
        d.findElement(By.id("password")).sendKeys(pw);
        d.findElement(By.id("login-button")).click();

        // Close browser
        Thread.sleep(2000);
        d.quit();
    }
    
}
