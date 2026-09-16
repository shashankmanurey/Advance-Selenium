package selenium.PomImpl;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.PomUtilities.DemoPage;

public class DemoPage1 {
    public static void main(String[] args) throws Exception {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        d.get("https://demowebshop.tricentis.com/");
        DemoPage j = new DemoPage(d);
        j.getSearchtf("laptops");
        j.getSearchButton();
        Thread.sleep(3000);
        j.getRegister();
        j.getFn("Shashank");

    }
}
