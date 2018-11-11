package sg.casa.base;


import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YourDeclarationPageWorkFlow extends SG_CASA_UI_Decleration {
	static HashMap<String, Integer> getxlcolumn= null;
	WebDriver driver;
	public YourDeclarationPageWorkFlow(WebDriver driver){
		this.driver=driver;
	}	
	
	public void PrincipleAppldeclaration(Row row) {
//		String Principal_Voice=row.getCell(getxlcolumn.get("Principal_Voice Call_Phone Call")).getStringCellValue().trim();		
//		String Principal_SMS=row.getCell(getxlcolumn.get("Principal_SMS_MMS")).getStringCellValue().trim();				
//		String Principal_Citizan=row.getCell(getxlcolumn.get("Principal_Citizan of the United States")).getStringCellValue().trim();
//		String Yes_Principal_USResident=row.getCell(getxlcolumn.get("FATCA - Yes_Principal_USResident")).getStringCellValue().trim();				
//		String Yes_Principal_USCitizen=row.getCell(getxlcolumn.get("FATCA - Yes_Principal_USCitizen")).getStringCellValue().trim();	
//		String Yes_Principal_USPermanent=row.getCell(getxlcolumn.get("FATCA - Yes_Principal_USPermanent")).getStringCellValue().trim();
//		String Yes_Principal_TIN=row.getCell(getxlcolumn.get("FATCA - Yes_Principal_TIN")).getStringCellValue().trim();		
//		String PrincipalCountryTax=row.getCell(getxlcolumn.get("Principal Country of Tax Residence")).getStringCellValue().trim();
//		String CRS_Principal_TIN=row.getCell(getxlcolumn.get("Do you have tax identification number_Principal")).getStringCellValue().trim();
//		String Principal_TIN=row.getCell(getxlcolumn.get("Principal_TIN")).getStringCellValue().trim();		
//		String Principal_reason=row.getCell(getxlcolumn.get("Principal state reason")).getStringCellValue().trim();		
//		String Principal_Explanation=row.getCell(getxlcolumn.get("Principal_Explanation")).getStringCellValue().trim();
//		String Add_country_Principal=row.getCell(getxlcolumn.get("Add Another country_Principal")).getStringCellValue().trim();		
//		String Othercountry_Principal=row.getCell(getxlcolumn.get("Other Country of Tax Residence_Principal")).getStringCellValue().trim();
//		String selectOthercountryTIN_Principal=row.getCell(getxlcolumn.get("Do you have Other country TIN_Principal")).getStringCellValue().trim();
//		String OthercountryTIN_Principal=row.getCell(getxlcolumn.get("Other country TIN_Principal")).getStringCellValue().trim();
//		String reason_Principal=row.getCell(getxlcolumn.get("Other country reason_Principal")).getStringCellValue().trim();	
//		String explain_Principal=row.getCell(getxlcolumn.get("Other Country Explaination_Principal")).getStringCellValue().trim();	
//		String deletecountry_Principal=row.getCell(getxlcolumn.get("Delete Another country_Principal")).getStringCellValue().trim();

		String Principal_Voice=row.getCell(1).getStringCellValue().trim();		
		String Principal_SMS=row.getCell(2).getStringCellValue().trim();				
		String Principal_Citizan=row.getCell(3).getStringCellValue().trim();
		String Yes_Principal_USResident=row.getCell(4).getStringCellValue().trim();				
		String Yes_Principal_USCitizen=row.getCell(5).getStringCellValue().trim();	
		String Yes_Principal_USPermanent=row.getCell(6).getStringCellValue().trim();
		String Yes_Principal_TIN=row.getCell(7).getStringCellValue().trim();		
		String PrincipalCountryTax=row.getCell(8).getStringCellValue().trim();
		String CRS_Principal_TIN=row.getCell(9).getStringCellValue().trim();
		String Principal_TIN=row.getCell(10).getStringCellValue().trim();		
		String Principal_reason=row.getCell(11).getStringCellValue().trim();		
		String Principal_Explanation=row.getCell(12).getStringCellValue().trim();
		String Add_country_Principal=row.getCell(13).getStringCellValue().trim();		
		String Othercountry_Principal=row.getCell(14).getStringCellValue().trim();
		String selectOthercountryTIN_Principal=row.getCell(15).getStringCellValue().trim();
		String OthercountryTIN_Principal=row.getCell(16).getStringCellValue().trim();
		String reason_Principal=row.getCell(17).getStringCellValue().trim();	
		String explain_Principal=row.getCell(18).getStringCellValue().trim();	
		String deletecountry_Principal=row.getCell(19).getStringCellValue().trim();		
		
		
		if(Principal_Voice.equals("check"))
			CommonMethords.selectcheckbox(voicecallPrincApp,"check");
		else
			CommonMethords.selectcheckbox(voicecallPrincApp,"uncheck");
		
		if(Principal_SMS.equals("check"))
			CommonMethords.selectcheckbox(smsmmsPrincApp,"check");
		else
			CommonMethords.selectcheckbox(smsmmsPrincApp,"uncheck");
		
		if(Principal_Citizan.equals("Yes")) {
			YesGreenCardHolderPrincApp.click();
			if(Yes_Principal_USResident.equals("Yes"))
				CommonMethords.selectcheckbox(USresidentPrincApp,"check");
			else
				CommonMethords.selectcheckbox(USresidentPrincApp,"uncheck");
			
			if(Yes_Principal_USCitizen.equals("Yes"))
				CommonMethords.selectcheckbox(USCitizenPrincApp,"check");
			else
				CommonMethords.selectcheckbox(USCitizenPrincApp,"uncheck");
			
			if(Yes_Principal_USPermanent.equals("Yes"))
				CommonMethords.selectcheckbox(USprPrincApp,"check");
			else
				CommonMethords.selectcheckbox(USprPrincApp,"uncheck");
			
			TINPrincApp.sendKeys(Yes_Principal_TIN);
		}	
		else
			NoGreenCardHolderPrincApp.click();
		
		CommonMethords.SelectDropdown(CountryPrincApp,PrincipalCountryTax);
		
		if(CRS_Principal_TIN.equals("Yes")) {
			YesTINPrincApp.click();
			CRSTINPrincApp.sendKeys(OthercountryTIN_Principal);
		}else {
			NoTINPrincApp.click();
			CommonMethords.SelectDropdownPartialtext(reasonPrincApp,Principal_reason);
			if(explainationPrincApp.size()>0) {
				explainationPrincApp.get(0).sendKeys(Principal_Explanation);
			}
		}
		
		if(Add_country_Principal.equals("Yes")) {
			addcountryPrincApp.click();
			CommonMethords.SelectDropdown(addCountryPrincApp,Othercountry_Principal);
			if(selectOthercountryTIN_Principal.equals("Yes")) {
				addYesTINPrincApp.click();
				addCRSTINPrincApp.sendKeys(Principal_TIN);
			}else {
				addNoTINPrincApp.click();
				CommonMethords.SelectDropdownPartialtext(addreasonPrincApp,reason_Principal);
				if(addexplainationPrincApp.size()>0) {
					addexplainationPrincApp.get(0).sendKeys(explain_Principal);
				}
			}
		}
		
		if(deletecountry_Principal.equals("Yes")) {
			if(delcountryPrincApp.isDisplayed()) {
				delcountryPrincApp.click();
			}
		}
	}

	public void JointAppldeclaration(Row row) {
//		String Joint_Voice=row.getCell(getxlcolumn.get("Joint_Voice Call_Phone Call")).getStringCellValue().trim();		
//		String Joint_SMS=row.getCell(getxlcolumn.get("Joint_SMS_MMS")).getStringCellValue().trim();				
//		String Joint_Citizan=row.getCell(getxlcolumn.get("Joint_Citizan of the United States")).getStringCellValue().trim();
//		String Yes_Joint_USResident=row.getCell(getxlcolumn.get("FATCA - Yes_Joint_USResident")).getStringCellValue().trim();				
//		String Yes_Joint_USCitizen=row.getCell(getxlcolumn.get("FATCA - Yes_Joint_USCitizen")).getStringCellValue().trim();	
//		String Yes_Joint_USPermanent=row.getCell(getxlcolumn.get("FATCA - Yes_Joint_USPermanent")).getStringCellValue().trim();
//		String Yes_Joint_TIN=row.getCell(getxlcolumn.get("FATCA - Yes_Joint_TIN")).getStringCellValue().trim();		
//		String JointCountryTax=row.getCell(getxlcolumn.get("Joint Country of Tax Residence")).getStringCellValue().trim();
//		String CRS_Joint_TIN=row.getCell(getxlcolumn.get("Do you have tax identification number_Joint")).getStringCellValue().trim();
//		String Joint_TIN=row.getCell(getxlcolumn.get("Joint_TIN")).getStringCellValue().trim();		
//		String Joint_reason=row.getCell(getxlcolumn.get("Joint state reason")).getStringCellValue().trim();		
//		String Joint_Explanation=row.getCell(getxlcolumn.get("Joint_Explanation")).getStringCellValue().trim();
//		String Add_country_Joint=row.getCell(getxlcolumn.get("Add Another country_Joint")).getStringCellValue().trim();		
//		String Othercountry_Joint=row.getCell(getxlcolumn.get("Other Country of Tax Residence_Joint")).getStringCellValue().trim();
//		String selectOthercountryTIN_Joint=row.getCell(getxlcolumn.get("Do you have Other country TIN_Joint")).getStringCellValue().trim();
//		String OthercountryTIN_Joint=row.getCell(getxlcolumn.get("Other country TIN_Joint")).getStringCellValue().trim();
//		String reason_Joint=row.getCell(getxlcolumn.get("Other country reason_Joint")).getStringCellValue().trim();	
//		String explain_Joint=row.getCell(getxlcolumn.get("Other Country Explaination_Joint")).getStringCellValue().trim();	
//		String deletecountry_Joint=row.getCell(getxlcolumn.get("Delete Another country_Joint")).getStringCellValue().trim();

		String Joint_Voice=row.getCell(20).getStringCellValue().trim();		
		String Joint_SMS=row.getCell(21).getStringCellValue().trim();				
		String Joint_Citizan=row.getCell(22).getStringCellValue().trim();
		String Yes_Joint_USResident=row.getCell(23).getStringCellValue().trim();				
		String Yes_Joint_USCitizen=row.getCell(24).getStringCellValue().trim();	
		String Yes_Joint_USPermanent=row.getCell(25).getStringCellValue().trim();
		String Yes_Joint_TIN=row.getCell(26).getStringCellValue().trim();		
		String JointCountryTax=row.getCell(27).getStringCellValue().trim();
		String CRS_Joint_TIN=row.getCell(28).getStringCellValue().trim();
		String Joint_TIN=row.getCell(29).getStringCellValue().trim();		
		String Joint_reason=row.getCell(30).getStringCellValue().trim();		
		String Joint_Explanation=row.getCell(31).getStringCellValue().trim();
		String Add_country_Joint=row.getCell(32).getStringCellValue().trim();		
		String Othercountry_Joint=row.getCell(33).getStringCellValue().trim();
		String selectOthercountryTIN_Joint=row.getCell(34).getStringCellValue().trim();
		String OthercountryTIN_Joint=row.getCell(35).getStringCellValue().trim();
		String reason_Joint=row.getCell(36).getStringCellValue().trim();	
		String explain_Joint=row.getCell(37).getStringCellValue().trim();	
		String deletecountry_Joint=row.getCell(38).getStringCellValue().trim();
		
		if(Joint_Voice.equals("check"))
			CommonMethords.selectcheckbox(voicecallJointApp,"check");
		else
			CommonMethords.selectcheckbox(voicecallJointApp,"uncheck");
		
		if(Joint_SMS.equals("check"))
			CommonMethords.selectcheckbox(smsmmsJointApp,"check");
		else
			CommonMethords.selectcheckbox(smsmmsJointApp,"uncheck");
		
		if(Joint_Citizan.equals("Yes")) {
			YesGreenCardHolderJointApp.click();
			if(Yes_Joint_USResident.equals("Yes"))
				CommonMethords.selectcheckbox(USresidentJointApp,"check");
			else
				CommonMethords.selectcheckbox(USresidentJointApp,"uncheck");
			
			if(Yes_Joint_USCitizen.equals("Yes"))
				CommonMethords.selectcheckbox(USCitizenJointApp,"check");
			else
				CommonMethords.selectcheckbox(USCitizenJointApp,"uncheck");
			
			if(Yes_Joint_USPermanent.equals("Yes"))
				CommonMethords.selectcheckbox(USprJointApp,"check");
			else
				CommonMethords.selectcheckbox(USprJointApp,"uncheck");
			
			TINJointApp.sendKeys(Yes_Joint_TIN);
		}	
		else
			NoGreenCardHolderJointApp.click();
		
		CommonMethords.SelectDropdown(CountryJointApp,JointCountryTax);
		
		if(CRS_Joint_TIN.equals("Yes")) {
			YesTINJointApp.click();
			CRSTINJointApp.sendKeys(OthercountryTIN_Joint);
		}else {
			NoTINJointApp.click();
			CommonMethords.SelectDropdownPartialtext(reasonJointApp,Joint_reason);
			if(explainationJointApp.size()>0) {
				explainationJointApp.get(0).sendKeys(Joint_Explanation);
			}
		}
		
		if(Add_country_Joint.equals("Yes")) {
			addcountryJointApp.click();
			CommonMethords.SelectDropdown(addCountryJointApp,Othercountry_Joint);
			if(selectOthercountryTIN_Joint.equals("Yes")) {
				addYesTINJointApp.click();
				addCRSTINJointApp.sendKeys(Joint_TIN);
			}else {
				addNoTINJointApp.click();
				CommonMethords.SelectDropdownPartialtext(addreasonJointApp,reason_Joint);
				if(addexplainationJointApp.size()>0) {
					addexplainationJointApp.get(0).sendKeys(explain_Joint);
				}
			}
		}
		
		if(deletecountry_Joint.equals("Yes")) {
			if(delcountryJointApp.isDisplayed()) {
				delcountryJointApp.click();
			}
		}
	}
	
	
	public void SupplementaryAppldeclaration(Row row) {
//		String Supplementary_Voice=row.getCell(getxlcolumn.get("Supplementary_Voice Call_Phone Call")).getStringCellValue().trim();		
//		String Supplementary_SMS=row.getCell(getxlcolumn.get("Supplementary_SMS_MMS")).getStringCellValue().trim();				
//		String Supplementary_Citizan=row.getCell(getxlcolumn.get("Supplementary_Citizan of the United States")).getStringCellValue().trim();
//		String Yes_Supplementary_USResident=row.getCell(getxlcolumn.get("FATCA - Yes_Supplementary_USResident")).getStringCellValue().trim();				
//		String Yes_Supplementary_USCitizen=row.getCell(getxlcolumn.get("FATCA - Yes_Supplementary_USCitizen")).getStringCellValue().trim();	
//		String Yes_Supplementary_USPermanent=row.getCell(getxlcolumn.get("FATCA - Yes_Supplementary_USPermanent")).getStringCellValue().trim();
//		String Yes_Supplementary_TIN=row.getCell(getxlcolumn.get("FATCA - Yes_Supplementary_TIN")).getStringCellValue().trim();		
//		String SupplementaryCountryTax=row.getCell(getxlcolumn.get("Supplementary Country of Tax Residence")).getStringCellValue().trim();
//		String CRS_Supplementary_TIN=row.getCell(getxlcolumn.get("Do you have tax identification number_Supplementary")).getStringCellValue().trim();
//		String Supplementary_TIN=row.getCell(getxlcolumn.get("Supplementary_TIN")).getStringCellValue().trim();		
//		String Supplementary_reason=row.getCell(getxlcolumn.get("Supplementary state reason")).getStringCellValue().trim();		
//		String Supplementary_Explanation=row.getCell(getxlcolumn.get("Supplementary_Explanation")).getStringCellValue().trim();
//		String Add_country_Supplementary=row.getCell(getxlcolumn.get("Add Another country_Supplementary")).getStringCellValue().trim();		
//		String Othercountry_Supplementary=row.getCell(getxlcolumn.get("Other Country of Tax Residence_Supplementary")).getStringCellValue().trim();
//		String selectOthercountryTIN_Supplementary=row.getCell(getxlcolumn.get("Do you have Other country TIN_Supplementary")).getStringCellValue().trim();
//		String OthercountryTIN_Supplementary=row.getCell(getxlcolumn.get("Other country TIN_Supplementary")).getStringCellValue().trim();
//		String reason_Supplementary=row.getCell(getxlcolumn.get("Other country reason_Supplementary")).getStringCellValue().trim();	
//		String explain_Supplementary=row.getCell(getxlcolumn.get("Other Country Explaination_Supplementary")).getStringCellValue().trim();	
//		String deletecountry_Supplementary=row.getCell(getxlcolumn.get("Delete Another country_Supplementary")).getStringCellValue().trim();

		
		String Supplementary_Voice=row.getCell(39).getStringCellValue().trim();		
		String Supplementary_SMS=row.getCell(40).getStringCellValue().trim();				
		String Supplementary_Citizan=row.getCell(41).getStringCellValue().trim();
		String Yes_Supplementary_USResident=row.getCell(42).getStringCellValue().trim();				
		String Yes_Supplementary_USCitizen=row.getCell(43).getStringCellValue().trim();	
		String Yes_Supplementary_USPermanent=row.getCell(44).getStringCellValue().trim();
		String Yes_Supplementary_TIN=row.getCell(45).getStringCellValue().trim();		
		String SupplementaryCountryTax=row.getCell(46).getStringCellValue().trim();
		String CRS_Supplementary_TIN=row.getCell(47).getStringCellValue().trim();
		String Supplementary_TIN=row.getCell(48).getStringCellValue().trim();		
		String Supplementary_reason=row.getCell(49).getStringCellValue().trim();		
		String Supplementary_Explanation=row.getCell(50).getStringCellValue().trim();
		String Add_country_Supplementary=row.getCell(51).getStringCellValue().trim();		
		String Othercountry_Supplementary=row.getCell(52).getStringCellValue().trim();
		String selectOthercountryTIN_Supplementary=row.getCell(53).getStringCellValue().trim();
		String OthercountryTIN_Supplementary=row.getCell(54).getStringCellValue().trim();
		String reason_Supplementary=row.getCell(55).getStringCellValue().trim();	
		String explain_Supplementary=row.getCell(56).getStringCellValue().trim();	
		String deletecountry_Supplementary=row.getCell(57).getStringCellValue().trim();
		if(Supplementary_Voice.equals("check"))
			CommonMethords.selectcheckbox(voicecallSuppApp,"check");
		else
			CommonMethords.selectcheckbox(voicecallSuppApp,"uncheck");
		
		if(Supplementary_SMS.equals("check"))
			CommonMethords.selectcheckbox(smsmmsSuppApp,"check");
		else
			CommonMethords.selectcheckbox(smsmmsSuppApp,"uncheck");
		
		if(Supplementary_Citizan.equals("Yes")) {
			YesGreenCardHolderSuppApp.click();
			if(Yes_Supplementary_USResident.equals("Yes"))
				CommonMethords.selectcheckbox(USresidentSuppApp,"check");
			else
				CommonMethords.selectcheckbox(USresidentSuppApp,"uncheck");
			
			if(Yes_Supplementary_USCitizen.equals("Yes"))
				CommonMethords.selectcheckbox(USCitizenSuppApp,"check");
			else
				CommonMethords.selectcheckbox(USCitizenSuppApp,"uncheck");
			
			if(Yes_Supplementary_USPermanent.equals("Yes"))
				CommonMethords.selectcheckbox(USprSuppApp,"check");
			else
				CommonMethords.selectcheckbox(USprSuppApp,"uncheck");
			
			TINSuppApp.sendKeys(Yes_Supplementary_TIN);
		}	
		else
			NoGreenCardHolderSuppApp.click();
		
		CommonMethords.SelectDropdown(CountrySuppApp,SupplementaryCountryTax);
		
		if(CRS_Supplementary_TIN.equals("Yes")) {
			YesTINSuppApp.click();
			CRSTINSuppApp.sendKeys(OthercountryTIN_Supplementary);
		}else {
			NoTINSuppApp.click();
			CommonMethords.SelectDropdownPartialtext(reasonSuppApp,Supplementary_reason);
			if(explainationSuppApp.size()>0) {
				explainationSuppApp.get(0).sendKeys(Supplementary_Explanation);
			}
		}
		
		if(Add_country_Supplementary.equals("Yes")) {
			addcountrySuppApp.click();
			CommonMethords.SelectDropdown(addCountrySuppApp,Othercountry_Supplementary);
			if(selectOthercountryTIN_Supplementary.equals("Yes")) {
				addYesTINSuppApp.click();
				addCRSTINSuppApp.sendKeys(Supplementary_TIN);
			}else {
				addNoTINSuppApp.click();
				CommonMethords.SelectDropdownPartialtext(addreasonSuppApp,reason_Supplementary);
				if(addexplainationSuppApp.size()>0) {
					addexplainationSuppApp.get(0).sendKeys(explain_Supplementary);
				}
			}
		}
		
		if(deletecountry_Supplementary.equals("Yes")) {
			if(delcountrySuppApp.isDisplayed()) {
				delcountrySuppApp.click();
			}
		}
	}
	
	
	public void performYourdeclaration(Sheet sheet, String primarykey) throws Exception {
		filehandlingfeatures loadfiles=new filehandlingfeatures();
		getxlcolumn=loadfiles.getexcelcolnumber(sheet,1);
		PageFactory.initElements(driver, this);

		for(int rw=1;rw<=sheet.getLastRowNum();rw++) {
			if(sheet.getRow(rw).getCell(getxlcolumn.get("Primary_Key")).getStringCellValue().trim().equals(primarykey)) {
				if(isPrincApp.size()>0 && CommonMethords.findelementsvisible(isPrincApp)) {
					PrincipleAppldeclaration(sheet.getRow(rw));
				}
				if(isJointApp.size()>0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isJointApp)) {
					JointAppldeclaration(sheet.getRow(rw));
				}
				if(isSuppApp.size()>0 && CommonMethords.findelementsvisible(SG_CASA_UI_Decleration.isSuppApp)) {
					SupplementaryAppldeclaration(sheet.getRow(rw));
				}
			}
		}
	}	
	

}
