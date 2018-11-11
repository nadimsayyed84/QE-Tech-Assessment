package sg.casa.base;

import net.thucydides.core.annotations.findby.By;

public class CrossSellWorkFlow extends SG_CASA_UI_Elements {
	
	//Get xpath of Crosssell Product.
	public static String GetCrosssellXpath (String crossellProduct) {
		String xpath="";		
		if(crossellProduct.equalsIgnoreCase("Fixed Deposit")) {
			xpath = "//form[contains(@name,'vm.formAccInf')]/div[5]/div/data-carousel/div[1]/div/div[1]/div/div/div/label/span[contains(text(), 'Select the product')]";
		}
		else if(crossellProduct.equalsIgnoreCase("CIMB Visa Signature")) {	
			if(driver.findElements(By.xpath("//form[contains(@name,'vm.formAccInf')]/div[5]/div/data-carousel/div[1]/div/div[3]/div/div/div/label/span[contains(text(), 'Select the product')]")).size()>0)
				xpath = "//form[contains(@name,'vm.formAccInf')]/div[5]/div/data-carousel/div[1]/div/div[3]/div/div/div/label/span[contains(text(), 'Select the product')]";
			else
				xpath = "//*[@id='CIMB_Visa_Signature']//following-sibling::label";
		}
		return xpath;
	}

	
//Credit card Section - 	Do you want a PIN (Personal Identification Number to be issued to you ?	
	public static String GetCrossSell_CreditCard_DoYouWantAPINXpath (String PinStatus) {
		String xpath="";
		if(PinStatus.equalsIgnoreCase("Yes")) {
			xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN_Yes;
		}
		else if(PinStatus.equalsIgnoreCase("No")) {
			xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_DoYouWantaPIN_No;
		}
		else {
			System.out.println("Inavalid Value for : Do you want a PIN (Personal Identification Number to be issued to you?");
		}
		return xpath;
	}

	//Credit card Section - 	Which type of monthly statements do you prefer ?
		public static String GetCrossSell_CreditCard_MonthlyStatementsXpath (String MonthlyStatementsType) {
			String xpath="";
			if(MonthlyStatementsType.equalsIgnoreCase("E-Statements Only")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatment_EStatment;
			}
			else if(MonthlyStatementsType.equalsIgnoreCase("Paper Statement")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_MonthlyStatment_PaperStatment;
			}
			else {
				System.out.println("Inavalid Value for : Which type of monthly statements do you prefer ?");
			}
			return xpath;
		}
		
		
		//Credit card Section - 	Which address would you want the card and statements to be delivered to?
		public static String GetCrossSell_CreditCard_MonthlyStatements_DeliveredAddressXpath (String DeliveredAddress) {
			String xpath="";
			if(DeliveredAddress.equalsIgnoreCase("Home")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress_Home;
			}
			else if(DeliveredAddress.equalsIgnoreCase("Office")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_CreditCard_CardDeliveryAddress_Office;
			}
			else {
				System.out.println("Inavalid Value for : Which address would you want the card and statements to be delivered to?");
			}
			return xpath;
		}
		
	//Supplimentary Card Methord Impplementation
	//
		public static String GetCrossSell_SupplementaryCard_DoYouWishTOAddASupplementaryCardHolderXpath (String Status) {
			String xpath="";
			if(Status.equalsIgnoreCase("Yes")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard_Yes;
			}
			else if(Status.equalsIgnoreCase("No")) {
				xpath = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_DoYouWantASupplementaryCard_No;
			}
			else {
				System.out.println("Inavalid Value for : Do you wish to add a supplementary card holder?");
			}
			return xpath;
		}
		   //To Verify the methord isSingapore PR
			public static String GetSupplementaryCardIsSingaporePRXpath (String isSingaporePR) {	
					String Parameter = null;
					
					if(isSingaporePR.contentEquals("Yes")) {
							//Return the isSingapore PR = Yes xpath
							Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR_Yes;
					
					}
					else if (isSingaporePR.contentEquals("No")) {
							//Return the isSingapore PR = No xpath
							Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_SingaporePR_No;
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
				public static String GetSupplementaryCardNRICandPassportNumberPRXpath (String isSingaporePR, String country) {	
					String Parameter = null;
					
					if(isSingaporePR.contentEquals("Yes")) {
							//Return the NRIC xpath
							Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC;
					
					}
					else if (isSingaporePR.contentEquals("No")) {
						if(country.equalsIgnoreCase("Malaysia")) {
							//Retun Malasia xpath
							Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_MalayiaICNumber;
						}
						else {
							//Return Passport xpath
							Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_PassportNumber;
						}
					}
					
					else if(isSingaporePR.contentEquals("Default")){
						//Return the NRIC xpath
						Parameter =	SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_Nationality_NRIC;
					}
					
					else {
						System.out.println("methord Values are not match with xl Sheet values : " +Parameter);
					
					}
					return Parameter;
				}
				
			      //To Get Passport Expiry date
				public static String GetSupplementaryCardPassportExpiryPRXpath (String isSingaporePR, String country) {	
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
								Parameter = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_PassportExpiry;
							}
						}
					
					return Parameter;
					
				}
				
			      //Supplimentray Card - Residential Address Selection 
				public static String GetSupplementaryCard_ResidentialAddressSelectionPRXpath (String AddressType) {	
					String Parameter = AddressType;
					
					if(AddressType.equalsIgnoreCase("Same as principal")) {
						Parameter = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_Yes;
					
					}
						else if(AddressType.equalsIgnoreCase("No")) {
							Parameter = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No;
						}
	
							else {
								
								System.out.println("Invalid Parameter");
							}
					
					
					return Parameter;	
				}	
				
			      //Supplimentray Card - Residential Address Selection  - local / Foreign
				public static String GetSupplementaryCard_ResidentialAddressSelectionLocalForeignPRXpath (String AddressType) {	
					String Parameter = AddressType;
					
					if(AddressType.equalsIgnoreCase("Local Address")) {
						Parameter = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No_Local;
					
					}
						else if(AddressType.equalsIgnoreCase("Foreign Address")) {
							Parameter = SG_CASA_UI_Elements.AccountInfromation_CrossSelll_CreditCard_SupplementaryCard_ResidentialAddress_SameAsPrincipal_No_Foreign;
						}
	
							else {
								
								System.out.println("Invalid Parameter");
							}
					
					
					return Parameter;
					
				}	
}
