package sg.casa.cimb.fast.saver.ii;

public interface Fast_saver_i_Retunxlid {
//General
	int Testcase_StatusExcelId = 0;
	
	//Getting Started Page	
	int GS_TestCaseSummary_xlid = 2;
	int GS_Title_xlid = 3;
	int GS_FullName_xlid = 4;
	int GS_SingaporePR_xlid = 5;
	int GS_Nationality_xlid = 6;
	int GS_NRICANDPassportNUmber_xlid = 7;
	int GS_PassportExpiryDate_xlid = 8;
	int GS_DateOfBirth_xlid = 9;
	int GS_Email_xlid = 10;
	int GS_MobileCode_xlid = 11;
	int GS_MobileNumber_xlid = 12;
	int GS_TermsandCondition_xlid = 13;
	int GS_StartButton_xlid = 14;
	
	//Account Information
	int ACI_AccountType_xlid = 18;
	int ACI_SignningCondition_xlid = 19;
	int ACI_PurposeOfAccount_xlid = 20;
	int ACI_SourceOfFundsForInitalDeposit_xlid = 21;
	int ACI_EStatment_xlid = 22;
	int AccountInformation_IsUserApplyForCrossSell = 23;
	int AccountInformation_CrosssellproductType = 24;
	int AccountInformation_Crosssel_CrossReferenceID = 25;
	int ACI_IsSupplimentrayCardIsApplicable = 27;
	int ACI_ApplicationinfoBtn_xlid = 26;
	
	//Application Information Page
	//Individul Applicant 
		//Personal Information.		
			int APInfo_Indi_Prin_AliasName_xlid = 29;
			int APInfo_Indi_Prin_PrimaryId_xlid = 31;
			int APInfo_Indi_Prin_CountryOfBirth_xlid = 32;
			int APInfo_Indi_Prin_PlaceOfBirth_xlid = 33;
			int APInfo_Indi_Prin_Gender_xlid = 34;
			int APInfo_Indi_Prin_MaritalStatus_xlid = 35;
			int APInfo_Indi_Prin_Race_xlid = 36;
			int APInfo_Indi_Prin_PrimarySourceOfWelth_xlid = 37;						
				
				//Contact Information
				int APInfo_Indi_Prin_ContactInfo_SecondaryContactType_xlid = 40;
				int APInfo_Indi_Prin_ContactInfo_SecondaryContact_PhoneNumber_xlid = 42;
							
					//Address Information
					//Residential Address Type
				int ApplicationInformation_Principal_AddressInformation_ResidentialAddresTypexlid = 43; 
	   
				//Local Address
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_PostalCodexlid = 44;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_IsuserClickOnGetAddressButton = 45;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BlockHouseNoxlid = 46;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Streetnamexlid = 47;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_Storyxlid = 48;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_UnitNumberxlid = 49;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Local_BuildingNamexlid = 50;
	
				//Foreign Address
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Countryxlid = 51;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine1xlid =  52;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_AddressLine2xlid = 53;
				int ApplicationInformation_Principal_AddressInformation_ResiAddress_Foreign_Postalcodexlid = 54;			
				
				//Mailing Address Type	(Need to Implement in XL)
				int ApplicationInformation_Principal_AddressInformation_MailingAddresTypexlid = 55;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_isResidentialid = 56;
			
				//Local Address
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_PostalCodexlid = 57; 
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_IsuserClickOnGetAddressButton = 58;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BlockHouseNoxlid = 59;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_Streetnamexlid = 60;	
				int ApplicationInformation_Principal_AddressInformation_MailingAddress_Local_Storyxlid = 61;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_UnitNumberxlid = 62;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Local_BuildingNamexlid = 63;			
			
				//Foreign Address
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Countryxlid = 64;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine1xlid =  65;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_AddressLine2xlid = 66;
				int ApplicationInformation_Principal_AddressInformation_MailingAddres_Foreign_Postalcodexlid = 67;
			
			
				//Job Information Section		
				int ApplicationInformation_Principal_JobInformation_EmploymentStatusxlid = 68;	
				int ApplicationInformation_Principal_JobInformation_Occupationxlid = 69;	
				int ApplicationInformation_Principal_JobInformation_NameOfCompanyxlid = 70;	
				int ApplicationInformation_Principal_JobInformation_NatureOfbusinessxlid = 71;	
			
				//Account Preferences Section.
				int ApplicationInformation_Principal_AccountPreferences_DoYouNeedaATMCardxlid = 72;
	
      //Joint Applicant 
				
				int ApplicationInformation_Joint_PersonalInformation_AccountTypeID = 1;
				
				//Application Information Panel
				int ApplicationInformation_Joint_PersonalInformation_Title = 4;
				int ApplicationInformation_Joint_PersonalInformation_ApplicantName = 5;
				int ApplicationInformation_Joint_PersonalInformation_Alias = 6;
				int ApplicationInformation_Joint_PersonalInformation_Nationality = 7;
				int ApplicationInformation_Joint_PersonalInformation_SingaporePR = 8;
				int ApplicationInformation_Joint_PersonalInformation_NRIC_PassportNumber = 9;
				int ApplicationInformation_Joint_PersonalInformation_PassportExpiry = 10;
				int ApplicationInformation_Joint_PersonalInformation_DateOfBirth = 11;
				int ApplicationInformation_Joint_PersonalInformation_CountryofBirth = 12;
				int ApplicationInformation_Joint_PersonalInformation_PlaceofBirth = 13;
				int ApplicationInformation_Joint_PersonalInformation_Gender = 14;
				int ApplicationInformation_Joint_PersonalInformation_MaritalStatus = 15;
				int ApplicationInformation_Joint_PersonalInformation_Race = 16;
				int ApplicationInformation_Joint_PersonalInformation_PrimarySourceOfWealth = 17;
				
				//Contact Information Panel		
				int ApplicationInformation_Joint_ContactInformation_PrimaryMobileCode = 18;
				int ApplicationInformation_Joint_ContactInformation_PrimaryMobileNumber = 19;
				int ApplicationInformation_Joint_ContactInformation_PrimaryEmail = 20;
				int ApplicationInformation_Joint_ContactInformation_SecondaryMobileType = 21;
				int ApplicationInformation_Joint_ContactInformation_SecondaryMobileCode = 22;
				int ApplicationInformation_Joint_ContactInformation_SecondaryMobileNumber = 23;
				
				//Address Information Residential Address
				int ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type = 24;
				int ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No = 25;
					//Local
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_PostalCode = 26;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_GetAddressBtn = 27;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_BlockHouseNumber = 28;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_Story = 29;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_UnitNumber = 30;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_StreetName = 31;
				int ApplicationInformation_Joint_AddressInformation_LocalAddress_BuildingName = 32;
					//Foreign
				int ApplicationInformation_Joint_AddressInformation_ForeignAddress_Country = 33;
				int ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine1 = 34;
				int ApplicationInformation_Joint_AddressInformation_ForeignAddress_AddressLine2 = 35;
				int ApplicationInformation_Joint_AddressInformation_ForeignAddress_PostalCode = 36;
				
				//Job Information Panel	
				int ApplicationInformation_Joint_JobInformation_EmploymentStatus = 37;
				int ApplicationInformation_Joint_JobInformation_Occupation = 38;
				int ApplicationInformation_Joint_JobInformation_NameOfCompany = 39;
				int ApplicationInformation_Joint_JobInformation_NatureOfBusiness = 40;
				
				//Account Preferences
				int ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard = 41;
	
	//CrossSell id	
				//Cross Sell Sheet.
				int ApplicationInformation_CrossSell_FixedDeposit_XLSheetCrossReferenceID = 1;
				int ApplicationInformation_CrossSell_FixedDeposit_ModeofDeposit = 4;
				int ApplicationInformation_CrossSell_FixedDeposit_Currency = 9;
				int ApplicationInformation_CrossSell_FixedDeposit_Tenure = 10;
				int ApplicationInformation_CrossSell_FixedDeposit_MaturityRenewalInstruction = 12;
				int ApplicationInformation_CrossSell_FixedDeposit_InstructionsForAnyPayment = 13;
				
				  // Credit Card
				int ApplicationInformation_CrossSell_CreditCard_XLSheetCrossReferenceID = 1;
						//Personal Information Panel
				int AccountInfromation_CrossSelll_CreditCard_PersonalInformation_Surname = 4;
				int AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NameToAppearOnCard = 5;
				int AccountInfromation_CrossSelll_CreditCard_PersonalInformation_MothersMaidenName = 6;
				int AccountInfromation_CrossSelll_CreditCard_PersonalInformation_HighestQualification = 7;
				int AccountInfromation_CrossSelll_CreditCard_PersonalInformation_NumberOfDependents = 8;
					//Contact Information
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_Name = 9;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileCode = 10;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_MobileNumber = 11;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType = 12;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileCode = 13;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_SecondaryContactType_MobileNumber = 14;
				int AccountInfromation_CrossSelll_CreditCard_ContactInformation_Reletionship = 15;
					//Address Information
				int AccountInfromation_CrossSelll_CreditCard_AddressInformation_PropertyType = 16;
				int AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Years = 17;
				int AccountInfromation_CrossSelll_CreditCard_AddressInformation_LengthOfResidence_Months = 18;
				int AccountInfromation_CrossSelll_CreditCard_AddressInformation_ResidenceStatus = 19;
					//Job Information
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_PostalCode = 20;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_GetAddressBtn = 21;	
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_BlockHouseNumber = 22;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_StreetName = 23;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_Story = 24;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_UnitNumber = 25;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_BuildingName = 26;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_GrossAnnualSalary = 27;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Years = 28;
				int AccountInfromation_CrossSelll_CreditCard_JobInformation_LengthOfEmployment_Months = 29;
					//Credit Card
				int AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimit = 30;
				int AccountInfromation_CrossSelll_CreditCard_CreditCard_IsPreferredCreditLimitAmmount = 31;
				int AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN = 32;
				int AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatmentType = 33;
				int AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress = 34;
					//Supplementary Card
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard = 35;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_RelationshipToPrincipal = 36;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameToAppearOnSupplementaryCard = 37;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Title = 38;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Surname = 39;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ApplicantName = 40;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Alias = 41;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality = 42;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR = 43;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC = 44;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry = 45;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DateOfBirth = 46;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Gender = 47;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MaritalStatus = 48;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Race = 49;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileCode = 50;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MobileNumber = 51;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_MothersMiddleName = 52;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress = 53;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No =54;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_PostalCode = 55;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_GetAddressBtn = 56;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BlockHouseNo = 57;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_StreetName = 58;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_Story = 59;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_UnitNo = 60;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Local_BuildingName = 61;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_Country = 62;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine1 = 63;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_AddressLine2 = 64;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_No_Foreign_PostalCode = 65;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_EmploymentStatus = 66;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Occupation = 67;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NameOfCompany = 68;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_NatureOfBusiness = 69;
				
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimitStatus = 70;
				int AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_preferredCreditLimit = 71;
}
