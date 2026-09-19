package selenium.advance.Examples;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
    
    @DataProvider 
    public Object[][] loginDetails() throws Exception
    {
       FileInputStream f = new FileInputStream("src/main/resources/DDT/Data.xlsx");
       Workbook w = WorkbookFactory.create(f);
       Sheet sh = w.getSheet("Sheet2");
       int rowCount = sh.getLastRowNum();
       
       
        Object[][] obj = new Object[rowCount][2];
        for(int i=1;i<=rowCount;i++)
        {
            obj[i-1][0] = sh.getRow(i).getCell(0).getStringCellValue();
            obj[i-1][1] = sh.getRow(i).getCell(1).getStringCellValue();
        }
        return obj;
        
    }

    @Test(dataProvider = "loginDetails")
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
