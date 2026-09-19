package selenium.advance.UsingTestNg;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import selenium.PomUtilities.Login;
import selenium.PomUtilities.checkout;
import selenium.PomUtilities.overview;
import selenium.PomUtilities.product;
import selenium.advance.BaseClassUtility.BaseClass1;

public class SauceTest extends BaseClass1 {

    @Test
    public void loginTest() throws Exception {

        FileInputStream file = new FileInputStream(
                "src/main/resources/DDT/test.xlsx");

        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheet("Sheet1");
        Row data = sheet.getRow(1);

        DataFormatter format = new DataFormatter();

        String user = format.formatCellValue(data.getCell(0));
        String pass = format.formatCellValue(data.getCell(1));

        book.close();
        file.close();

        Login loginPage = new Login(driver);

        loginPage.getus(user);
        loginPage.getpd(pass);
        loginPage.getlogin();

        if (loginPage.verifyProductsPage()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is not displayed");
        }

        System.out.println("Login test passed");
        driver.quit();
    }

    @Test(dependsOnMethods = "loginTest")
    public void oderPalcementTest() throws Exception {

        FileInputStream file = new FileInputStream(
                "src/main/resources/DDT/test.xlsx");

        Workbook book = WorkbookFactory.create(file);
        Sheet sheet = book.getSheet("Sheet1");
        Row data = sheet.getRow(1);

        DataFormatter format = new DataFormatter();

        String user = format.formatCellValue(data.getCell(0));
        String pass = format.formatCellValue(data.getCell(1));
        String fname = format.formatCellValue(data.getCell(2));
        String lname = format.formatCellValue(data.getCell(3));
        String postal = format.formatCellValue(data.getCell(4));

        book.close();
        file.close();

        Login loginPage = new Login(driver);

        loginPage.getus(user);
        loginPage.getpd(pass);
        loginPage.getlogin();

        if (loginPage.verifyProductsPage()) {
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is not displayed");
        }

        product prod = new product(driver);

        prod.getad();
        System.out.println("Sauce Labs Backpack added to cart");

        if (prod.getsb().equals("1")) {
            System.out.println("Cart contains 1 item");
        } else {
            System.out.println("Cart does not contain 1 item");
        }

        prod.getsc();

        if (prod.verifyCartPage()) {
            System.out.println("Sauce Labs Backpack is displayed in cart");
        } else {
            System.out.println("Sauce Labs Backpack is not displayed in cart");
        }

        checkout check = new checkout(driver);

        check.getcheckout();
        check.getfn(fname);
        check.getln(lname);
        check.getpc(postal);

        overview ov = new overview(driver);

        ov.getcont();

        ov = new overview(driver);

        if (ov.verifyOverview()) {
            System.out.println("Checkout: Overview page is displayed");
        } else {
            System.out.println("Checkout: Overview page is not displayed");
        }

        ov.getfinish();

        ov = new overview(driver);

        if (ov.verifyMessage()) {
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Thank you message is not displayed");
        }

        System.out.println("Order placement test passed");
    }
}