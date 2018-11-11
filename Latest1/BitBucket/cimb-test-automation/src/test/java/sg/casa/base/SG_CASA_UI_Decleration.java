package sg.casa.base;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SG_CASA_UI_Decleration {

//	//Decleration Page 
//	//Main checkboxes 
//	
//	//Principal Account
//	String Principal_PDPA_VoiceandPhoneCall= ".//*[@automation-id='YDP_Aut_ConsentToVoiceCallOrPhoneCall']//following-sibling::label";
//	String Principal_PDPA_SMSansMMS = ".//*[@automation-id='YDP_Aut_ConsentToSMSOrMMS']//following-sibling::label";
//	
//	String Principal_AreYou_UnitedStatesOr_territories_Yes = ".//*[@automation-id='YDP_Aut_YesGreenCardHolder']//following-sibling::span";
//	String Principal_AreYou_UnitedStatesOr_territories_No = ".//*[@automation-id='YDP_Aut_NotGreenCardHolder']//following-sibling::span";
//	String Principal_USResident = "//*[@automation-id='YDP_Aut_AreYouAUSResidentIncludingCurrentWorkPermit']//following-sibling::label";
//	String Principal_USCitizen = "//*[@automation-id='YDP_Aut_AreYouAUSCitizenOrACitizenOfUSTerritory']//following-sibling::label";
//	String Principal_USPermanent = "//*[@automation-id='YDP_Aut_DoYouHoldAUSPermanentResidentCard']//following-sibling::label";
//	
//	//Joint Account
//	String Joint_PDPA_VoiceandPhoneCall= ".//*[@automation-id='YDJ_Aut_ConsentToVoiceCallOrPhoneCall']//following-sibling::label";
//	String Joint_PDPA_SMSansMMS = ".//*[@automation-id='YDJ_Aut_ConsentToSMSOrMMS']//following-sibling::label";
//	
//	String Joint_AreYou_UnitedStatesOr_territories_Yes = ".//*[@automation-id='YDJ_Aut_YesGreenCardHolder']//following-sibling::span";
//	String Joint_AreYou_UnitedStatesOr_territories_No = ".//*[@automation-id='YDJ_Aut_NotGreenCardHolder']//following-sibling::span";
//	String Joint_USResident = "//*[@automation-id='YDJ_Aut_AreYouAUSResidentIncludingCurrentWorkPermit']//following-sibling::label";
//	String Joint_USCitizen = "//*[@automation-id='YDJ_Aut_AreYouAUSCitizenOrACitizenOfUSTerritory']//following-sibling::label";
//	String Joint_USPermanent = "//*[@automation-id='YDJ_Aut_DoYouHoldAUSPermanentResidentCard']//following-sibling::label";
	
	public @FindBy(xpath = "//*[text()='Principal Applicant' or contains(text(),'Parent') or contains(text(),'Guardian')]")
	static List<WebElement> isPrincApp;
	
	public @FindBy(xpath = "//*[text()='Joint CardHolder' or text()='Joint Applicant' or contains(text(),'Child Applicant')]")
	static List<WebElement> isJointApp;
	
	public @FindBy(xpath = "//*[text()='Supplementary CardHolder' or text()='Supplementary Applicant']")
	static List<WebElement> isSuppApp;
	
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_ConsentToVoiceCallOrPhoneCall']//ancestor::div[@class='checkbox']")
	WebElement voicecallPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_ConsentToVoiceCallOrPhoneCall']//ancestor::div[@class='checkbox']")
	WebElement voicecallJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_ConsentToVoiceCallOrPhoneCall']//ancestor::div[@class='checkbox']")
	WebElement voicecallSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_ConsentToSMSOrMMS']//ancestor::div[@class='checkbox']")
	WebElement smsmmsPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_ConsentToSMSOrMMS']//ancestor::div[@class='checkbox']")
	WebElement smsmmsJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_ConsentToSMSOrMMS']//ancestor::div[@class='checkbox']")
	WebElement smsmmsSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_YesGreenCardHolder']//following-sibling::span")
	WebElement YesGreenCardHolderPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_NotGreenCardHolder']//following-sibling::span")
	WebElement NoGreenCardHolderPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_YesGreenCardHolder']//following-sibling::span")
	WebElement YesGreenCardHolderJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_NotGreenCardHolder']//following-sibling::span")
	WebElement NoGreenCardHolderJointApp;
		
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_YesGreenCardHolder']//following-sibling::span")
	WebElement YesGreenCardHolderSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_NotGreenCardHolder']//following-sibling::span")
	WebElement NoGreenCardHolderSuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_AreYouAUSResidentIncludingCurrentWorkPermit']//ancestor::div[@class='checkbox']")
	WebElement USresidentPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_AreYouAUSResidentIncludingCurrentWorkPermit']//ancestor::div[@class='checkbox']")
	WebElement USresidentJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_AreYouAUSResidentIncludingCurrentWorkPermit']//ancestor::div[@class='checkbox']")
	WebElement USresidentSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_AreYouAUSCitizenOrACitizenOfUSTerritory']//ancestor::div[@class='checkbox']")
	WebElement USCitizenPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_AreYouAUSCitizenOrACitizenOfUSTerritory']//ancestor::div[@class='checkbox']")
	WebElement USCitizenJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_AreYouAUSCitizenOrACitizenOfUSTerritory']//ancestor::div[@class='checkbox']")
	WebElement USCitizenSuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_DoYouHoldAUSPermanentResidentCard']//ancestor::div[@class='checkbox']")
	WebElement USprPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_DoYouHoldAUSPermanentResidentCard']//ancestor::div[@class='checkbox']")
	WebElement USprJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_DoYouHoldAUSPermanentResidentCard']//ancestor::div[@class='checkbox']")
	WebElement USprSuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_TaxpayerIdentificationNumber']")
	WebElement TINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_TaxpayerIdentificationNumber']")
	WebElement TINJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_TaxpayerIdentificationNumber']")
	WebElement TINSuppApp;

	public @FindBy(xpath = "//*[@automation-id='YDP_Aut_Country']")
	WebElement CountryPrincApp;
	
	public @FindBy(xpath = "//select[@automation-id='YDJ_Aut_Country']")
	WebElement CountryJointApp;
	
	public @FindBy(xpath = "//select[@automation-id='YDS_Aut_Country']")
	WebElement CountrySuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_YesHaveATaxIdentificationNumberOrEquivalent']//following-sibling::span")
	WebElement YesTINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_NotHaveATaxIdentificationNumberOrEquivalent' or @automation-id='YDP_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent']//following-sibling::span")
	WebElement NoTINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_YesHaveATaxIdentificationNumberOrEquivalent']//following-sibling::span")
	WebElement YesTINJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent' or @automation-id='YDJ_Aut_NotHaveATaxIdentificationNumberOrEquivalent']//following-sibling::span")
	WebElement NoTINJointApp;
		
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_YesHaveATaxIdentificationNumberOrEquivalent']//following-sibling::span")
	WebElement YesTINSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_NotHaveATaxIdentificationNumberOrEquivalent' or @automation-id='YDS_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent']//following-sibling::span")
	WebElement NoTINSuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_TaxIdentificationNumber']")
	WebElement CRSTINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_TaxIdentificationNumber']")
	WebElement CRSTINJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_TaxIdentificationNumber']")
	WebElement CRSTINSuppApp;

	public @FindBy(xpath = "//*[@automation-id='YDP_Aut_PleaseStateReason']")
	WebElement reasonPrincApp;
	
	public @FindBy(xpath = "//*[@automation-id='YDJ_Aut_PleaseStateReason']")
	WebElement reasonJointApp;
	
	public @FindBy(xpath = "//*[@automation-id='YDS_Aut_PleaseStateReason']")
	WebElement reasonSuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_PleaseSpecifyExplanation']")
	List<WebElement> explainationPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_PleaseSpecifyExplanation']")
	List<WebElement> explainationJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_PleaseSpecifyExplanation']")
	List<WebElement> explainationSuppApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDP_Aut_AddAnotherCountry']")
	WebElement addcountryPrincApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDJ_Aut_AddAnotherCountry']")
	WebElement addcountryJointApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDS_Aut_AddAnotherCountry']")
	WebElement addcountrySuppApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDP_Aut_DeleteTaxResident']")
	WebElement delcountryPrincApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDJ_Aut_DeleteTaxResident']")
	WebElement delcountryJointApp;
	
	public @FindBy(xpath = "//button[@automation-id='YDS_Aut_DeleteTaxResident']")
	WebElement delcountrySuppApp;
	
	
	public @FindBy(name = "principalTaxResidence_1")
	WebElement addCountryPrincApp;
	
	public @FindBy(name = "jointTaxResidence_1")
	WebElement addCountryJointApp;
	
	public @FindBy(name = "supCardTaxResidence_1")
	WebElement addCountrySuppApp;

	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_YesHaveATaxIdentificationNumberOrEquivalent' and @name='hasPrincipalTaxTinNo_1']//following-sibling::span")
	WebElement addYesTINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDP_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent' and @name='hasPrincipalTaxTinNo_1']//following-sibling::span")
	WebElement addNoTINPrincApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_YesHaveATaxIdentificationNumberOrEquivalent' and @name='hasJointTaxTinNo_1']//following-sibling::span")
	WebElement addYesTINJointApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDJ_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent' and @name='hasJointTaxTinNo_1']//following-sibling::span")
	WebElement addNoTINJointApp;
		
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_YesHaveATaxIdentificationNumberOrEquivalent' and @name='hasSupCardTaxTinNo_1']//following-sibling::span")
	WebElement addYesTINSuppApp;
	
	public @FindBy(xpath = "//input[@automation-id='YDS_Aut_DoNotHaveTaxIdenficationNumberOrEquivalent' and @name='hasSupCardTaxTinNo_1']//following-sibling::span")
	WebElement addNoTINSuppApp;

	public @FindBy(name = "principalTaxTinNo_1")
	WebElement addCRSTINPrincApp;
	
	public @FindBy(name = "jointTaxTinNo_0")
	WebElement addCRSTINJointApp;
	
	public @FindBy(name = "supCardTaxTinNo_1")
	WebElement addCRSTINSuppApp;

	public @FindBy(name = "principalTinNoReason_1")
	WebElement addreasonPrincApp;
	
	public @FindBy(name = "jointTinNoReason_1")
	WebElement addreasonJointApp;
	
	public @FindBy(name = "supCardTinNoReason_1")
	WebElement addreasonSuppApp;

	public @FindBy(name = "principalTinNoExplain_1")
	List<WebElement> addexplainationPrincApp;
	
	public @FindBy(name = "jointTinNoExplain_1")
	List<WebElement> addexplainationJointApp;
	
	public @FindBy(name = "supCardTinNoExplain_1")
	List<WebElement> addexplainationSuppApp;
	
}
