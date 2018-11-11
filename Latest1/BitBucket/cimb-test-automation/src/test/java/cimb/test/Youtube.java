package cimb.test;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import com.ford.automation.base.BaseTest;
import cucumber.api.java.en.When;
import sg.casa.base.*;

public class Youtube extends BaseTest{
	
	//Getting Started Page...................................................................
	public String User_Nationality ="";
	Boolean isSingaporePR = false;
	
	@When("^User Execute Without CrossSell Testcases$")
	public void user_Execute_Without_CrossSell_Testcases() throws Throwable {
	  
		//Read xl
		String filePath = System.getProperty("user.dir");
		String sheetName = "Individual";
		String fileName = "Star_Saver_Saving.xlsx";
		
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
	    
	   // for (int i = 3; i <= rowCount; i++) {
	    for (int i = 3; i <= 1000; i++) {
	    	Row row = guru99Sheet.getRow(i);
	    	
	  
	    	JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.open('','testwindow','width=400,height=200')");
			driver.close();
			driver.switchTo().window("testwindow");
			js.executeScript("window.moveTo(0,0);");
			js.executeScript("window.resizeTo(1450,1000);");
			//driver.get(IbaseUrl.StarSaver_saving);
			//driver.get(IbaseUrl.Youtube);
			Thread.sleep(200000);

	     	driver.close();
	      	
	    	} // End Of Test case Execution If Condition
	}//End of For Loop
 	   
	}
	

