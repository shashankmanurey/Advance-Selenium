package selenium.advance.Examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingExcelFiles {

    public static void main(String[] args) throws IOException {

        // Location of Excel file
        FileInputStream f = new FileInputStream("src/main/resources/DDT/Data.xlsx");

        // Open Excel workbook
        Workbook workbook = WorkbookFactory.create(f);

        // Select sheet
        Sheet sheet = workbook.getSheet("Sheet1");

        // Read first row of data
        Row row = sheet.getRow(1);

        // Read cell values
        String browser = row.getCell(0).getStringCellValue();
        String url = row.getCell(1).getStringCellValue();
        String username = row.getCell(2).getStringCellValue();
        String password = row.getCell(3).getStringCellValue();

        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

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
            workbook.close();
            f.close();
            return;
        }

        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get(url);

        d.findElement(By.id("user-name")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.id("login-button")).click();

        // Close Excel resources
        workbook.close();
        f.close();
    }
}
