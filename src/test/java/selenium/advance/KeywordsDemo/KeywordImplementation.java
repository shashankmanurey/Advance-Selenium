package selenium.advance.KeywordsDemo;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordImplementation {
    WebDriver d;
    public void launchbrowser()
    {
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void openurl()
    {
        d.get("https://demowebshop.tricentis.com/");
    }
    public void search()
    {
        d.findElement(By.id("small-searchterms")).sendKeys("laptop");
    }
    public void searchbutton()
    {
        d.findElement(By.xpath("//input[@type='submit']")).click();
    }
    public void closebrowser()
    {
        d.quit();
    }

}
