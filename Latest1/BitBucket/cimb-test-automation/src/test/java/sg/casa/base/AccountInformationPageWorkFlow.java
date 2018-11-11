package sg.casa.base;

public class AccountInformationPageWorkFlow {

	//To Get Account Type Xpath
	public static String GetAccountInformationpageAccountTypeXpath (String accountType) {	
		String Parameter = accountType;
		
		if(accountType.equalsIgnoreCase("Joint")) {
			//Retun Joint xpath
			Parameter = SG_CASA_UI_Elements.E_ACI_AccountType_Joint;
		
		}
			else if (accountType.equalsIgnoreCase("Individual")){
				//Return Individual xpath.
				Parameter = SG_CASA_UI_Elements.E_ACI_AccountType_Individual;
			}
			else {
				System.out.println("Account Type parameter is invalid");
			}
		
		return Parameter;
	}
	
	//To Get Purpose of Account Xpath
		public static String GetAccountInformationpagePurposeOfAccountXpath (String PurposeofAccount) {	
			String Parameter = PurposeofAccount;
			Parameter = SG_CASA_UI_Elements.E_ACI_PurposeOfAccount+PurposeofAccount+"']";
			return Parameter;
		}
		
	//To Get Source of Funds for Initial Deposit Xpath
		public static String GetAccountInformationpageSourceOfFundsForInitialDepositXpath (String sourceoffunds) {	
			String Parameter = sourceoffunds;
			Parameter = SG_CASA_UI_Elements.E_ACI_SourceOfFundsForInitialDeposit+sourceoffunds+"']";
			return Parameter;
		}	
		
		//To Get Source of Funds for Initial Deposit Xpath
		public static String GetAccountInformationpageEstatmentXpath (String estatment) {	
			String Parameter = estatment;
			//Need to Implement the logic.
			//Parameter = sg_casa_Elements.est+sourceoffunds+"']";
			return Parameter;
		}
		
		//To Get Source of Funds for Initial Deposit Xpath
		public static String GetAccountInformationpageApplicationinfoBtnXpath (String btn) {	
			String Parameter = btn;
			if(btn.equalsIgnoreCase("Yes")) {
				Parameter = SG_CASA_UI_Elements.E_ACI_AccountInformation_SubmitButton;
			
			}
				else {
					System.out.println("User doesn't click on Account Information Button.");
				}
			
			return Parameter;
		}		
}
