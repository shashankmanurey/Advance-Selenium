package selenium.PomImpl;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.advance.BaseClassUtility.OrangeBase1;
import selenium.PomUtilities.OrangeLogin;
import selenium.PomUtilities.OrangeRect;
import selenium.PomUtilities.OrangeVac;

public class OrangeVacTest extends OrangeBase1 {

    @Test
    public void createVacancy() throws Exception {

        // Step 1: Read data from Excel
        FileInputStream f = new FileInputStream("src/main/resources/DDT/OrangeExcel.xlsx");

        Workbook wb = WorkbookFactory.create(f);

        Sheet sh = wb.getSheet("Sheet1");
        Row row = sh.getRow(1);

        DataFormatter df = new DataFormatter();

        String vacancyName = df.formatCellValue(row.getCell(0));
        String jobTitle = df.formatCellValue(row.getCell(1));
        String description = df.formatCellValue(row.getCell(2));
        String hiringManager = df.formatCellValue(row.getCell(3));
        String numberOfPositions = df.formatCellValue(row.getCell(4));

        wb.close();
        f.close();

        // Step 2: Login
        OrangeLogin login = new OrangeLogin(d);

        login.getun("Admin");
        login.getPass("admin123");
        login.getLgbt();

        Assert.assertTrue(
            login.verify(),
            "Login failed: Dashboard not displayed"
        );

        // Step 3: Navigate to Recruitment - Vacancies
        OrangeRect rect = new OrangeRect(d);

        rect.clickRecruitment();
        rect.clickvac();
        rect.clickadd();

        // Step 4: Fill vacancy form using Excel data
        OrangeVac vac = new OrangeVac(d);

        vac.enterVacancy(vacancyName);
        vac.selectJob(jobTitle);
        vac.enterDesc(description);
        vac.selectHM(hiringManager);
        vac.enterNumPos(numberOfPositions);

        // Step 5: Save vacancy
        vac.clickSave();
    }
}
