package sg.casa.base;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ford.automation.base.BaseTest;

import net.serenitybdd.core.annotations.findby.How;

public class SG_CASA_UI_Elements extends BaseTest{
	
	// Page Buttons
	public static final String YourDeclaration_Button = "//*[@automation-id='API_Aut_Next' or contains(@automation-id,'Aut_Submit') or contains(@automation-id,'Aut_Next')]";//".//*[@automation-id='API_Aut_Next']";

	public static final String UploadDoc_Button = ".//*[@automation-id='YD_Aut_Submit']";

	// Starsaver Product - -------------------
	// Getting Started Page.
	public static final String E_GS_Title = "//select[@automation-id='GS_Title_Aut']";
	public static final String E_GS_FullName = ".//*[@automation-id='GS_Fullname_Aut']";
	public static final String E_GS_Nationality = "//select[@automation-id='GS_Nationality_Aut']";
	public static final String E_GS_NRIC = ".//*[@automation-id='GS_Nric_Aut']";
	public static final String E_GS_Singaporean_Yes = ".//*[@id='pr']/label[1]/span";
	public static final String E_GS_Singaporean_No = ".//*[@id='pr']/label[2]/span";
	public static final String E_GS_Malayasia_IC = ".//*[@automation-id='GS_Myic_Aut']";
	public static final String E_GS_Passport_Number = ".//*[@automation-id='GS_Passport_Aut']";
	public static final String E_GS_Passport_Expiry_Date = ".//*[@automation-id='GS_Passportexp_Aut']";
	public static final String E_GS_Date_Of_Birth = ".//*[@automation-id='GS_Dob_Aut']";
	public static final String E_GS_Email = ".//*[@automation-id='GS_Email_Aut']";
	public static final String E_GS_Mobile_Country_Code = ".//*[@automation-id='GS_MobileCode_Aut']";
	public static final String E_GS_Mobile_Number = ".//*[@automation-id='GS_Mobilenum_Aut']";
	public static final String E_GS_Terms_and_Conditions = "//div[@class='checkbox']/label";
	// public static final String E_GS_Terms_and_Conditions =
	// ".//*[@automation-id='GS_Agreement_Aut']";
	public static final String E_GS_Start_Application = "//button[@class='btn-primary']";

	// Account Information.
	public static final String E_ACI_AccountType_Individual = "//*[@automation-id='AC_Aut_AccountType_Individual']//following-sibling::span"; // Individual, Joint
	public static final String E_ACI_AccountType_Joint = "//*[@automation-id='AC_Aut_AccountType_Joint']//following-sibling::span"; // Individual, Joint
	public static final String E_ACI_PurposeOfAccount = "//*[@automation-id='AI_Aut_PurposeOfAccount']";
	public static final String E_ACI_SourceOfFundsForInitialDeposit = "//*[@automation-id='AI_Aut_SourceOfFundsForInitialDeposit']";

	public static final String E_ACI_PurposeOfAccount_Other = ".//*[@name='otherAccountPurpose']";

	public static final String E_ACI_SourceOfFundsForInitialDeposit_Other = ".//*[@name='otherSourceOfFunds']";
	public static final String E_ACI_E_StatmentOnly = "//*[@automation-id='AI_Aut_MonthlyEStatements']//following-sibling::span";
	public static final String E_ACI_E_StatmentANDPaperStatments = "//*[@automation-id='Ai_Aut_EStatementAndPaperStatements']//following-sibling::span";
	public static final String E_ACI_E_StatmentANDPaperStatments_Note = "";
	public static final String E_ACI_Crosssell_CreditCard = ""; // None, credit_Card, Fixed_Deposit
	public static final String E_ACI_Crosssell_FixedDeposit = "";
	public static final String E_ACI_Crosssell_ReadMore_Hyperlink = "";
	public static final String E_ACI_Crosssell_LeftArrow = "";
	public static final String E_ACI_Crosssell_RightArrow = "";
	public static final String E_ACI_AccountInformation_BackButton = "//*[@automation-id='AI_Aut_Submit']";
	public static final String E_ACI_AccountInformation_SubmitButton = "//button[@type='submit' and contains(., 'Application Information')]";

	// Application Information
	// Principal Account
	// Personal Information Section
	public static final String ApplicationInformation_Principal_PersoanalInformation_id = "//form[contains(@name,'vm.formPI')]//*[@id='user-nric-no']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_Surname = "//form[contains(@name,'vm.formPI')]//*[@id='surname']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_AliasName = "//form[contains(@name,'vm.formPI')]//*[@id='user-alias']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_CountryOfBirth = "//form[contains(@name,'vm.formPI')]//*[@id='user-birth-country']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_PlaceOfBirth = "//form[contains(@name,'vm.formPI')]//*[@id='user-birth-place']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_Gender = "//form[contains(@name,'vm.formPI')]//*[@id='user-gender']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_MaritalStatus = "//form[contains(@name,'vm.formPI')]//*[@id='user-marital-status']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_Race = "//form[contains(@name,'vm.formPI')]//*[@id='user-race']";
	public static final String ApplicationInformation_Principal_PersoanalInformation_PrimarySourceOfWealth = "//form[contains(@name,'vm.formPI')]//*[@id='user-wealth-source']";

	// Contact Information Section
	public static final String ApplicationInformation_Principal_ContactInformation_SecondaryPhone_Home = "//form[contains(@name,'vm.formPI')]//input[@name='secondary-contact-no' and @value='home']";
	public static final String ApplicationInformation_Principal_ContactInformation_SecondaryPhone_Office = "//form[contains(@name,'vm.formPI')]//input[@name='secondary-contact-no' and @value='office']";
	public static final String ApplicationInformation_Principal_ContactInformation_SecondaryPhoneCode = "";
	public static final String ApplicationInformation_Principal_ContactInformation_SecondaryPhoneNumber = "//form[contains(@name,'vm.formPI')]//*[@name='secondaryMobileNum']";

	// Address Information
	// Residential Address
	// Local Address
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_LocalAddress_RadioButton = "//*[@automation-id='API_Aut_ResidentialAddress_Local']//following-sibling::span";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_ForeignAddress_RadioButton = "//*[@automation-id='API_Aut_ResidentialAddress_Foreign']//following-sibling::span";

	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_PostalCode = "//*[@automation-id='API_Aut_PostalCode']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNo = "//*[@automation-id='API_Aut_BlockOrHouseNo']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Streetname = "//*[@automation-id='API_Aut_StreetName']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Story = "//*[@automation-id='API_Aut_StoreyNo']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumber = "//*[@automation-id='API_Aut_Unit']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BuildingName = "//*[@automation-id='API_Aut_BuildingName']";

	// Foreign Address
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Country = "//*[@automation-id='API_Aut_Country']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1 = "//*[@automation-id='API_Aut_ForeignAddressLine1']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2 = "//*[@automation-id='API_Aut_ForeignAddressLine2']";
	public static final String ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcode = "//*[@automation-id='API_Aut_ForeignAddressPostalCode']";

	// Mailing Address Type
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_Yes = "//*[@automation-id='API_Aut_MailingAddressSameAsResidentialAddress']//following-sibling::span";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No = "//*[@automation-id='API_Aut_MailingAddressNotSameAsResidentialAddress']//following-sibling::span";

	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress = "//*[@automation-id='API_Aut_MailingAddressLocalAddress']//following-sibling::span";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress = "//*[@automation-id='API_Aut_MailingAddressForeignAddress']//following-sibling::span";

	// Local Address
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_PostalCode = "//*[@automation-id='API_Aut_MailingAddressPostalCode']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_GetAddressButton = "";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_BlockHouseNo = "//*[@automation-id='API_Aut_MailingAddressBlockOrHouseNo']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_StreetName = "//*[@automation-id='API_Aut_MailingAddressStreetName']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_Story = "//*[@automation-id='API_Aut_MailingAddressStoreyNo']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_UnitNumber = "//*[@automation-id='API_Aut_MailingAddressUnitNo']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress_BuildingName = "//*[@automation-id='API_Aut_MailingAddressBuildingName']";

	// Foreign Address
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Country = "//*[@automation-id='API_Aut_MailingAddressCountry']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Line1 = "//*[@automation-id='API_Aut_MailingAddressForeignAddress1']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_Line2 = "//*[@automation-id='API_Aut_MailingAddressForeignAddress2']";
	public static final String AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress_PostalCode = "//*[@automation-id='API_Aut_MailingAddressPostalCode']";

	// Job Information Section
	public static final String ApplicationInformation_Principal_JobInformation_EmploymentStatus = "//form[contains(@name,'vm.formPI')]//select[@id='user-employment-status']";
	public static final String ApplicationInformation_Principal_JobInformation_Occupationxl = "//form[contains(@name,'vm.formPI')]//select[@id='user-employment-occupation']";
	public static final String ApplicationInformation_Principal_JobInformation_NameOfCompany = "//form[contains(@name,'vm.formPI')]//*[@id='user-company-name']";
	public static final String ApplicationInformation_Principal_JobInformation_NatureOfbusiness = "//form[contains(@name,'vm.formPI')]//select[@id='user-business-nature']";

	// Account Preferences Section
	public static final String ApplicationInformation_Principal__AccountPreferences_DoYouNeedaATMCard_Yes = "//form[contains(@name,'vm.formPI')]/div/div[5]/div/div[1]/div/div/div/div[1]/div/label/span";
	public static final String ApplicationInformation_Principal__AccountPreferences_DoYouNeedaATMCard_No = "//form[contains(@name,'vm.formPI')]//div/div[5]/div/div[1]/div/div/div/div[2]/div/label/span";

	// Joint Account
	// Joint Account Button
	public static final String ApplicationInformation_Jointbtn = "//section/div[2]/div[3]/div/button[2]";
	// Personal Information.
	public static final String ApplicationInformation_Joint_PersoanalInformation_Title = "//form[contains(@name,'vm.formJI')]//*[@id='title']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_ApplicantName = "//form[contains(@name,'vm.formJI')]//*[@id='user-fullname']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_Alias = "//form[contains(@name,'vm.formJI')]//*[@id='user-alias']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_Nationality = "//form[contains(@name,'vm.formJI')]//*[@id='user-nationality']";

	public static final String ApplicationInformation_Joint_PersoanalInformation_AreYouSingapore_PR_Yes = "//form[contains(@name,'vm.formJI')]//*[@id='pr']/label[1]/span";
	public static final String ApplicationInformation_Joint_PersoanalInformation_AreYouSingapore_PR_No = "//form[contains(@name,'vm.formJI')]//*[@id='pr']/label[2]/span";

	public static final String ApplicationInformation_Joint_PersoanalInformation_NRIC = "//form[contains(@name,'vm.formJI')]//*[@id='user-nric-no']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_MalaysiaICNo = "//form[contains(@name,'vm.formJI')]//*[@id='user-ic-no']";

	public static final String ApplicationInformation_Joint_PersoanalInformation_PassportNumber = "//form[contains(@name,'vm.formJI')]//*[@id='user-passport-no']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_PassportExpiryDate = "//form[contains(@name,'vm.formJI')]//*[@id='user-passport-date']";

	public static final String ApplicationInformation_Joint_PersoanalInformation_DateOfBirth = "//form[contains(@name,'vm.formJI')]//*[@id='user-birth-date']";

	public static final String ApplicationInformation_Joint_PersoanalInformation_CountryOfBirth = "//form[contains(@name,'vm.formJI')]//*[@id='user-birth-country']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_PlaceOfBirth = "//form[contains(@name,'vm.formJI')]//*[@id='user-birth-place']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_Gender = "//form[contains(@name,'vm.formJI')]//*[@id='user-gender']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_MaritalStatus = "//form[contains(@name,'vm.formJI')]//*[@id='user-marital-status']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_Race = "//form[contains(@name,'vm.formJI')]//*[@id='user-race']";
	public static final String ApplicationInformation_Joint_PersoanalInformation_PrimarySourceOfWealth = "//form[contains(@name,'vm.formJI')]//*[@id='user-wealth-source']";

	// Contact Information
	public static final String ApplicationInformation_Joint_ContactInformation_PrimaryMobileCode = "//form[contains(@name,'vm.formJI')]//*[@name='mobileCode']";
	public static final String ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumber = "//form[contains(@name,'vm.formJI')]//*[@id='user-mobile']";
	public static final String ApplicationInformation_Joint_ContactInformation_PrimaryEmail = "//form[contains(@name,'vm.formJI')]//*[@id='user-email']";
	public static final String ApplicationInformation_Joint_ContactInformation_SecondaryMobileType_Home = "//form[contains(@name,'vm.formJI')]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/label/span";
	public static final String ApplicationInformation_Joint_ContactInformation_SecondaryMobileType_Office = "//form[contains(@name,'vm.formJI')]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/label/span";
	public static final String ApplicationInformation_Joint_ContactInformation_SecondaryMobileCode = "//form[contains(@name,'vm.formJI')]//*[@name='secondaryMobileCode']";
	public static final String ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumber = "//form[contains(@name,'vm.formJI')]//*[@name='secondaryMobileNum']";

	// Address Information Residential Address
	public static final String ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type_SameAsPrincipal = "//form[contains(@name,'vm.formJI')]/div/div[3]/div/div[1]/div/div/div/div[1]/div/label/span";
	public static final String ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No = "//form[contains(@name,'vm.formJI')]/div/div[3]/div/div[1]/div/div/div/div[2]/div/label/span";

	public static final String ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No_LocalAddress = "//form[contains(@name,'vm.formJI')]/div/div[3]/div/div[2]/div[1]/div/label/span";
	public static final String ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No_ForeignAddress = "//form[contains(@name,'vm.formJI')]/div/div[3]/div/div[2]/div[2]/div/label/span";

	// Local
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCode = "//form[contains(@name,'vm.formJI')]//*[@id='user-postal-code']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_GetAddressBtn = "//form[contains(@name,'vm.formJI')]//*[@id='user-mobile']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumber = "//form[contains(@name,'vm.formJI')]//*[@id='user-house-no']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_Story = "//form[contains(@name,'vm.formJI')]//*[@id='user-storey']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumber = "//form[contains(@name,'vm.formJI')]//*[@name='residentUnitno']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetName = "//form[contains(@name,'vm.formJI')]//*[@id='user-street-name']";
	public static final String ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingName = "//form[contains(@name,'vm.formJI')]//*[@id='user-building-name']";
	// Foreign
	public static final String ApplicationInformation_Joint_AddressInformation_ForeignAddress_Country = "//form[contains(@name,'vm.formJI')]//*[@id='user-residence-country']";
	public static final String ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1 = "//form[contains(@name,'vm.formJI')]//*[@id='user-foreign-address-1']";
	public static final String ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2 = "//form[contains(@name,'vm.formJI')]//*[@id='user-foreign-address-2']";
	public static final String ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCode = "//form[contains(@name,'vm.formJI')]//*[@id='user-foreign-address-postal-code']";

	// Job Information Panel
	public static final String ApplicationInformation_Joint_JobInformation_EmploymentStatus = "//form[contains(@name,'vm.formJI')]//*[@id='user-employment-status']";
	public static final String ApplicationInformation_Joint_JobInformation_Occupation = "//form[contains(@name,'vm.formJI')]//*[@id='user-employment-occupation']";
	public static final String ApplicationInformation_Joint_JobInformation_NameOfCompany = "//form[contains(@name,'vm.formJI')]//*[@id='user-company-name']";
	public static final String ApplicationInformation_Joint_JobInformation_NatureOfBusiness = "//form[contains(@name,'vm.formJI')]//*[@id='user-business-nature']";

	// Account Preferences
	public static final String ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard_Yes = "//form[contains(@name,'vm.formJI')]/div/div[5]/div/div/div/div/div/div[1]/div/label/span";
	public static final String ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard_No = "//form[contains(@name,'vm.formJI')]/div/div[5]/div/div/div/div/div/div[2]/div/label/span";

	// Cross Sell
	// Fixed Deposit
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit = ".//*[@automation-id='API_Aut_ModeOfDeposit']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber = ".//*[@automation-id='API_Aut_CIMBAccountNumber']";
	// public static final String
	// AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_GetOTPBtn
	// = "//button[@type='button' and contains(., 'Get OTP')]";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_GetOTPBtn = ".//*[@automation-id='API_Aut_GetOtp']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPText = ".//*[@automation-id='API_Aut_OneTimePassword']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPBtn = "//button[@type='button' and contains(., 'Verify')]";

	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Currency = ".//*[@automation-id='API_Aut_Currency']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Tenure = ".//*[@automation-id='API_Aut_Tenure']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_DepositAmount = ".//*[@automation-id='API_Aut_DepositAmount']";

	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_MaturityRenewalInstruction = ".//*[@automation-id='API_Aut_MaturityRenewalInstructions']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_InstructionsForAnyPayment = ".//*[@automation-id='API_Aut_InstructionsForAnyPayment']";
	public static final String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_CIMBAccountNumberToCredit = ".//*[@automation-id='API_Aut_CIMBAccountNumberToCredit']";

	// Credit Card
	// Personal Information Panel
	public static final String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_Surname = ".//*[@id='user-surname']";
	public static final String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCard = ".//*[@id='user-card']";
	public static final String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenName = ".//*[@id='maiden-name']";
	public static final String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualification = ".//*[@id='user-qualification']";
	public static final String AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NumberOfDependents = ".//*[@id='user-dependents']";

	// Contact Information
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name = ".//*[@automation-id='API_Aut_EmergencyContactName']";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileCode = ".//*[@automation-id='API_Aut_EmergencyContactMobileCountryCode ']";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber = ".//*[@automation-id='API_Aut_EmergencyContactMobileNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_Home = "";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_Office = "";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileCode = ".//*[@automation-id='API_Aut_EmergencySecondaryCountryCode']";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber = ".//*[@automation-id='API_Aut_EmergencySecondaryMobileNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship = ".//*[@automation-id='API_Aut_Relationship']";

	// Address Information
	public static final String AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyType = ".//*[@automation-id='API_Aut_PropertyType']";
	public static final String AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Years = ".//*[@automation-id='API_Aut_LengthOfResidence_Year']";
	public static final String AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Months = ".//*[@automation-id='API_Aut_LengthOfResidence_Month']";
	public static final String AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatus = ".//*[@automation-id='API_Aut_ResidenceStatus']";

	// Job Information
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode = ".//*[@automation-id='API_Aut_CompanyPostalCode']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_GetAddressBtn = ".//*[@automation-id='API_Aut_CompanyGetAddress']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber = ".//*[@automation-id='API_Aut_CompanyBlockOrHouseNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName = ".//*[@automation-id='API_Aut_CompanyStreetName']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_Story = ".//*[@automation-id='API_Aut_CompanyStoreyNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber = ".//*[@automation-id='API_Aut_CompanyUnitNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName = ".//*[@automation-id='API_Aut_CompanyBuildingName']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary = ".//*[@automation-id='API_Aut_GrossAnnualSalary']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years = ".//*[@automation-id='API_Aut_EmploymentLengthYears']";
	public static final String AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months = ".//*[@automation-id='API_Aut_EmploymentLengthMonths']";

	// Credit Card
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit = "//*[@automation-id='API_Aut_NoPreferredCreditLimit']//following-sibling::label";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount = "//*[@automation-id='API_Aut_PreferredCreditLimit']";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN_Yes = "//*[@automation-id='API_Aut_IssuanceOfPIN']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN_No = "//*[@automation-id='API_Aut_NoIssuanceOfPIN']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatment_EStatment = "//*[@automation-id='API_Aut_MonthlyEStatementEmail']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatment_PaperStatment = "//*[@automation-id='API_Aut_MonthlyEStatementAndPaperStatement']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress_Home = "//*[@automation-id='API_Aut_SendMyCardAndStatementToHome']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress_Office = "//*[@automation-id='API_Aut_SendMyCardAndStatementToOffice']//following-sibling::span";

	// Supplementary Card
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard_Yes = "//*[@automation-id='APIS_Aut_YesWishToApplyForASupplementaryCard']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard_No = "//*[@automation-id='APIS_Aut_DoNotIWishToApplyForASupplementaryCard']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal = "//*[@automation-id='APIS_Aut_RelationshipToPrincipal']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard = "//*[@automation-id='APIS_Aut_NameToAppearOnCard']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title = "//*[@automation-id='APIS_Aut_Title']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname = ".//*[@automation-id='APIS_Aut_Surname']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName = "//*[@automation-id='APIS_Aut_Fullname']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias = "//*[@automation-id='APIS_Aut_AliasName']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality = "//*[@automation-id='APIS_Aut_Nationality']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR_Yes = "//*[@automation-id='APIS_Aut_SingaporePR_Yes']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR_No = "//*[@automation-id='APIS_Aut_SingaporePR_No']//following-sibling::span";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC = "//*[@automation-id='APIS_Aut_NRICNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_MalayiaICNumber = "//*[@automation-id='APIS_Aut_MalaysiaICNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_PassportNumber = "//*[@automation-id='APIS_Aut_PassportNo']";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry = "//*[@automation-id='APIS_Aut_PassportExpiryDate']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth = "//*[@automation-id='APIS_Aut_DateOfBirth']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender = "//*[@automation-id='APIS_Aut_Gender']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus = "//*[@automation-id='APIS_Aut_MaritalStatus']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race = "//*[@automation-id='APIS_Aut_Race']";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileCode = "//*[@automation-id='APIS_Aut_MobileCountryCode']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber = "//*[@automation-id='APIS_Aut_MobileNumber']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName = "//*[@automation-id='APIS_Aut_MothersMaidenName']";

	// Address Information
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_Yes = "//*[@automation-id='APIS_Aut_ResidentialAddressSameAsPrinciple']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No = "//*[@automation-id='APIS_Aut_ResidentialAddressNotSameAsPrinciple']//following-sibling::span";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No_Local = "//*[@automation-id='APIS_Aut_ResidentialAddress_Local']//following-sibling::span";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No_Foreign = "//*[@automation-id='APIS_Aut_ResidentialAddress_Foreign']//following-sibling::span";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode = "//*[@automation-id='APIS_Aut_PostalCode']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_GetAddressBtn = "//*[@automation-id='APIS_Aut_GetAddress']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo = "//*[@automation-id='APIS_Aut_BlockOrHouseNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName = "//*[@automation-id='APIS_Aut_StreetName']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story = "//*[@automation-id='APIS_Aut_StoreyNo']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo = "//*[@automation-id='APIS_Aut_Unit']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName = "//*[@automation-id='APIS_Aut_BuildingName']";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country = "//*[@automation-id='APIS_Aut_Country']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1 = "//*[@automation-id='APIS_Aut_ForeignAddressLine1']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2 = "//*[@automation-id='APIS_Aut_ForeignAddressLine2']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode = "//*[@automation-id='APIS_Aut_ForeignAddressPostalCode']";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus = "//*[@automation-id='APIS_Aut_EmploymentStatus']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation = "//*[@automation-id='APIS_Aut_Occupation']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany = "//*[@automation-id='APIS_Aut_NameOfCompany']";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness = "//*[@automation-id='APIS_Aut_NatureOfBusiness']";

	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus = "//*[@automation-id='APIS_Aut_NoPreferredCreditLimit']//following-sibling::label";
	public static final String AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit = "//*[@automation-id='APIS_Aut_PreferredCreditLimit']";

	public static final String Singnature = "//canvas";
	public static final String fileuploads = "//div[contains(@class,'form-group')]//*[@class='btn-upload']";	
	
	//Before You Submit - Arpit
	public static final String BeforeYouSubmit_ReferredByFriend_Yes = "//input[@automation-id='RAC_Aut_ReferredByAFriend_Yes']/following::span[1]";
	public static final String BeforeYouSubmit_ReferredByFriend_No = "//input[@automation-id='RAC_Aut_ReferredByAFriend_No']/following::span[1]";
	public static final String BeforeYouSubmit_ReferredByFriend_Fullname = "//input[@automation-id='RAC_Aut_ReferredByAFriend_Fullname']";
	public static final String BeforeYouSubmit_ReferredByFriend_FriendNric = "//input[@automation-id='RAC_Aut_ReferredByAFriend_FriendNric']";
	public static final String BeforeYouSubmit_HaveAPromoCode_Yes = "//input[@automation-id='RAC_Aut_HaveAPromoCode_Yes']/following::span[1]";
	public static final String BeforeYouSubmit_HaveAPromoCode_No = "//input[@automation-id='RAC_Aut_HaveAPromoCode_No']/following::span[1]";
	public static final String BeforeYouSubmit_PromotionalCode = "//input[@automation-id='RAC_Aut_PromotionalCode']";
	public static final String ReviewSubmitButton = "//button[@type='button' and contains(., 'Submit')]";
	
	//Processing Page - Arpit
	public static final String ProcessingPage_OnlineSearch = "//input[@automation-id='APP_Aut_Feedback_Online Search']/following::label[1]";
	public static final String ProcessingPage_WebBanners = "//input[@automation-id='APP_Aut_Feedback_Web Banners']/following::label[1]";
	public static final String ProcessingPage_ElectronicMailers = "//input[@automation-id='APP_Aut_Feedback_Electronic Mailers']/following::label[1]";
	public static final String ProcessingPage_CIMBWebsite = "//input[@automation-id='APP_Aut_Feedback_CIMB Website']/following::label[1]";
	public static final String ProcessingPage_OnlineSeminars = "//input[@automation-id='APP_Aut_Feedback_Online Seminars']/following::label[1]";
	public static final String ProcessingPage_Roadshows= "//input[@automation-id='APP_Aut_Feedback_Roadshows']/following::label[1]";
	public static final String ProcessingPage_Seminars = "//input[@automation-id='APP_Aut_Feedback_Seminars']/following::label[1]";
	public static final String ProcessingPage_BillboardsBusBusstopsBuildings = "//input[@automation-id='APP_Aut_Feedback_Billboards/Bus/Bus stops/Buildings']/following::label[1]";
	public static final String ProcessingPage_Taxis = "//input[@automation-id='APP_Aut_Feedback_Taxis']/following::label[1]";
	public static final String ProcessingPage_TrainsTrainStations = "//input[@automation-id='APP_Aut_Feedback_Trains/Train Stations']/following::label[1]";
	public static final String ProcessingPage_Television = "//input[@automation-id='APP_Aut_Feedback_Television']/following::label[1]";
	public static final String ProcessingPage_PrintMedia = "//input[@automation-id='APP_Aut_Feedback_Print Media (e.g. magazines, newspapers ads, articles)']/following::label[1]";
	public static final String ProcessingPage_Radio = "//input[@automation-id='APP_Aut_Feedback_Radio']/following::label[1]";
	public static final String ProcessingPage_WordofMouth = "//input[@automation-id='APP_Aut_Feedback_Word of Mouth (e.g. friends/family)']/following::label[1]";
	public static final String ProcessingPage_CIMBBranches = "//input[@automation-id='APP_Aut_Feedback_CIMB Branches']/following::label[1]";
	public static final String ProcessingPage_Mobile = "//input[@automation-id='APP_Aut_Feedback_Mobile (e.g. SMS/MMS)']/following::label[1]";
	public static final String ProcessingPage_SubmitFeedback = "//button[@automation-id='APP_Aut_Feedback_Submit']";
	//input[@automation-id='APP_Aut_Feedback_Television']/following::label[1]
	
	//Thank You Page - Arpit
	public static final String ThankYouPage_DownloadApplication = "//span[@class='btn-text' and contains(., 'Download Application')]";
	public static final String ThankYouPage_ApplicationNumber = "//html//p[2]/b[1]/span";	
	
	
	public @FindBy(xpath = "//*[contains(@automation-id,'saveSignature')]")
	static List<WebElement> saveSignature;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_AgreementIc']//ancestor::div[@class='checkbox']")
	WebElement GreenCardYes;
	
	public @FindBy(xpath = "//*[contains(text(),'Principal Applicant')]//following-sibling::*//input[contains(@automation-id,'SignOption_Sign')]//following-sibling::span")
	WebElement GreenCardNo;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_SupportDocuments']")
	WebElement PrinAppSupportingDocuments;
	
	public @FindBy(xpath = "//input[contains(@automation-id,'FLD_Indi_Aut_SignOption_Sign')]//following-sibling::span")
	WebElement PrincipalApplicantSignHerechk;

	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_SignatureUpload']")
	WebElement PrincipalApplicantSignfileupload;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_AgreementIc']//ancestor::div[@class='checkbox']")
	WebElement Singlefileupload_PA;
	
	public @FindBy(xpath = "//input[contains(@automation-id,'FLD_Indi_Aut_SignOption_Upload')]//following-sibling::span")
	WebElement PrincipalApplicantUploadSignchk;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_FrontIc']")
	List<WebElement> firstfilePrincipalAccount;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_BackIc']")
	List<WebElement> secondfilePrincipalAccount;
		
	public @FindBy(xpath = "//input[@automation-id='FLD_Joint_Aut_SupportDocuments']")
	WebElement JointAppSupportingDocuments;
	
	public @FindBy(xpath = "//*[contains(text(),'Joint Applicant')]//following-sibling::*[1]//input[contains(@automation-id,'SignOption_Sign')]//following-sibling::span")
	WebElement JointApplicantSignHerechk;

	public @FindBy(xpath = "//input[@automation-id='FLD_Joint_Aut_SignatureUpload']")
	WebElement JointApplicantSignfileupload;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Joint_Aut_AgreementIc']//ancestor::div[@class='checkbox']")
	WebElement Singlefileupload_JA;
	
	public @FindBy(xpath = "//*[contains(text(),'Joint Applicant')]//following-sibling::*[1]//input[contains(@automation-id,'SignOption_Upload')]//following-sibling::span")
	WebElement JointApplicantUploadSignchk;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Joint_Aut_FrontIc']")
	List<WebElement> firstfileJointAccount;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Joint_Aut_BackIc']")
	List<WebElement> secondfileJointAccount;
	
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Supp_Aut_SupportDocuments']")
	WebElement SupplementaryAppSupportingDocuments;
	
	public @FindBy(xpath = "//*[contains(text(),'Supplementary Applicant')]//following-sibling::*[1]//input[contains(@automation-id,'SignOption_Sign')]//following-sibling::span")
	WebElement SupplementaryApplicantSignHerechk;

	public @FindBy(xpath = "//input[@automation-id='FLD_Supp_Aut_SignatureUpload']")
	WebElement SupplementaryApplicantSignfileupload;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Supp_Aut_AgreementIc']//ancestor::div[@class='checkbox']")
	WebElement Singlefileupload_SA;
	
	public @FindBy(xpath = "//*[contains(text(),'Supplementary Applicant')]//following-sibling::*[1]//input[contains(@automation-id,'SignOption_Upload')]//following-sibling::span")
	WebElement SupplementaryApplicantUploadSignchk;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Supp_Aut_FrontIc']")
	List<WebElement> firstfileSupplementaryAccount;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Supp_Aut_BackIc']")
	List<WebElement> secondfileSupplementaryAccount;
	
	public @FindBy(xpath = "//input[@automation-id='FLD_Indi_Aut_AgreementCpf']//ancestor::div[@class='checkbox']")
	WebElement CPFStatementchk;

	public @FindBy(xpath = "//form[contains(@name,'vm.formAccInf')]/div[5]/div/data-carousel/div[1]/div/div[3]/div/div/div/label/span[contains(text(), 'Select the product')]")
	static
	List<WebElement> CIMBVisaSignatureCard1;
	
	public @FindBy(xpath = "//*[@id='CIMB_Visa_Signature']//following-sibling::label")
	static List<WebElement> CIMBVisaSignatureCard2;
}
