package pojoClass;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Zabiulla
 *
 */
public class ExcelUtility {
	/**
	 * To Fetch the Data from the Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, IOException
	{
		FileInputStream fileinputstream = new FileInputStream("./src/test/resources/RestAssured.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row .getCell(cellNum);
		DataFormatter format = new DataFormatter();
		String value = format.formatCellValue(cell);
		return value;
	}

	/**
	 * To insert The Data Into the Excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Exception
	 * @throws Throwable
	 */
	public void insertIntoExcel(String sheetName,int rowNum, int cellNum,String data) throws Exception, Throwable
	{
		FileInputStream fileinputstream = new FileInputStream("./src/test/resources/RestAssured.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row .createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstream = new FileOutputStream("./src/test/resources/RestAssured.xlsx");
		workbook.write(fileoutputstream);
	}

	/**
	 *  To Get Last used Row Number from the Excel
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNumFromExcel(String sheetName) throws Throwable
	{
		FileInputStream fileinputstream = new FileInputStream("./src/test/resources/RestAssured.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
}
