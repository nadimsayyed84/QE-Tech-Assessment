package sg.casa.cimb.star.saver.ii;

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
import sg.casa.base.CrossSellWorkFlow;
import sg.casa.base.GettingStartedPageWorkFlow;
import sg.casa.base.Retunxlid;
import sg.casa.base.SG_CASA_UI_Elements;

public class StarSaver_i_WithCrossSellCreditCard {
	//Execute Fixed Deposit
		public static void ExecuteCrossSellCreditcard(String CreditCardID, String Section, WebDriver driver) throws InterruptedException, IOException {
		
			//Read xl
			String filePath = System.getProperty("user.dir");
			String sheetName = "Crosssell-Creditcard";
			String fileName = "Star_Saver_i.xlsx";
			
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
		    	
		        String xlAccountTypeID = row.getCell(Retunxlid.ApplicationInformation_CrossSell_CreditCard_XLSheetCrossReferenceID).getStringCellValue();	
		      //Cross Sell credit card
		        	//Personal Information
		        String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_SurnameXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_Surname).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCardXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCard).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenNameXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenName).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualificationXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualification).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NumberOfDependentsXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NumberOfDependents).getNumericCellValue());
			
				//Contact information
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileCode = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileCode).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileCode = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileCode).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship).getStringCellValue();
				
				// Address Information
				String AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyTypeXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyType).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_YearsXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Years).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_MonthsXL = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Months).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatusXL = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatus).getStringCellValue();
				
				//Job Information
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_GetAddressBtn = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_GetAddressBtn).getStringCellValue();	
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_Story = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_Story).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months).getNumericCellValue());
				
				//Credit Card
				String AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatmentType =row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatmentType).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress).getStringCellValue();
			
				//Supplimentary Card
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race).getStringCellValue();
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileCode = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileCode).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName).getStringCellValue();			
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No =row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No).getStringCellValue();			
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_GetAddressBtn = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_GetAddressBtn).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo).getNumericCellValue());
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName).getStringCellValue();			
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1 = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2 = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode).getNumericCellValue());
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus =row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany).getStringCellValue();			
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness).getStringCellValue();			
				
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus = row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus).getStringCellValue();
				String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Retunxlid.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit).getNumericCellValue());
				
				
				
				
		    	if(xlAccountTypeID.equalsIgnoreCase(CreditCardID)) {
					System.out.println("Credit Card xl Row ID " + xlAccountTypeID +  " ||    Parent xl Sheet Reference ID " + CreditCardID );

				if(Section.equalsIgnoreCase("Personal Information")) {
					//Surname
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_Surname))).sendKeys(AccountInfromation_CrossSelll_CreditCard_PersonalInformation_SurnameXL);
					System.out.println("Name to Appear on Card : " + AccountInfromation_CrossSelll_CreditCard_PersonalInformation_SurnameXL);
					// Name to Appear on Card
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCard))).sendKeys(AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCardXL);
					System.out.println("Name to Appear on Card : " + AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCardXL);
					// Mother's Maiden Name
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenName))).sendKeys(AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenNameXL);
					System.out.println("Mother's Maiden Name : " + AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenNameXL);	
					//Highest Qualification.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualification, AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualificationXL,driver);
					System.out.println("Highest Qualification : " + AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualificationXL);
					Thread.sleep(5000);
			}
			
			if(Section.equalsIgnoreCase("Contact Information")) {
				//Name
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name))).sendKeys(AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name);
				System.out.println("Name : " + AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name);
				//Primary Mobile Code Need to be Implement
				
				//Primary Mobile Number
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber))).sendKeys(AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber);
				System.out.println("Primary Mobile Number : " + AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber);
				
				//Secondary Mobile Code Type Need to be Implement
				
				
				//Secondary Mobile Code Need to be Implement
				
				//Secondary Mobile Number
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber))).sendKeys(AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber);
				System.out.println("Secondary Mobile Number : " + AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber);
				
				//Reletionship
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship, AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship,driver);
				System.out.println("Reletionship : " + AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship);
				Thread.sleep(5000);
			}
			if(Section.equalsIgnoreCase("Address Information")) {
				//Property Type
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyType, AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyTypeXL,driver);
				System.out.println("Property Type : " + AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyTypeXL);
				//Length Of Residence - Years
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Years))).sendKeys(AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_YearsXL);
				System.out.println("Length Of Residence - Years : " + AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_YearsXL);
				//Length Of Residence - Months
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Months))).sendKeys(AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_MonthsXL);
				System.out.println("Length Of Residence - Months : " + AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_MonthsXL);
				//Residence Status
				CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatus, AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatusXL,driver);
				System.out.println("Residence Status : " + AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatusXL);
				Thread.sleep(5000);
			}
			
			if(Section.equalsIgnoreCase("Job Information")) {
				//Postal Code
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode);
				System.out.println("Postal Code : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode);
				//Block / House Number
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber);
				System.out.println("Block / House Number : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber);
				//Street Name
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName);
				System.out.println("Street Name : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName);
				//Story
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_Story))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_Story);
				System.out.println("Story : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_Story);
				//Unit Number
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber);
				System.out.println("Unit Number : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber);
				//Building Name
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName);
				System.out.println("Building Name : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName);
				//Gross Annual Salary
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary);
				System.out.println("Gross Annual Salary : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary);
				//Length of Employment - Years
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years);
				System.out.println("Length of Employment - Years : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years);
				//Length of Employment - Months
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months))).sendKeys(AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months);
				System.out.println("Length of Employment - Months : " + AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months);
				Thread.sleep(5000);
			}
			
			if(Section.equalsIgnoreCase("Credit Card")) {
			//Execute Credit Section
				//User click on I do not have a preferred credit limit and agree to any credit limit determined by the Bank "Check Box"
				//Yes == Checked
				if(AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit.equalsIgnoreCase("Yes")) {
					System.out.println("I do not have a preferred credit limit and agree to any credit limit determined by the Bank : " +  AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit);
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit))).click();
				}
				else {
					//What is your preferred credit limit ?
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount))).sendKeys(AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount);
					System.out.println("What is your preferred credit limit ? : " + AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount);
				}
				
				//Do you want a PIN (Personal Identification Number to be issued to you ?
				driver.findElement(org.openqa.selenium.By.xpath((CrossSellWorkFlow.GetCrossSell_CreditCard_DoYouWantAPINXpath(AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN)))).click();
				System.out.println("Do you want a PIN (Personal Identification Number to be issued to you ? : " + AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN);
			
				//Which type of monthly statements do you prefer ?
				driver.findElement(org.openqa.selenium.By.xpath((CrossSellWorkFlow.GetCrossSell_CreditCard_MonthlyStatementsXpath(AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatmentType)))).click();
				System.out.println("Which type of monthly statements do you prefer ? : " + AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatmentType);
				
				//Which address would you want the card and statements to be delivered to?
				driver.findElement(org.openqa.selenium.By.xpath((CrossSellWorkFlow.GetCrossSell_CreditCard_MonthlyStatements_DeliveredAddressXpath(AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress)))).click();
				System.out.println("Which address would you want the card and statements to be delivered to? : " + AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress);
				
				Thread.sleep(5000);
			}
			
			if(Section.equalsIgnoreCase("Supplementary Card")) {
			//Do you wish to add a supplementary card holder?
				driver.findElement(org.openqa.selenium.By.xpath((CrossSellWorkFlow.GetCrossSell_SupplementaryCard_DoYouWishTOAddASupplementaryCardHolderXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard)))).click();
				System.out.println("Which address would you want the card and statements to be delivered to? : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard);
				if(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard.equalsIgnoreCase("Yes")) {
					//Relationship to Principal
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal,driver);
					System.out.println("Relationship to Principal : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal);
					//Name to appear on Supplementary Card
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard);
					System.out.println("Name to appear on Supplementary Card : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard);
					//Title
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title,driver);
					System.out.println("Title : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title);		
					
					//Surname
					//driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname);
					//System.out.println("Surname : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname);	
					
					//Applicant Name (as per NRIC/Passport)
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName);
					System.out.println("Applicant Name (as per NRIC/Passport) : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName);	
					//Alias (as per NRIC/Passport,where applicable)
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias);
					System.out.println("Alias (as per NRIC/Passport,where applicable) : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias);	
					//Nationality
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality,driver);
					System.out.println("Nationality : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality);		
					//User click on Are You Singaporen Option.
					if(!AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR.equalsIgnoreCase("Default")) {
					driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetSupplementaryCardIsSingaporePRXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR))).click();
					System.out.println("Are you Singaporean ?  :" + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR);
					}	
					//User enter NRIC, Malayasia IC
					driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetSupplementaryCardNRICandPassportNumberPRXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC);
					System.out.println("User NRIC | IC | Passport Number : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC);	
					//User Enter Passport Expiry date
					if(!AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry.equalsIgnoreCase("N/A"))
					driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetSupplementaryCardPassportExpiryPRXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry);
					System.out.println("Passport Expiry date : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry);
					//User enter date of Birth.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth);
					System.out.println("Date Of Birth : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth);	
					//Gender.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender,driver);
					System.out.println("Gender : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender);
					
					//Marital Status.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus,driver);
					System.out.println("Marital Status : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus);
					
					//Race.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race,driver);
					System.out.println("Race : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race);
					
					//Mobile Number
					driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber);
					System.out.println("Mobile Number : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber);	
					//Mother's Maiden Name
					driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName);
					System.out.println("Mother's Maiden Name : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName);
					
					//Residential Address
					driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetSupplementaryCard_ResidentialAddressSelectionPRXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress))).click();
					System.out.println("Residential Address ?  :" + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress);
					
					//Residential Address - Local / Foreign
					driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetSupplementaryCard_ResidentialAddressSelectionLocalForeignPRXpath(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No))).click();
					System.out.println("Residential Address - Local / Foreign  :" + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No);
					if(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No.equalsIgnoreCase("Local Address")) {
						//Postal Code
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode);
						System.out.println("Postal Code : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode);
						//Block/House No
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo);
						System.out.println("Block/House No : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo);
						//Street Name
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName);
						System.out.println("Street Name : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName);
						//Storey
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story);
						System.out.println("Storey : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story);
						// Unit No.
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo);
						System.out.println("Unit No. : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo);
						// Building Name (If applicable)
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName);
						System.out.println("Building Name (If applicable) : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName);
					}
					else {
						//Country.
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country,driver);
						System.out.println("Country. : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country);
						// Foreign Address Line 1
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1);
						System.out.println("Foreign Address Line 1 : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1);
						// Foreign Address Line 2
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2);
						System.out.println("Foreign Address Line 2 : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2);
						// Postal Code
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode)).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode);
						System.out.println("Postal Code : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode);
					}//End of Foreign Address
				
					//Select Employment Status
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus,driver);
					System.out.println("Employment Status : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus);
					//Occupation
					if(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus.contentEquals("Employed") || AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus.contentEquals("Self-employed") || AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus.contentEquals("Commission")) {	
						//Select Occupation ID
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation,driver);
						System.out.println("Occupation : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation);
						
						//Name of Company
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany);
						System.out.println("Name Of Company : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany);
						
						//Select Nature of Business
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness, AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness,driver);
						System.out.println("Nature of Business : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness);
					}
				
					//User click on I do not have a preferred credit limit and agree to any credit limit determined by the Bank
					//Yes == Checked
					if(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus.equalsIgnoreCase("Yes")) {
						System.out.println("I do not have a preferred credit limit and agree to any credit limit determined by the Bank : " +  AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus);
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus))).click();
					}
					else {
						//What is your preferred credit limit ?
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit))).sendKeys(AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit);
						System.out.println("What is your preferred credit limit ? : " + AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit);
					}
				
				}
				Thread.sleep(5000);
			}
			
			break;
		    	}//End of ID Mapping 
		    	
				
	
		    }//End of For loop
		    
		}//End Of Methord

}//End of Calss
