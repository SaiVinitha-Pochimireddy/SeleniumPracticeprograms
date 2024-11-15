package basicseleniumtopics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;

public class FileReading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//excel file -> workbook -> sheet -> row -> cell
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\file1.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("sheet1");
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=currentrow.getCell(c);
				System.out.print(cell.toString()+ "\t");
			}
			System.out.println();
		}

	}

}
