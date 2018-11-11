package sg.casa.cimb.star.saver.i.saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import sg.casa.base.CommonMethords;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class StarSaver_i_Saving_FixedDeposit {

	//Execute Fixed Deposit
	public static void ExecuteFixedDeposit(String FixeddepsitId, WebDriver driver) throws InterruptedException, IOException {
	
		//Read xl
		String filePath = System.getProperty("user.dir");
		String sheetName = "Crosssell-Fixeddeposit";
		String fileName = "Star_Saver_i_Saving.xlsx";
		
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
		
	    for (int i = 3; i <= rowCount; i++) {
	    	Row row = guru99Sheet.getRow(i);
	    	
	    String xlAccountTypeID = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_XLSheetCrossReferenceID).getStringCellValue();	
	    String ApplicationInformation_CrossSell_FixedDeposit_ModeofDepositXL = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_ModeofDeposit).getStringCellValue();	
	    String ApplicationInformation_CrossSell_FixedDeposit_CurrencyXL = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_Currency).getStringCellValue();	
	    String ApplicationInformation_CrossSell_FixedDeposit_TenureXL = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_Tenure).getStringCellValue();	
	    String ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstructionXL = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstruction).getStringCellValue();	
	    String ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPaymentXL = row.getCell(Retunxlid.ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPayment).getStringCellValue();	
	    
	    
		if(xlAccountTypeID.equalsIgnoreCase(FixeddepsitId)) {
			System.out.println("Fixed Deposit xl Row ID " + xlAccountTypeID +  " ||    Parent xl Sheet Reference ID " + FixeddepsitId );
			
			//Select Mode of Deposit
			CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit, ApplicationInformation_CrossSell_FixedDeposit_ModeofDepositXL,driver);
			System.out.println("Mode Of Deposit : " + ApplicationInformation_CrossSell_FixedDeposit_ModeofDepositXL);
			
			if(ApplicationInformation_CrossSell_FixedDeposit_ModeofDepositXL.equalsIgnoreCase("Debit my existing CIMB Bank a/c")) {
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber))).sendKeys("1234567890");
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_GetOTPBtn))).click();
				Thread.sleep(3000);
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPText))).sendKeys("123456");
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPBtn))).click();
			}
			
		 //Select Currancy
			CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Currency, ApplicationInformation_CrossSell_FixedDeposit_CurrencyXL,driver);
			System.out.println("Currancy : " + ApplicationInformation_CrossSell_FixedDeposit_CurrencyXL);	

	    //Select Tenue
			CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Tenure, ApplicationInformation_CrossSell_FixedDeposit_TenureXL,driver);
			System.out.println("Tenue : " + ApplicationInformation_CrossSell_FixedDeposit_TenureXL);		
			
		    //Enter Deposit Ammount
			driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_DepositAmount))).sendKeys("100000");
			System.out.println("Deposit Ammount : 100000");		
			
		    //Select Maturity Renewal Instruction
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_MaturityRenewalInstruction, ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstructionXL,driver);
				System.out.println("Maturity Renewal Instruction : " + ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstructionXL);	
			
				if(!ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstructionXL.equalsIgnoreCase("Principal + Interest")) {
					//Select Maturity Renewal Instruction
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_InstructionsForAnyPayment, ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPaymentXL,driver);
					System.out.println("Instructions For Any Payment : " + ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPaymentXL);	
					if(ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPaymentXL.equalsIgnoreCase("Credit my existing CIMB Bank a/c")) {
					    //Enter CIMB Account Number to Credit
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_CIMBAccountNumberToCredit))).sendKeys("1234567890");
					}
				}
				
				
				
				
			break;
		}//End of ID Mapping Section
	    
	    
	    
	    
	    }//End of For Loop.
	
	}//End of Fixed Deposti Methord   
	    
	    
	    
	}//End of Class
	
