package sg.casa.cimb.fixeddeposit;

public interface FixedDeposit_Elements {

	
	//Fixed Deposit
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit = ".//*[@automation-id='AI_Aut_ModeOfDeposit']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber = ".//*[@automation-id='AI_Aut_CIMBAccountNumber']";	
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_GetOTPBtn = "//button[@type='button' and contains(., 'Get OTP')]";	
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPText = ".//*[@automation-id='AI_Aut_OneTimePassword']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_AccountNumber_VerifyOTPBtn = "//button[@type='button' and contains(., 'Verify')]";
	
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Currency = ".//*[@automation-id='AI_Aut_Currency']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_Tenure = ".//*[@automation-id='AI_Aut_Tenure']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_DepositAmount = ".//*[@automation-id='AI_Aut_DepositAmount']";
	
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_MaturityRenewalInstruction = ".//*[@automation-id='AI_Aut_MaturityRenewalInstructions']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_InstructionsForAnyPayment = ".//*[@automation-id='AI_Aut_InstructionsForAnyPayment']";
	String AccountInfromation_CrossSell_FixedDeposit_ModeOfDeposit_CIMBAccountNumberToCredit = ".//*[@automation-id='AI_Aut_CIMBAccountNumberToCredit']";
	
}
