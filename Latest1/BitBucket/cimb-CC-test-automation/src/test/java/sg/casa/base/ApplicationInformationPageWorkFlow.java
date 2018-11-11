package sg.casa.base;

public class ApplicationInformationPageWorkFlow {
	//Individual Applicant
		//Personal Information
	
				//Get Country of Birth
					public static String GetACCInfo_Principal_PersoanlInformation_CountryOfBirthXpath(String country) {	
						String xpath = country;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_CountryOfBirth+country+"']";
						return xpath;
					}
				//Get Place Of Birth	
					public static String GetACCInfo_Principal_PersoanlInformation_PlaceOfBirthXpath() {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_PlaceOfBirth;
						return xpath;
					}
			   //Get Gender	
					public static String GetACCInfo_Principal_PersoanlInformation_GenderXpath(String gender) {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_Gender+gender+"']";
						return xpath;
					}
			   //Get Marital Status	
					public static String GetACCInfo_Principal_PersoanlInformation_MaritalStatusXpath(String MaritalStatus) {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_MaritalStatus+MaritalStatus+"']";
						return xpath;
					}
			   //Get Race	
					public static String GetACCInfo_Principal_PersoanlInformation_RaceXpath(String race) {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_Race+race+"']";;
						return xpath;
					}
			   //Get primary Source of Wealth
					public static String GetACCInfo_Principal_PersoanlInformation_PrimarySourceOfWelthXpath(String Source) {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_PrimarySourceOfWealth+Source+"']";
						return xpath;
					}
			  //Get Alias Name
					public static String GetACCInfo_Principal_PersoanlInformation_AliasXpath() {	
						String xpath;
						xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_PersoanalInformation_AliasName;
						return xpath;
					}
		
//	Contact Information	
		    //Get Secondary Contact Type
		public static String GGetACCInfo_Principal_ContactInformation_secondaryContactType_Xpath (String ContactType) {	
			String xpath = null;
			if(ContactType.equalsIgnoreCase("Home")) {
				xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_ContactInformation_SecondaryPhone_Home;
				System.out.println("Contact Type Xpath" +xpath);
			}
				else if (ContactType.equalsIgnoreCase("Office")){
					xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_ContactInformation_SecondaryPhone_Office;
					System.out.println("Contact Type Xpath" +xpath);
				}
				else
					System.out.println("Application Information | Contact Information | Invalid Parameter for Secondary Contact Type.");
			return xpath;
		}
		
//Get Place Of Birth	
		public static String GetACCInfo_Principal_Contactinformation_SecondaryPhoneNumberXpath() {	
			String xpath;
			xpath = SG_CASA_UI_Elements.ApplicationInformation_Principal_ContactInformation_SecondaryPhoneNumber;
			return xpath;
		}
		
//To Get Address Information - Residential Address Xpath
		public static String GetApplicationInformationpage_AddressInformation_ResidentialAddressTypeXpath (String ResidentialAddressType) {	
			String Parameter = ResidentialAddressType;
			
			if(ResidentialAddressType.equalsIgnoreCase("Local Address")) {
				//Retun Local Address
				Parameter = SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_LocalAddress_RadioButton;
			
			}
				else if (ResidentialAddressType.equalsIgnoreCase("Foreign Address")){
					//Return Foreign Address xpath.
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Principal_AddressInformation_ResiAddress_ForeignAddress_RadioButton;
				}
				else {
					System.out.println("Residential Address is Invalid");
				}
			
			return Parameter;
		}	
	
		//To Get Address Information - Mailing Address Xpath
				public static String GetApplicationInformationpage_AddressInformation_MailingAddressTypeXpath (String MailingAddressType) {	
					String Parameter = MailingAddressType;	
					
					if(MailingAddressType.equalsIgnoreCase("Same as Residential")) {
						//Retun Same as Residential xpath
						Parameter = SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_Yes;
					
					}
						else if (MailingAddressType.equalsIgnoreCase("No")){
							//Retun Same as Residential - No xpath
							Parameter = SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No;
						}
						else {
							System.out.println("Residential Address is Invalid");
						}
					
					return Parameter;
				}	
				
				//To Get Address Information - Mailing Address Not Residence Xpath
				public static String GetApplicationInformationpage_AddressInformation_MailingAddressNotSameasresidentialaddressXpath (String notresidentialaddress) {	
					String Parameter = notresidentialaddress;	
					
					if(notresidentialaddress.equalsIgnoreCase("Local Address")) {
						//Retun Same as Residential xpath
						Parameter = SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_LocalAddress;
					
					}
						else if (notresidentialaddress.equalsIgnoreCase("Foreign Address")){
							//Retun Same as Residential - No xpath
							Parameter = SG_CASA_UI_Elements.AccountInformation_Principal_AddressInformation_MailingAddresType_Sameasresidentialaddress_No_ForeignAddress;
						}
						else {
							System.out.println("Not Residential Address is Invalid");
						}
					
					return Parameter;
				}				

				//To Get Account Preferences - Do You Need a ATM card.
				public static String GetApplicationInformationpage_AccountPreferences_DoYouNeedAnATMCardXpath (String status) {	
					String Parameter = status;	
					
					if(status.equalsIgnoreCase("Yes")) {
						//Do you Need ATM Card. == "Yes"
						Parameter = SG_CASA_UI_Elements.ApplicationInformation_Principal__AccountPreferences_DoYouNeedaATMCard_Yes;
					
					}
						else if (status.equalsIgnoreCase("No")){
							//Do you Need ATM Card. == "No"
							Parameter = SG_CASA_UI_Elements.ApplicationInformation_Principal__AccountPreferences_DoYouNeedaATMCard_No;
						}
						else {
							System.out.println("Do You Need an ATM Card Selection is Invalid");
						}
					
					return Parameter;
				}	
}
