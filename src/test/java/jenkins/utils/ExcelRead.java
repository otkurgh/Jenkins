package jenkins.utils;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int rowCount(String exelfile, String sheet) {

		int rownum = 0;

		try {
			file = new FileInputStream(exelfile);
			wb = new XSSFWorkbook(file);
			ws = wb.getSheet(sheet);
			rownum = ws.getLastRowNum();
			wb.close();
			file.close();

		} catch (IOException e) {

			e.getStackTrace();
		}

		return rownum;

	}

	public static int columnCount(String exelfile, String sheet, int rownum) {

		int colnum = 0;

		try {
			file = new FileInputStream(exelfile);
			wb = new XSSFWorkbook(file);
			ws = wb.getSheet(sheet);
			row = ws.getRow(rownum);
			colnum = row.getLastCellNum();
			wb.close();
			file.close();

		} catch (IOException e) {

			e.getStackTrace();
		}

		return colnum;

	}

	public static String getcellData(String exelfile, String sheet, int rown, int coln) throws IOException {

		file = new FileInputStream(exelfile);
		wb = new XSSFWorkbook(file);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rown);
		cell = row.getCell(coln);

		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;

		} catch (Exception e) {

			data = " ";

		}

		wb.close();
		file.close();
		return data;

	}

	public static String[][] readexcelData(String file, String sheet) throws IOException {

		int rows = rowCount(file, sheet);
		int cols = columnCount(file, sheet, 1);

		String[][] data = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				data[i - 1][j] = getcellData(file, sheet, i, j);
                System.out.print(data[i-1][j] + " ");
			}
			
			 System.out.println(" ");
		}

		return (data);
	}

	public static void main(String[] args) throws IOException {

		String file = "/Users/otkurghojash/Desktop/staffs.xlsx";

		readexcelData(file, "Employee Data");
		

	}

}
