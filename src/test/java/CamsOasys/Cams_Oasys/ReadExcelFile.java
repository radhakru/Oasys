package CamsOasys.Cams_Oasys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadExcelFile {

	private XSSFWorkbook xssfworkbook;
	private XSSFSheet xssfSheet;
	private XSSFRow xssfRow;
	private XSSFCell xssfCell, xssfCell1;
	private int cellsize;

	private FileInputStream fis;

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

//		fis=new FileInputStream(System.getProperty("user.dir")+"//DataExcel//Data.xlsx");

//		File file=new File(System.getProperty("user.dir") + "//DataExcel//Data.xlsx");

//		try {
		fis = new FileInputStream(System.getProperty("user.dir") + "//Externaldata//CamsEntry.xlsx");
		System.out.println("this is executed");
//	s

//		try {
		xssfworkbook = new XSSFWorkbook(fis);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		else {
//			System.out.println("File Doesnot exist...");
//		
//		}

		xssfSheet = xssfworkbook.getSheet("Sheet1");
		System.out.println("read the execel sheet");
		rowsize = xssfSheet.getLastRowNum();
		cellValue = xssfSheet.getRow(0).getLastCellNum();
		cellSize = Integer.valueOf(cellValue);
		cellsize=cellSize;

		System.out.println("RowSize=" + rowsize);
		System.out.println("CellSize=" + cellSize);

		// initialize the Object[][].
		object = new String[rowsize + 1][cellSize];
		
		

		//store all the excel value to two dimensional array which is object[][].
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 0; j < 11; j++) {
				if (j==3 || j == 10 ) {
					System.out.println(xssfSheet.getRow(i).getCell(j).getNumericCellValue());
					double value = xssfSheet.getRow(i).getCell(j).getNumericCellValue();
//					System.out.println("This is for only 7 cell"+value);
					object[i][j] = String.valueOf(xssfSheet.getRow(i).getCell(j).getNumericCellValue());
//					System.out.println("This is for only 7 cell");
				} else {
					System.out.println(xssfSheet.getRow(i).getCell(j).getStringCellValue());
					object[i][j] = xssfSheet.getRow(i).getCell(j).getStringCellValue();
//					System.out.println("This is for all");
				}

			}

		}
////		
//		System.out.println("row number" + object[1].length);
//		// return this
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 0; j < cellSize; j++) {
				System.out.println("object print" + object[i][j]);
			}
		}
		fis.close();

		return object;

	}
	public void create_Cell() throws IOException {
		//read the file
		System.out.println("create cell() calling................");
		fis=new FileInputStream(System.getProperty("user.dir")+"//Externaldata//CamsEntry.xlsx");
		xssfworkbook=new XSSFWorkbook(fis);
		
		xssfSheet=xssfworkbook.getSheet("Sheet1");
		short lastcell_value=xssfSheet.getRow(0).getLastCellNum();
		int value=lastcell_value;
		System.out.println("Lastcell value ="+lastcell_value);
		while(lastcell_value!=0){
			System.out.println("Cell value printed..."+xssfSheet.getRow(0).getCell(lastcell_value-1).getStringCellValue());
			lastcell_value--;
		}	
		
		if(!(xssfSheet.getRow(0).getCell(value-1).getStringCellValue().equals("Pincode"))) {
			xssfSheet.getRow(0).createCell(value).setCellValue("new_phone_no");
			
		}
	
		//write in file
		FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir")+"//Externaldata//CamsEntry.xlsx");
		xssfworkbook.write(fos);
		
		
		System.out.println("Succefully printed in excel ............."+xssfSheet.getRow(0).getLastCellNum());
			
		fos.close();
		fis.close();	
		
	}
	
	
	
	


}
