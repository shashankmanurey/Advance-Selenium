package selenium.advance.BaseClassUtility;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.*;

public class BaseClass1 {

    protected WebDriver driver;

    @BeforeSuite
    public void Bs() {
        System.out.println("open DataBase connectivity");
    }

    @AfterSuite
    public void As() {
        System.out.println("close Database connectivity");
    }

    @BeforeTest
    public void Bt() {
        System.out.println("pre-conditions");
    }

    @AfterTest
    public void At() {
        System.out.println("post-conditions");
    }

    @BeforeClass
    public void Bc() {
        System.out.println("Launch the browser");
    }

    @AfterClass
    public void Ac() {
        System.out.println("close the browser");
    }

    @BeforeMethod
    public void Bm() throws Exception {

        Properties p = new Properties();

        try (FileInputStream fis = new FileInputStream(
                "src/main/resources/DDT/commondata.properties")) {
            p.load(fis);
        }

        String browser = p.getProperty("browser");
        String url = p.getProperty("url");

        if (browser == null || url == null) {
            throw new RuntimeException(
                    "Browser or URL is missing in commondata.properties");
        }

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(30));

        driver.get(url);
    }

    @AfterMethod
    public void Am() {

        System.out.println("logout method");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}