package sg.casa.cimb.star.saver.saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.ford.automation.base.BaseTest;

import sg.casa.base.ApplicationInformationPageWorkFlow;
import sg.casa.base.BeforeYouSubmitWorkFlow;
import sg.casa.base.CommonMethords;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class StarSaverSaving_BeforeYouSubmit extends BaseTest{
	//Execute Before You Submit
	public static void ExecuteBeforeYouSubmit(String SubmitId, WebDriver driver) throws InterruptedException, IOException {
		//Read xl
				String filePath = System.getProperty("user.dir");
				String sheetName = "ReviewPage";
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
				
			    for (int i = 3; i <= rowCount; i++) {
			    	Row row = guru99Sheet.getRow(i);
			    	
				    String BeforeYouSubmitIDXL = row.getCell(Retunxlid.BeforeYouSubmit_Submitxlid).getStringCellValue();	
				    String BeforeYouSubmit_ReferredByFriendXL = row.getCell(Retunxlid.BeforeYouSubmit_ReferredByFriendxlid).getStringCellValue();	
				    String BeforeYouSubmit_ReferredByFriend_ApplicantNameXL = row.getCell(Retunxlid.BeforeYouSubmit_ReferredByFriend_ApplicantNamexlid).getStringCellValue();	
				    String BeforeYouSubmit_ReferredByFriend_NRICPassportNumberXL = row.getCell(Retunxlid.BeforeYouSubmit_ReferredByFriend_NRICPassportNumberxlid).getStringCellValue();	
				    String BeforeYouSubmit_DoYouHavePromoCodeXL = row.getCell(Retunxlid.BeforeYouSubmit_DoYouHavePromoCodexlid).getStringCellValue();	
				    String BeforeYouSubmit_DoYouHavePromoCode_PromoCodeXL = row.getCell(Retunxlid.BeforeYouSubmit_DoYouHavePromoCode_PromoCodexlid).getStringCellValue();	
				    
				    
					if(BeforeYouSubmitIDXL.equalsIgnoreCase(SubmitId)) {
						System.out.println("Before You Submit xl Row ID " + BeforeYouSubmitIDXL +  " ||    Parent xl Sheet Reference ID " + SubmitId);
						
						System.out.println("Before You Submit -- Testing");
						
						driver.findElement(org.openqa.selenium.By.xpath(BeforeYouSubmitWorkFlow.ReviewPageAreYouReferred(BeforeYouSubmit_ReferredByFriendXL))).click();
						System.out.println("Are You Referred By A Friend ? " + BeforeYouSubmit_ReferredByFriendXL);	
		
						
						//If Referred By Friend--> Yes - Enter the Applicant name and NRIC Number
						
						if(BeforeYouSubmit_ReferredByFriendXL.equalsIgnoreCase("Yes")) {
							//Select Yes Referred By a Friend
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_Yes))).click();
							System.out.println("Referred By A Friend ---- Yes"); 
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_Fullname))).sendKeys(BeforeYouSubmit_ReferredByFriend_ApplicantNameXL);
							System.out.println("Before You Submit - Applicant Name --> "+BeforeYouSubmit_ReferredByFriend_ApplicantNameXL);
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_FriendNric))).sendKeys(BeforeYouSubmit_ReferredByFriend_NRICPassportNumberXL);
							System.out.println("Before You Submit - NRIC --> "+BeforeYouSubmit_ReferredByFriend_NRICPassportNumberXL);
							Thread.sleep(1000);
						}
						else
						if(BeforeYouSubmit_ReferredByFriendXL.equalsIgnoreCase("No")) {
							//Select No Referred By a Friend
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_ReferredByFriend_No))).click();
							System.out.println("Referred By A Friend ---- No"); 
							Thread.sleep(1000);
						}
						
						
						//If Have a Promocode--> Yes - Enter the Promo Code Number
						if(BeforeYouSubmit_DoYouHavePromoCodeXL.equalsIgnoreCase("Yes")) {
							//Have a Promocode - Yes
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_HaveAPromoCode_Yes))).click();
							System.out.println("Have a Promocode ---- Yes");
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_PromotionalCode))).sendKeys(BeforeYouSubmit_DoYouHavePromoCode_PromoCodeXL);
							System.out.println("Before You Submit - Promo Code --> "+BeforeYouSubmit_DoYouHavePromoCode_PromoCodeXL);
							Thread.sleep(1000);
						}
						else
						if(BeforeYouSubmit_DoYouHavePromoCodeXL.equalsIgnoreCase("No")) { 
							//Have a Promocode - No
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.BeforeYouSubmit_HaveAPromoCode_No))).click();
							System.out.println("Have a Promocode ---- No"); 
							
						}

					
						break;
					}//End of ID Mapping Section
				    
				}//End of For Loop.
				
		 }//End of Before You Submit Method   
				    
}//End of Class
				
