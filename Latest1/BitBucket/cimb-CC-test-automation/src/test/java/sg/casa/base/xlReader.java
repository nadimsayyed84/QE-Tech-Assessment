package sg.casa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlReader{
	
	public static void readxl (String filePath1, String filename1, String sheetName1) throws IOException {
		   
		
				String filePath = filePath1;
				String sheetName = filename1;
				String fileName = sheetName1;
				
			   System.out.print("File path......."+ filePath);
			    File file =    new File(filePath+"/"+fileName);
			  
			    //Create an object of FileInputStream class to read excel file

			    FileInputStream inputStream = new FileInputStream(file);

			  Workbook guru99Workbook = null;

			    //Find the file extension by splitting file name in substring  and getting only extension name

			    String fileExtensionName = fileName.substring(fileName.indexOf("."));

			    //Check condition if the file is xlsx file

			    if(fileExtensionName.equals(".xlsx")){

			    //If it is xlsx file then create object of XSSFWorkbook class

			    guru99Workbook = new XSSFWorkbook(inputStream);

			    }

			    //Check condition if the file is xls file

			    else if(fileExtensionName.equals(".xls")){

			        //If it is xls file then create object of XSSFWorkbook class

			        guru99Workbook = new HSSFWorkbook(inputStream);

			    }

			    //Read sheet inside the workbook by its name

			    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

			    //Find number of rows in excel file

			  int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
			    System.out.println("Row Count :"+rowCount);
			    
			    for (int i = 1; i <= rowCount; i++) {
			    	Row row = guru99Sheet.getRow(i);
			    	System.out.println("Row ID : " + i);
			    	
			    	
			    	//Select the Test cases to Execute.
			     	String TestcaseDescription_xl = row.getCell(2).getStringCellValue();
			     	System.out.println("Test case Desctiption" + TestcaseDescription_xl);
			    	
		 
			        }
			        System.out.println("End of the Sheet");

			    }	
	
	 
	}


