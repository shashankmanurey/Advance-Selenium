package selenium.advance.BaseClassUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    WebDriver d = null;

    @BeforeSuite
    public void Bs() {
        System.out.println("open database connectivity");
    }

    @BeforeTest
    public void Bt() {
        System.out.println("pre conditions");
    }

    @BeforeClass
    public void Bc() {
        System.out.println("Launch the browser");

        d = new ChromeDriver();
        d.manage().window().maximize();
    }

    @BeforeMethod
    public void bs() {
        d.get("https://www.saucedemo.com/");

        d.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        d.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        d.findElement(By.id("login-button")).click();

        System.out.println("Login");
    }

    @AfterMethod
    public void Am() {
        System.out.println("login executed");
    }

    @AfterClass
    public void closeBrowser() {
        if (d != null) {
            d.quit();
        }
    }
}