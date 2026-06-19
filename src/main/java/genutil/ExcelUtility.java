package genutil;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String toReadDataFromExcelFile(String SheetName, int rowNo, int cellNo) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\JspidersPC\\Desktop\\SaucePropList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return data;
	}

	public int togetLastRowNum(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\OrangeTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rownum;
	}
	
}
