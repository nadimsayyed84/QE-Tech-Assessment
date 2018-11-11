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
import com.ford.automation.base.BaseTest;

import sg.casa.base.ApplicationInformationPageWorkFlow;
import sg.casa.base.CommonMethords;
import sg.casa.base.JointApplicantWorkFlow;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class StarSaver_i_Saving_Joint extends BaseTest{
	
	public static void ExecuteJointAccount(String JointID, WebDriver driver) throws InterruptedException, IOException {
		//Read xl
		String filePath = System.getProperty("user.dir");
		String sheetName = "Joint";
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
	    	String xlAccountTypeID = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_AccountTypeID).getStringCellValue();	
	    
	    	System.out.println("Joint Account Row ID : " + i);
	    	
	    	if(JointID.equalsIgnoreCase(xlAccountTypeID)) {
			  System.out.println("Str Value " + xlAccountTypeID);
		    	  System.out.println("Joint ID Value " + JointID);
		    	
		    	//Read the xl Row 
		    	//Personal Information
		    	String ApplicationInformation_Joint_PersonalInformation_TitleXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_Title).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_ApplicantNameXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_ApplicantName).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_AliasXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_Alias).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_NationalityXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_Nationality).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_SingaporePRXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_SingaporePR).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_NRIC_PassportNumberXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_NRIC_PassportNumber).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_PassportExpiryXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_PassportExpiry).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_DateOfBirthXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_DateOfBirth).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_CountryofBirthXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_CountryofBirth).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_PlaceofBirthXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_PlaceofBirth).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_GenderXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_Gender).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_MaritalStatusXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_MaritalStatus).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_RaceXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_Race).getStringCellValue();
		    	String ApplicationInformation_Joint_PersonalInformation_PrimarySourceOfWealthXl = row.getCell(Retunxlid.ApplicationInformation_Joint_PersonalInformation_PrimarySourceOfWealth).getStringCellValue();
		   
		    	//Contact Information
		    	String ApplicationInformation_Joint_ContactInformation_PrimaryMobileCodeXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_PrimaryMobileCode).getNumericCellValue());
		    	String ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumberXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumber).getNumericCellValue());
		    	String ApplicationInformation_Joint_ContactInformation_PrimaryEmailXL = row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_PrimaryEmail).getStringCellValue();
		    	String ApplicationInformation_Joint_ContactInformation_SecondaryMobileTypeXL = row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_SecondaryMobileType).getStringCellValue();
		    	String ApplicationInformation_Joint_ContactInformation_SecondaryMobileCodeXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_SecondaryMobileCode).getNumericCellValue());
		    	String ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumberXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumber).getNumericCellValue());
		    	
		    	//Address Information Residential Address
		    	String ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No).getStringCellValue();
				//Local
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCodeXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCode).getNumericCellValue());
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_GetAddressBtnXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_GetAddressBtn).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumberXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumber).getNumericCellValue());
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_StoryXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_Story).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumberXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumber).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetNameXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetName).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingNameXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingName).getStringCellValue();
		    		//Foreign
		    	String ApplicationInformation_Joint_AddressInformation_ForeignAddress_CountryXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_ForeignAddress_Country).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1XL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2XL = row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2).getStringCellValue();
		    	String ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCodeXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCode).getNumericCellValue());
		    
		   //Job Information
		    	String ApplicationInformation_Joint_JobInformation_EmploymentStatusXL = row.getCell(Retunxlid.ApplicationInformation_Joint_JobInformation_EmploymentStatus).getStringCellValue();
		    	String ApplicationInformation_Joint_JobInformation_OccupationXL = row.getCell(Retunxlid.ApplicationInformation_Joint_JobInformation_Occupation).getStringCellValue();
		    	String ApplicationInformation_Joint_JobInformation_NameOfCompanyXL = row.getCell(Retunxlid.ApplicationInformation_Joint_JobInformation_NameOfCompany).getStringCellValue();
		    	String ApplicationInformation_Joint_JobInformation_NatureOfBusinessXL = row.getCell(Retunxlid.ApplicationInformation_Joint_JobInformation_NatureOfBusiness).getStringCellValue();
		    	
		    //Account Preferences.	
		    	String ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCardXL = row.getCell(Retunxlid.ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard).getStringCellValue();
		    	
 	
		    	
		    	//Personal Information
		    		//User click on Personal Information panel
		    		driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.Joint_ApplicationInformation_PersonalInformation_PanelClick())).click();
				Thread.sleep(2000);
				System.out.println("Personal Information Section............................");
	
		    	//Title
		    	//Gender.
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_Title, ApplicationInformation_Joint_PersonalInformation_TitleXl,driver);
				System.out.println("Title : " + ApplicationInformation_Joint_PersonalInformation_TitleXl);
		    	
		    	//Applicant Name
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_ApplicantName))).sendKeys(ApplicationInformation_Joint_PersonalInformation_ApplicantNameXl);
				System.out.println("Applicant Name : " + ApplicationInformation_Joint_PersonalInformation_ApplicantNameXl);
		    	
		    	//Alias Name
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_Alias))).sendKeys(ApplicationInformation_Joint_PersonalInformation_AliasXl);
				System.out.println("Alias Name : " + ApplicationInformation_Joint_PersonalInformation_AliasXl);
		    	
		    	//Nationality Name
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_Nationality, ApplicationInformation_Joint_PersonalInformation_NationalityXl,driver);
				System.out.println("Nationality : " + ApplicationInformation_Joint_PersonalInformation_NationalityXl);
	
			//User click on Are You Singaporen Option.
				if(!ApplicationInformation_Joint_PersonalInformation_SingaporePRXl.equalsIgnoreCase("Default")) {
				driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_IsSingaporePRXpath(ApplicationInformation_Joint_PersonalInformation_SingaporePRXl))).click();
				System.out.println("Are you Singaporean ?  :" + ApplicationInformation_Joint_PersonalInformation_SingaporePRXl);
				}	
				
		   //User enter NRIC, Malayasia IC
			  Thread.sleep(2000);
			  driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_NRICandPassportNumberPRXpath(ApplicationInformation_Joint_PersonalInformation_SingaporePRXl, ApplicationInformation_Joint_PersonalInformation_NationalityXl))).sendKeys(ApplicationInformation_Joint_PersonalInformation_NRIC_PassportNumberXl);
			  System.out.println("User NRIC | IC | Passport Number : " + ApplicationInformation_Joint_PersonalInformation_NRIC_PassportNumberXl);	
		  
		   //User Enter Passport Expiry date
			  if(!ApplicationInformation_Joint_PersonalInformation_PassportExpiryXl.equalsIgnoreCase("N/A"))
			  driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_PassportExpiryPRXpath(ApplicationInformation_Joint_PersonalInformation_SingaporePRXl, ApplicationInformation_Joint_PersonalInformation_NationalityXl))).sendKeys(ApplicationInformation_Joint_PersonalInformation_PassportExpiryXl);
			  System.out.println("Passport Expiry date : " + ApplicationInformation_Joint_PersonalInformation_PassportExpiryXl);	    	  
			  
		  //User enter date of Birth.
			  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_DateOfBirth))).click();
			  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_DateOfBirth))).sendKeys(ApplicationInformation_Joint_PersonalInformation_DateOfBirthXl);
			  System.out.println("Date Of Birth : " + ApplicationInformation_Joint_PersonalInformation_DateOfBirthXl);	  

		 //User enter Country of Birth.
			  CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_CountryOfBirth, ApplicationInformation_Joint_PersonalInformation_CountryofBirthXl,driver);
			  System.out.println("Country Of Birth : " + ApplicationInformation_Joint_PersonalInformation_CountryofBirthXl);	 
			  
		//User enter Place of Birth.
			  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_PlaceOfBirth))).sendKeys(ApplicationInformation_Joint_PersonalInformation_PlaceofBirthXl);
			  System.out.println("Place Of Birth : " + ApplicationInformation_Joint_PersonalInformation_PlaceofBirthXl);	  	  
		
		//User enter Gender
			  CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_Gender, ApplicationInformation_Joint_PersonalInformation_GenderXl,driver);
			  System.out.println("Gender : " + ApplicationInformation_Joint_PersonalInformation_GenderXl);	 	  
			  
		//User enter Marital Status
			  CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_MaritalStatus, ApplicationInformation_Joint_PersonalInformation_MaritalStatusXl,driver);
			  System.out.println("Marital Status : " + ApplicationInformation_Joint_PersonalInformation_MaritalStatusXl);	 		  
		
		//User enter Race
			  CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_Race, ApplicationInformation_Joint_PersonalInformation_RaceXl,driver);
			  System.out.println("Race : " + ApplicationInformation_Joint_PersonalInformation_RaceXl);	 	  
			  
		//User enter Primary Source of Wealth
			  CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_PrimarySourceOfWealth, ApplicationInformation_Joint_PersonalInformation_PrimarySourceOfWealthXl,driver);
			  System.out.println("Primary Source of Wealth : " + ApplicationInformation_Joint_PersonalInformation_PrimarySourceOfWealthXl);	  
			  
//Contact Information.
      //User open the Contact Information Panel.	  	
			  driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.Joint_ApplicationInformation_ContactInformation_PanelClick())).click();
				Thread.sleep(3000);
				System.out.println("Contact Information Section............................");
			  
		//Enter Contact Information
				//User enter Primary Mobile Number.
				  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumber))).sendKeys(ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumberXL);
				  System.out.println("Primary Mobile Number : " + ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumberXL);	  
			  
				//User enter Primary Mobile Number.
				  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_ContactInformation_PrimaryEmail))).sendKeys(ApplicationInformation_Joint_ContactInformation_PrimaryEmailXL);
				  System.out.println("Email : " + ApplicationInformation_Joint_ContactInformation_PrimaryEmailXL); 
			  
				// User click on Secondary Mobile Type , Home, Office.
				  driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_SecondaryPhoneTypeXpath(ApplicationInformation_Joint_ContactInformation_SecondaryMobileTypeXL))).click();
				  System.out.println("Secondary Mobile Type : " + ApplicationInformation_Joint_ContactInformation_SecondaryMobileTypeXL); 
				  
				//User enter Secondary Mobile Number.
				  driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumber))).sendKeys(ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumberXL);
				  System.out.println("Primary Mobile Number : " + ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumberXL);	   
				   
	//Address Information
		//User open the Address Information Panel.	  	
		driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.Joint_ApplicationInformation_AddressInformation_PanelClick())).click();
		Thread.sleep(3000);
		System.out.println("Address Information Section............................");
		  //Residential Address Type
				  driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_AddressInformation_ResidentialAddressTypeXpath(ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type))).click();
				  System.out.println("Residential Address Type : " + ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type);   
				  
		// Is Residential Address Type = "No"	  
				  if(ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type.equalsIgnoreCase("No")) {
					  driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_AddressInformation_ResidentialAddressIsnotSameAsprincipalTypeXpath(ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No))).click();
					  System.out.println("Residential Address Type - Is Same as principal == No : " + ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No); 
					  
					  if(ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No.equalsIgnoreCase("Local Address")) {
						//Postal Code
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCode))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCodeXL);
							System.out.println("Postal Code : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCodeXL);
							//Block House Number
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumber))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumberXL);
							System.out.println("Block House Number : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumberXL);
							//Street Name
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetName))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetNameXL);
							System.out.println("Street Name : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetNameXL);
							//Story
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_Story))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_StoryXL);
							System.out.println("Story : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_StoryXL);
							//Unit Number
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumber))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumberXL);
							System.out.println("Unit Number : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumberXL);
							//Building Name
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingName))).sendKeys(ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingNameXL);
							System.out.println("Building Name : " + ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingNameXL);
					  }
					  else {
						  //Foreign Address
						//Country
							CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_ForeignAddress_Country, ApplicationInformation_Joint_AddressInformation_ForeignAddress_CountryXL,driver);
							System.out.println("Country : " + ApplicationInformation_Joint_AddressInformation_ForeignAddress_CountryXL);		
							
							//Address Line 1
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1))).sendKeys(ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1XL);
							System.out.println("Address Line 1 : " + ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1XL);
							
							//Address Line 2
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2))).sendKeys(ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2XL);
							System.out.println("Address Line 2 : " + ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2XL);
							
							//Postal Code
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCode))).sendKeys(ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCodeXL);
							System.out.println("Postal Code : " + ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCodeXL);
					  }
				  }
		//Job Information
		//User open the Job Information Panel.	  	
		driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.Joint_ApplicationInformation_JobInformation_PanelClick())).click();
		Thread.sleep(3000);		   
		System.out.println("Job Information Section............................");
		
				//Select Employment Status
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_JobInformation_EmploymentStatus, ApplicationInformation_Joint_JobInformation_EmploymentStatusXL,driver);
				System.out.println("Employment Status : " + ApplicationInformation_Joint_JobInformation_EmploymentStatusXL);
				
				//Check xl value to select other fields.
				if(ApplicationInformation_Joint_JobInformation_EmploymentStatusXL.contentEquals("Employed") || ApplicationInformation_Joint_JobInformation_EmploymentStatusXL.contentEquals("Self-employed") || ApplicationInformation_Joint_JobInformation_EmploymentStatusXL.contentEquals("Commission")) {	
					//Select Occupation ID
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_JobInformation_Occupation, ApplicationInformation_Joint_JobInformation_OccupationXL,driver);
					System.out.println("Occupation : " + ApplicationInformation_Joint_JobInformation_OccupationXL);
					
					//Name of Company
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Joint_JobInformation_NameOfCompany))).sendKeys(ApplicationInformation_Joint_JobInformation_NameOfCompanyXL);
					System.out.println("Name Of Company : " + ApplicationInformation_Joint_JobInformation_NameOfCompanyXL);
					
					//Select Nature of Business
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Joint_JobInformation_NatureOfBusiness, ApplicationInformation_Joint_JobInformation_NatureOfBusinessXL,driver);
					System.out.println("Nature of Business : " + ApplicationInformation_Joint_JobInformation_NatureOfBusinessXL);
				}
		
	 //Account Preferences Section. 
			 //User click on Account Preferences Panel to expand
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.Joint_ApplicationInformation_AccountPreferences_PanelClick())).click();
					System.out.println();
					System.out.println("Account Preferences Section............................");
					Thread.sleep(2000);
					driver.findElement(org.openqa.selenium.By.xpath(JointApplicantWorkFlow.SetJointApplicant_ApplicationInformation_AccountPreferencesXpath(ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCardXL))).click();
					System.out.println("Do You Need an ATM Card :" + ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCardXL);			
				  
					break;
		    	}	
	    }	
	    Thread.sleep(3000); // After for Loop	
		
		
	}//End of Function
	
} // End of Class
