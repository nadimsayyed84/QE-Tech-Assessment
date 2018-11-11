package sg.casa.cimb.star.saver.saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ford.automation.base.BaseTest;

import sg.casa.base.CommonMethords;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class StarSaverSaving_ThankYou extends BaseTest{
	
//	public static String downloadDir = "/Users/arpit/Downloads";
	public static String downloadDir = System.getProperty("user.home")+"/Downloads";
	public static String fileExtension = ".pdf";
		//Execute Thank You Page
			public static void ExecuteThankYou(String ParentMappingID, WebDriver driver) throws InterruptedException, IOException {
				//Read xl
						String filePath = System.getProperty("user.dir");
						String sheetName = "ThankYouPage";
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
					    	
						    String ThankYouPageIDXL = row.getCell(Retunxlid.ThankYouPage_Mappingxlid).getStringCellValue();	
						
							if(ThankYouPageIDXL.equalsIgnoreCase(ParentMappingID)) {
								System.out.println("Thank You Page ID " + ThankYouPageIDXL +  " ||  Parent Key ID " + ParentMappingID);
								System.out.println("Thank You Page Testing");
								
								WebElement element = (new WebDriverWait(driver, 140)).until(ExpectedConditions.elementToBeClickable(By.xpath(SG_CASA_UI_Elements.ThankYouPage_DownloadApplication)));
								//Time Calculation
								String filename=row.getCell(2).getStringCellValue();
								long time = System.currentTimeMillis();
								new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SG_CASA_UI_Elements.ThankYouPage_DownloadApplication)));
								long CTAdisplayTime = System.currentTimeMillis() - time;
								System.out.println(String.format("The Download CTA appeared after %d milliseconds", CTAdisplayTime));
								
								//Read the application number and write in the Excel sheet
								if(driver.findElements(By.xpath(SG_CASA_UI_Elements.ThankYouPage_ApplicationNumber)).size()>0) {
									String ApplicationNumber = driver.findElement(By.xpath(SG_CASA_UI_Elements.ThankYouPage_ApplicationNumber)).getText();
									Cell cell= guru99Sheet.getRow(i).createCell(1); //create first column
									cell.setCellValue(ApplicationNumber);
								}else if(driver.findElements(By.xpath("//*[contains(text(),'Thank you') and not(contains(@class,'hide'))]")).size()>0) {
									System.out.println("Thank you page displayed however application number does not generated.");
								}
//								inputStream.close();
								
								
								// Download and validate the application pdf
								if(element.getText().equalsIgnoreCase("Download Application"))
								{
									element.click();
									System.out.println("Application Downloaded");
//									String getLatestFile = CommonMethords.getDownloadedDocumentName(downloadDir, fileExtension);
//									//System.out.println("File Downloaded"+ getLatestFile);
//									if(getLatestFile.contains("application"))
//									{
//										System.out.println("Correct File Downloaded");
//									}
//									else
//									{
//										System.out.println("Correct File not Downloaded");
//									}
//									//Write Downloaded File Name into Excel Sheet
//									Cell cell2= guru99Sheet.getRow(i).createCell(2); //create first column
//									cell2.setCellValue(getLatestFile);
//									inputStream.close();
									
//									//Added by Nadim
//									String Brochurepath = downloadDir + "/" + filename + ".pdf";
//									File filepath = new File(Brochurepath);
//									int chkfile=0;
//									do {
//										Thread.sleep(5000);
//										chkfile++;
//									}while(!filepath.exists() && chkfile<=72);
//									
//									if (filepath.exists()) {
//										System.out.println("Application downloaded successfully: " + Brochurepath);
//										filepath.delete();
//									} else {
//										Assert.assertFalse("Application download failed, pdf file does not exist locally", true);
//									}
								}
								
								//Download button disappear after 3 mins.
								new WebDriverWait(driver, 200).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SG_CASA_UI_Elements.ThankYouPage_DownloadApplication)));
								long CTAdisappearTime = System.currentTimeMillis() - time;
								System.out.println(String.format("The Download CTA disappeared after %d milliseconds", CTAdisappearTime));
								long totalTime = CTAdisappearTime - CTAdisplayTime; 
								long totalTimeMin = (totalTime/60000);
								System.out.println(String.format("The Download CTA disappeared after %d minutes", totalTimeMin));
								
								//Create object of output file 
								FileOutputStream outputStream = new FileOutputStream(file);
								guru99Workbook.write(outputStream);
								outputStream.close();
								
								
							break;
							}//End of ID Mapping Section
						    
						}//End of For Loop.
						
				 }//End of Before You Submit Method   
						    
		}//End of Class
						