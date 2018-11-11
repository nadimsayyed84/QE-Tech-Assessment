package sg.casa.base;
import org.apache.commons.lang3.math.NumberUtils;

public interface test {
		
		//Getting Started Page
		String GS_TestCaseSummary_xl = "2";
		String GS_Title_xl = "3";
		String GS_FullName_xl = "4";
		String GS_SingaporePR_xl = "5";
		String GS_Nationality_xl = "6";
		String GS_NRICANDPassportNUmber_xl = "7";
		String GS_PassportExpiryDate_xl = "8";
		String GS_DateOfBirth_xl = "9";
		String GS_Email_xl = "10";
		String GS_MobileCode_xl = "11";
		String GS_MobileNumber_xl = "12";
		String GS_TermsandCondition_xl = "13";
		String GS_StartButton_xl = "14";	
		
		int GS_TestCaseSummary_xlid = NumberUtils.toInt(GS_TestCaseSummary_xl);
		int GS_Title_xlid =NumberUtils.toInt(GS_Title_xl);
		int GS_FullName_xlid = NumberUtils.toInt(GS_FullName_xl);
		int GS_SingaporePR_xlid = NumberUtils.toInt(GS_SingaporePR_xl);
		int GS_Nationality_xlid = NumberUtils.toInt(GS_Nationality_xl);
		int GS_NRICANDPassportNUmber_xlid = NumberUtils.toInt(GS_NRICANDPassportNUmber_xl);
		int GS_PassportExpiryDate_xlid = NumberUtils.toInt(GS_PassportExpiryDate_xl);
		int GS_DateOfBirth_xlid = NumberUtils.toInt(GS_DateOfBirth_xl);
		int GS_Email_xlid = NumberUtils.toInt(GS_Email_xl);
		int GS_MobileCode_xlid = NumberUtils.toInt(GS_MobileCode_xl);
		int GS_MobileNumber_xlid = NumberUtils.toInt(GS_MobileNumber_xl);
		int GS_TermsandCondition_xlid = NumberUtils.toInt(GS_TermsandCondition_xl);
		int GS_StartButton_xlid = NumberUtils.toInt(GS_StartButton_xl);
		
		
		//Account Information Page.
		String ACI_AccountType_xl = "18";
		String ACI_SignningCondition_xl = "19";
		String ACI_PurposeOfAccount_xl = "20";
		String ACI_SourceOfFundsForInitalDeposit_xl = "21";
		String ACI_EStatment_xl = "22";
		String ACI_Crosssell_xl = "23";
		String ACI_ApplicationinfoBtn_xl = "25";
		
		int ACI_AccountType_xlid = NumberUtils.toInt(ACI_AccountType_xl);
		int ACI_SignningCondition_xlid =NumberUtils.toInt(ACI_SignningCondition_xl);
		int ACI_PurposeOfAccount_xlid = NumberUtils.toInt(ACI_PurposeOfAccount_xl);
		int ACI_SourceOfFundsForInitalDeposit_xlid = NumberUtils.toInt(ACI_SourceOfFundsForInitalDeposit_xl);
		int ACI_EStatment_xlid = NumberUtils.toInt(ACI_EStatment_xl);
		int ACI_Crosssell_xlid = NumberUtils.toInt(ACI_Crosssell_xl);
		int ACI_ApplicationinfoBtn_xlid = NumberUtils.toInt(ACI_ApplicationinfoBtn_xl);
		
		
		//Application Information Page
			//Individul Applicant 
		
		        //Personal Information.
				String APInfo_Indi_Prin_Surname_xl = "29";
				String APInfo_Indi_Prin_AliasName_xl = "29";
				String APInfo_Indi_Prin_PrimaryId_xl = "31";
				String APInfo_Indi_Prin_CountryOfBirth_xl = "32";
				String APInfo_Indi_Prin_PlaceOfBirth_xl = "33";
				String APInfo_Indi_Prin_Gender_xl = "34";
				String APInfo_Indi_Prin_MaritalStatus_xl = "35";
				String APInfo_Indi_Prin_Race_xl = "36";
				String APInfo_Indi_Prin_PrimarySourceOfWelth_xl = "37";
				
				int APInfo_Indi_Prin_Surname_xlid = NumberUtils.toInt(APInfo_Indi_Prin_Surname_xl);
				int APInfo_Indi_Prin_AliasName_xlid = NumberUtils.toInt(APInfo_Indi_Prin_AliasName_xl);
				int APInfo_Indi_Prin_PrimaryId_xlid = NumberUtils.toInt(APInfo_Indi_Prin_PrimaryId_xl);
				int APInfo_Indi_Prin_CountryOfBirth_xlid = NumberUtils.toInt(APInfo_Indi_Prin_CountryOfBirth_xl);
				int APInfo_Indi_Prin_PlaceOfBirth_xlid = NumberUtils.toInt(APInfo_Indi_Prin_PlaceOfBirth_xl);
				int APInfo_Indi_Prin_Gender_xlid = NumberUtils.toInt(APInfo_Indi_Prin_Gender_xl);
				int APInfo_Indi_Prin_MaritalStatus_xlid = NumberUtils.toInt(APInfo_Indi_Prin_MaritalStatus_xl);
				int APInfo_Indi_Prin_Race_xlid = NumberUtils.toInt(APInfo_Indi_Prin_Race_xl);
				int APInfo_Indi_Prin_PrimarySourceOfWelth_xlid = NumberUtils.toInt(APInfo_Indi_Prin_PrimarySourceOfWelth_xl);
				
				//Contact Information
				String APInfo_Indi_Prin_ContactInfo_SecondaryContactType_xl = "40";
				String APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xl = "42";
				
				int APInfo_Indi_Prin_ContactInfo_SecondaryContactType_xlid = NumberUtils.toInt(APInfo_Indi_Prin_ContactInfo_SecondaryContactType_xl);
				int APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xlid = NumberUtils.toInt(APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xl);
				
				//Address Information
				//Residential Address
					//Local Address
				String ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexl = "43";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexl = "44";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxl = "45";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexl = "46";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxl = "47";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxl = "48";
				String AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexl = "49";
				
				  // Foreign Address
				String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxl = "50";
			    String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xl = "51"; 
			    String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xl = "52";
			    String AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexl = "53";
				
			    //Residential Address Type
			    int ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlid = NumberUtils.toInt(ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexl);
			    
			    //Local Address
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_Storyxl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexl);
				
				//Foreign Address
				  // Foreign Address
				int AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xl);
				int AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexlid = NumberUtils.toInt(AccountInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexl);
				
		
}
