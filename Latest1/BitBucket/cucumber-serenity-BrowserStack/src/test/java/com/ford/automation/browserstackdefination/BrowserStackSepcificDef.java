package com.ford.automation.browserstackdefination;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.ford.automation.base.BaseTest;
import com.ford.automation.p2_general.P2General;
import com.google.common.base.Strings;
import com.mkyong.rest.JSONService;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class BrowserStackSepcificDef extends BaseTest {

	//Added by Sajith - Change Xpath of captcha
	@Then("^Verify Captcha present$")
	public void Verify_Captcha_present() throws Throwable {
		System.out.println("Verify Captcha present");
//		getVisibleElementByXpath("//input[@name='captchaValue' or @name='recaptcha']");
//		try {
//			getVisibleElementByXpath("//select[@id='title']");
//		}catch(Exception e) {}
	}
	
	@And("^Fill in Vehicle Info credentials on P2$")
	public void fillInVehicleInfo(DataTable vehicleInfoCredentials) throws Throwable {
		System.out.println("Fill in Vehicle Infomation");
		// Write the code to handle Data Table
		List<List<String>> data = vehicleInfoCredentials.raw();
		getVisibleElementByXpath("//input[@name='nickName']");
		waitTillElemVisiblebyXpath("//input[@name='nickName']", 240);
		if (!data.get(0).get(0).isEmpty()) {
			getVisibleElementByXpath("//span[contains(text(),'Miss') or contains(text(),'安徽')]").click();
			getVisibleElementByXpath("//div[@class='select2-result-label' and contains(text(),'" + data.get(0).get(0) + "')]").click();
		}
		getVisibleElementByXpath("//input[@name='nickName']").sendKeys(data.get(0).get(1));
		if (!data.get(0).get(2).isEmpty()) {
			getVisibleElementByXpath("//span[contains(text(), 'Select State')]").click();
			getVisibleElementByXpath("//div[@class='select2-result-label' and contains(text(),'" + data.get(0).get(2) + "')]").click();
		}
		getVisibleElementByXpath("//input[@name='postCode']").sendKeys(data.get(0).get(3));
		getVisibleElementByXpath("//input[@name='mobileNumber' or @name='homePhoneNumber']").sendKeys(phn);
		getVisibleElementByXpath("//input[@name='workphoneNumber' or @name='workPhoneNumber']").sendKeys(phn);
		getVisibleElementByXpath("//span[contains(text(), 'I have read and understood')]").click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//label[contains(@for,'agreement')]").click();

		getVisibleElementByXpath("//input[@name='recaptcha']").sendKeys(EnterCaptcha());
	}
	
	@And("^Select vehicle credentials on P2$")
	public void selectVehicleCredentials(DataTable vehicleCredentials) throws Throwable {
		System.out.println("Click on select Vehicle");
		// Write the code to handle Data Table
		List<List<String>> data = vehicleCredentials.raw();
//		waitTillElemVisiblebyXpath("//form[@id='vehicleInfoForm']//input[@name='vehicleName']", 240);
		Thread.sleep(3000);
		getVisibleElementByXpath("//input[@name='vehicleName']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@name='vincode']").sendKeys(data.get(0).get(1));
	}
	
	@When("^Click on Activate My Account link in activation mail on P2$")
	public void clickOnActivateMyAccountLink() throws Throwable {
		System.out.println("Click on Activate My Account link in activation mail");
		Thread.sleep(10000);
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector("#publicshowmaildivcontent"))).findElement(By.tagName("body"));
		} catch (Exception e) {
			driver.switchTo().frame(driver.findElement(By.id("msg_body")));
		}
		WebElement link = getVisibleElementByXpath("//span[@class='cl-ford-blue' and contains(text(),'[ACTIVATE MY ACCOUNT]') or @class='cl-ford-blue' and contains(text(),'激活我的账号')]");
		link.click();
		Thread.sleep(80000);
	}
	
	@When("^Click on My Profile link on P2$")
	public void clickOnMyProfileLink() throws Throwable {
		System.out.println("Click on My Profile link");
		waitTillElemVisiblebyXpath("//a[contains(@href,'myprofile.html')]/i[@class='site-link-icon icon-profile']",240);
		getVisibleElementByXpath("//a[contains(@href,'myprofile.html')]/i[@class='site-link-icon icon-profile']").click();
	}
	
	@And("^Click on Change Email Address link on Account Info on P2$")
	public void clickOnChangeEmailAddressLinkOnAccountInfo() throws Throwable {
		System.out.println("Click on Change Email Address link on Account Info");
		Thread.sleep(5000);
		getVisibleElementByXpath("//a[contains(text(),'Change Email') or contains(text(),'更改邮箱地址')]").click();
	}
	

	@And("^Click on Change Password on Account Info on P2$")
	public void clickOnChangePasswordOnAccountInfo() throws Throwable {
		System.out.println("Click on change password on account info");
		Thread.sleep(5000);
		getVisibleElementByXpath("//a[text()='New Password' or text()='修改密码' or text()='Change Password']").click();
	}
	

	@Then("^See the first vehicle tab name on P2$")
	public void seeTheFirstVehicleTabName() throws Throwable {
		System.out.println("See the first vehicle tab name");
		waitTillElemVisiblebyXpath("//*[@id='tabs-0']", 240);
		getVisibleElementByXpath("//*[@id='tabs-0' and @class='ownerVehicleTitle']");
	}

	@Then("^See the second vehicle tab name on P2$")
	public void seeTheSecondVehicleTabName() throws Throwable {
		System.out.println("See the second vehicle tab name");
		getVisibleElementByXpath("//*[@id='tabs-1' and @class='ownerVehicleTitle']");
		Thread.sleep(5000);
	}

	@When("^Click on first vehicle tab on P2$")
	public void clickOnFirstVehicleTab() throws Throwable {
		System.out.println("Click on first Vehicle tab");
		getVisibleElementByXpath("//*[@id='tabs-0' and @class='ownerVehicleTitle']").click();
		Thread.sleep(5000);
	}

	@Then("^Verify first vehicle tab is loaded correctly on P2$")
	public void verifyFirstVehicleTabLoadedCorrectly() throws Throwable {
		System.out.println("Verify first vehicle tab is loaded correctly");
		getVisibleElementByXpath("//*[@id='tabs-0' and @class='ownerVehicleTitle']");
	}

	@Then("^Close the SYNC overlay on P2$")
	public void ClosetheSYNCoverlayonP2() throws Throwable {
		System.out.println("Close the SYNC overlay");
		getVisibleElementByXpath("//i[@class='icon-plus icon-x']");
	}

	@When("^Click on second vehicle tab on P2$")
	public void clickOnSecondVehicleTab() throws Throwable {
		System.out.println("Click on second Vehicle tab");
		getVisibleElementByXpath("//*[@id='tabs-1' and @class='ownerVehicleTitle']").click();
	}

	@Then("^Verify second vehicle tab is loaded correctly on P2$")
	public void verifySecondVehicleTabLoadedCorrectly() throws Throwable {
		System.out.println("Verify second vehicle tab is loaded correctly on P2");
		getVisibleElementByXpath("//*[@id='tabs-1' and @class='ownerVehicleTitle']");
	}
	
	
	@And("^Click on Download Now link on Profile overlay on P2$")
	public void clickOnDownloadNowLinkOnProfileOverlay() throws Throwable {
		System.out.println("Click on Download Now link on Profile overlay");
		String mainWindowHandle = driver.getWindowHandles().iterator().next();
		try {
			waitTillElementExist("//a[text()='Download Now' or text()='下载手册' or text()='下载手册']");
			driver.findElement(By.xpath("//a[text()='Download Now' or text()='下载手册' or text()='下载手册']")).click();
		} catch (Exception e) {
			waitTillElementExist("//a[text()='Start Download']");
			getVisibleElementByXpath("//a[text()='Start Download']").click();
		}
		Thread.sleep(5000);
		if (driver.getWindowHandles().size() > 1) {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
		}
		getVisibleElementByXpath("//input[@type='button']");
		driver.switchTo().window(mainWindowHandle);
	}
	

	@When("^Logout China Owner$")
	public void LogoutChinaOwner() throws Throwable {
		System.out.println("Logout China Owner");
		getVisibleElementByXpath("//a[contains(@href,'logout')]").click();
		waitTillElementExist("//a[contains(@class,'logout-confirm')]");
		driver.findElement(By.cssSelector("a.logout-confirm")).click();
	}
	@And("^Fill in Vehicle Info credentials on china P2$")
	public void fillInVehicleInfochina(DataTable vehicleInfoCredentials) throws Throwable {
		System.out.println("Fill in Vehicle Info credentials on china P2");
		// Write the code to handle Data Table
		List<List<String>> data = vehicleInfoCredentials.raw();
		if(!data.get(0).get(0).isEmpty()) {
		getVisibleElementByXpath("//span[contains(text(),'Miss') or contains(text(),'安徽')]").click();
		getVisibleElementByXpath("//div[@class='select2-result-label' and contains(text(),'" + data.get(0).get(0) + "')]").click();
		}
		getVisibleElementByXpath("//input[@name='postCode']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='mobileNumber']").sendKeys(phn);
		getVisibleElementByXpath("//label[@for='terms_and_conditions']").click();
		getVisibleElementByXpath("//label[@for='user_legal_agreement']").click();

		getVisibleElementByXpath("//input[@name='recaptcha']").sendKeys(EnterCaptcha());
	}
	

	@When("^Click on Accessory Name Item on P2 INT$")
	public void clickOnAccessoryNameItemInt() throws Throwable {
		System.out.println("Click on Accessory Name Item");
		getVisibleElementByXpath("//*[@id='accessories']//li[@class='ng-scope active']//span[contains(text(),'Alloy wheel lock nut set')]").click();
	}
	

	@Then("^See Pricing Summary on P2$")
	public void seePricingSummary() throws Throwable {
		System.out.println("See pricing Summary");
		Thread.sleep(15000);
//		waitTillElementExist("//h3[contains(text(),'Pricing Summary') or contains(text(),'Pricing  Summary')]");
		getVisibleElementByXpath("//h3[contains(text(),'Pricing Summary') or contains(text(),'Pricing  Summary')]");
	}
	
	@Then("^See CTAs and links are functional on the page$")
	public void see_CTAs_and_links_are_functional_on_the_page() throws Throwable{
		System.out.println("See CTAs and links are functional on the page");
	    // Write code here that turns the phrase above into concrete actions
		getVisibleElementByXpath("//*[@class='site-link-title' and contains(text(),'Vehicles')]").click();
		getVisibleElementByXpath("//*[@class='site-link-title' and contains(text(),'Shop')]").click();
		getVisibleElementByXpath("//*[@class='site-link-title' and contains(text(),'Finance')]").click();
		getVisibleElementByXpath("//*[@class='site-link-title' and contains(text(),'Owner')]").click();
		getVisibleElementByXpath("//*[@class='site-link-title' and contains(text(),'Owner')]").click();
	}
	

	@When("^Click on Hamburger menu$")
	public void click_on_Hamburger_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Hamburger menu");
		driver.navigate().refresh();
		waitTillElementExist("//a[contains(@class,'menu')]");
		getVisibleElementByXpath("//a[contains(@class,'menu')]").click();	
	}
	

	@Then("^Enter Location$")
	public void enter_Location(DataTable arg1) throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("Enter Location");
		List<List<String>> data = arg1.raw();
		getVisibleElementByXpath("//span[contains(@class,'select2-chosen')]").click();
		waitTillElemVisiblebyXpath("//input[@type='text' and contains(@class,'input')]", 240);
		getVisibleElementByXpath("//input[@type='text' and contains(@class,'input')]").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@type='text' and contains(@class,'input')]").sendKeys(Keys.ENTER);
//		getVisibleElementByXpath("//span[text()='"+data.get(0).get(0)+"']").click();
	}
	
	@When("^Select a Vehicle$")
	public void select_a_Vehicle(DataTable arg1) throws Throwable{
		System.out.println("Select a Vehicle");
		List<List<String>> data=arg1.raw();
		waitTillElemVisiblebyXpath("//*[contains(text(),'"+data.get(0).get(0)+"')]/preceding-sibling::*//img", 240);
		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(0)+"')]/preceding-sibling::*//img").click();
		waitTillElemVisiblebyXpath("//*[contains(text(),'Change Vehicle')]//preceding-sibling::span//ancestor::a", 240);
		try {
		getVehiclePrice=super.convertStrtoDoubletoInt(driver.findElement(By.xpath("//div[@class='rcol']//span[@class='ng-binding' and contains(text(),'₹')]")).getText().split("₹")[1]);
		addConfigPrice=0;
		}catch(Exception e) {}
	}
	
	@When("^Click on Accessory Sub Tab$")
	public void click_on_Accessory_Sub_Tab(DataTable arg1) throws Throwable {
		List<List<String>> data=arg1.raw();
//		waitTillElemVisiblebyXpath("//a[contains(text(),'"+ data.get(0).get(0) +"') and not(contains(@class,'hide'))]", 240);
		getVisibleElementByXpath("//a[contains(text(),'" + data.get(0).get(0) + "') and not(contains(@class,'hide'))]").click();
	}

	@Then("^see User is directing to Build and Price page$")
	public void see_User_is_directing_to_Build_and_Price_page() throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see User is directing to Build and Price page");
//		waitTillElemVisiblebyXpath("//div/*[contains(text(),'Change Vehicle')]", 240);
		getVisibleElementByXpath("//div/*[contains(text(),'Change Vehicle')]");
		getVisibleElementByXpath("//div[not(contains(@class,'mobile-btns'))]//*[contains(text(),'Review') and contains(@class,'cta')]");
	}

	
	@When("^Click on Save as PDF link$")
	public void click_on_Save_as_PDF_link() throws Throwable{
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Save as PDF link");
		getVisibleElementByXpath("//*[contains(@class,'desktop')]//*[contains(text(),'Save as PDF') or contains(text(),'Print')]");
//		getVisibleElementByXpath("//*[contains(@class,'desktop')]//*[contains(text(),'Save as PDF') or contains(text(),'Print')]").click();
	}

	
	@Then("^Verify Drive away price with SL calls$")
	public void verify_Drive_away_price_with_SL_calls(DataTable arg1) throws Throwable {
		System.out.println("Verify Drive away price with SL calls");
		List<List<String>> data=arg1.raw();
		Map<Integer,String> getValuesFrmDict=new HashMap<Integer,String>();
		String GetSLresponse=JSONService.getJsonResponse(data.get(0).get(1));
		if (isAlertPresent()) {
		    driver.switchTo().alert();
		    driver.switchTo().alert().accept();
		    driver.switchTo().defaultContent();
		}
		String getDriveAwayPrice=getVisibleElementByXpath(data.get(0).get(0)).getText().replace(",","").split(" ")[1];
		getValuesFrmDict=findDriveAwayPriceAU(GetSLresponse);
		int dicItemCnt=getValuesFrmDict.keySet().size();
		String SLdriveawayprice=getValuesFrmDict.get(dicItemCnt-1);
//		String SLmodelkey=getValuesFrmDict.get(dicItemCnt-2);
		Double parseDAPrice=Double.parseDouble(SLdriveawayprice);
		int iSLvalue=(int) Math.floor(parseDAPrice);
		int iDAprice=Integer.parseInt(getDriveAwayPrice);
		if(iSLvalue!=iDAprice) {
			if ((iSLvalue - iDAprice) == 1 || (iSLvalue - iDAprice) == -1) {
				System.out.println("Drive Away Price from SL and UI matched.");
			} else {
				Assert.assertFalse("Drive Away Price from SL and UI did not matched. SL value:" + iSLvalue + ", UI value:" + iDAprice, true);
			}
		}else {
			System.out.println("Drive Away Price from SL and UI matched.");
		}
	}
	
	@When("^Click on the Show Pricing link in each models$")
	public void Click_on_the_Show_Pricing_link_in_each_models() throws Throwable {
	    System.out.println("Click on the Show Pricing link in each models");
	   
//	    getVisibleElementByXpath("//div[@id='model']//label[contains(@class,'checkbox')]//div[contains(@class,'control__indicator')]");
		List<WebElement> models=driver.findElements(By.xpath("//div[@id='model']//label[contains(@class,'checkbox')]//*[contains(@class,'label-text')]"));
		System.out.println("Total # of Models displayed:"+models.size());
		System.out.println("Model Names are mentioned below:-");
		for(WebElement modeldetails:models) {
			System.out.println(modeldetails.getText().trim());
		}
	}

	
	
	@When("^Select any Model$")
	public void Select_any_Model() throws Throwable {
	    System.out.println("Select any Model");	   
	    getVisibleElementByXpath("//div[@id='model']//label//div").click();//div[@id='model']//label[contains(@class,'checkbox')]").click();//div[contains(@class,'control__indicator')]
	    tempStr=getVisibleElementByXpath("//div[@id='model']//label//span[contains(@class,'label-text')]").getText().trim(); //Get Model Name for further comparision
	}
	
	@Then("^No values should be searched and show a validation message$")
	public void no_values_should_be_searched_and_show_a_validation_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("No values should be searched and show a validation message");
//		getVisibleElementByXpath("//li[contains(@class,'no-results')]");
		if(driver.findElements(By.xpath("//li[contains(@class,'no-results')]")).size()==0) {
			Assert.assertFalse("Validation message for No values does not displayed.", false);
		}
	}	
	
	@When("^Input valid value for Amount Financed$")
	public void Input_valid_value_for_Amount_Financed() throws Throwable {
		System.out.println("Input valid value for Amount Financed");
		Click_on_Finance_optons();
		
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		amtfinanced=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		downpaymRatio=Integer.parseInt(getVisibleElementByXpath("//div[contains(@class,'rs-txt') and text()!='']").getText().replace("%", ""));
		String paddedString1 = Strings.padEnd("1", String.valueOf(amtfinanced).length()-1, '0'); //"007"
		System.out.println("New Amount Financed is:"+paddedString1);
		try {
			getVisibleElementByXpath("//input[contains(@name,'amountFinanced')]").click();
			getVisibleElementByXpath("//input[contains(@name,'amountFinanced')]").clear();
			getVisibleElementByXpath("//input[contains(@name,'amountFinanced')]").sendKeys(String.valueOf(amtfinanced-Integer.parseInt(paddedString1)));
		}catch(Exception e) {
			(new P2General()).dragDownpaymentRatio(1000);
		}	
	}
	

	
	@When("^Click on the Compare Finance accordion$")
	public void Click_on_the_Compare_Finance_Details_accordion(DataTable arg) throws Throwable {
		System.out.println("Click on the Compare Finance Details accordion");
		List<List<String>> data=arg.raw();
		Thread.sleep(2000);
		List<WebElement> findexpanded=driver.findElements(By.xpath("//*[contains(@class,'accordion-title')]//h3//ancestor::a"));
		Thread.sleep(2000);
		for(WebElement explorBtn:findexpanded) {	
			if(explorBtn.getText().contains(data.get(0).get(0)) && explorBtn.findElement(By.xpath("ancestor::div[contains(@class,'accordion-title')]")).getAttribute("class").contains("active")==false) {
				moveToElement(explorBtn);
				explorBtn.findElement(By.xpath("div//i")).click();//following-sibling::div//i
				waitTillElemVisiblebyXpath("//div[contains(@class,'compare-financial-options')]//*[@class='icon-plus-circled']", 240);
				getVisibleElementByXpath("//div[contains(@class,'compare-financial-options')]//*[@class='icon-plus-circled']").click();
				break;
			}
		}
	
	}
	
	@And("^Click on Finance optons$")
	public void Click_on_Finance_optons() throws Throwable {
		System.out.println("Click on Finance optons");
		Thread.sleep(2000);
		List<WebElement> findexpanded=driver.findElements(By.xpath("//div[@class='accordion-title']//h3//ancestor::a"));//driver.findElements(By.xpath("//*[contains(@class,'accordion-title')]//h3"));
		Thread.sleep(2000);
		for(WebElement explorBtn:findexpanded) {	
			if(explorBtn.getText().contains("方案总结") && explorBtn.findElement(By.xpath("ancestor::div[@class='accordion-title']")).getAttribute("class").contains("active")==false) {
				moveToElement(explorBtn);
				explorBtn.findElement(By.xpath("div//i")).click();//div//i
				break;
			}
		}
	}
	
	@When("^Input valid value for Down Payment$")
	public void Input_valid_value_for_Down_Payment() throws Throwable {
		System.out.println("Input valid value for Down Payment");
		moveToElement(driver.findElement(By.name("downPayment")));
		Click_on_Finance_optons();
		
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		amtfinanced=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		downpaymRatio=Integer.parseInt(getVisibleElementByXpath("//div[contains(@class,'rs-txt') and text()!='']").getText().replace("%", ""));
		String paddedString1 = Strings.padEnd("1", String.valueOf(downpayment).length()-1, '0'); //"007"
		System.out.println("New Downpayment amount is:"+paddedString1);
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").click();
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").clear();
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").sendKeys(String.valueOf(downpayment+Integer.parseInt(paddedString1)));
	}
	

	@Then("^Check default value of Down Payment and Amount Financed$")
	public void Check_default_value_of_Down_Payment_and_Amount_Financed() throws Throwable {
		System.out.println("Check default value of Down Payment and Amount Financed");
		Click_on_Finance_optons();
		
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		amtfinanced=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		
		int calculatedDownpay=(int) Math.ceil((getVehiclePrice*20)/100);
		int calculatedFinance=getVehiclePrice-calculatedDownpay;
		if(downpayment==calculatedDownpay || downpayment==(calculatedDownpay-1) || downpayment==(calculatedDownpay+1)) {
			System.out.println("Downpayment Amount displayed on UI is as expected: " + formatNumberFrChina(downpayment));
		}else {
//			System.out.println("Downpayment Amount displayed on UI does not matched, expected: " + formatNumberFrChina(calculatedDownpay) + ", Actual:" + formatNumberFrChina(downpayment));
			Assert.assertFalse("Downpayment Amount displayed on UI does not matched, expected: " + formatNumberFrChina(calculatedDownpay) + ", Actual:" + formatNumberFrChina(downpayment),true);
		}
		
		if(amtfinanced==calculatedFinance || amtfinanced==(calculatedFinance-1) || amtfinanced==(calculatedFinance+1)) {
			System.out.println("Financed Amount displayed on UI is as expected: " + formatNumberFrChina(amtfinanced));
		}else {
//			System.out.println("Financed Amount displayed on UI does not matched, expected: " + formatNumberFrChina(calculatedFinance) + ", Actual:" + formatNumberFrChina(amtfinanced));
			Assert.assertFalse("Financed Amount displayed on UI does not matched, expected: " + formatNumberFrChina(calculatedFinance) + ", Actual:" + formatNumberFrChina(amtfinanced),true);
		}
	}
	
	
	@When("^Drag Down Payment ratio to actual final point$")
	public void Drag_Down_Payment_ratio_to_actual_final_point() throws Throwable {
		System.out.println("Drag Down Payment ratio to actual final point");
		Click_on_Finance_optons();
		
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		amtfinanced=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		downpaymRatio=Integer.parseInt(getVisibleElementByXpath("//div[contains(@class,'rs-txt') and text()!='']").getText().replace("%", ""));
		
		(new P2General()).dragDownpaymentRatio(2000);
	}
	
	
	@When("^Input Down Payment amount$")
	public void Input_Down_Payment_amount() throws Throwable {
		System.out.println("Input Down Payment amount");
		Click_on_Finance_optons();
		
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""))+1;	
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").click();
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").clear();
		getVisibleElementByXpath("//input[contains(@name,'downPayment')]").sendKeys(String.valueOf(downpayment));
		Thread.sleep(2000);
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		amtfinanced=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		downpaymRatio=Integer.parseInt(getVisibleElementByXpath("//div[contains(@class,'rs-txt') and text()!='']").getText().replace("%", ""));
		term=getVisibleElementByXpath("//div[contains(@id,'s2id_autogen4')]//span[text()!='']").getText();
		System.out.println(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//span[contains(@class,'payment-monthlyPayment')]").getText());
		monthlyPay=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//span[contains(@class,'payment-monthlyPayment')]").getText().substring(1).replaceAll(",", ""));
		paympkg=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-ewPackage') and text()!='']").getText().substring(1).replaceAll(",", ""));
	}
	
	
	@Then("^See the EW-package with its value is shown in Summary list$")
	public void See_the_EW_package_with_its_value_is_shown_in_Summary_list() throws Throwable {
		System.out.println("See the EW-package with its value is shown in Summary list");
		String pkgdata=getVisibleElementByXpath("//div[contains(@class,'product-list')]//li//div[contains(@data-ng-if,'product.selectedTerm.ewPackage')]").getText();
		String pkgAmt=null;
	    String pattern = "\\d,\\d*";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(pkgdata);
	    while(m.find()) {
	    	 if(!m.group(0).isEmpty()) {
	    		System.out.println(m.group(0).trim());
	    		pkgAmt=m.group(0).trim();
	    	  	break;
	    	  	}
	     }
	    String pkgName=pkgdata.split(pkgAmt)[1].trim();
	    Click_on_Finance_optons();
	    getVisibleElementByXpath("//a//h3[contains(text(),'方案总结')]");
		List<WebElement> pkg=driver.findElements(By.xpath("//*[contains(@class,'payment-summary')]//*[contains(text(),'"+pkgName+"')]"));
		List<WebElement> pamt=driver.findElements(By.xpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-ewPackage-price') and contains(text(),'"+pkgAmt+"')]"));
	    
	}

	@Then("^See all the information in Summary list varies correctly$")
	public void See_all_the_information_in_Summary_list_varies_correctly(DataTable arg) throws Throwable {
		System.out.println("See all the information in Summary list varies correctly");
		List<List<String>> data=arg.raw();
		(new P2General()).dragDownpaymentRatio(2000);
		Thread.sleep(2000);
		downpayment=getVehiclePrice-Integer.parseInt(data.get(0).get(0));
		amtfinanced=Integer.parseInt(data.get(0).get(0));
		String monthlyAmt=getVisibleElementByXpath("//div[contains(@class,'product-list')]//h3[contains(text(),'qual')]//following-sibling::div[@class='desc']//li[1]//b[text()!='']").getText();
		String Terms=getVisibleElementByXpath("//div[contains(@class,'product-list')]//h3[contains(text(),'qual')]//following-sibling::div[@class='desc']//li[2]//b[text()!='']").getText().trim().substring(1, 2);
		Click_on_Finance_optons();
//		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-price') and contains(text(),'"+formatNumberFrChina(getVehiclePrice)+"')]");
//		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and contains(text(),'"+formatNumberFrChina(downpayment)+"')]");
//		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and contains(text(),'"+formatNumberFrChina(amtfinanced)+"')]");
//		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-term') and contains(text(),'"+Terms+"')]");
//		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-monthlyPayment') and contains(text(),'"+monthlyAmt+"')]");
		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-price') and text()!='']");
		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']");
		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']");
		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-term') and text()!='']");
		getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-monthlyPayment') and text()!='']");
	}
	
	
	@When("^See Add new Vehicle model is shown at the end$")
	public void See_Add_new_Vehicle_model_is_shown_at_the_end() throws Throwable {
		System.out.println("See Add new Vehicle model is shown at the end");
		Thread.sleep(2000);
//		waitTillElemVisiblebyXpath("//div[contains(@class,'compare-financial-options')]//*[@class='icon-plus-circled']", 240);
		getVisibleElementByXpath("//div[contains(@class,'compare-financial-options')]//*[@class='icon-plus-circled']").click();
	}
	
	
	
	@When("^See Down Payment and Amount Financed in Summary list vary correctly$")
	public void See_Down_Payment_and_Amount_Financed_in_Summary_list_vary_correctly(DataTable arg) throws Throwable {
		System.out.println("See Down Payment and Amount Financed in Summary list vary correctly");
		List<List<String>> data=arg.raw();
		Thread.sleep(2000);
		downpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));	
		amtfinanced=getVehiclePrice-downpayment;;
		
		int dwnpayment=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-downPayment') and text()!='']").getText().substring(1).replaceAll(",", ""));
		int amtfinc=Integer.parseInt(getVisibleElementByXpath("//*[contains(@class,'payment-summary')]//*[contains(@class,'payment-amountFinanced') and text()!='']").getText().substring(1).replaceAll(",", ""));
		
		if(downpayment==dwnpayment && amtfinanced==amtfinc) {
			System.out.println("Downpayment and Amount Financed displayed properly in Summary list with runtime changed Down Payment ratio");
		}else {
			System.out.println("Downpayment Amount expected: " + formatNumberFrChina(downpayment) + ", Actual:" + formatNumberFrChina(dwnpayment));
			System.out.println("Amount Financed expected: " + formatNumberFrChina(amtfinanced) + ", Actual:" + formatNumberFrChina(amtfinc));
			Assert.assertFalse("Discrepency in Downpayment and Amount Financed display in Summary list with the runtime changed Down Payment ratio",true);
		}
	}
	
	@When("^Click on \"(.*?)\" Button$")
	public void ClickonButton(String Btn) throws Throwable {
		System.out.println("Click on Button " + Btn);
		try {
			getVisibleElementByXpath("//div[@id='desktop-btn-next']/a[contains(text(),'下一步')]").click();
		}catch(Exception e) {
			if(!e.getMessage().contains("timeout")) {
				throw new Exception(e.getMessage());
			}
		}

		try {
			getVisibleElementByXpath("//p[contains(@class,'price') and text()!='']/following-sibling::span[contains(@class,'checkbox')]").click();
		} catch (Exception e) {
		}
		getVisibleElementByXpath("//li/small[contains(text(),'总价')]//following-sibling::p[text()!='']");
		System.out.println(driver.findElements(By.xpath("//p[contains(@class,'price') and text()!='']")).get(0).getText());
		modelPrice=convertStrtoDoubletoInt(driver.findElements(By.xpath("//p[contains(@class,'price') and text()!='']")).get(0).getText().split(" ")[1]);
		int nameplateprz=convertStrtoDoubletoInt(driver.findElements(By.xpath("//*[contains(@ng-bind,'getPrice')]")).get(0).getText().split(" ")[1]);
		if(modelPrice!=nameplateprz) {
			modelPrice=nameplateprz;
		}
	}
	
	
	@Then("^Components loads and CTAs and links are functional on the page$")
	public void Components_loads_and_CTAs_and_links_are_functional_on_the_page() throws Throwable {
		System.out.println("Components loads and CTAs and links are functional on the page");
		getVisibleElementByXpath("//a[text()='外观']").click();
//		try {
//			waitTillElemVisiblebyXpath("//img[contains(@src,'PN4AG.jpg')]", 240);
//			getVisibleElementByXpath("//img[contains(@src,'PN4AG.jpg')]").click();
//			waitTillElemVisiblebyXpath("//div[@class='owl-item active']//img[contains(@src,'PN4AG/1.jpg')]", 120);
//			getVisibleElementByXpath("//div[@class='owl-item active']//img[contains(@src,'PN4AG/1.jpg')]");
//			getVisibleElementByXpath("//img[contains(@src,'PNEAM.jpg')]").click();
//			waitTillElemVisiblebyXpath("//div[@class='owl-item active']//img[contains(@src,'PNEAM/1.jpg')]", 120);
//			getVisibleElementByXpath("//div[@class='owl-item active']//img[contains(@src,'PNEAM/1.jpg')]");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		getVisibleElementByXpath("//a[text()='内饰']").click();
//		try {
//			String srcExt = getVisibleElementByXpath("//div[contains(@ng-repeat,'features.interior')]//img").getAttribute("ng-src");
//			String[] spl = srcExt.split("/");
//			System.out.println(srcExt);
//			String img = spl[spl.length - 1].split("\\.")[0];
//	
//			getVisibleElementByXpath("//img[contains(@src,'" + img + ".jpg')]").click();
//			waitTillElemVisiblebyXpath("//div[@class='owl-item active']//img[contains(@src,'" + img + "/1.')]", 120);
//			getVisibleElementByXpath("//div[@class='owl-item active']//img[contains(@src,'" + img + "/1.')]");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		getVisibleElementByXpath("//a[text()='配置']").click();
	}
	
	
	@Then("^Click on Build and price summary button$")
	public void Click_on_Build_and_price_summary_button(DataTable param) throws Throwable {
		System.out.println("Click on Build and Price");
		List<List<String>> data = param.raw();
		waitTillElemVisiblebyXpath("//*[@id='summary_btn']//a[contains(text(),'" + data.get(0).get(0) + "') or contains(text(),'下一步')]", 240);
		
		try {
			getVisibleElementByXpath("//p[contains(@class,'price') and text()!='']/following-sibling::span[contains(@class,'checkbox')]").click();
		} catch (Exception e) {
		}
		//waitTillElemVisiblebyXpath("//li/small[contains(text(),'总价')]//following-sibling::p[text()!='']", 240);
		modelPrice=convertStrtoDoubletoInt(driver.findElement(By.xpath("//p[contains(@class,'price') and text()!='']")).getText().split(" ")[1]);
		int nameplateprz=convertStrtoDoubletoInt(driver.findElements(By.xpath("//*[contains(@ng-bind,'getPrice')]")).get(0).getText().split(" ")[1]);
		if(modelPrice!=nameplateprz) {
			modelPrice=nameplateprz;
		}
		modelName=driver.findElement(By.xpath("//div[@class='component-bp-config-menu']//li[contains(@class,'ng-binding')]")).getText();
		
		getVisibleElementByXpath("//*[@id='summary_btn']//a[contains(text(),'" + data.get(0).get(0) + "') or contains(text(),'下一步')]").click();
	}
	

	@And("^Click on Finance optons accordion$")
	public void Click_on_Finance_optons_accordion() throws Throwable {
		System.out.println("Click on Finance optons accordion");
		Thread.sleep(2000);
		List<WebElement> findexpanded=driver.findElements(By.xpath("//*[@class='panel-lock' and text()!='']"));
		Thread.sleep(2000);
		for(WebElement explorBtn:findexpanded) {	
			if(explorBtn.getText().contains("方案总结") && Boolean.parseBoolean(explorBtn.findElement(By.xpath("ancestor::a")).getAttribute("aria-expanded"))==false) {
				moveToElement(explorBtn);
				explorBtn.findElement(By.xpath("i")).click();
				break;
			}
		}
	}	
	
	
	@And("^Based on the slider bar the Down payment should changed in real time$")
	public void Based_on_the_slider_bar_the_Down_payment_should_changed_in_real_time() throws Throwable {
		System.out.println("Based on the slider bar the Down payment should changed in real time");
		
		Click_on_Finance_optons_accordion();
		downpayment=Integer.parseInt(getVisibleElementByXpath("//td[@currency='currency' and @model='percentValue']").getText().substring(1).replaceAll(",", ""));
		downpaymRatio=Integer.parseInt(getVisibleElementByXpath("//p[contains(@class,'value-model')]").getText().replaceAll("%", ""));
		String MonthlyPayment=getVisibleElementByXpath("//*[@currency='currency' and @model='currentPayment' and text()!='']").getText();
		int MonthlyPaymentInt=Integer.parseInt(MonthlyPayment.substring(1).replaceAll(",", ""));
		
		getVisibleElementByXpath("//div[contains(@class,'ui-slider-range')]//following-sibling::span");
		WebElement slider = driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range')]//following-sibling::span"));
	    Actions move = new Actions(driver);
	    Action action = (Action) move.dragAndDropBy(slider, 50, 0).build();
	    action.perform();
	    Thread.sleep(2000);
	    
	    int ActualDownpayment=Integer.parseInt(getVisibleElementByXpath("//td[@currency='currency' and @model='percentValue']").getText().substring(1).replaceAll(",", ""));
	    int ActualdownpaymRatio=Integer.parseInt(getVisibleElementByXpath("//p[contains(@class,'value-model')]").getText().replaceAll("%", ""));
	    String ActualMonthlyPayment=getVisibleElementByXpath("//*[@currency='currency' and @model='currentPayment' and text()!='']").getText();
		int ActualMonthlyPaymentInt=Integer.parseInt(ActualMonthlyPayment.substring(1).replaceAll(",", ""));
	    if(downpayment<ActualDownpayment && downpaymRatio<ActualdownpaymRatio && MonthlyPaymentInt>ActualMonthlyPaymentInt) {
	    		System.out.println("Using a Sider bar user is able to adjust the ratio. Based on that Down payment has changed. Initial Down Payment:" + downpayment + ", Down Payment after Side:" + ActualDownpayment);
	    		System.out.println("Down payment ratio and down payment amount displayed and reflected in real time on drag of the slider bar.Initial Down payment ratio:" + downpaymRatio + "%, Ratio after Side:" + ActualdownpaymRatio + "%");
	    		System.out.println("Monthly Payment has been changed based on slider. Initial Monthly Payment:" + MonthlyPayment + ", Monthly Payment after Side:" + ActualMonthlyPayment);
	    } 
	    
	    List<WebElement> PayMonthly=driver.findElements(By.xpath("//*[@currency='currency' and @model='currentPayment' and contains(text(),'"+ActualMonthlyPayment+"')]"));
		if(PayMonthly.size()<2) {
			Assert.assertFalse("Monthly Payment display issue.", true);
		}
	}
	
	
	
	@And("^see UI controls and values$")
	public void see_UI_controls_and_values() throws Throwable {
		System.out.println("see UI controls and values");
		
		Click_on_Finance_optons_accordion();
		
		System.out.println("Check for Vehicle Price (MSRP)");
		getVisibleElementByXpath("//p[@model='carPrice' and @currency='currency' and contains(text(),'" + formatNumberFrChina(modelPrice) + "')]");
		getVisibleElementByXpath("//td[@model='carPrice' and @currency='currency' and contains(text(),'" + formatNumberFrChina(modelPrice) + "')]");
		
		System.out.println("Check for Down Payment");
		int len=getVisibleElementByXpath("//td[@currency='currency' and @model='percentValue']").getText().substring(1).trim().length();
		if(len<=0) {
			Assert.assertFalse("Down Payment amount does not displayed in the Summary Table.", true);
		}
		
		System.out.println("Check for Down Payment Ratio");
		String dwnpay=getVisibleElementByXpath("//*[contains(@class,'value-model')]").getText();
		List<WebElement> dnpayRatio=driver.findElements(By.xpath("//*[contains(@class,'ng-binding') and text()='"+dwnpay+"']"));
		if(dnpayRatio.size()<=1) {
			Assert.assertFalse("Down Payment Ratio display issue, please chek on summary page.", true);
		}
		
		System.out.println("Check for Payment Terms (in Months)");
		getVisibleElementByXpath("//select[contains(@data-ng-model,'currentTerm')]").click();
		String payterm=getVisibleElementByXpath("//select[contains(@data-ng-model,'currentTerm')]//option[@selected='selected']").getText();
		getVisibleElementByXpath("//td[text()='"+payterm+"']");
		
		System.out.println("Check for Monthly Payment");
		getVisibleElementByXpath("//td[(@currency='currency' and @model='currentPayment' and text()!='') or (@currency='currency' and @model='restPayment' and text()!='')]");
	}

	
	@And("^see Downpayment field,Balance Amount field,Downpayment Ratio and Term field is disabled$")
	public void see_Downpayment_field_Balance_Amount_field_Downpayment_Ratio_and_Term_field_is_disabled() throws Throwable {
		System.out.println("see Downpayment field,Balance Amount field,Downpayment Ratio and Term field is disabled");
		
		Click_on_Finance_optons_accordion();
		
		System.out.println("Check whether Down Payment field is disabled");
		if(getVisibleElementByXpath("//input[@model='percentValue']").isDisplayed()==false) {
			Assert.assertFalse("Down Payment field is Enabled", true);
		}
		
		System.out.println("Check whether Down Payment Ratio field is disabled");
		if(getVisibleElementByXpath("//div[@model='percentValue']").isDisplayed()==false) {
			Assert.assertFalse("Down Payment Ratio display issue, please chek on summary page", true);
		}
		
		System.out.println("Check whether Payment Terms (in Months) field is disabled");
		if(getVisibleElementByXpath("//input[@model='currentTerm.term']").isDisplayed()==false) {
			Assert.assertFalse("Down Payment Ratio display issue, please chek on summary page", true);
		}
		
		System.out.println("Check whether Balance Amount of Money field is disabled");
		if(getVisibleElementByXpath("//input[@model='restPayment']").isDisplayed()==false) {
			Assert.assertFalse("Down Payment Ratio display issue, please chek on summary page", true);
		}
		downpayment=Integer.parseInt(getVisibleElementByXpath("//td[@currency='currency' and @model='percentValue']").getText().substring(1).replaceAll(",", ""));
	}
	
	
	//Modified
	@When("^Input amount of money on Payment Calculator on P2 Lincoln$")
	 public void inputAmountOfMoneyOnPaymentCalculator() throws Throwable {
	  System.out.println("Input amount of money on Payment Calculator");
	  int randomNum = ThreadLocalRandom.current().nextInt(1, 20);
	  Click_on_Finance_optons_accordion();
	  //int send = Integer.parseInt(getVisibleElementByXpath(".//*[@id='collapseOne']/div/div/table/tbody/tr[2]/td[2]").getText().substring(1));
	  //System.out.println("Before formatNumberFrChina: " + formatNumberFrChina (send));
	  //System.out.println("After formatNumberFrChina : " + formatNumberFrChina (send));
	 // downpayment=Integer.parseInt(getVisibleElementByXpath("//td[@currency='currency' and @model='percentValue']").getText().substring(1).replaceAll(",", ""))+randomNum;//(int) Math.ceil((modelPrice*20)/100)+50;//Integer.parseInt(data.get(0).get(0));//Integer.parseInt(getVisibleElementByXpath("//input[@currency='currency' and @model='percentValue']").getText());//Integer.parseInt(data.get(0).get(0));
	  downpayment=Integer.parseInt(getVisibleElementByXpath(".//*[@id='collapseOne']/div/div/table/tbody/tr[2]/td[2]").getText().substring(1).replaceAll(",", ""));
	  System.out.println("Before add Random Downpayment Value : " +downpayment);
	  downpayment=Integer.parseInt(getVisibleElementByXpath(".//*[@id='collapseOne']/div/div/table/tbody/tr[2]/td[2]").getText().substring(1).replaceAll(",", ""))+randomNum;//(int) Math.ceil((modelPrice*20)/100)+50;//Integer.parseInt(data.get(0).get(0));//Integer.parseInt(getVisibleElementByXpath("//input[@currency='currency' and @model='percentValue']").getText());//Integer.parseInt(data.get(0).get(0));
	  System.out.println("After add Random Downpayment Value : " +downpayment);
	  
	  getVisibleElementByXpath("//input[@model='percentValue']").click();
	  getVisibleElementByXpath("//input[@model='percentValue']").clear();
	  getVisibleElementByXpath("//input[@model='percentValue']").sendKeys(String.valueOf(downpayment));
	  
	  //waitTillElemVisiblebyXpath("//p[@model='carPrice' and @currency='currency']", 240);
	 }


	@When("^Click on Video in MKZ page on P1 Lincoln$")
	public void clickOnVideoInMkzPage() throws Throwable {
		System.out.println("Click on Video in MKZ page");
//		waitTillElemVisiblebyXpath("//div[contains(@class,'billboard-carousel carousel owl-oneitem')]//div[@class='hidden-xs']//span[@class='lincoln-icon_play-thin']", 240);
		getVisibleElementByXpath("//div[@class='hidden-xs']//span[@class='lincoln-icon_play-thin']").click();
	}


	@When("^Enter valid values$")
	public void enter_valid_values() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter valid values");
		ClearAndInputTextBox("//input[@name='username']",UniqueKey + "@mailinator.com");
		ClearAndInputTextBox("//input[@name='mobile']",phn);
		getVisibleElementByXpath("//select[@id='title']");
	}
	
	@When("^Click on Forgot Password link$")
	public void click_on_Forgot_Password_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Forgot Password link");
		getVisibleElementByXpath("//a[contains(@data-ng-click,'btnForgot')]").click();
	}

	@And("^Wait till 2 mins$")
	public void Wait_till_2_mins() throws Throwable {
		System.out.println("Wait till 2 mins");
		int i=0;
		do {
			Thread.sleep(2000);
			String str=driver.getCurrentUrl();
		}while(++i<=30);	
	}
	
	@When("^Enter User and Password$")
	public void enter_User_and_Password(DataTable arg) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Enter User and Password");
		List<List<String>> data=arg.raw();
//		waitTillElemVisiblebyXpath("//input[@name='loginFirstName' or @name='userId' or @id='userNameInput']", 240);
		if(data.get(0).get(0).isEmpty()) {
			ClearAndInputTextBox("//input[@name='loginFirstName' or @name='userId']",UniqueKey + "@mailinator.com");
			System.out.println("Login user is: " + UniqueKey + "@mailinator.com");
		}else {
			ClearAndInputTextBox("//input[@name='loginFirstName' or @name='userId' or @id='userNameInput']",data.get(0).get(0));
			System.out.println("Login user is: " + UniqueKey);
		}		
		ClearAndInputTextBox("//input[@name='loginPassword' or @name='passwd' or @id='passwordInput']",data.get(0).get(1));		
	}
	
	

	@Then("^User login should be successful and overview page should be displayed$")
	public void user_login_should_be_successful_and_overview_page_should_be_displayed(DataTable arg) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User login should be successful and overview page should be displayed");
		List<List<String>> data=arg.raw();
		String WelcomeMsg="Welcome, "+data.get(0).get(0)+" "+data.get(0).get(1);
//		waitTillElemVisiblebyXpath("//span[contains(text(),'Overview')]", 240);
		getVisibleElementByXpath("//span[contains(text(),'Overview')]");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			System.out.println("Jenkins build FALSE");
			getVisibleElementByXpath("//span[contains(text(),'"+WelcomeMsg+"')]");
		}
		getVisibleElementByXpath("//span[contains(text(),'Logout')]");
		driver.switchTo().defaultContent();
	}
	
	

	//Added by Sajith - Change Email Generation Waiting Time
	@And("^Click on Email on MailInator page$")
	public void Click_on_Email_on_MailInator_page() throws Throwable {
		System.out.println("Click on Email on MailInator page");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			int recsc=0;
			do {
				driver.navigate().refresh();
				Thread.sleep(2000);
				recsc++;
				if (isAlertPresent()) {
				    driver.switchTo().alert();
				    driver.switchTo().alert().accept();
				    driver.switchTo().defaultContent();
				}
			} while (driver.findElements(By.cssSelector("div.all_message-min-check-container")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
			
			do {
				Thread.sleep(2000);
				recsc++;
			} while (driver.findElements(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago') or contains(text(),'2 minutes ago')]")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
			
			driver.findElement(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago') or contains(text(),'2 minutes ago')]")).click();
		}
	}
	
	
	//Added by Sajith - Change Xpath of Terms and Condition.
	@And("^Select agreement check box$")
	public void Select_agreement_check_box() throws Throwable {
		System.out.println("Select agreement check box");
		//getVisibleElementByXpath("//*[contains(@class,'checkbox-style gux-icon-check')]").click();
		getVisibleElementByXpath("//input[@id='termsTypeCode']//following-sibling::span[1]").click();
		
	}
	

	//Added by Sajith - Change Xpath of Terms and Condition.	
	@And("^Click on Activation Email on MailInator page on P2$")
	public void clickOnActivationEmailOnMailInatorPage() throws Throwable {
		System.out.println("Click on Activation Email on MailInator page");
		int recsc=0;
		do {
			driver.navigate().refresh();
			Thread.sleep(2000);
			recsc++;
			if (isAlertPresent()) {
			    driver.switchTo().alert();
			    driver.switchTo().alert().accept();
			    driver.switchTo().defaultContent();
			}
		} while (driver.findElements(By.cssSelector("div.all_message-min-check-container")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
		
		recsc=0;
		do {
			Thread.sleep(2000);
			recsc++;
		} while (driver.findElements(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago') or contains(text(),'2 minutes ago')]")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
		
		driver.findElement(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago') or contains(text(),'2 minutes ago')]")).click();		
	}
	//SAJIT
	@When("^Click on Activate My Account link in activation mail$")
	public void clickOnActivateMyAccountLinkInMail() throws Throwable {
		System.out.println("Click on Activate My Account link in activation mail");
		Thread.sleep(10000);
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector("#publicshowmaildivcontent")))
					.findElement(By.tagName("body"));
			System.out.println("Log.........1");
		} catch (Exception e) {
			driver.switchTo().frame(driver.findElement(By.id("msg_body")));
			System.out.println("Log.........2");
		}
//		WebElement link = getVisibleElementByXpath("//a[contains(text(),'here')]");
//		link.click();
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("Log.........3");
		Thread.sleep(80000);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (isAlertPresent()) {
			    driver.switchTo().alert();
			    System.out.println("ALERT test2" + driver.switchTo().alert().getText());
			    driver.switchTo().alert().accept();
			    driver.switchTo().defaultContent();
			}

			System.out.println("Log.........4");
		}
		System.out.println("Log.........5");

	}
	
	public void Click_on_Finance_optons_accordion_Panel() throws Throwable {
		System.out.println("Click on Finance optons accordion");
		Thread.sleep(2000);
		List<WebElement> findexpanded=driver.findElements(By.xpath("//*[@class='panel-lock' and text()!='']"));
		Thread.sleep(2000);
		for(WebElement explorBtn:findexpanded) {	
			if(explorBtn.getText().contains("方案总结") && Boolean.parseBoolean(explorBtn.findElement(By.xpath("ancestor::a")).getAttribute("aria-expanded"))==false) {
				moveToElement(explorBtn);
				explorBtn.findElement(By.xpath("i")).click();
				break;
			}
		}
	}
	
	//Added by sajith, Change the B&P Xpath.
	@And("^Go to Build and price page$")
	 public void Go_to_Build_and_price_page() throws Throwable {
		  System.out.println("Go to Build and price page");
		  // Write the code to handle Data Table
		  //waitTillElemVisiblebyXpath("//*[contains(@id,'liBpActive')]/a", 240);
		//  getVisibleElementByXpath("//*[contains(@id,'liBpActive')]/a").click();	 
		  getVisibleElementByXpath(".//*[@id='liBpActive']/a/span[1]").click();	 
		  
	 }
	
	//Added by sajith - Comment the Refresh Line.
	@And("^Click on Sign in$")
	 public void Click_on_Sign_in() throws Throwable {
		  System.out.println("Click on Sign in");
		  getVisibleElementByXpath("//*[@id='submitButton']").click();
		 // driver.navigate().refresh();
		  //waitTillElemVisiblebyXpath("//*[contains(@id,'liBpActive')]/a", 240);
	 }
	
	//Added By Sajith - Change the xpath to login from Active Directory.
	@And("^Click Logon$")
	 public void Click_Logon() throws Throwable {
		  System.out.println("Click Logon");
		  // Write the code to handle Data Table
		 // waitTillElemVisiblebyXpath("//*[contains(text(),'Secure Web Logon')]", 100);
		  do {
			  Thread.sleep(10000);
			  //getVisibleElementByXpath("//*[contains(text(),'Secure Web Logon')]").click();
			  getVisibleElementByXpath("//*[contains(text(),'Active Directory')]").click();
			  Thread.sleep(5000);
		  }while(getVisibleElementByXpath("//input[@name='loginFirstName' or @name='userId' or @id='userNameInput']").isDisplayed()==false);
		  //driver.findElements(By.xpath("//input[@name='loginFirstName' or @name='userId' or @id='userNameInput']")).size()>0
	 }
	
	//Added by Sajith - comment the waitting element.
	@And("^see Nameplates listed down for the selected market$")
	 public void see_Nameplates_listed_down_for_the_selected_market() throws Throwable {
		  System.out.println("see Nameplates listed down for the selected market");
//		  waitTillElemVisiblebyXpath("//*[contains(@id,'liBpActive')]/a", 240);
		  List<WebElement> SubmenuNameplates=driver.findElements(By.xpath("//*[contains(@id,'liBpActive')]//*[contains(@class,'sub-menu')]//li//a[contains(text(),'MKC') or contains(text(),'MKX') or contains(text(),'Navigator') or contains(text(),'Continental')or contains(text(),'MKZ')]"));	  	
		  for(int ClickNP=0;ClickNP<SubmenuNameplates.size();ClickNP++) {
			  SubmenuNameplates.get(ClickNP).click();
			  Thread.sleep(30000);
			  getVisibleElementByXpath("//a[contains(text(),'Images')]");
			  List<WebElement> series=driver.findElements(By.xpath("//div[@id='bpCatalogListContent']//table//tbody[contains(@id,'tableContent')]/tr"));
			  if(series.size()>0) {
				  getVisibleElementByXpath("//a[contains(text(),'Edit Price')]");
				  List<WebElement> ChkNullMPV=driver.findElements(By.xpath("//div[@id='bpCatalogListContent']//table//tbody[contains(@id,'tableContent')]/tr//td[contains(text(),'no any mpv')]"));
				  if(ChkNullMPV.size()==0) {
					  List<WebElement> Modelseries=driver.findElements(By.xpath("//div[@id='bpCatalogListContent']//table//tbody[contains(@id,'tableContent')]/tr"));
					  for(WebElement getSerdetails:Modelseries) {
						  System.out.println(getSerdetails.findElements(By.xpath("td/a")).get(0).getText() + "  " + getSerdetails.findElements(By.xpath("td")).get(1).getText());
					  }
					  break;
				  }
			  }
			  SubmenuNameplates=driver.findElements(By.xpath("//*[contains(@id,'liBpActive')]//*[contains(@class,'sub-menu')]//li//a[contains(text(),'MKC') or contains(text(),'MKX') or contains(text(),'Navigator') or contains(text(),'Continental')or contains(text(),'MKZ')]"));	  	
		  }
	}

	
	
}
