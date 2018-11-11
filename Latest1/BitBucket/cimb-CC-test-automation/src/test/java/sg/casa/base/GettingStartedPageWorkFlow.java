package sg.casa.base;

public class GettingStartedPageWorkFlow {
	
	//Getting Start page
			//To Get Title Xpath
			public static String GetGettingstartPageTitleXpath () {	
				String Parameter;
				Parameter = (SG_CASA_UI_Elements.E_GS_Title);// +title+"']");
				return Parameter;
			}
			
			//To Get Full Name Xpath
			public static String GetGettingstartPageFullNameXpath () {	
					String Parameter;
					Parameter = (SG_CASA_UI_Elements.E_GS_FullName);
					return Parameter;
				}
			
	       //To select Nationality.
			public static String GetGettingstartPageNationalityXpath () {	
					String Parameter;
					Parameter = (SG_CASA_UI_Elements.E_GS_Nationality); //+nationality+"']");
					return Parameter;
				}
		
		   //To Verify the methord isSingapore PR
			public static String GetGettingstartPageIsSingaporePRXpath (String isSingaporePR) {	
					String Parameter = null;
					
					if(isSingaporePR.contentEquals("Yes")) {
							//Return the isSingapore PR = Yes xpath
							Parameter =	SG_CASA_UI_Elements.E_GS_Singaporean_Yes;
					
					}
					else if (isSingaporePR.contentEquals("No")) {
							//Return the isSingapore PR = No xpath
							Parameter =	SG_CASA_UI_Elements.E_GS_Singaporean_No;
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
			public static String GetGettingstartPageNRICandPassportNumberPRXpath (String isSingaporePR, String country) {	
				String Parameter = null;
				
				if(isSingaporePR.contentEquals("Yes")) {
						//Return the NRIC xpath
						Parameter =	SG_CASA_UI_Elements.E_GS_NRIC;
				
				}
				else if (isSingaporePR.contentEquals("No")) {
					if(country.equalsIgnoreCase("Malaysia")) {
						//Retun Malasia xpath
						Parameter =	SG_CASA_UI_Elements.E_GS_Malayasia_IC;
					}
					else {
						//Return Passport xpath
						Parameter =	SG_CASA_UI_Elements.E_GS_Passport_Number;
					}
				}
				
				else if(isSingaporePR.contentEquals("Default")){
					//Return the NRIC xpath
					Parameter =	SG_CASA_UI_Elements.E_GS_NRIC;
				}
				
				else {
					System.out.println("methord Values are not match with xl Sheet values : " +Parameter);
				
				}
				return Parameter;
			}
	
	      //To Get Passport Expiry date
			public static String GetGettingstartPagePassportExpiryPRXpath (String isSingaporePR, String country) {	
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
							Parameter = SG_CASA_UI_Elements.E_GS_Passport_Expiry_Date;
						}
					}
				
				return Parameter;
				
			}
		
		 //To Get Date of Birth Xpath
			public static String GetGettingstartPageDateofBirthXpath() {	
				String Parameter;
				Parameter = (SG_CASA_UI_Elements.E_GS_Date_Of_Birth);
				return Parameter;
			}
			
	     //To Get Email Xpath
			public static String GetGettingstartPageEmailXpath() {	
				String Parameter;
				Parameter = (SG_CASA_UI_Elements.E_GS_Email);
				return Parameter;
			}	
			
	    //To Get MobileNumber Xpath
			public static String GetGettingstartPageMobileNumberXpath() {	
				String Parameter;
				Parameter = (SG_CASA_UI_Elements.E_GS_Mobile_Number);
				return Parameter;
			}				
			
		 //To Get Terms and ondition Xpath
			public static String GetGettingstartPageTermsandConditionXpath (String terms) {	
				String Parameter = terms;
				
				if(terms.equalsIgnoreCase("Yes")) {
					//Retun Terms and condition xpath;
					Parameter = SG_CASA_UI_Elements.E_GS_Terms_and_Conditions;
				
				}
					else {
						//No User doesn't click on Terms and condions.
						System.out.println("No User doesn't click on Terms and condions.");
					}
				
				return Parameter;
			}		
				
		//To Get Terms and ondition Xpath
			public static String GetGettingstartPageGettingStartedBtnXpath (String btnGettingStart) {	
				String Parameter = btnGettingStart;
				
				if(btnGettingStart.equalsIgnoreCase("Yes")) {
					//Retun Terms and condition xpath;
					Parameter = SG_CASA_UI_Elements.E_GS_Start_Application;
				
				}
					else {
						//No User doesn't click on Terms and condions.
						System.out.println("User doesn't click on Getting Start Button.");
					}
				
				return Parameter;
			}		
}
