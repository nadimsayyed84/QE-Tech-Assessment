package sg.casa.cimb.fixed.deposit.i;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import sg.casa.base.SG_CASA_UI_Decleration;
import sg.casa.base.YourDeclarationPageWorkFlow;


public class FixedDeposit_i_YourDeclaration {
	
	
//	public static void VerifyYourDecleration (String AccountType, String isSupplementary, String ParentID,WebDriver driver) throws IOException, InterruptedException {
//		String filePath = System.getProperty("user.dir");
//		String sheetName = "Decleration";
//		String fileName = "Fixed_Deposit_i.xlsx";
//		
//	   System.out.print("File path......."+ filePath);
//	    File file =    new File(filePath+"/"+fileName);
//	  
//	    //Create an object of FileInputStream class to read excel file
//
//	    FileInputStream inputStream = new FileInputStream(file);
//
//	  Workbook guru99Workbook = null;
//
//	    //Find the file extension by splitting file name in substring  and getting only extension name
//
//	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
//
//	    //Check condition if the file is xlsx file
//
//	    if(fileExtensionName.equals(".xlsx")){
//
//	    //If it is xlsx file then create object of XSSFWorkbook class
//
//	    guru99Workbook = new XSSFWorkbook(inputStream);
//
//	    }
//
//	    //Check condition if the file is xls file
//
//	    else if(fileExtensionName.equals(".xls")){
//
//	        //If it is xls file then create object of XSSFWorkbook class
//
//	        guru99Workbook = new HSSFWorkbook(inputStream);
//
//	    }
//
//	    //Read sheet inside the workbook by its name
//
//	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
//
//	    //Find number of rows in excel file
//
//	  int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
//	    System.out.println("Row Count :"+rowCount);
//	    
//	    for (int i = 1; i <= rowCount; i++) {
//	    	Row row = guru99Sheet.getRow(i);
//	    	
//	    	String DeclerationChildID = row.getCell(FixedDeposit_i_Retunxlid.YourDecleration_childID).getStringCellValue();
//	   //Individual 
//	    	String Principal_PDPA_VoiceandPhoneCallxl= row.getCell(FixedDeposit_i_Retunxlid.Principal_PDPA_VoiceandPhoneCall).getStringCellValue();
//	    	String Principal_PDPA_SMSansMMSxl = row.getCell(FixedDeposit_i_Retunxlid.Principal_PDPA_SMSansMMS).getStringCellValue();
//	    	String Principal_AreYou_UnitedStatesOr_territoriesxl = row.getCell(FixedDeposit_i_Retunxlid.Principal_AreYou_UnitedStatesOr_territories).getStringCellValue();
//	    	
//	    	String Principal_USResidentxl = row.getCell(FixedDeposit_i_Retunxlid.Principal_USResident).getStringCellValue();
//	    	String Principal_USCitizenxl = row.getCell(FixedDeposit_i_Retunxlid.Principal_USCitizen).getStringCellValue();
//	    	String Principal_USPermanentxl = row.getCell(FixedDeposit_i_Retunxlid.Principal_USPermanent).getStringCellValue();
//	    	
//	    	
//	    	
//	    	
//	    	
//	    	//Joint
//	    String Joint_PDPA_VoiceandPhoneCallxl= row.getCell(FixedDeposit_i_Retunxlid.Joint_PDPA_VoiceandPhoneCall).getStringCellValue();
//	    	String Joint_PDPA_SMSansMMSxl = row.getCell(FixedDeposit_i_Retunxlid.Joint_PDPA_SMSansMMS).getStringCellValue();
//	    	String Joint_AreYou_UnitedStatesOr_territoriesxl = row.getCell(FixedDeposit_i_Retunxlid.Joint_AreYou_UnitedStatesOr_territories).getStringCellValue();
//	    
//	    	String Joint_USResidentxl = row.getCell(FixedDeposit_i_Retunxlid.Joint_USResident).getStringCellValue();
//	    	String Joint_USCitizenxl = row.getCell(FixedDeposit_i_Retunxlid.Joint_USCitizen).getStringCellValue();
//	    	String Joint_USPermanentxl = row.getCell(FixedDeposit_i_Retunxlid.Joint_USPermanent).getStringCellValue();
//	    	
//	    	
//	    	
//	    	if(DeclerationChildID.equalsIgnoreCase(ParentID)) {
//			  System.out.println("Your Decleration Parent ID " + ParentID + "Your Decleration Child ID" + DeclerationChildID);
//			  System.out.println(" Your Decleration *********************");
//	  		  
//			  if(AccountType.contentEquals("Individual")) {
//				  Thread.sleep(5000);
//				  System.out.println("Account Type " + AccountType);
//				 if(Principal_PDPA_VoiceandPhoneCallxl.equalsIgnoreCase("Yes")) {
//				  driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_VoiceandPhoneCall)).click();
//				 }
//				 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_SMSansMMS)).click();
//				 if(Principal_PDPA_SMSansMMSxl.equalsIgnoreCase("Yes")) {
//				 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_SMSansMMS)).click();
//				 }
//				 //Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories?
//				 driver.findElement(org.openqa.selenium.By.xpath(YourDeclarationPageWorkFlow.YourDecleration_AreYou_UnitedStatesOr_territoriesXpath(AccountType, Principal_AreYou_UnitedStatesOr_territoriesxl))).click();
//				 System.out.println("Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories? :"+Principal_AreYou_UnitedStatesOr_territoriesxl);
//				 
//				 
//				 //Which is applicable to you?
//				 if(Principal_USResidentxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USResident)).click();
//					 }
//				 if(Principal_USCitizenxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USCitizen)).click();
//					 }
//				 if(Principal_USPermanentxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USPermanent)).click();
//					 }
//			  }//End of Principal Account
//			  
//			  if(AccountType.contentEquals("Joint")) {
//				  Thread.sleep(5000);
//				  
//				  //-------
//				  if(Principal_PDPA_VoiceandPhoneCallxl.equalsIgnoreCase("Yes")) {
//					  driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_VoiceandPhoneCall)).click();
//					 }
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_SMSansMMS)).click();
//					 if(Principal_PDPA_SMSansMMSxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_PDPA_SMSansMMS)).click();
//					 }
//					 //Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories?
//					 if(Principal_AreYou_UnitedStatesOr_territoriesxl.equalsIgnoreCase("Yes"))
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_AreYou_UnitedStatesOr_territories_Yes)).click();
//					 else
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_AreYou_UnitedStatesOr_territories_No)).click();	 
//					 System.out.println("Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories? :"+Principal_AreYou_UnitedStatesOr_territoriesxl);
//					 
//					 
//					 //Which is applicable to you?
//					 if(Principal_USResidentxl.equalsIgnoreCase("Yes")) {
//						 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USResident)).click();
//						 }
//					 if(Principal_USCitizenxl.equalsIgnoreCase("Yes")) {
//						 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USCitizen)).click();
//						 }
//					 if(Principal_USPermanentxl.equalsIgnoreCase("Yes")) {
//						 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Principal_USPermanent)).click();
//						 }
//				  //----
//				  System.out.println("Account Type " + AccountType);
//				 if(Joint_PDPA_VoiceandPhoneCallxl.equalsIgnoreCase("Yes")) {
//				  driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_PDPA_VoiceandPhoneCall)).click();
//				 }
//				 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_PDPA_SMSansMMS)).click();
//				 if(Joint_PDPA_SMSansMMSxl.equalsIgnoreCase("Yes")) {
//				 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_PDPA_SMSansMMS)).click();
//				 }
//				 
//				 //Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories?
//				 driver.findElement(org.openqa.selenium.By.xpath(YourDeclarationPageWorkFlow.YourDecleration_AreYou_UnitedStatesOr_territoriesXpath(AccountType, Joint_AreYou_UnitedStatesOr_territoriesxl))).click();
//				 System.out.println("Are you a Resident, Green Card Holder, or the Citizan of the United States of America or its territories? :"+Joint_AreYou_UnitedStatesOr_territoriesxl);
//				 
//				 //Which is applicable to you?
//				 if(Joint_USResidentxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_USResident)).click();
//					 }
//				 if(Joint_USCitizenxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_USCitizen)).click();
//					 }
//				 if(Joint_USPermanentxl.equalsIgnoreCase("Yes")) {
//					 driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Decleration.Joint_USPermanent)).click();
//					 }
//			  }//End of Joint Account 
//			  
//	    	}//End of Parent and Child ID Mapping
//
//	        }
//	        System.out.println("End of the Sheet");
//
//	    }	

	}
