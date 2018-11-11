package sg.casa.cimb.starsaver;

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

import sg.casa.base.CommonMethords;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class Star_Saver_Processing extends BaseTest{
	//Execute Before You Submit
		public static void ExecuteProcessing(String ParentMappingID, WebDriver driver) throws InterruptedException, IOException {
			//Read xl
					String filePath = System.getProperty("user.dir");
					String sheetName = "ProcessingPage";
					String fileName = "Star_Saver.xlsx";
					
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
				    	
					    String ProcessingPageIDXL = row.getCell(Retunxlid.ProcessingPage_Mappingxlid).getStringCellValue();	
					    String ProcessingPage_HowDidYouHearAboutUsXL = row.getCell(Retunxlid.ProcessingPage_HowDidYouHearAboutUsxlid).getStringCellValue();	
					    //String BeforeYouSubmit_ReferredByFriend_ApplicantNameXL = row.getCell(Retunxlid.BeforeYouSubmit_ReferredByFriend_ApplicantNamexlid).getStringCellValue();	
					    //String BeforeYouSubmit_ReferredByFriend_NRICPassportNumberXL = row.getCell(Retunxlid.BeforeYouSubmit_ReferredByFriend_NRICPassportNumberxlid).getStringCellValue();	
					    //String BeforeYouSubmit_DoYouHavePromoCodeXL = row.getCell(Retunxlid.BeforeYouSubmit_DoYouHavePromoCodexlid).getStringCellValue();	
					    //String BeforeYouSubmit_DoYouHavePromoCode_PromoCodeXL = row.getCell(Retunxlid.BeforeYouSubmit_DoYouHavePromoCode_PromoCodexlid).getStringCellValue();	
					    String ProcessingPage_SubmitFeedbackXL = row.getCell(Retunxlid.ProcessingPage_SubmitFeedbackxlid).getStringCellValue();
					    
						if(ProcessingPageIDXL.equalsIgnoreCase(ParentMappingID)) {
							System.out.println("Processing Page ID" + ProcessingPageIDXL +  " ||  Parent Key ID" + ParentMappingID);
							
							System.out.println("Processing Page Testing");
							
							
							
							if(ProcessingPage_HowDidYouHearAboutUsXL.equalsIgnoreCase("Yes")) {
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_OnlineSearch))).click();
								System.out.println("Processing Page - Online Search");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_WebBanners))).click();
								System.out.println("Processing Page - Web Banners");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_ElectronicMailers))).click();
								System.out.println("ProcessingPage_ElectronicMailers");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_CIMBWebsite))).click();
								System.out.println("Processing Page - CIMB Website");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_OnlineSeminars))).click();
								System.out.println("Processing Page - Online Seminars");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Roadshows))).click();
								System.out.println("Processing Page - Road shows");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Seminars))).click();
								System.out.println("Processing Page - Seminars");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_BillboardsBusBusstopsBuildings))).click();
								System.out.println("Processing Page - Billboards/Bus/Busstops/Buildings");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Taxis))).click();
								System.out.println("Processing Page - Taxis");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_TrainsTrainStations))).click();
								System.out.println("Processing Page - Trains/TrainStations");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Television))).click();
								System.out.println("Processing Page - Television");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_PrintMedia))).click();
								System.out.println("Processing Page - Print Media");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Radio))).click();
								System.out.println("Processing Page - Radio");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_WordofMouth))).click();
								System.out.println("Processing Page - Word of Mouth");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_CIMBBranches))).click();
								System.out.println("Processing Page - CIMB Branches");
								driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_Mobile))).click();
								System.out.println("Processing Page - Mobile");
								System.out.println("Submit Feedback - Enabled");
							}
							else
							if(ProcessingPage_HowDidYouHearAboutUsXL.equalsIgnoreCase("No")) {
								//How Did You Hear About Us - Not enabled
								System.out.println("Submit Feedback - Not Enabled");
							}
							break;
						}//End of ID Mapping Section
					    
					}//End of For Loop.
					
			 }//End of Before You Submit Method   
					    
	}//End of Class
					

