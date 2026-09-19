package selenium.advance.Examples;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertDemo3 {
	@Test
	public void assert1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        System.out.println("Executed");

        WebElement text = driver.findElement(By.cssSelector("[data-test='title']"));
        Assert.assertEquals(text.getText(), "Products");
        System.out.println("Executed");

        boolean cart = driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        Assert.assertTrue(cart);
        System.out.println("Executed");
		
	}
}
