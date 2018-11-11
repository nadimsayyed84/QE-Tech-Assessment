package sg.casa.cimb.fast.saver.ii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ford.automation.base.BaseTest;

import PageObjectModel.UploadFilePageObjModel;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.findby.By;
import sg.casa.base.*;
import sg.casa.cimb.star.saver.i.saving.Star_Saver_i_saving_Retunxlid;
import sg.casa.cimb.star.saver.saving.StarSaverSaving_BeforeYouSubmit;
import sg.casa.cimb.star.saver.saving.StarSaverSaving_Processing;
import sg.casa.cimb.star.saver.saving.StarSaverSaving_ThankYou;
import sg.casa.cimb.star.saver.saving.Star_Saver_Saving_Retunxlid;

public class Fast_saver_ii extends BaseTest {

	// Getting Started
	// Page...................................................................
	public String User_Nationality = "";
	Boolean isSingaporePR = false;

	@SuppressWarnings("deprecation")
	@When("^User Execute Without CrossSell Testcases$")
	public void user_Execute_Without_CrossSell_Testcases() throws Throwable {

		// Read xl
		String filePath = System.getProperty("user.dir");
		String sheetName = "Individual";
		String fileName = "Fast_Saver_i.xlsx";

		System.out.print("File path......." + filePath);
		File file = new File(filePath + "/" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file

		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class

			guru99Workbook = new XSSFWorkbook(inputStream);

		}

		// Check condition if the file is xls file

		else if (fileExtensionName.equals(".xls")) {

			// If it is xls file then create object of XSSFWorkbook class

			guru99Workbook = new HSSFWorkbook(inputStream);

		}

		// Read sheet inside the workbook by its name

		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

		// Find number of rows in excel file

		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		System.out.println("Row Count :" + rowCount);

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		driver.close();
		driver.switchTo().window("testwindow");
		js.executeScript("window.moveTo(0,0);");
		js.executeScript("window.resizeTo(1450,1000);");
		
		for (int i = 3; i <= rowCount; i++) {
			Row row = guru99Sheet.getRow(i);

			// Start Only Pending Usecases
			String TestcaseStatus = row.getCell(Fast_saver_i_Retunxlid.Testcase_StatusExcelId).getStringCellValue();
			if (TestcaseStatus.equalsIgnoreCase("Run")) {
				try {
					System.out.println("********************* Product :  Star Saver Savings ********************* ");
					System.out.println("++++++++++++++++++++++++++++++++++++++Test Case Execution Excel Row ID : " + i + " Test Case Status : " + TestcaseStatus + " +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ");

					driver.get(IbaseUrl.FastSaver_i);
					Thread.sleep(5000);

					// Getting Started Page
					String Title_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_Title_xlid).getStringCellValue();
					String FullName_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_FullName_xlid).getStringCellValue();
					String SingaporePR_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_SingaporePR_xlid).getStringCellValue();
					String Nationality_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_Nationality_xlid).getStringCellValue();
					String NRICandPassportNumber_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_NRICANDPassportNUmber_xlid).getStringCellValue();
					String PassportExpiryDate_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_PassportExpiryDate_xlid).getStringCellValue();
					String DateOfBirth_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_DateOfBirth_xlid).getStringCellValue();
					String Email_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_Email_xlid).getStringCellValue();
					double mobilel_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_MobileNumber_xlid).getNumericCellValue();
					String strMobileNumber = Double.toString(mobilel_xlValue);
					String termsandCondition_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_TermsandCondition_xlid).getStringCellValue();
					String gettingstartedBtn_xlValue = row.getCell(Fast_saver_i_Retunxlid.GS_StartButton_xlid).getStringCellValue();

					// Account Information Page.
					String AccountType_xlValue = row.getCell(Fast_saver_i_Retunxlid.ACI_AccountType_xlid).getStringCellValue();
					String PurposeOfAccount_xlValue = row.getCell(Fast_saver_i_Retunxlid.ACI_PurposeOfAccount_xlid).getStringCellValue();
					String SourceOfFundsForInitialDeposit_xlValue = row.getCell(Fast_saver_i_Retunxlid.ACI_SourceOfFundsForInitalDeposit_xlid).getStringCellValue();
					String EStatment_xlValue = row.getCell(Fast_saver_i_Retunxlid.ACI_EStatment_xlid).getStringCellValue();
					String AccountInformation_IsUserApplyForCrossSellXL = row.getCell(Fast_saver_i_Retunxlid.AccountInformation_IsUserApplyForCrossSell).getStringCellValue();
					String ACI_IsSupplimentrayCardIsApplicableXL = row.getCell(Fast_saver_i_Retunxlid.ACI_IsSupplimentrayCardIsApplicable).getStringCellValue();
					String AccountInformation_CrosssellproductTypeXL = row.getCell(Fast_saver_i_Retunxlid.AccountInformation_CrosssellproductType).getStringCellValue();

					String AccountInformation_Crosssel_CrossReferenceIDXL = row.getCell(Fast_saver_i_Retunxlid.AccountInformation_Crosssel_CrossReferenceID).getStringCellValue();
					String Applicationinfobtn_xlValue = row.getCell(Fast_saver_i_Retunxlid.ACI_ApplicationinfoBtn_xlid).getStringCellValue();

					// Application Information - Individual - Personal Information
					String APInfo_Indi_Prin_AliasName_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_AliasName_xlid).getStringCellValue();
					String APInfo_Indi_Prin_PrimaryId_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_PrimaryId_xlid).getStringCellValue();
					String APInfo_Indi_Prin_CountryOfBirth_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_CountryOfBirth_xlid).getStringCellValue();
					String APInfo_Indi_Prin_PlaceOfBirth_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_PlaceOfBirth_xlid).getStringCellValue();
					String APInfo_Indi_Prin_Gender_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_Gender_xlid).getStringCellValue();
					String APInfo_Indi_Prin_MaritalStatus_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_MaritalStatus_xlid).getStringCellValue();
					String APInfo_Indi_Prin_Race_xlvalue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_Race_xlid).getStringCellValue();
					String APInfo_Indi_Prin_PrimarySourceOfWelth_xlValue = row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_PrimarySourceOfWelth_xlid).getStringCellValue();
					// Individual - Contact Information
					String APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xlid).getNumericCellValue());
					// Individual - Address Information - Residential Address
					String ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlvalue = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlid).getStringCellValue();
					// Local Address
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexlid).getNumericCellValue());
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxlid).getNumericCellValue());
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Storyxlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexlid).getStringCellValue();
					// Foreign Address
					String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexlid).getNumericCellValue());
					// Individual - Address Information - Mailing Address
					String ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlid).getStringCellValue();
					String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_isResidentialid).getStringCellValue();

					// Local Address
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_PostalCodexlidxl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_PostalCodexlid).getNumericCellValue());
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_IsuserClickOnGetAddressButtonxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_IsuserClickOnGetAddressButton).getStringCellValue();
					// String
					// ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlidxl
					// =
					// row.getCell(Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlidxl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlid).getNumericCellValue());
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_Streetnamexlidxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_Streetnamexlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddress_Local_Storyxlidxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddress_Local_Storyxlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_UnitNumberxlidxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_UnitNumberxlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BuildingNamexlidxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BuildingNamexlid).getStringCellValue();

					// Foreign Address
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Countryxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Countryxlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine1xl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine1xlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine2xl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine2xlid).getStringCellValue();
					String ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Postalcodexl = CommonMethords.GetNumbersConvertToStringValue(row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Postalcodexlid).getNumericCellValue());

					// JOB Information Section.
					String ApplicationInformation_Principal_JobInformation_EmploymentStatusxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_JobInformation_EmploymentStatusxlid).getStringCellValue();
					String ApplicationInformation_Principal_JobInformation_Occupationxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_JobInformation_Occupationxlid).getStringCellValue();
					String ApplicationInformation_Principal_JobInformation_NameOfCompanyxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_JobInformation_NameOfCompanyxlid).getStringCellValue();
					String ApplicationInformation_Principal_JobInformation_NatureOfbusinessxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_JobInformation_NatureOfbusinessxlid).getStringCellValue();

					// Account Preferences Section.
					String ApplicationInformation_Principal_AccountPreferences_DoYouNeedaATMCardxl = row.getCell(Fast_saver_i_Retunxlid.ApplicationInformation_Principal_AccountPreferences_DoYouNeedaATMCardxlid).getStringCellValue();

					// Cross Sell credit card

					// Getting Start Page
					System.out.println("Getting Start Page.........................");

					// Select Title
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.E_GS_Title, Title_xlValue, driver);
					System.out.println("Title :" + Title_xlValue);

					// Full Name
					driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.E_GS_FullName)).sendKeys(FullName_xlValue);
					System.out.println("Full Name :" + FullName_xlValue);

					// Select Title
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.E_GS_Nationality, Nationality_xlValue, driver);
					System.out.println("Nationality  :" + Nationality_xlValue);

					// User click on Are You Singaporen Option.
					if (!SingaporePR_xlValue.equalsIgnoreCase("Default")) {
						driver.findElement(org.openqa.selenium.By.xpath(GettingStartedPageWorkFlow.GetGettingstartPageIsSingaporePRXpath(SingaporePR_xlValue))).click();
						System.out.println("Are you Singaporean ?  :" + SingaporePR_xlValue);
					}

					// User enter NRIC, Malayasia IC
					driver.findElement(org.openqa.selenium.By.xpath(GettingStartedPageWorkFlow.GetGettingstartPageNRICandPassportNumberPRXpath(SingaporePR_xlValue, Nationality_xlValue))).sendKeys(NRICandPassportNumber_xlValue);
					System.out.println("User NRIC | IC | Passport Number : " + NRICandPassportNumber_xlValue);

					// User Enter Passport Expiry date
					if (!PassportExpiryDate_xlValue.equalsIgnoreCase("N/A"))
						driver.findElement(org.openqa.selenium.By.xpath(GettingStartedPageWorkFlow.GetGettingstartPagePassportExpiryPRXpath(SingaporePR_xlValue, Nationality_xlValue))).sendKeys(PassportExpiryDate_xlValue);
					System.out.println("Passport Expiry date : " + PassportExpiryDate_xlValue);

					// User enter date of Birth.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Date_Of_Birth))).click();
					System.out.println("Date Of Birth : Click on that");
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Date_Of_Birth))).sendKeys(DateOfBirth_xlValue);
					System.out.println("Date Of Birth : " + DateOfBirth_xlValue);

					// User enter Email.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Email))).sendKeys(Email_xlValue);
					System.out.println("Email : " + Email_xlValue);

					// User enter Mobile Number.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Mobile_Number))).sendKeys(strMobileNumber);
					System.out.println("Mobile Number : " + mobilel_xlValue);

					// User click on Terms & Condition Button.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Terms_and_Conditions))).click();
					System.out.println("Does User Click on Terms & Condition :" + termsandCondition_xlValue);

					// User click on Getting Start page Button
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.E_GS_Start_Application))).click();
					System.out.println("Does User Click on Getting Start Button :" + gettingstartedBtn_xlValue);
					Thread.sleep(5000);

					// Account Information Page
					// User select Account Type.
					System.out.println();
					System.out.println("Account Information Page............................");
					Thread.sleep(1000);
					if (!AccountType_xlValue.equalsIgnoreCase("Individual")) {
						driver.findElement(org.openqa.selenium.By.xpath(AccountInformationPageWorkFlow.GetAccountInformationpageAccountTypeXpath(AccountType_xlValue))).click();
						System.out.println("User Select Account Type :" + AccountType_xlValue);
					}

					// User select Purpose of Account.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.E_ACI_PurposeOfAccount, PurposeOfAccount_xlValue, driver);
					System.out.println("Purpose of Account : " + PurposeOfAccount_xlValue);

					// User select Source of Fund.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.E_ACI_SourceOfFundsForInitialDeposit, SourceOfFundsForInitialDeposit_xlValue, driver);
					System.out.println("Purpose of Account : " + SourceOfFundsForInitialDeposit_xlValue);

					// Is User select cross sell
					System.out.println("Is User select cross sell : " + AccountInformation_IsUserApplyForCrossSellXL);
					if (!AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("WithOut Crosssell")) {
						Thread.sleep(5000);
						driver.findElement(org.openqa.selenium.By.xpath(CrossSellWorkFlow.GetCrosssellXpath(AccountInformation_CrosssellproductTypeXL))).click();
					}
					Thread.sleep(4000);
					// User click onAccount Information Button.
					driver.findElement(org.openqa.selenium.By.xpath(AccountInformationPageWorkFlow.GetAccountInformationpageApplicationinfoBtnXpath(Applicationinfobtn_xlValue))).click();
					System.out.println("Does User click on Account Information Button : " + Applicationinfobtn_xlValue);

					// Application Information Page
					System.out.println();
					System.out.println("Application Information Page............................");
					System.out.println("Personal Information Section........");
					Thread.sleep(1000);
					// Individual Application.
					// Surname.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_AliasName))).sendKeys(APInfo_Indi_Prin_AliasName_xlvalue);
					System.out.println("Surname : " + APInfo_Indi_Prin_AliasName_xlvalue);

					// Country of Birth.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_CountryOfBirth, APInfo_Indi_Prin_CountryOfBirth_xlvalue, driver);
					System.out.println("Country Of Birth : " + APInfo_Indi_Prin_CountryOfBirth_xlvalue);

					// Place Of Birth.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_PlaceOfBirth))).sendKeys(APInfo_Indi_Prin_PlaceOfBirth_xlvalue);
					System.out.println("Place Of Birth : " + APInfo_Indi_Prin_PlaceOfBirth_xlvalue);

					// Gender.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_Gender, APInfo_Indi_Prin_Gender_xlvalue, driver);
					System.out.println("Gender : " + APInfo_Indi_Prin_Gender_xlvalue);

					// Marital Status.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_MaritalStatus, APInfo_Indi_Prin_MaritalStatus_xlvalue, driver);
					System.out.println("Marital Status : " + APInfo_Indi_Prin_MaritalStatus_xlvalue);

					// Race.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_Race, APInfo_Indi_Prin_Race_xlvalue, driver);
					System.out.println("Race : " + APInfo_Indi_Prin_Race_xlvalue);

					// Primary Source of Wealth.
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_PrimarySourceOfWealth, APInfo_Indi_Prin_PrimarySourceOfWelth_xlValue, driver);
					System.out.println("Primary Source of Wealth : " + APInfo_Indi_Prin_PrimarySourceOfWelth_xlValue);

					// Credit card - Cross Sell
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						System.out.println("For your Credit Card Application");
						Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Personal Information", driver);
					}

					// Contact Information
					Thread.sleep(1000);
					// User click on Contact Information Panel to expand
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_ContactInformation_PanelClick())).click();
					System.out.println("Contact Information Section........");
					Thread.sleep(1000);

					// Secondary Contact Information Phone Number.
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_ContactInformation_SecondaryPhoneNumber))).sendKeys(APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xl);
					System.out.println("Secondary Contact Number : " + APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xl);

					// Credit card - Cross Sell
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						System.out.println("For your Credit Card Application");
						Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Contact Information", driver);
					}

					// Address Information
					// User click on Address Information Panel to expand
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_AddressInformation_PanelClick())).click();
					System.out.println("Address Information Section........");
					Thread.sleep(1000);

					// Residential Address Type
					driver.findElement(org.openqa.selenium.By.xpath(ApplicationInformationPageWorkFlow.GetApplicationInformationpage_AddressInformation_ResidentialAddressTypeXpath(ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlvalue))).click();
					System.out.println("Residential Address :" + ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlvalue);

					if (ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlvalue.equalsIgnoreCase("Local Address")) {
						// Postal Code
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_PostalCode))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexl);
						System.out.println("Postal Code : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexl);
						// Block House Number
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNo))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxl);
						System.out.println("Block House Number : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxl);
						// Street Name
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Streetname))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexl);
						System.out.println("Street Name : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexl);
						// Story
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Story))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxl);
						System.out.println("Story : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxl);
						// Unit Number
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumber))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxl);
						System.out.println("Unit Number : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxl);
						// Building Name
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BuildingName))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexl);
						System.out.println("Building Name : " + AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexl);
					} else {
						// Country
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Country, AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxl, driver);
						System.out.println("Country : " + AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxl);

						// Address Line 1
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xl);
						System.out.println("Address Line 1 : " + AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xl);

						// Address Line 2
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xl);
						System.out.println("Address Line 2 : " + AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xl);

						// Postal Code
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcode))).sendKeys(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexl);
						System.out.println("Postal Code : " + AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexl);
					}
					// Mailing Address Type
					Thread.sleep(1000);
					driver.findElement(org.openqa.selenium.By.xpath(ApplicationInformationPageWorkFlow.GetApplicationInformationpage_AddressInformation_MailingAddressTypeXpath(ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlxl))).click();
					System.out.println("Mailing Address Type :" + ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlxl);

					if (!ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlxl.equalsIgnoreCase("Same as Residential")) {
						// Not same as Residential Address
						driver.findElement(org.openqa.selenium.By.xpath(ApplicationInformationPageWorkFlow.GetApplicationInformationpage_AddressInformation_MailingAddressNotSameasresidentialaddressXpath(AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No))).click();
						System.out.println("Mailing Address Type - Not Same as Residental Address :" + AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No);
						// Local Address
						if (AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No.equalsIgnoreCase("Local Address")) {
							// Postal Code
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_PostalCode))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_PostalCodexlidxl);
							System.out.println("Postal Code : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_PostalCodexlidxl);
							// Block House Number
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_BlockHouseNo))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlidxl);
							System.out.println("Block House Number : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlidxl);
							// Street Name
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_StreetName))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_Streetnamexlidxl);
							System.out.println("Street Name : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_Streetnamexlidxl);
							// Story
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_Story))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddress_Local_Storyxlidxl);
							System.out.println("Story : " + ApplicationInformation_Principal_AddressInformation_MailingAddress_Local_Storyxlidxl);
							// Unit Number
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_UnitNumber))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_UnitNumberxlidxl);
							System.out.println("Unit Number : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_UnitNumberxlidxl);
							// Building Name
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_BuildingName))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BuildingNamexlidxl);
							System.out.println("Building Name : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BuildingNamexlidxl);
						} else {
							// Foreign Address
							// Country
							CommonMethords.SelectDropdown(SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Country, ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Countryxl, driver);
							System.out.println("Country : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Countryxl);

							// Address Line 1
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Line1))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine1xl);
							System.out.println("Address Line 1 : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine1xl);

							// Address Line 2
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Line2))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine2xl);
							System.out.println("Address Line 2 : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine2xl);

							// Postal Code
							driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_PostalCode))).sendKeys(ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Postalcodexl);
							System.out.println("Postal Code : " + ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Postalcodexl);
						}
					}

					// Credit card - Cross Sell
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						System.out.println("For your Credit Card Application");
						Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Address Information", driver);
					}

					// job Information
					// User click on Job Information Panel to expand
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_JobInformation_PanelClick())).click();
					System.out.println();
					System.out.println("Job Information Section........");
					Thread.sleep(1000);

					// Select Employment Status
					CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_JobInformation_EmploymentStatus, ApplicationInformation_Principal_JobInformation_EmploymentStatusxl, driver);
					System.out.println("Employment Status : " + ApplicationInformation_Principal_JobInformation_EmploymentStatusxl);

					// Check xl value to select other fields.
					if (ApplicationInformation_Principal_JobInformation_EmploymentStatusxl.contentEquals("Employed") || ApplicationInformation_Principal_JobInformation_EmploymentStatusxl.contentEquals("Self-employed") || ApplicationInformation_Principal_JobInformation_EmploymentStatusxl.contentEquals("Commission")) {
						// Select Occupation ID
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_JobInformation_Occupationxl, ApplicationInformation_Principal_JobInformation_Occupationxl, driver);
						System.out.println("Occupation : " + ApplicationInformation_Principal_JobInformation_Occupationxl);

						// Name of Company
						driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ApplicationInformation_Principal_JobInformation_NameOfCompany))).sendKeys(ApplicationInformation_Principal_JobInformation_NameOfCompanyxl);
						System.out.println("Name Of Company : " + ApplicationInformation_Principal_JobInformation_NameOfCompanyxl);

						// Select Nature of Business
						CommonMethords.SelectDropdown(SG_CASA_UI_Elements.ApplicationInformation_Principal_JobInformation_NatureOfbusiness, ApplicationInformation_Principal_JobInformation_NatureOfbusinessxl, driver);
						System.out.println("Nature of Business : " + ApplicationInformation_Principal_JobInformation_NatureOfbusinessxl);

						// Check Cross Sell Credit card
						if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
							System.out.println("For your Credit Card Application");
							Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Job Information", driver);
						}
					}
					// Account Preferences Section.
					// User click on Account Preferences Panel to expand
					System.out.println("Not Applicable for Fast Saver - Account Preferences Section........");
					// driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_AccountPreferences_PanelClick())).click();
					// System.out.println();
					// System.out.println("Account Preferences Section........");
					// Thread.sleep(1000);
					// driver.findElement(org.openqa.selenium.By.xpath(ApplicationInformationPageWorkFlow.GetApplicationInformationpage_AccountPreferences_DoYouNeedAnATMCardXpath(ApplicationInformation_Principal_AccountPreferences_DoYouNeedaATMCardxl))).click();
					// System.out.println("Do You Need an ATM Card :" +
					// ApplicationInformation_Principal_AccountPreferences_DoYouNeedaATMCardxl);

					// Check Cross Sell Credit card
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						System.out.println("For your Credit Card Application");
						// User click on Credit Panel
						driver.findElement(org.openqa.selenium.By.xpath((CommonMethords.CrossSell_Credit_PanelClick()))).click();
						System.out.println("User click on Credit Panel");
						Thread.sleep(3000);
						Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Credit Card", driver);
					}

					// User click on Supplementary Card
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Credit Card Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						System.out.println("For your Credit Card Application");
						// User click on Credit Panel
						driver.findElement(org.openqa.selenium.By.xpath((CommonMethords.CrossSell_SupplementaryCard_PanelClick()))).click();
						System.out.println("User click on Supplementary Card Panel");
						Thread.sleep(3000);
						Fast_saver_i_WithCrossSellCreditCard.ExecuteCrossSellCreditcard(AccountInformation_Crosssel_CrossReferenceIDXL, "Supplementary Card", driver);
					}

					// User click on Fixed deposit Cross Sell Panel.
					if (AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("Fixed Deposit Only") || AccountInformation_IsUserApplyForCrossSellXL.equalsIgnoreCase("FD + Credit card")) {
						if (AccountInformation_CrosssellproductTypeXL.equalsIgnoreCase("Fixed Deposit")) {
							driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.CrossSell_FixedDeposit_PanelClick())).click();
							Thread.sleep(3000);
							Fast_saver_i_FixedDeposit.ExecuteFixedDeposit(AccountInformation_Crosssel_CrossReferenceIDXL, driver);
						}
					}
					// call to the Joint account.
					if (AccountType_xlValue.equalsIgnoreCase("joint")) {
						System.out.println("Joint Account Personal Information Section................................................................");
						driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.ApplicationInformation_Jointbtn)).click();
						Fast_saver_i_Joint.ExecuteJointAccount(row.getCell(17).getStringCellValue(), driver);
						Thread.sleep(5000);
					}

					// User click on Your Declaraion button.
					// user click on Back Button

					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_YourDeclerationButtonClick())).click();
					System.out.println("User Click on Your Decleration Button....");

					////////////
					Thread.sleep(5000);

					// Check the Decleration Account Type
					filehandling loadfiles = new filehandlingfeatures();
					HashMap<String, Integer> indivsheetdata = loadfiles.getexcelcolnumber(guru99Workbook.getSheet(sheetName), 2);
					String primkey = row.getCell(indivsheetdata.get("Primary_Key")).getStringCellValue();
					YourDeclarationPageWorkFlow makedeclaration = new YourDeclarationPageWorkFlow(driver);
					makedeclaration.performYourdeclaration(guru99Workbook.getSheet("Decleration"), primkey);
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_YourDeclerationButtonClick())).click();
					// FILE UPLOAD
					UploadFile doupload = new UploadFile(driver);
					doupload.performfileupload(guru99Workbook.getSheet("UploadFiles"), primkey);
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.ApplicationInformation_YourDeclerationButtonClick())).click();

					// ARPIT
					String DeclarationPage_BeforeYouSubmitxl = row.getCell(Star_Saver_Saving_Retunxlid.DeclarationPage_BeforeYouSubmitxlid).getStringCellValue();

					// Before You Submit Page Call
					// if(AccountType_xlValue.equalsIgnoreCase("BeforeYouSubmit")) {
					System.out.println("Before You Submit Section................................................................");
					// driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.ApplicationInformation_Jointbtn)).click();
					StarSaverSaving_BeforeYouSubmit.ExecuteBeforeYouSubmit(DeclarationPage_BeforeYouSubmitxl, driver);

					// User click on Review Submit button
					driver.findElement(org.openqa.selenium.By.xpath(CommonMethords.BeforeYouSubmit_ReviewSubmitButtonClick())).click();
					Thread.sleep(1000);

					// Close the Driver
					// driver.close();

					// Processing Page Call
					System.out.println("Processing Page................................................................");
					// driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.ApplicationInformation_Jointbtn)).click();
					StarSaverSaving_Processing.ExecuteProcessing(DeclarationPage_BeforeYouSubmitxl, driver);

					// User click on Processing Page - Submit Feedback button
					driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_SubmitFeedback))).click();

					// Thank You Page Call
					System.out.println("Thank You Page................................................................");
					// driver.findElement(org.openqa.selenium.By.xpath(SG_CASA_UI_Elements.ApplicationInformation_Jointbtn)).click();
					StarSaverSaving_ThankYou.ExecuteThankYou(DeclarationPage_BeforeYouSubmitxl, driver);
					Thread.sleep(1000);
					/////////////

					Thread.sleep(5000);
					// Close the Driver
//					driver.close();
					row.getCell(Star_Saver_i_saving_Retunxlid.Testcase_StatusExcelId).setCellValue("Pass");
				} catch (Exception e) {
//					driver.close();
					row.getCell(Star_Saver_i_saving_Retunxlid.Testcase_StatusExcelId).setCellValue("Fail");
					e.printStackTrace();
				} // End of Try Catch
			} // End Of Test case Execution If Condition
			FileOutputStream writeresult=new FileOutputStream(file);
			guru99Workbook.write(writeresult);
			writeresult.close();
			Thread.sleep(2000); // added wait to catch all the System errs
		} // End of For Loop
		driver.close();
		System.out.println("End of the Sheet");
	}

}
