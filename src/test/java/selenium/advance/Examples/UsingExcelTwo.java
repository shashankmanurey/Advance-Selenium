package selenium.advance.Examples;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;


public class UsingExcelTwo {
    @Test 
    public void ex() throws Exception
    {
        FileInputStream f = new FileInputStream("src/main/resources/DDT/Data.xlsx");
        Workbook w = WorkbookFactory.create(f);
        Sheet sh = w.getSheet("Sheet2");

        //capture the last row 
        int rowCount = sh.getLastRowNum();
        for(int i=1;i<=rowCount;i++)
        {
            String n =  sh.getRow(i).getCell(0).getStringCellValue();
            System.out.println(n);
        }
        
    }
}
