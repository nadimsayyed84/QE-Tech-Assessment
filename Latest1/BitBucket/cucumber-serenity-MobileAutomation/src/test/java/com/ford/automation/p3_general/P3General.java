package com.ford.automation.p3_general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.browserstack.BrowserStackSerenityDriver;
import com.ford.automation.base.BaseTest;
import config.Configuration;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class P3General extends BaseTest {
	  @Before
	  public void before(Scenario scenario){
		  BrowserStackSerenityDriver.ScenarioName = (String)scenario.getName();
	  }
	  
	@Given("^Open firefox browser$")
	public void openFireFoxBrowser() throws Throwable {
		System.out.println("Open FireFox browser");
		System.setProperty("webdriver.gecko.driver", Configuration.PATH_TO_GECKO_DRIVER);
		driver = new FirefoxDriver();
	}

	@Given("^Open chrome browser$")
	public void openChromeBrowser() throws Throwable {
		System.out.println("Open Chrome browser");
//		System.setProperty("webdriver.chrome.driver", Configuration.PATH_TO_CHROME_DRIVER);
//		driver = new ChromeDriver();
	}

	@When("^Redirect to third party new link \"(.*?)\" on P2$")
	public void redirectt(String link) throws Throwable {
		System.out.println("Redirect to link");
		Thread.sleep(10000);
		driver.get(getProfileURL(link));
	}
	
	@When("^Maximize browser and enter link \"(.*?)\" on pointsprizes site$")
	public void openTestLink(String link) throws Throwable {
		System.out.println("Maximize browser and enter link");
		driver.manage().window().maximize();
		driver.get(getProfileURL(link));
	}

	@When("^Input mail into email field$")
	public void inputMailIntoEmailField(DataTable email) throws Throwable {
		List<List<String>> data = email.raw();
		getVisibleElementByXpath("//*[@id='index-header-email-input']/div/input[1]").sendKeys(data.get(0).get(0));
	}

	@And("^Click on Start Earning$")
	public void clickOnStartEarning() throws Throwable {
		getVisibleElementByXpath("//*[@id='index-header-email-input']/div/span/button").click();
	}

	@Then("^See components on pointsprizes site$")
	public void seeAllComponentsOnPointsprizes() throws Throwable {
		System.out.println("See components on pointsprizes site");
		getVisibleElementByXpath("//*[@id='wall']/div[1]/div[34]/a/div/div/div[2]/span");
	}

	@When("^Select items on pointsprizes site$")
	public void clickOnItems() throws Throwable {
		System.out.println("Select items on the list");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(text(),'Points')]"));
		int count = 0;
		int interval = 30000;
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				element.click();
				Thread.sleep(interval);
				count++;
				if (count == elements.size())
					break;
			}
		}
		driver.quit();
	}

	@When("^Redirect to Join on grabpoints site$")
	public void redirectToJoin() throws Throwable {
		System.out.println("Redirect to Join on grabpoints site");
		WebElement link = getVisibleElementByXpath("//a[text()='JOIN']");
		driver.get(getProfileURL(link.getAttribute("href")));
	}

	@And("^Click on Your Email arrow$")
	public void clickOnYourEmailArrow() throws Throwable {
		System.out.println("Click on Your Email arrow");
		getVisibleElementByXpath("//div[1]/div/div[2]/div[2]/div/form/div/div/div[1]/button").click();
	}

	@And("^Input email into your email$")
	public void inputEmailIntoYourEmail(DataTable email) throws Throwable {
		System.out.println("Input email into your email");
		List<List<String>> data = email.raw();
		getVisibleElementByXpath("//input[@name='email']").sendKeys(data.get(0).get(0));
	}

	@And("^Fill in registration form$")
	public void fillInRegistrationForm(DataTable registration) throws Throwable {
		System.out.println("Fill in registration form");
		List<List<String>> data = registration.raw();
		getVisibleElementByXpath("//input[@id='firstName']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@id='lastName']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@id='password']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@id='passwordVerification']").sendKeys(data.get(0).get(3));
	}

	@And("^Click on Submit button$")
	public void clickOnSubmitButton() throws Throwable {
		System.out.println("Click on Submit button");
		getVisibleElementByXpath("//button[text()='Submit']").click();
		Thread.sleep(5000);
	}

	@And("^Click on Skip button$")
	public void clickOnSkipButton() throws Throwable {
		System.out.println("Click on Skip button");
		getVisibleElementByXpath("//span[text()='Skip!']").click();
	}

	@When("^Redirect to link \"(.*?)\" in P3 Ford$")
	public void redirectToLink(String link) throws Throwable {
		System.out.println("Redirect to link");
		Thread.sleep(10000);
		driver.get(getProfileURL(link));
	}

	@When("^Go to google mail site in P3 Ford$")
	public void gotoGmailSite() throws Throwable {
		System.out.println("Go to google mail site");
		driver.navigate().to(
				"https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/&hl=vi#identifier");
	}

	@When("^Input credentials on gmail site in P3 Ford$")
	public void inputUserNameAndNext(DataTable credentials) throws Throwable {
		System.out.println("Input credentials on gmail site");
		// Write the code to handle Data Table
		List<List<String>> data = credentials.raw();
		getVisibleElementByXpath("//input[@id='identifierId']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//span[text()='Tiếp theo']").click();
		getVisibleElementByXpath("//input[@name='password']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//span[text()='Tiếp theo']").click();
	}

	@When("^Click on first mail item in P3 Ford$")
	public void clickOnFirstMailItem() throws Throwable {
		System.out.println("Click on first mail item");
		// getVisibleElementByXpath("//table/tbody/tr[contains(@class,'zE')]//b[text()='Forgot
		// username']").click();
		getVisibleElementByXpath("//table/tbody/tr[contains(@class,'zE')]//b[contains(text(),'Ford Delivery')]").click();
	}

	@When("^Redirect to Login on grabpoints site$")
	public void redirectToLogin() throws Throwable {
		System.out.println("Redirect to Login on grabpoints site");
		WebElement link = getVisibleElementByXpath("//a[text()='LOGIN']");
		driver.get(getProfileURL(link.getAttribute("href")));
	}

	@And("^Click on No to not push notifications$")
	public void clickOnNo() throws Throwable {
		System.out.println("Click on No to push notifications");
		getVisibleElementByXpath("html/body/gp-dialog/div/div[2]/dialog-content/div/div[2]/div[2]/span").click();
		Thread.sleep(5000);
	}

	@And("^Click on Demographic questions$")
	public void clickOnDemographicQuestions() throws Throwable {
		System.out.println("Click on Demographic questions");
		getVisibleElementByXpath("//h3[text()='Demographic questions']").click();
	}

	@And("^Answer the remaining demographic questions$")
	public void answerTheRemainingDemographicQuestion() throws Throwable {
		System.out.println("Answer the remaining demographic questions");
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='People']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath("//input[@id='REWARD']").click();
		getVisibleElementByXpath("//input[@id='REWARD']").sendKeys("Oscar");
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
	}

	@When("^Click on Connect to Facebook$")
	public void clickConnectToFacebook(DataTable credentials) throws Throwable {
		System.out.println("Click on Connect to Facebook");
		getVisibleElementByXpath("//h3[contains(text(),'Connect to Facebook')]").click();
		String winHandleBefore = driver.getWindowHandle();
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		List<List<String>> data = credentials.raw();
		getVisibleElementByXpath("//input[@id='email']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@id='pass']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//label[@id='loginbutton']").click();
		getVisibleElementByXpath("//button[contains(text(),'Continue as')]").click();
		getVisibleElementByXpath("//button[text()='OK']").click();
		Thread.sleep(30000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@When("^Click on Follow us on Twitter$")
	public void clickFollowUsOnTwitter(DataTable credentials) throws Throwable {
		System.out.println("Click on Follow us on Twitter");
		getVisibleElementByXpath("//h3[contains(text(),'Follow us on Twitter')]").click();
		String winHandleBefore = driver.getWindowHandle();
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		List<List<String>> data = credentials.raw();
		getVisibleElementByXpath("//*[@id='oauth_form']/fieldset[1]/div[1]/label").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//*[@id='oauth_form']/fieldset[1]/div[2]/label").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@id='allow']").click();

		Thread.sleep(30000);
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}

	@And("^Fill in all information$")
	public void fillInAllInfo() throws Throwable {
		System.out.println("Fill in all information");
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='Male']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath("//input[@id='BIRTHDAY']").click();
		getVisibleElementByXpath(
				"//div[@id='BIRTHDAY_root']/div/div/div/div/div[2]/div/select[contains(@class,'picker__select--year')]")
						.click();
		getVisibleElementByXpath(
				"//div[@id='BIRTHDAY_root']/div/div/div/div/div[2]/div/select[2]/option[text()='2001']").click();
		getVisibleElementByXpath("//*[@id='BIRTHDAY_table']/tbody/tr[1]/td[5]/div[text()='1']").click();
		getVisibleElementByXpath("//button[text()='Close']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath("//input[@id='STATE']").click();
		getVisibleElementByXpath("//input[@id='STATE']").sendKeys("HoangMai");
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath("//input[@id='CITY']").click();
		getVisibleElementByXpath("//input[@id='CITY']").sendKeys("Hanoi");
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[5]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='Caucasian']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[6]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='No schooling completed']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[7]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='Single']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[8]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='Employed for wages']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[9]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[contains(text(),'9999')]").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[10]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='Yes']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath(
				"//div[1]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[11]/div/form/div/div[2]/div/div/div/input")
						.click();
		getVisibleElementByXpath("//li[2]/span[text()='People']").click();
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
		getVisibleElementByXpath("//input[@id='REWARD']").click();
		getVisibleElementByXpath("//input[@id='REWARD']").sendKeys("Oscar");
		getVisibleElementByXpath("//div[1]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/span").click();
	}

	@And("^Click on Tutorial$")
	public void clickOnTutorial() throws Throwable {
		System.out.println("Click on Tutorial");
		getVisibleElementByXpath("//h3[text()='Tutorial']").click();
	}

	@And("^Fill in Tutorial$")
	public void fillInTutorial() throws Throwable {
		System.out.println("Fill in Tutorial");
		getVisibleElementByXpath("//span[contains(text(),'Begin tour')]").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Next']").click();
		getVisibleElementByXpath("//span[text()='Start earning points']").click();
	}

	@Then("^See page redirected to correct link \"(.*?)\" on grabpoints site$")
	public void seeThePageRedirectedToCorrectLink(String link) throws Throwable {
		System.out.println("See page redirected to correct link");
		verifyRedirecToCorrectLink(link);
		Thread.sleep(5000);
	}

	@And("^Enter credentials on grabpoints site$")
	public void enterCredentials(DataTable credentials) throws Throwable {
		System.out.println("Enter credentials");
		List<List<String>> data = credentials.raw();
		getVisibleElementByXpath("//input[@id='email']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@id='password']").sendKeys(data.get(0).get(1));
	}

	@When("^Maximize browser and enter link \"(.*?)\" in P3 Ford$")
	public void openTestLinkInP3(String link) throws Throwable {
		System.out.println("Maximize browser and enter link");
		driver.manage().window().maximize();
		driver.get(getProfileURL(link));
	}

	@Then("^See all components in service price calculator page in P3 Ford$")
	public void seeAllComponentsInServicePriceCalculatorPage() throws Throwable {
		System.out.println("See all components in service price calculator page");
		getVisibleElementByXpath("//span[text()='Vehicles']");
		getVisibleElementByXpath("//span[text()='Shop']");
		getVisibleElementByXpath("//span[text()='Finance']");
		getVisibleElementByXpath("//span[text()='Owner']");
		getVisibleElementByXpath("//i[contains(@class,'icon-locate-a-dealer')]");
		getVisibleElementByXpath("//span[text()='Dealer Locator']");
		getVisibleElementByXpath("//i[contains(@class,'icon-profile')]");
		getVisibleElementByXpath("//span[text()='Login']");
		getVisibleElementByXpath("//span[text()='My Profile']");
		getVisibleElementByXpath("//img[@alt='logo']");
		getVisibleElementByXpath("//img[@alt='demo']");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']/h2[text()='Service Price Promise Calculator']");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']/p[contains(text(),'Service Price Promise')]");
		getVisibleElementByXpath("//span[text()='Year']");
		getVisibleElementByXpath("//div[@id='s2id_select1']/a[@class='select2-choice']");
		getVisibleElementByXpath("//span[text()='Model']");
		getVisibleElementByXpath("//div[@id='s2id_select2']/a[@class='select2-choice']");
		getVisibleElementByXpath("//span[text()='Style']");
		getVisibleElementByXpath("//div[@id='s2id_select3']/a[@class='select2-choice']");
		getVisibleElementByXpath("//span[text()='Engine']");
		getVisibleElementByXpath("//div[@id='s2id_select4']/a[@class='select2-choice']");
		getVisibleElementByXpath("//button[contains(text(),'Next')]");
		getVisibleElementByXpath("//a[text()='Booking Service']");
		getVisibleElementByXpath("//div[@class='book-button-holder']/a[text()='Call Your Dealer']");
		getVisibleElementByXpath("//a[text()='Terms and Conditions']");
		getVisibleElementByXpath("//h3[text()='Disclosures']");
	}

	@When("^Select values in all the drop downs in P3 Ford$")
	public void clickOnSelectYearDropdownList() throws Throwable {
		System.out.println("Select values in all the drop downs");
		getVisibleElementByXpath("//div[@id='s2id_select1']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'2017')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select2']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'ZG Escape')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select3']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'Wagon FWD')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select4']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'1.5L Petrol')]").click();
		getVisibleElementByXpath("//button[contains(text(),'Next')]").click();
	}

	@Then("^See all information after selecting values in all the drop downs in P3 Ford$")
	public void seeAllInformationAfterSelectingValuesInAllTheDropDowns() throws Throwable {
		System.out.println("See all information after selecting values in all the drop downs");
		waitTillElemVisiblebyXpath("//span[contains(text(),'ESTIMATED KILOMETRES TO DATE')]", 240);
		getVisibleElementByXpath("//span[contains(text(),'ESTIMATED KILOMETRES TO DATE')]");
		getVisibleElementByXpath("//input[@class='ng-isolate-scope ng-pristine ng-valid']");
		getVisibleElementByXpath("//span[contains(text(),'FIRST REGISTRATION DATE')]");
		getVisibleElementByXpath(
				"//div[@id='s2id_select6']/a[@class='select2-choice']/span[contains(text(),'January')]");
		getVisibleElementByXpath("//div[@id='s2id_select7']//span[contains(text(),'2017')]");
		getVisibleElementByXpath("//button[contains(text(),'Calculate')]");
		getVisibleElementByXpath("//div[@class='item-holder']/a[@class='item active']");
		getVisibleElementByXpath("//div[@class='item-holder']/a[@class='item active']//span[text()='Kms']");
		getVisibleElementByXpath(
				"//div[@class='item-holder']/a[@class='item active']//span[contains(text(),'15,000')]");
		getVisibleElementByXpath("//div[@class='item-holder']/a[@class='item active']//span[text()='Service']");
		getVisibleElementByXpath(
				"//div[@class='item-holder']/a[@class='item active']//span[contains(text(),'1')]/small[text()='Year']");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a[@class='item']");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a[@class='item']//span[text()='Kms']");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a[@class='item']//span[contains(text(),'30,000')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a[@class='item']//span[text()='Service']");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a[@class='item']//span[contains(text(),'2')]/small[text()='Years']");
		getVisibleElementByXpath("//h2[text()='Payment Details']");
		// getVisibleElementByXpath("//p[text()='The maximum price for your 15,000 kms
		// (1 Year year) standard service is:']");
		// getVisibleElementByXpath("//span[contains(text(),'260')]");
		// getVisibleElementByXpath("//input[@id='checkbox1']");
		// getVisibleElementByXpath("//p[text()='Total Service Price']");
		// getVisibleElementByXpath("//small[text()='Incl. GST']");
		getVisibleElementByXpath("//a[text()='Terms and Conditions']");
		getVisibleElementByXpath("//img[@alt='LAD']");
		getVisibleElementByXpath("//div[@class='content desktop hideForMobile']//a[text()='Book Service']");
		getVisibleElementByXpath("//img[@alt='Call Your Dealer']");
		getVisibleElementByXpath("//div[@class='content desktop hideForMobile']//a[text()='Call Your Dealer']");
		getVisibleElementByXpath("//img[@alt='View PDF']");
		getVisibleElementByXpath("//div[@class='content desktop hideForMobile']//a[text()='View&Print PDF']");
		getVisibleElementByXpath("//h3[text()='Disclosures']");
	}

	@When("^Input into Estimated Kilometres to date and select First Registration Date in P3 Ford$")
	public void inputIntoEstimatedKilometresToDateAndSelectFirstRegistrationDate(DataTable parameters)
			throws Throwable {
		System.out.println("Input into Estimated Kilometres to date and select First Registration Date");
		List<List<String>> data = parameters.raw();
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[1]/form/div[1]/div/div/label/input")
						.clear();
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[1]/form/div[1]/div/div/label/input")
						.sendKeys(data.get(0).get(0));
	}

	@And("^Click on Calculate button in P3 Ford$")
	public void clickOnCalculateButton() throws Throwable {
		System.out.println("Click on Calculate button");
		Thread.sleep(5000);
		getVisibleElementByXpath("//button[contains(text(),'Calculate')]").click();
	}

	@Then("^See all Kilometers and Service number section highlighted accordingly in P3 Ford$")
	public void seeAllKilometersAndServiceNumberSectionHightlightedAccordingly(DataTable parameters) throws Throwable {
		System.out.println("See all Kilometers and Service number section highlighted accordingly");
		List<List<String>> data = parameters.raw();
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a/ul/li[1]/span[contains(text(),'"
						+ data.get(0).get(0) + "')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a/ul/li[2]/span[contains(text(),'"
						+ data.get(0).get(1) + "')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/a/ul/li[1]/span[contains(text(),'"
						+ data.get(0).get(2) + "')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/a/ul/li[2]/span[contains(text(),'"
						+ data.get(0).get(3) + "')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[5]/div/a/ul/li[1]/span[contains(text(),'"
						+ data.get(0).get(4) + "')]");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[5]/div/a/ul/li[2]/span[contains(text(),'"
						+ data.get(0).get(5) + "')]");
	}

	@When("^Click on highlighted Kilometers and Service number in P3 Ford$")
	public void clickOnHighlightedKilometersAndServiceNumber(DataTable parameter) throws Throwable {
		System.out.println("Click on highlighted Kilometers and Service number");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[3]/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/a/ul/li[1]/span[contains(text(),'"
						+ data.get(0).get(0) + "')]").click();
	}

	@Then("^See all components on Payment Details in P3 Ford$")
	public void seeAllComponentsOnPaymentDetails() throws Throwable {
		System.out.println("See all components on Payment Details");
		getVisibleElementByXpath("//p[text()='Standard Service Price' or text()='Standard Payment Price']");
		getVisibleElementByXpath("//p[text()='Additional Service Items']");
		getVisibleElementByXpath("//p[text()='Total Service Price']");
	}

	@When("^Select up to 3 items on Additional Service Items in P3 Ford$")
	public void selectUpTo3ItemsOnAdditionalServiceItems() throws Throwable {
		System.out.println("Select up to 3 items on Additional Service Items");
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//input[@id='checkbox1']"));
		int count = 0;
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				element.click();
				count++;
				if (count == 3)
					break;
			}
		}
	}

	@When("^Select up to 3 items on Additional Service Items in P3 Ford Chrome$")
	public void selectUpTo3ItemsOnAdditionalServiceItemsChrome() throws Throwable {
		System.out.println("Select up to 3 items on Additional Service Items");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		List<WebElement> elements = driver.findElements(By.xpath("//input[@id='checkbox1']"));
		int count = 0;
		for (WebElement element : elements) {
			actions.moveToElement(element);
			actions.click().build().perform();
			count++;
			if (count == 3)
				break;
		}
	}

	@Then("^Verify Total Service Price is updated correctly in P3 Ford$")
	public void verifyTotalServicePriceIsUpdatedCorrectly(DataTable parameter) throws Throwable {
		System.out.println("Verify Total Service Price is updated correctly");
		// Write the code to handle Data Table
		List<List<String>> data = parameter.raw();
		WebElement elem=getVisibleElementByXpath(data.get(0).get(1));
		if(elem.getText().isEmpty()) {
			Assert.assertFalse("Total Service Price issue", true);
		}
//		getVisibleElementByXpath(data.get(0).get(0), data.get(0).get(1));
	}

	@When("^Click on View and Print PDF in P3 Ford$")
	public void clickOnViewAndPrintPdf() throws Throwable {
		System.out.println("Click on View and Print PDF");
		getVisibleElementByXpath("//div[@class='content desktop hideForMobile']//a[text()='View&Print PDF']").click();
	}

	@Then("^See all components on Latest Offers Postcode in P3 Ford$")
	public void seeAllComponentsOnLatestOffersPostcode() throws Throwable {
		System.out.println("See all components on Latest Offers Postcode");
		getVisibleElementByXpath("//h4[text()='Want to see offers in your local area?']");
		getVisibleElementByXpath("//span[text()='Enter your postcode']");
		getVisibleElementByXpath("//input[@name='postcode']");
		getVisibleElementByXpath("//button[text()='Submit']");
		getVisibleElementByXpath("//a[text()='Cancel']");
	}

	@When("^Input wrong postcode into postcode field and verify validation message displayed in P3 Ford$")
	public void inputWrongPostcodeIntoPostcodeFieldAndVerifyValidationMessageDisplayed(DataTable parameters)
			throws Throwable {
		System.out.println("Input wrong postcode into postcode field and verify validation message displayed");
		List<List<String>> data = parameters.raw();
		getVisibleElementByXpath("//input[@name='postcode']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//button[text()='Submit']").click();
		getVisibleElementByXpath("//small[text()!='']");
		//getVisibleElementByXpath("//small[text()='" + data.get(0).get(1) + "']");
		// getVisibleElementByXpath("//input[@name='postcode']").clear();
		// getVisibleElementByXpath("//input[@name='postcode']").sendKeys(data.get(0).get(2));
		// getVisibleElementByXpath("//button[text()='Submit']").click();
		// getVisibleElementByXpath("//small[text()='"+data.get(0).get(3)+"']");
	}

	@When("^Input correct postcode into postcode field in P3 Ford$")
	public void inputCorrectPostcodeIntoPostcodeField(DataTable parameter) throws Throwable {
		System.out.println("Input correct postcode into postcode field");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//input[@name='postcode']").clear();
		getVisibleElementByXpath("//input[@name='postcode']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//button[text()='Submit']").click();
	}

	@Then("^See all components on Latest Offers left panel in P3 Ford$")
	public void seeAllComponentsOnLatestOffersLeftPanel(DataTable parameter) throws Throwable {
		System.out.println("See all components on Latest Offers left panel");
		List<List<String>> data = parameter.raw();
		for (int i = 0; i <= 20; i++) {
			getVisibleElementByXpath(
					"//div[@class='offers-column search-filter-holder']//span[text()='" + data.get(0).get(i) + "']");
		}
		getVisibleElementByXpath(
				"//div[@class='offers-column search-filter-holder']//span[contains(@class,'ui-slider-handle')]");
	}

	@Then("^See all components on Latest Offers main page in P3 Ford$")
	public void seeAllComponentsOnLatestOffersMainPage(DataTable parameter) throws Throwable {

		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//p[contains(text(),'Prices for July 21, 2014 Postal Code')]");
		getVisibleElementByXpath("//a[text()='" + data.get(0).get(0) + "']");
		getVisibleElementByXpath("//h2[text()='Latest Offers']");
		getVisibleElementByXpath("//p[text()='Our latest offers are updated regularly, so check in for a good deal.']");
		getVisibleElementByXpath("//span[text()='Sort by']");
		getVisibleElementByXpath("//a[text()='View Disclaimer']");
		getVisibleElementByXpath("//h4[text()='TRUCK']");
		getVisibleElementByXpath("//h4[text()='SUV']");
		getVisibleElementByXpath("//h4[text()='CAR']");
		for (int i = 1; i <= 23; i++) {
			getVisibleElementByXpath("//span[text()='" + data.get(0).get(i) + "']");
		}
	}

	@Then("^Verify all the vehicles have details about model year details of offers available in P3 Ford$")
	public void verifyAllTheVehiclesHaveDetailsAboutModelYearDetailsOfOffersAvailable() throws Throwable {
		String xpath2 = "/div/a/p";
		System.out.println("Verify all the vehicles have details about model year details of offers available");
		for (int i = 1; i <= 6; i++) {
			String xpath1 = "//div[@id='item" + i + "_1']";
			getVisibleElementByXpath(xpath1.concat(xpath2));
		}

		for (int j = 1; j <= 11; j++) {
			String xpath1 = "//div[@id='item" + j + "_2']";
			getVisibleElementByXpath(xpath1.concat(xpath2));
		}

		for (int k = 1; k <= 8; k++) {
			String xpath1 = "//div[@id='item" + k + "_2']";
			getVisibleElementByXpath(xpath1.concat(xpath2));
		}
	}

	@When("^Click on Sort by in Latest Offer page in P3 Ford$")
	public void clickOnSortByInLatestOfferPage(DataTable parameter) throws Throwable {
		System.out.println("Click on Sort by in Latest Offer page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//span[text()='Sort by']").click();
		getVisibleElementByXpath("//a[text()='Price High To Low']");
		getVisibleElementByXpath("//a[text()='Price Low To High']");
		getVisibleElementByXpath("//a[text()='Default']");
		getVisibleElementByXpath("//a[text()='" + data.get(0).get(0) + "']").click();
	}

	@SuppressWarnings("unchecked")
	@Then("^Verify the ascending sorting option are working in P3 Ford$")
	public void verifyTheAscendingSortingOptionAreWorking() throws Throwable {
		System.out.println("Verify the ascending sorting option are working");
		@SuppressWarnings("rawtypes")
		ArrayList entries = new ArrayList();

		String amount1 = getVisibleElementByXpath("//span[text()='$46,493']").getText().toString();
		String amount1Trim = amount1.replace("$", " ");
		String amount1Trim1 = amount1Trim.replace(",", " ");
		String amount1Trim2 = amount1Trim1.trim();
		double price1 = Double.valueOf(amount1Trim2).doubleValue();

		String amount2 = getVisibleElementByXpath("//span[text()='$48,493']").getText().toString();
		String amount2Trim = amount2.replace("$", " ");
		String amount2Trim1 = amount2Trim.replace(",", " ");
		String amount2Trim2 = amount2Trim1.trim();
		double price2 = Double.valueOf(amount2Trim2).doubleValue();

		String amount3 = getVisibleElementByXpath("//span[text()='$56,493']").getText().toString();
		String amount3Trim = amount3.replace("$", " ");
		String amount3Trim1 = amount3Trim.replace(",", " ");
		String amount3Trim2 = amount3Trim1.trim();
		double price3 = Double.valueOf(amount3Trim2).doubleValue();

		String amount4 = getVisibleElementByXpath("//span[text()='$40,693']").getText().toString();
		String amount4Trim = amount4.replace("$", " ");
		String amount4Trim1 = amount4Trim.replace(",", " ");
		String amount4Trim2 = amount4Trim1.trim();
		double price4 = Double.valueOf(amount4Trim2).doubleValue();

		String amount5 = getVisibleElementByXpath("//span[text()='$40,493']").getText().toString();
		String amount5Trim = amount5.replace("$", " ");
		String amount5Trim1 = amount5Trim.replace(",", " ");
		String amount5Trim2 = amount5Trim1.trim();
		double price5 = Double.valueOf(amount5Trim2).doubleValue();

		String amount6 = getVisibleElementByXpath("//span[text()='$46,493']").getText().toString();
		String amount6Trim = amount6.replace("$", " ");
		String amount6Trim1 = amount6Trim.replace(",", " ");
		String amount6Trim2 = amount6Trim1.trim();
		double price6 = Double.valueOf(amount6Trim2).doubleValue();

		entries.add(new AscendingPrice(price1));
		entries.add(new AscendingPrice(price2));
		entries.add(new AscendingPrice(price3));
		entries.add(new AscendingPrice(price4));
		entries.add(new AscendingPrice(price5));
		entries.add(new AscendingPrice(price6));

		Collections.sort(entries);
	}

	@Then("^See the ascending sorting option in P3 Ford$")
	public void seeTheAscendingSortingOption() throws Throwable {
		System.out.println("See the ascending sorting option");
		getVisibleElementByXpath("//span[contains(text(),'$15,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$17,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$18,49')]");
		getVisibleElementByXpath("//span[contains(text(),'$19,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$20,99')]");
	}

	@When("^Click on the filters on the left pane of the page in P3 Ford$")
	public void clickOnTheFiltersOnTheLeftPaneOfThePage(DataTable parameter) throws Throwable {
		System.out.println("Click on the filters on the left pane of the page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//span[text()='" + data.get(0).get(0) + "']");
	}

	@Then("^See all the filters are behaving correctly in P3 Ford$")
	public void seeAllTheFilersAreBehavingCorrectly() throws Throwable {
		System.out.println("See all the filters are behaving correctly");
		getVisibleElementByXpath("//span[contains(text(),'$15,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$17,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$20,99')]");
		getVisibleElementByXpath("//span[contains(text(),'$24,49')]");

	}

	@When("^Click on any offer in P3 Ford$")
	public void clickOnAnyOffer(DataTable parameter) throws Throwable {
		System.out.println("Click on any offer");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//span[text()='" + data.get(0).get(0) + "']").click();

	}

	@Then("^See all components in offer details page load correctly in P3 Ford$")
	public void seeAllComponentsInOfferDetailsPageLoadCorrectly(DataTable parameter) throws Throwable {
		System.out.println("See all components in offer details page load correctly");
		List<List<String>> data = parameter.raw();
		Thread.sleep(5000);
		getVisibleElementByXpath("//b[text()='" + data.get(0).get(0) + "']");
		getVisibleElementByXpath("//span[text()='" + data.get(0).get(1) + "']");
		getVisibleElementByXpath("//b[text()='" + data.get(0).get(2) + "']");

		for (int i = 3; i <= 9; i++) {
			getVisibleElementByXpath("//li[contains(text(),'" + data.get(0).get(i) + "')]");
		}
	}

	@When("^Click on General Features$")
	public void ClickonGeneralFeatures() throws Throwable {
		System.out.println("Click on General Features");
		getVisibleElementByXpath("//p[contains(text(),'General Features')]").click();

	}
	
	
	@Then("^see all general features display correctly$")
	public void see_all_general_features_display_correctly(DataTable parameter) throws Throwable {
		System.out.println("see all general features display correctly");
		List<List<String>> data = parameter.raw();
		Thread.sleep(5000);
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(0) + "')]");
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(1) + "')]");
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(2) + "')]");

	}

	
	@When("^Click on Fiesta Ambiente$")
	public void Click_on_Fiesta_Ambiente() throws Throwable {
		System.out.println("Click on Fiesta Ambiente");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//p[contains(text(),'Fiesta Ambiente')]").click();

	}
	
	
	@Then("^see all Fiesta Ambiente features display correctly$")
	public void see_all_Fiesta_Ambiente_features_display_correctly(DataTable parameter) throws Throwable {
		System.out.println("see all Fiesta Ambiente features display correctly");
		List<List<String>> data = parameter.raw();
		Thread.sleep(5000);
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(0) + "')]");
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(1) + "')]");
		getVisibleElementByXpath("//h4[contains(text(),'" + data.get(0).get(2) + "')]");

	}	
	
	@Then("^See all components in Predelivery page loaded correctly in P3 Ford$")
	public void seeAllComponentsInPredeliveryPageLoadedCorrectly(DataTable parameter) throws Throwable {
		System.out.println("See all components in Predelivery page loaded correctly");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//img[@alt='logo']");
		for (int i = 0; i <= 4; i++) {
			getVisibleElementByXpath(
					"//div[@class='desktop hideForMobile']//span[contains(text(),'" + data.get(0).get(i) + "')]");
		}

		for (int j = 5; j <= 23; j++) {
			getVisibleElementByXpath("//span[text()='" + data.get(0).get(j) + "']");
		}

		for (int k = 24; k <= 32; k++) {
			getVisibleElementByXpath("//input[@name='" + data.get(0).get(k) + "']");
		}

		getVisibleElementByXpath("//p[text()='* REQUIRED FIELDS']");

		getVisibleElementByXpath("//div[@id='s2id_autogen1']/a");
		getVisibleElementByXpath("//div[@id='s2id_autogen3']/a");
		getVisibleElementByXpath("//div[@id='s2id_select-model']/a");
		getVisibleElementByXpath("//*[@id='s2id_select-series']/a");
		getVisibleElementByXpath("//div[@id='s2id_select-color']/a");
		getVisibleElementByXpath("//small[contains(text(),'Field must have 17 characters or leave field blank')]");
	}

	@When("^Fill in Pre Delivery form in P3 Ford$")
	public void FillInPreDeliveryForm(DataTable parameter) throws Throwable {
		System.out.println("Fill in Pre Delivery form");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//div[@id='s2id_autogen1']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(0) + "')]").click();
		getVisibleElementByXpath("//input[@name='Firstname']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='Lastname']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@name='Email']").sendKeys(data.get(0).get(3));
		getVisibleElementByXpath("//input[@name='MobilePhone']").sendKeys(data.get(0).get(4));
		getVisibleElementByXpath("//input[@name='Address1']").sendKeys(data.get(0).get(5));
		getVisibleElementByXpath("//input[@name='Suburb']").sendKeys(data.get(0).get(6));
		getVisibleElementByXpath("//input[@name='Postcode']").sendKeys(data.get(0).get(7));
		getVisibleElementByXpath("//div[@id='s2id_autogen3']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(8) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select-model']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(9) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select-series']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(10) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select-color']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(11) + "')]").click();
		getVisibleElementByXpath("//input[@name='VIN']").sendKeys(data.get(0).get(12));
		Thread.sleep(5000);
		getVisibleElementByXpath("//div[@id='s2id_select-dealership']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(14) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_select-dealer']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(13) + "')]").click();
		getVisibleElementByXpath("//span[contains(text(),'I have read and understood the')]").click();
	}

	@When("^Click on Next button in Pre Delivery form in P3 Ford$")
	public void clickOnNextButtonInPreDeliveryForm() throws Throwable {
		System.out.println("Click on Next button in Pre Delivery form");
		getVisibleElementByXpath("//button[@type='submit' and contains(text(),'Next')]").click();
	}

	@Then("^See all records in Pre Delivery page in P3 Ford$")
	public void seeAllRecordsInPreDeliveryPage(DataTable parameter) throws Throwable {
		System.out.println("See all records in Pre Delivery page");
		List<List<String>> data = parameter.raw();

		for (int i = 0; i <= 10; i++) {
			getVisibleElementByXpath(
					"//header[@class='predelivery-header']//span[text()='" + data.get(0).get(i) + "']");
		}

		for (int j = 11; j <= 18; j++) {
			getVisibleElementByXpath("//span[text()='" + data.get(0).get(j) + "']");
		}
	}

	@When("^Click on Save and Continue button in Pre Delivery page in P3 Ford$")
	public void clickOnSaveAndContinueButtonInPreDeliveryPage() throws Throwable {
		System.out.println("Click on Save and Continue button in Pre Delivery page");
		getVisibleElementByXpath("//button[@type='button' and contains(text(),'Save & Continue')]").click();
	}

	@Then("^Verify message is successfully saved in Pre Delivery page in P3 Ford$")
	public void verifyMessageIsSuccessfullySavedInPreDeliveryPage(DataTable parameter) throws Throwable {
		System.out.println("Verify message is successfully saved in Pre Delivery page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//strong[text()='" + data.get(0).get(0) + "']");
		Thread.sleep(5000);
	}

	@When("^Click on icon play button in Pre Delivery page in P3 Ford$")
	public void clickOnIconPlayButtonInPreDeliveryPage() throws Throwable {
		System.out.println("Click on icon play button in Pre Delivery page");
		getVisibleElementByXpath(
				"//div[@id='global-ux']/div[2]/div[2]/div/form/div/div[3]/div[2]/div/div/div[1]/div[4]/div/table/tbody/tr[2]/td[2]/a/i[@class='icon-play']")
						.click();
	}

	@Then("^See video frame in Pre Delivery page in P3 Ford$")
	public void seeVideoFrameInPreDeliveryPage() throws Throwable {
		System.out.println("See video frame in Pre Delivery page");
		getVisibleElementByXpath("//object[@id='bcExperienceObj0']");
		getVisibleElementByXpath(
				"//div[@class='overlay-container visible overlay-video']//i[@class='icon-plus icon-x']");
	}

	@And("^Click on Close button in video frame in P3 Ford$")
	public void clickOnCloseButtonInVideoFrame() throws Throwable {
		System.out.println("Click on Close button in video frame");
		getVisibleElementByXpath(
				"//div[@class='overlay-container visible overlay-video']//i[@class='icon-plus icon-x']").click();
	}

	@When("^Click on Step 4 in Pre Delivery page in P3 Ford$")
	public void clickOnStep4InPreDeliveryPage() throws Throwable {
		System.out.println("Click on Step 4 in Pre Delivery page");
		getVisibleElementByXpath("//span[text()='Step 4']").click();
	}

	@Then("^See Personalise your Ford form in Pre Delivery page in P3 Ford$")
	public void seePersonaliseYourFordFormInPreDeliveryPage(DataTable parameter) throws Throwable {
		System.out.println("See Personalise your Ford form in Pre Delivery page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//span[text()='PERSONALISE FOR PICK-UP']");
		for (int i = 0; i <= 7; i++) {
			getVisibleElementByXpath("//h5[text()='" + data.get(0).get(i) + "']");
		}
		getVisibleElementByXpath("//input[@name='P-MOBILE-PHONE']");
		// getVisibleElementByXpath("//div[@class='desktop
		// hideForMobile']//a[text()='Check compatibility']");
		// getVisibleElementByXpath("//span[text()='TEMPARATURE']");
		// getVisibleElementByXpath("//span[text()='24-HOUR']");
		// getVisibleElementByXpath("//span[text()='12-HOUR']");
		// getVisibleElementByXpath("//textarea[@name='P-CUSTOMER-NOTES']");
	}

	@When("^Click on Next button in Personalise for pick up section in P3 Ford$")
	public void clickOnNextButtonInPreDeliveryPage() throws Throwable {
		System.out.println("Click on Next button in Personalise for pick up section");
		getVisibleElementByXpath(
				"//div[@class='form predelivery-step is-active-step']//button[contains(text(),'Next')]").click();
	}

	@Then("^See all records after hitting Next in Step 4 in P3 Ford$")
	public void seeAllRecordsAfterHittingNextInStep4(DataTable parameter) throws Throwable {
		System.out.println("See all records after hitting Next in Step 4");
		List<List<String>> data = parameter.raw();

		for (int i = 0; i <= 31; i++) {
			getVisibleElementByXpath("//span[text()='" + data.get(0).get(i) + "']");
		}
		getVisibleElementByXpath("//input[@name='recaptcha' or @name='INDIVIDUAL_CUST_SEX_CODE']");
	}

	@When("^Click on View Summary as PDF in Summary page in P3 Ford$")
	public void clickOnViewSummaryAsPdfInSummaryPage() throws Throwable {
		System.out.println("Click on View Summary as PDF in Summary page");
		getVisibleElementByXpath("//button[@type='button' and contains(text(),'View As PDF')]").click();
	}

	@When("^Input into captcha field in Summary page in P3 Ford$")
	public void inputIntoCaptchaFieldInSummaryPage(DataTable parameter) throws Throwable {
		System.out.println("Input into captcha field in Summary page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//input[@name='recaptcha' or @name='INDIVIDUAL_CUST_SEX_CODE']").sendKeys(EnterCaptcha());
	}

	@Then("^See Confirmation page displayed in P3 Ford$")
	public void seeConfirmationPageDisplayed(DataTable parameter) throws Throwable {
		System.out.println("See Confirmation page displayed");
		List<List<String>> data = parameter.raw();
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			Thread.sleep(40000);
			getVisibleElementByXpath("//img[@alt='logo']");
	
			for (int i = 0; i <= 2; i++) {
				getVisibleElementByXpath(
						"//div[@class='desktop hideForMobile']//span[text()='" + data.get(0).get(i) + "']");
			}
	
			for (int j = 3; j <= 6; j++) {
				getVisibleElementByXpath("//strong[contains(text(),'" + data.get(0).get(j) + "')]");
			}
			getVisibleElementByXpath("//a[text()='phone compatibility']");
			getVisibleElementByXpath("//a[contains(text(),'Android')]");
			getVisibleElementByXpath("//a[text()='iOS']");
			getVisibleElementByXpath("//div[@class='desktop hideForMobile']//a[text()='Close and Return to Ford Home']");
		}
	}

	@When("^Click on Submit To Dealer in Summary page in P3 Ford$")
	public void clickOnSubmitToDealerInSummaryPage() throws Throwable {
		System.out.println("Click on Submit To Dealer in Summary page");
		getVisibleElementByXpath("//button[@type='button' and contains(text(),'Submit To Dealer')]").click();
	}

	@Then("^See all components loaded correctly in Offers page in P3 Ford$")
	public void seeAllComponentsLoadedCorrectlyInOffersPage(DataTable parameter) throws Throwable {
		System.out.println("See all components loaded correctly in Offers page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//img[@alt='logo']");

		for (int i = 0; i <= 9; i++) {
			getVisibleElementByXpath("//span[text()='" + data.get(0).get(i) + "']");
		}

		for (int j = 10; j <= 15; j++) {
			getVisibleElementByXpath(
					"//div[contains(@class,'desktop hideForMobile')]//a[text()='" + data.get(0).get(j) + "']");
		}

		getVisibleElementByXpath("//div[contains(@class,'desktop hideForMobile')]//strong[text()='FIESTA']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'2017')]/strong[text()='Fiesta']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'2017')]/strong[text()='Mustang']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'2016')]/strong[text()='Focus']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'2016')]/strong[text()='Fiesta']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'New')]/strong[text()='Fiesta']");
		getVisibleElementByXpath(
				"//div[@class='desktop hideForMobile']//a[contains(text(),'New')]/strong[text()='Focus']");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//strong[text()='Figo']");
		getVisibleElementByXpath("//h3[text()='Disclosures']");
	}

	@When("^Redirect to Offer Details Model Fiesta 2017 link in P3 Ford$")
	public void redirectToPasswordResetLink() throws Throwable {
		System.out.println("Redirect to Offer Details Model Fiesta 2017 link");
		Thread.sleep(30000);
		WebElement link = getVisibleElementByXpath(
				"//div[@id='splitter']/div/div/div[1]/div/div/div[3]/div/div[2]/div[2]/div/div[1]/h6[2]/a[text()='Detalhes da Oferta']");
		driver.get(getProfileURL(link.getAttribute("href")));
	}

	@Then("^See all components loaded correctly in Offer Details page in P3 Ford$")
	public void seeAllComponentsLoadedCorrectlyInOfferDetailsPage(DataTable parameter) throws Throwable {
		System.out.println("See all components loaded correctly in Offer Details page");
		List<List<String>> data = parameter.raw();
		getVisibleElementByXpath("//div[@id='splitter']/div/div/div[1]/div/div/div[2]/div/div[1]/h3[1]");
		getVisibleElementByXpath("//div[@id='splitter']/div/div/div[1]/div/div/div[2]/div/div[1]/h3[2]");
		getVisibleElementByXpath("//div[@id='splitter']/div/div/div[1]/div/div/div[2]/div/div[1]/h6[1]");
		getVisibleElementByXpath("//div[@id='splitter']/div/div/div[1]/div/div/div[2]/div/div[1]/h6[2]");
		getVisibleElementByXpath("//div[@id='splitter']/div/div/div[1]/div/div/div[2]/div/div[1]/h6[3]");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//a[text()='Request a Quote']");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']/h2[text()='Awards']");
		for (int i = 0; i <= 2; i++) {
			getVisibleElementByXpath(
					"//div[contains(@class,'hideForMobile')]/h3[contains(text(),'" + data.get(0).get(i) + "')]");
		}
	}
	
//	@When("^Redirect to link \"(.*?)\" on P2$")
//	public void z(String link) throws Throwable {
//		System.out.println("Redirect to link");
//		Thread.sleep(10000);
//		driver.get(getProfileURL(link));
//	}
	
//	@And("^Click on Activation Email on MailInator page on P2$")
//	public void clickOnActivationEmailOnMailInatorPage() throws Throwable {
//		System.out.println("Click on Activation Email on MailInator page");
//		driver.navigate().refresh();
//		do {
//			driver.navigate().refresh();
//			Thread.sleep(5000);
//		} while (driver.findElements(By.cssSelector("div.all_message-min-check-container")).size() == 0);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
//		driver.findElement(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago')]")).click();	
//	}

	
	@And("^Click on Email on MailInator page$")
	public void Click_on_Email_on_MailInator_page() throws Throwable {
		System.out.println("Click on Email on MailInator page");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			int recsc=0;
			do {
				driver.navigate().refresh();
				Thread.sleep(2000);
				recsc++;
			} while (driver.findElements(By.cssSelector("div.all_message-min-check-container")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
			
			do {
				Thread.sleep(2000);
				recsc++;
			} while (driver.findElements(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago')]")).size() == 0 && recsc<60);// (By.cssSelector("div.col-lg-1.col-md-1.col-sm-1.hidden-xs")).size()==0);
			
			driver.findElement(By.xpath("//ul[@id='inboxpane']/li//div[contains(text(),'moments ago') or contains(text(),'minute ago')]")).click();
		}
	}
	
	@When("^Verify Ford Delivery Checklist mail$")
	public void Verify_Ford_Delivery_Checklist_mail() throws Throwable {
		System.out.println("Verify Ford Delivery Checklist mail");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			Thread.sleep(10000);
			try {
				driver.switchTo().frame(driver.findElement(By.cssSelector("#publicshowmaildivcontent")))
						.findElement(By.tagName("body"));
			} catch (Exception e) {
				driver.switchTo().frame(driver.findElement(By.id("msg_body")));
			}
			WebElement link = getVisibleElementByXpath("//td[contains(text(),'Your Ford Delivery Checklist')]");
			driver.switchTo().defaultContent();
		}
	}
}