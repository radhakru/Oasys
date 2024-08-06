package CamsOasys.Cams_Marketing_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ListOfNonPaddyExcelRead {
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
		int rowvalue = 1;

		// C:\Users\nirak\Desktop\Radhakrushna_OASYS\Cams_Oasys\src\test\java\CamsOasys\Cams_Marketing_Testdata\CamsEntry.xlsx
		fis = new FileInputStream(System.getProperty("user.dir") + "//Externaldata//Procurement_Of_Non_Paddy.xlsx");
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

		object = new String[rowsize][14];

		// store all the excel value to two dimensional array which is object[][].
		for (int i = rowvalue; i <= rowsize; i++) {
			for (int j = 0; j < 14; j++) {
				if (j==7 ||j==9||j==10||j==11||j==12||j==13) {
					object[i - 1][j] = String.valueOf(xssfSheet.getRow(i).getCell(j).getNumericCellValue());
				} else {
					object[i - 1][j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();
				}

			}

		}
////		
//		System.out.println("row number" + object[1].length);
//		// return this
		for (int i = rowvalue; i <= rowsize; i++) {
			for (int j = 0; j < 14; j++) {
				System.out.println("object print" + object[i - 1][j]);
			}
		}
		rowvalue = rowsize + 1;
		System.out.println("rowvalue=" + rowvalue);
		fis.close();

		return object;

	}


}
