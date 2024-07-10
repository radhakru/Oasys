package CamsOasys.Cams_Oasys;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadCamsLogin {
	private XSSFWorkbook xssfworkbook;
	private XSSFSheet xssfSheet;
	private XSSFRow xssfRow;
	private XSSFCell xssfCell, xssfCell1;
	private int cellsize;

	private FileInputStream fis;
	private FileOutputStream fos;

	/*
	 * @Test(dataProvider="LoginData") public void Test(String name,String password)
	 * { System.out.println(name.trim()); System.out.println(password.trim());
	 * 
	 * 
	 * }
	 */

	@DataProvider(name = "test")
	public Object[][] getFile() throws IOException {
		Object[][] object;
		int rowsize;
		int cellSize;
		int cellValue;
		int rowvalue=1;

		fis = new FileInputStream(System.getProperty("user.dir") + "//Externaldata//Cams_login.xlsx");
		System.out.println("this is executed");

		xssfworkbook = new XSSFWorkbook(fis);

		xssfSheet = xssfworkbook.getSheet("Sheet1");
		System.out.println("read the execel sheet");
		rowsize = xssfSheet.getLastRowNum();
		cellValue = xssfSheet.getRow(0).getLastCellNum();
		cellSize = Integer.valueOf(cellValue);
		cellsize = cellSize;

		System.out.println("RowSize=" + rowsize);
		System.out.println("CellSize=" + cellSize);

		// initialize the Object[][].
		
		
		object = new String[rowsize + 1][3];

		// store all the excel value to two dimensional array which is object[][].
		for (int i =rowvalue; i <= rowsize; i++) {
			for (int j = 0; j < 3; j++) {

				object[i][j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();

			}

		}
////		
//		System.out.println("row number" + object[1].length);
//		// return this
		for (int i = rowvalue; i <= rowsize; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("object print" + object[i][j]);
			}
		}
		rowvalue=rowsize+1;
		System.out.println("rowvalue="+rowvalue);
		fis.close();

		return object;

	}

	public void create_cell_cams() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "//Externaldata//Cams_login.xlsx");
		xssfworkbook = new XSSFWorkbook(fis);
		xssfSheet = xssfworkbook.getSheet("Sheet1");
		short last_cell_value = xssfSheet.getRow(0).getLastCellNum();
		int cell_value = last_cell_value;
		while (last_cell_value != 0) {
			System.out.println("cell Value" + xssfSheet.getRow(0).getCell(last_cell_value - 1).getStringCellValue());
			last_cell_value--;
		}

		if (xssfSheet.getRow(0).getCell(cell_value - 1).getStringCellValue().equals("Password")) {
			xssfSheet.getRow(0).createCell(cell_value).setCellValue("Login_Status");

		}
		fos = new FileOutputStream(System.getProperty("user.dir") + "//Externaldata//Cams_login.xlsx");
		xssfworkbook.write(fos);

		System.out.println(
				"Last cell value after adding login_staus cell in excel..... " + xssfSheet.getRow(0).getLastCellNum());

		fos.close();
		fis.close();
	}

	//manual entry or hard coded for cell value
	public void update_cell_value(int rownum, String text) throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "//Externaldata//Cams_login.xlsx");
		xssfworkbook = new XSSFWorkbook(fis);
		xssfSheet = xssfworkbook.getSheet("Sheet1");
		short last_cell = xssfSheet.getRow(rownum).getLastCellNum();
		System.out.println("enter in the method" + last_cell);
		System.out.println("String cell value for ..." + xssfSheet.getRow(rownum).getCell(10).getCellType());
		// xssfSheet.getRow(rownum).createCell(last_cell).setCellValue(text);

		if (xssfSheet.getRow(rownum).getCell(10).getCellType().equals(CellType.STRING)||xssfSheet.getRow(rownum).getCell(11).getCellType().equals(CellType.BLANK)||xssfSheet.getRow(rownum).getCell(11).getCellType().equals(CellType.STRING)) {
			xssfSheet.getRow(rownum).createCell(11).setCellValue(text);
			fos = new FileOutputStream(System.getProperty("user.dir") + "//Externaldata//Cams_login.xlsx");
			xssfworkbook.write(fos);
		}
		System.out.println(
				"Last cell value after adding login_staus cell in excel..... " + xssfSheet.getRow(rownum).getLastCellNum());

		fos.close();
		fis.close();

	}

}
