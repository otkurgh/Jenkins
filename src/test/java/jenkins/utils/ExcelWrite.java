package jenkins.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	
	@SuppressWarnings("resource")
	public static void readExcel() {
	
	
	XSSFWorkbook workbook = new XSSFWorkbook(); 
    
    //Create a blank sheet
    XSSFSheet sheet = workbook.createSheet("Employee Data");
      
    //This data needs to be written (Object[])
    Map<String, Object[]> data = new TreeMap<String, Object[]>();
    data.put("1", new Object[] {"NAME", "AGE", "SALARY"});
    data.put("2", new Object[] {"Amit", "45", "10000"});
    data.put("3", new Object[] {"Lokesh", "40", "9000"});
    data.put("4", new Object[] {"John", "35", "7000"});
    data.put("5", new Object[] {"Brian", "39", "7600"});
      
    //Iterate over data and write to sheet
    Set<String> keyset = data.keySet();
    int rownum = 0;
    for (String key : keyset) {
        XSSFRow row = sheet.createRow(rownum++);
        Object [] objArr = data.get(key);
        int cellnum = 0;
        for (Object obj : objArr)
        {
           XSSFCell cell = row.createCell(cellnum++);
           if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Integer)
                cell.setCellValue((Integer)obj);
        }
    } try{
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(new File("/Users/otkurghojash/Desktop/staffs.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
    } catch (Exception e) {
    
        e.printStackTrace();
    }
		
}
	
	public static void main(String [] args) {
		
		readExcel();
		
		
	}

	
}	
	
	
	

