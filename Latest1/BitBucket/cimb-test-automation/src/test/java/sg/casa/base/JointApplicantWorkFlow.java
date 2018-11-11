package sg.casa.base;

public class JointApplicantWorkFlow {
	//To Verify the methord isSingapore PR
	public static String SetJointApplicant_IsSingaporePRXpath (String isSingaporePR) {	
			String Parameter = null;
			
			if(isSingaporePR.contentEquals("Yes")) {
					//Return the isSingapore PR = Yes xpath
					Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_AreYouSingapore_PR_Yes;
			
			}
			else if (isSingaporePR.contentEquals("No")) {
					//Return the isSingapore PR = No xpath
					Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_AreYouSingapore_PR_No;
			}
			
			else if(isSingaporePR.contentEquals("Default")){
				//Orginal Singapore
				System.out.println("Orginal Singapore " + Parameter);
			}
			
			else {
				System.out.println("methord Values are not match with xl Sheet values : " +Parameter);
			
			}
			return Parameter;
		}
	
    //To Get NRIC , Malaysia NRIC & Passport Number
		public static String SetJointApplicant_NRICandPassportNumberPRXpath (String isSingaporePR, String country) {	
			String Parameter = null;
			
			if(isSingaporePR.contentEquals("Yes")) {
					//Return the NRIC xpath
					Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_NRIC;
			
			}
			else if (isSingaporePR.contentEquals("No")) {
				if(country.equalsIgnoreCase("Malaysia")) {
					//Retun Malasia xpath
					Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_MalaysiaICNo;
				}
				else {
					//Return Passport xpath
					Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_PassportNumber;
				}
			}
			
			else if(isSingaporePR.contentEquals("Default")){
				//Return the NRIC xpath
				Parameter =	SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_NRIC;
			}
			
			else {
				System.out.println("methord Values are not match with xl Sheet values : " +Parameter);
			
			}
			return Parameter;
		}
		
	      //To Get Passport Expiry date
			public static String SetJointApplicant_PassportExpiryPRXpath (String isSingaporePR, String country) {	
				String Parameter = country;
				
				if(country.equalsIgnoreCase("Singapore")) {
					//Singapore PR;
					System.out.println("Country : " +Parameter);
				
				}
					else if(country.equalsIgnoreCase("Malaysia")) {
						//Malaysia
						System.out.println("Country : " +Parameter);
					}
					else {
						if(isSingaporePR.equalsIgnoreCase("Yes")) {
							//Except Singapore & Malaysia, But Singapore PR;
							System.out.println("Sigapore PR : " +isSingaporePR);
						}
						else {
							//Retun Passport Expity Date;
							Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_PersoanalInformation_PassportExpiryDate;
						}
					}
				
				return Parameter;
				
			}
			 //To Get Secondary Phone Contact 
			public static String SetJointApplicant_SecondaryPhoneTypeXpath (String Type) {	
				String Parameter = "";
				
				if(Type.equalsIgnoreCase("Home")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_ContactInformation_SecondaryMobileType_Home;
				}
				else if (Type.equalsIgnoreCase("Office")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_ContactInformation_SecondaryMobileType_Office;
				}
				else {
					System.out.println("Invalid parameter for Secondary Phone Contact...... ");
				}
			
				return Parameter;
				
			}
			
			 //To Get Address Information - Residential Address Type
			public static String SetJointApplicant_AddressInformation_ResidentialAddressTypeXpath (String Type) {	
				String Parameter = "";
				
				if(Type.equalsIgnoreCase("Same as principal")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_ResidentialAddress_Type_SameAsPrincipal;
				}
				else if (Type.equalsIgnoreCase("No")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No;
				}
				else {
					System.out.println("Invalid parameter for Residential Address Type...... ");
				}
			
				return Parameter;
				
			}	
			
			///To Get Address Information - Residential Address Type - Local , Foreign
			public static String SetJointApplicant_AddressInformation_ResidentialAddressIsnotSameAsprincipalTypeXpath (String Type) {	
				String Parameter = "";
				
				if(Type.equalsIgnoreCase("Local Address")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No_LocalAddress;
				}
				else if (Type.equalsIgnoreCase("Foreign Address")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AddressInformation_IsResidentialAddress_Type_No_ForeignAddress;
				}
				else {
					System.out.println("Invalid parameter for Residential Address Type (Local Foreign)...... ");
				}
			
				return Parameter;
				
			}	


			///To Get Account Preferences
			public static String SetJointApplicant_ApplicationInformation_AccountPreferencesXpath (String Type) {	
				String Parameter = "";
				
				if(Type.equalsIgnoreCase("Yes")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard_Yes;
				}
				else if (Type.equalsIgnoreCase("No")) {
					Parameter = SG_CASA_UI_Elements.ApplicationInformation_Joint_AccountPreferences_DoYouNeedAnATMCard_No;
				}
				else {
					System.out.println("Invalid parameter for Account Preferences...... ");
				}
			
				return Parameter;
				
			}		
} //End of Class
