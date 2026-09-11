package selenium.advance.Examples;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UsingExcelFile {
    public static void main(String[] args) throws Exception{
        FileInputStream f = new FileInputStream("src/main/resources/DDT/Data.xlsx");
        Workbook w = WorkbookFactory.create(f);
        
        //sheet
        Sheet sh = w.getSheet("Sheet1");

        //row 
        Row r = sh.getRow(0);

        //cell
        Cell c = r.getCell(0);

        //value
        System.out.println(c.getStringCellValue());

        String password = w.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        System.out.println(password);
    }
}
