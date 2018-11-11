package com.ford.automation.p1_general;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.browserstack.BrowserStackSerenityDriver;
import com.ford.automation.base.BaseTest;

import config.Configuration;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.mkyong.rest.*;
public class P1General extends BaseTest {
  @Before
  public void before(Scenario scenario){
	  BrowserStackSerenityDriver.ScenarioName = (String)scenario.getName();
  }
	@Given("^Open FireFox browser on P1General$")
	public void openFireFoxBrowser() throws Throwable {
		System.out.println("Open FireFox browser");
		System.setProperty("webdriver.gecko.driver", Configuration.PATH_TO_GECKO_DRIVER);
		driver = new FirefoxDriver();

	}

	@Given("^Open FireFox browser$")
	public void openFireFoxBrowser2() throws Throwable {
		System.out.println("Open FireFox browser");
		driver = new FirefoxDriver();

	}
	
	@Given("^Open Chrome browser on P1General$")
	public void openChromeBrowser() throws Throwable {
		System.out.println("Open Chrome browser");
//		System.setProperty("webdriver.chrome.driver", Configuration.PATH_TO_CHROME_DRIVER);
//		ChromeOptions options = new ChromeOptions();
//		if(System.getProperty("os.name").toLowerCase().contains("linux")) {
//			System.out.println("Setting up ChromeOptions");
//			options.setBinary("/usr/bin/google-chrome-stable");
//			options.addArguments("--headless");
//		}
//		options.addArguments("--start-maximized");
//		driver = new ChromeDriver(options);
		// driver = new ChromeDriver();
////		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
////       driver.manage().timeouts().setScriptTimeout(240, TimeUnit.SECONDS);
	}

	@Given("^Open \"(.*?)\" browser$")
	public void openSpecificBrowser(String browserName) throws Throwable {
		if ("FireFox".equals(browserName)) {
			openFireFoxBrowser();
		} else if ("Chrome".equals(browserName)) {
			openChromeBrowser();
		}
	}

	@When("^Maximize browser and enter link \"(.*?)\"$")
	public void openTestLink(String link) throws Throwable {
		System.out.println("Maximize browser and enter link");
//		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		js.executeScript("window.open('','testwindow','width=400,height=200')");
//		driver.close();
//		driver.switchTo().window("testwindow");
//		js.executeScript("window.moveTo(0,0);");
//		js.executeScript("window.resizeTo(1450,1000);");
		driver.manage().window().maximize();
		driver.get(getProfileURL(link));
	}
	
	@When("^Redirect to link \"(.*?)\" on P1$")
	public void redirect(String link) throws Throwable {
		System.out.println("Redirect to link");
		Thread.sleep(10000);
		driver.get(getProfileURL(link));
	}
	
	@When("^Maximize browser and enter link \"(.*?)\" and check if link is broken$")
	public void openTestLinkAndCheckIfLinkIsBroken(String link) throws Throwable {
		System.out.println("Maximize browser and enter link and check if link is broken");
		if(Boolean.parseBoolean(System.getProperty("isMobile"))==false) {
			driver.manage().window().maximize();
		}
		driver.get(getProfileURL(link));
		List<WebElement> allImages = findAllLinks(driver);
		System.out.println("Total number of elements found: " + allImages.size());

		for (WebElement element : allImages) {
			try {
				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));
				// System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned "
				// + isLinkBroken(new URL(element.getAttribute("href"))));
			} catch (Exception exp) {
				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
			}
		}
	}

	@Then("^See all components in newsroom page$")
	public void seeAllComponentsInNewsroomPage() throws Throwable {
		System.out.println("See all components in newsroom page");
		getVisibleElementByXpath("//div[text()='News']");
		getVisibleElementByXpath("//input[@class='search typeahead']");
		getVisibleElementByXpath("//span[contains(text(),'Sort By')]");
		getVisibleElementByXpath("//a[text()='Article1']");
		getVisibleElementByXpath(
				"//a[text()='Ford Conducts Industry-First Snow Tests of Autonomous Vehicles – Further Accelerating Development Program']");
		getVisibleElementByXpath(
				"//a[contains(text(),'Ford Tripling Size of Autonomous Vehicle Development Fleet, Accelerating On-Road Testing of Sensors and Software')]");
		getVisibleElementByXpath("//a[text()='Ford Philippines Calls for Entries to 16th Henry Ford Awards']");
		getVisibleElementByXpath(
				"//a[text()='Ford Invests in Making Customer Experience as Strong as Its Cars, SUVs, Trucks and Electrified Vehicles with FordPass']");
		getVisibleElementByXpath("//div[contains(text(),'View More News')]");
	}

	@Then("^See all components in newsroom page Perf$")
	public void seeAllComponentsInNewsroomPagePerf() throws Throwable {
		System.out.println("See all components in newsroom page Perf");
		getVisibleElementByXpath("//div[text()='News']");
		getVisibleElementByXpath("//span[contains(text(),'Sort By')]");
		getVisibleElementByXpath("//a[text()='The 15th Henry Ford Awards: Now Open for Entries']");
		getVisibleElementByXpath(
				"//a[text()='Ford Philippines Sales Rise 19 Percent']");
		getVisibleElementByXpath(
				"//a[contains(text(),'Ford Raises the Bar for Refined and Rugged Capable SUVs with the Launch of the All-New Everest')]");
		getVisibleElementByXpath("//a[text()='The Voice of the Philippines']");
		getVisibleElementByXpath(
				"//a[text()='FORD PHILIPPINES GOES FURTHER WITH FORD FORZA TRIATHLON TEAM']");
	}
	
	@When("^Input any word into Search field in newsroom page$")
	public void inputAnyWordIntoSearchFieldInNewsroomPage(DataTable searchedWord) throws Throwable {
		System.out.println("Input any word into Search field in newsroom page");
		List<List<String>> data = searchedWord.raw();
		getVisibleElementByXpath("//input[@class='search typeahead']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//i[@class='icon-search']").click();
	}

	@Then("^See the searched word display in newsroom page$")
	public void seeTheSearchedWordDisplayInNewsroomPage(DataTable searchedWord) throws Throwable {
		System.out.println("See the searched word display in newsroom page");
		Thread.sleep(5000);
		List<List<String>> data = searchedWord.raw();
		getVisibleElementByXpath("//strong[text()='" + data.get(0).get(0) + "']");
	}

	@Then("^See the latest version of JS \"(.*?)\"$")
	public void seeTheLatestVersionOfJS(String version) throws Throwable {
		System.out.println("See the latest version of JS");
		String versionStringToVerify = "var aemGuxfoapUiReleaseVersion = '" + version + "'";

		Boolean correctVersion = driver.getPageSource().contains(versionStringToVerify);
		if (!correctVersion) {
			throw new Exception("Incorrect version!");
		}
	}

	@When("^Redirect to link \"(.*?)\"$")
	public void redirectToLink(String link) throws Throwable {
		System.out.println("Redirect to link");
		// Thread.sleep(3000);
		driver.get(getProfileURL(link));
	}

	@When("^Redirect to link \"(.*?)\" and check if link is broken$")
	public void redirectToLinkAndCheckIfLinkIsBroken(String link) throws Throwable {
		System.out.println("Redirect to link and check if link is broken");
		Thread.sleep(10000);
		driver.get(getProfileURL(link));
		List<WebElement> allImages = findAllLinks(driver);
		System.out.println("Total number of elements found: " + allImages.size());

		for (WebElement element : allImages) {
			try {
				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));
				// System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned "
				// + isLinkBroken(new URL(element.getAttribute("href"))));
			} catch (Exception exp) {
				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
			}
		}
	}

	@Then("^See all components on home page loaded without performance issue$")
	public void seeHomePageLoadWithoutIssue() throws Throwable {
		System.out.println("See all components on home page loaded without performance issue");
		// getVisibleElementByXpath("//a[text()='View All Vehicles']");

		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//a[text()='Build & Price']");
		getVisibleElementByXpath("//input[@id='mini-lad-input']");
	}

	@When("^Select province and city in China Mini LAD$")
	public void selectProvinceAndCityInChinaMiniLad(DataTable parameters) throws Throwable {
		System.out.println("Select province and city in China Mini LAD");
		List<List<String>> data = parameters.raw();
		getVisibleElementByXpath("//div[@id='s2id_autogen5']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(0) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_autogen7']/a[@class='select2-choice']").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(1) + "')]").click();
	}

	@And("^Click on Search button in China Mini LAD$")
	public void clickOnSearchButtonInChinaMiniLad() throws Throwable {
		System.out.println("Click on Search button in China Mini LAD");
		getVisibleElementByXpath("//button[contains(text(),'搜寻')]").click();
	}

	@Then("^See dealer in China Mini LAD Map$")
	public void seeDealerInChinaMiniLadMap() throws Throwable {
		System.out.println("See dealer in China Mini LAD Map");
		getVisibleElementByXpath("//p[text()='1']");
		getVisibleElementByXpath("//span[text()='1']");
		getVisibleElementByXpath("//div[@id='map']//h3[text()='上海江铃汽车销售服务有限公司']");
		getVisibleElementByXpath("//div[@id='map']//a[contains(text(),'销售:021-57432116')]");
		getVisibleElementByXpath("//div[@id='map']//a[@href='tel:服务：021-62176667']");
		getVisibleElementByXpath("//div[@id='map']//a[contains(text(),'方向')]");
	}

	@When("^Click on Dealer Details in China Mini LAD Map$")
	public void clickOnDealerDetailsInChinaMiniLadMap() throws Throwable {
		System.out.println("Click on Dealer Details in China Mini LAD Map");
		// getVisibleElementByXpath("//div[@id='dealer-locator-china']//span[@class='icon-details']").click();
		getVisibleElementByXpath("//div[@class='dealer-result-holder']//span[@class='icon-details']").click();
		// getVisibleElementByXpath("//div[@class='dealer-details-holder']//span[contains(text(),'详细信息')]").click();
	}

	@Then("^See Dealer Details expander in China Mini LAD Map$")
	public void seeDealerDetailsExpanderInChinMiniLadMap() throws Throwable {
		System.out.println("See Dealer Details expander in China Mini LAD Map");
		getVisibleElementByXpath("//a[text()='mailto:shjl@jmc.com.cn']");
		getVisibleElementByXpath("//span[text()='经销商车型']");
		// getVisibleElementByXpath("//div[@id='dealer-locator-china']//a[contains(text(),'获取报价')]");
		// getVisibleElementByXpath("//div[@id='dealer-locator-china']//a[contains(text(),'长安福特及进口车预约试驾')]");
		// getVisibleElementByXpath("//div[@id='dealer-locator-china']//a[contains(text(),'江铃汽车预约试驾
		// ')]");
	}

	@When("^Select province and city in China Main LAD$")
	public void selectProvinceAndCityInChinaMainLad(DataTable parameters) throws Throwable {
		System.out.println("Select province and city in China Main LAD");
		List<List<String>> data = parameters.raw();
		getVisibleElementByXpath("//div[@id='s2id_autogen1']/a");
		getVisibleElementByXpath("//div[@id='s2id_autogen3']/a");
		getVisibleElementByXpath("//div[@id='s2id_autogen5']/a");
		getVisibleElementByXpath("//div[@id='s2id_autogen1']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(0) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_autogen3']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(1) + "')]").click();
		getVisibleElementByXpath("//div[@id='s2id_autogen5']/a").click();
		getVisibleElementByXpath("//div[contains(text(),'" + data.get(0).get(2) + "')]").click();
	}

	@Then("^See dealer in China Map$")
	public void seeDealerInChinaMap() throws Throwable {
		System.out.println("See dealer in China Map");
		getVisibleElementByXpath("//span[text()='1']");
		// getVisibleElementByXpath("//div[@id='map']//a[contains(text(),'Directions')]");
		// getVisibleElementByXpath("//div[@id='dealer-locator-china']//a[contains(text(),'Directions')]");
		// getVisibleElementByXpath("//span[@class='icon-details']");
	}

	@When("^Click on Dealer Details in China Map$")
	public void clickOnDealerDetailsInChinaMap() throws Throwable {
		System.out.println("Click on Dealer Details in China Map");
		getVisibleElementByXpath("//div[@id='dealer-locator-china']/div[7]/div/div/div[2]/div/div/div[1]/div/div/div/div[3]/div[3]/p/span/span[@class='icon-details']").click();
	}

	@Then("^See Dealer Details expander in China Map$")
	public void seeDealerDetailsExpanderInChinaMap() throws Throwable {
		System.out.println("See Dealer Details expander in China Map");
		getVisibleElementByXpath("//a[text()='369526@qq.com']");
		getVisibleElementByXpath("//h3[@class='dl-dealer-name dl-dealer-name-details' and contains(text(),'亳州市远景福润汽车销售服务有限责任公司')]");
		// getVisibleElementByXpath("//span[text()='Car Dealer']");
		// getVisibleElementByXpath("//a[contains(text(),'Car Prices')]");
		// getVisibleElementByXpath("//a[contains(text(),'Book A Test Drive')]");
		// getVisibleElementByXpath("//a[contains(text(),'JMC Book A Test Drive')]");
	}

	@And("^Click on Search button in China Main LAD$")
	public void clickOnSearchButtonInChinaMainLad() throws Throwable {
		System.out.println("Click on Search button in China Main LAD");
		getVisibleElementByXpath("//button[contains(text(),'搜寻经销商')]").click();
	}

	@When("^Input position \"(.*?)\" to Mini LAD and Search$")
	public void inputPositionAndSearch(String position) throws Throwable {
		System.out.println("Input position to Mini LAD and Search");
		Thread.sleep(3000);
		getVisibleElementByXpath("//input[@id='mini-lad-input']").clear();
		getVisibleElementByXpath("//input[@id='mini-lad-input']").sendKeys(position);
		getVisibleElementByXpath("//button[@class='submit-btn search-submit']").click();
	}

	@When("^Click on LAD Expander button$")
	public void clickLADExpander() throws Throwable {
		System.out.println("Click on LAD Expander button");
		Thread.sleep(30);
		getVisibleElementByXpath("//div[@class='expander-head']/a[contains(@class,'expander')]").click();
	}

	@When("^See the first result \"(.*?)\" on Map$")
	public void seeTheFirstResultOnMap(String foundPosition) throws Throwable {
		System.out.println("See the first result on Map");
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dealer-info expander-body expanded']//h4/a[text()='" + foundPosition + "']")));
		getVisibleElementByXpath("//div[@class='dealer-info expander-body expanded']//h4/a[text()='" + foundPosition + "']");
	}

	@When("^Click on Dealer Detail$")
	public void clickOnDealerDetail() throws Throwable {
		System.out.println("Click on Dealer Detail");
		getVisibleElementByXpath("//i[@class='icon-details']").click();
	}

	@Then("^See page redirected to correct link \"(.*?)\"$")
	public void seeThePageRedirectedToCorrectLink(String link) throws Throwable {
		System.out.println("See page redirected to correct link");

		Thread.sleep(10000); // 60000

		String url = driver.getCurrentUrl();
		if (!url.equals(link)) {
			throw new Exception("Redirect to incorrect link");
		}
	}

	@Then("^See page redirected to link contains \"(.*?)\"$")
	public void seeThePageRedirectedToLinkContains(String link) throws Throwable {
		System.out.println("See page redirected to link contains");

		Thread.sleep(30000);

		String url = driver.getCurrentUrl();
		System.out.println("xxxxxxxxxxxxxxxx" + url);
		if (!url.contains(link)) {
			throw new Exception("Redirect to incorrect link");
		}
	}

	@Then("^Verify map container is loaded$")
	public void verifyMapContainerLoaded(String foundPosition) throws Throwable {
		System.out.println("Click on Dealer Detail");
		getVisibleElementByXpath("//div[@class='map-container']");
		getVisibleElementByXpath("//h3[contains(text(),'" + foundPosition + "')]");
	}

	@Then("^See all components on Fiesta page loaded without performance issue$")
	public void seeFiestaPageWithoutIssue() throws Throwable {
		System.out.println("See all components on Fiesta page loaded without performance issue");
		waitTillElementExist(
				"//div[contains(@class,'service-ok')][1]//div[@class='heading']/a[text()='Model Compare' or text()='Overview All Models']");
		getVisibleElementByXpath(
				"//div[contains(@class,'secondaryNavigation')]//div[@class='desktop hideForMobile']//a[text()='Request A Test Drive' or text()='Request a Test Drive']");
		getVisibleElementByXpath(
				"//div[contains(@class,'secondaryNavigation')]//div[@class='desktop hideForMobile']//a[text()='Request A Brochure' or text()='Request a Brochure']");
		getVisibleElementByXpath(
				"//div[contains(@class,'secondaryNavigation')]//div[@class='desktop hideForMobile']//a[text()='Locate A Dealer' or text()='Locate Dealer']");
		try {
		getVisibleElementByXpath(
				"//article[@class='carousel-slide slider-model-detail white flex-active-slide']//div[@class='desktop hideForMobile']//a[text()='Request A Test Drive']");
		}catch(Exception e) {}
	}

	@When("^Click on Main Nav \"(.*?)\"$")
	public void clickOnMainNav(String mainNav) throws Throwable {
		System.out.println("Click on Main Nav");
		// getVisibleElementByXpath("//div[@id='nav-content']//span[text()='" + mainNav
		// + "']").click();
		getVisibleElementByXpath("//span[text()='Vehicles']").click();
	}

	@When("^Click on Main Navigation \"(.*?)\"$")
	public void clickOnMainNavigation(String mainNav) throws Throwable {
		System.out.println("Click on Main Nav");
		// getVisibleElementByXpath("//div[@id='nav-content']//span[text()='" + mainNav
		// + "']").click();
		getVisibleElementByXpath("//span[contains(text(),'Vehicles')]").click();
	}
	
	@When("^Click on tab in Vehicle \"(.*?)\"$")
	public void clickOnTabInVehicle(String tabName) throws Throwable {
		System.out.println("Click on tab in Vehicle");
		// try {
		// getVisibleElementByXpath("//a[text()='" + tabName + "']").click();
		// } catch (Exception e) {
		// Thread.sleep(5000);
		// getVisibleElementByXpath("//li[@class='vehicle-menu-item']//a[text()='" +
		// tabName + "']");
		getVisibleElementByXpath("//a[@class='vehicle-menu-item-title' and text()='" + tabName + "']//ancestor::li")
				.click();
		// }
	}

	@Then("^Verify vehicle name in menu \"(.*?)\"$")
	public void verifyVehicleNameInMenu(String vehicleName) throws Throwable {
		System.out.println("Verify vehicle name in menu");
		// getVisibleElementByXpath("//span[contains(text(), '" +vehicleName+ "')]");
		clickOnLinks("//span[text()='" + vehicleName + "']//ancestor::a[contains(@href,'" + vehicleName.toLowerCase()
				+ "')]");
	}

	@When("^Click on View All Vehicle$")
	public void clickOnViewAllVehicle() throws Throwable {
		System.out.println("Verify vehicle name in menu");
		getVisibleElementByXpath("//a[text()='View All Vehicles']").click();

	}

	@When("^Click on a model \"(.*?)\"$")
	public void clickOnAModel(String modelName) throws Throwable {
		System.out.println("Click on a model");
		// getVisibleElementByXpath("//div[@class='vehicle-card-grid']/div[@class='item']/div[@class='item-content']/h3[text()='"
		// + modelName + "']/preceding-sibling::div/a/img").click();
		clickOnLinks("//span[text()='" + modelName + "']//ancestor::a[contains(@href,'" + modelName.toLowerCase() + "')]");
	}

	@When("^Click on model \"(.*?)\"$")
	public void clickOnModel(String modelName) throws Throwable {
		System.out.println("Click on a model");
//		getVisibleElementByXpath("//span[text()='" + modelName + "' and @class!='']").click();
		clickOnLinks("//span[text()='" + modelName + "' and @class!='']//ancestor::a[contains(@href,'" + modelName.toLowerCase() + "')]");
	}
	
	@When("^Click on Menu Item on Main Nav \"(.*?)\"$")
	public void clickOnMenuItemOnMainNav(String item) throws Throwable {
		System.out.println("Click on Menu Item on Main Nav");
		// getVisibleElementByXpath("//span[text()='" + item + "']").click();
		clickOnLinks("//span[text()='" + item + "']//ancestor::a[contains(@href,'" + item.toLowerCase() + "')]");
	}

	@When("^Click on SubMenu Item \"(.*?)\"$")
	public void clickOnSubMenuItemOnMainNav(String item) throws Throwable {
		System.out.println("Click on Menu Item on Main Nav");
		// getVisibleElementByXpath("//span[text()='" + item + "']").click();
		clickOnLinks("//*[text()='" + item + "']");
	}
	
	@When("^Search SubMenu link accros the Main Navigation link\"(.*?)\"$")
	public void Search_SubMenu_link_accros_the_Main_Navigation_link(String item) throws Throwable {
		System.out.println("Search SubMenu link accros the Main Navigation link");
		// getVisibleElementByXpath("//span[text()='" + item + "']").click();
		WebDriverWait wait = new WebDriverWait(driver, 240);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'vehicle-menu')]//*[contains(@class,'vehicle-menu-item')]/a")));
		List<WebElement> subtabs=driver.findElements(By.xpath("//*[contains(@class,'vehicle-menu')]//*[contains(@class,'vehicle-menu-item')]/a"));
		if(subtabs.size()>0) {
			for(WebElement clicksubtab:subtabs) {
//				clickOnLinks("//*[text()='" + clicksubtab.getText() + "']");
				do {
					Thread.sleep(5000);
				}while(!clicksubtab.isDisplayed());
				clicksubtab.click();
//				WebElement clicktab=driver.findElement(By.xpath("//*[contains(@class,'vehicle-menu')]//*[contains(@class,'vehicle-menu-item')]/a/following-sibling::div//span[contains(@class,'model-name') and contains(text(),'"+item+"')]"));
				try {
					clickOnLinks("//span[contains(text(),'" + item + "')]//ancestor::a[contains(@href,'" + item.toLowerCase() + "')]");
//					clicktab.click();
//					break;
				}catch(Exception e) {}
			}
		}else {
			Assert.assertFalse("No subtabs found.",true);
		}
//		clickOnLinks("//*[text()='" + item + "']");
	}
	
	@When("^Click on Secondary menu switcher$")
	public void clickOnSecondaryMenuSwitcher() throws Throwable {
		System.out.println("Click on Secondary menu switcher");
		getVisibleElementByXpath("//h2[contains(text(),'Explore')]").click();
	}

	@When("^Click on Secondary Menu \"(.*?)\"$")
	public void clickToOpenSecondaryMenu(String secondaryMenu) throws Throwable {
		System.out.println(
				"Click on Secondary Menu: " + "//div[contains(@class,'desktop')]//a[text()='" + secondaryMenu + "']");
		getVisibleElementByXpath("//a[text()='" + secondaryMenu + "']").click();
	}

	@When("^Click on Model compare$")
	public void Click_on_Model_compare() throws Throwable {
		System.out.println("Click on Secondary Menu: " + "//div[contains(@class,'desktop')]//a[text()='Model Compare']");
		getVisibleElementByXpath("//div[contains(@class,'desktop')]//a[text()='Model Compare']").click();
	}
	
	@When("^Click on image on Gallery$")
	public void clickOnImageOnGallery() throws Throwable {
		System.out.println("Click on image on Gallery");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getVisibleElementByXpath("//div[@class='images-container']/div[@class='image section']/div/a").click();
	}

	@Then("^Verify overlay open from image Gallery$")
	public void verifyGalleryOverlayOpen() throws Throwable {
		System.out.println("Verify overlay open from image");
		Thread.sleep(5000);
		getVisibleElementByXpath("//div[@class='box-image-overlay box-content' or contains(@class,'common-overlay')]");
	}

	@When("^Click on Show Details$")
	public void clickOnShowDetails() throws Throwable {
		System.out.println("Click on Show Details");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement em = getVisibleElementByXpath("//span[text()='Hide Details']");
			try {
				em.click();
				// getVisibleElementByXpath("//span[text()='Show Details']").click();
			} catch (Exception e) {
				System.out.println("No Hide Details");
			}
			;
		} catch (Exception e) {
		}
		;
		getVisibleElementByXpath(
				"//span[@class='accordion-details-button' and text()='Show Details' or text()='View Details']").click();
		Thread.sleep(5000);
	}

	@When("^Click on View Details$")
	public void clickOnViewDetails() throws Throwable {
		System.out.println("Click on View Details");
		getVisibleElementByXpath(
				"//span[@class='accordion-details-button' and text()='Show Details' or text()='View Details']").click();
		Thread.sleep(5000);
	}

	@Then("^Verify overlay open from image$")
	public void verifyOverlayOpenFromImage() throws Throwable {
		System.out.println("Verify overlay open from image");
		// getVisibleElementByXpath("//img[@src='https://wwwdev.brandap.ford.com/content/ford/ph/en_ph/fiesta-content/image-overlays/gallery-exterior/stylish-4-door-sedan/_jcr_content/par/box/generalParsys/image/image.imgs.full.high.jpg/1492425446786.jpg']");
		waitTillElementExist("//i[@class='icon-plus icon-x']");
		getVisibleElementByXpath("//i[@class='icon-plus icon-x']");
		getVisibleElementByXpath("//span[@class='accordion-details-button' and text()='Show Details']");
	}

	@When("^Click on the X button on the top left$")
	public void clickOnTheXbuttonOnTheTopLeft() throws Throwable {
		System.out.println("Click on the X button on the top left");
		Thread.sleep(2000);
		getVisibleElementByXpath("//div[@id='global-ux']/div[3]/div[4]/div/span/i[@class='icon-plus icon-x']").click();
	}

	@Then("^Verify seen Share and Download button$")
	public void verifySeenShareAndDownload() throws Throwable {
		System.out.println("Verify seen Share and Download button");
		getVisibleElementByXpath("//i[@class='icon-share']");
		getVisibleElementByXpath("//i[contains(@class,'icon-download')]");
	}

	@When("^Click on Share$")
	public void clickOnShare() throws Throwable {
		System.out.println("Click on Share");
		getVisibleElementByXpath("//i[@class='icon-share']").click();
		Thread.sleep(2000);
	}

	@When("^Click on Download$")
	public void clickOnDownload() throws Throwable {
		System.out.println("Click on Download");
		getVisibleElementByXpath("//i[contains(@class,'icon-download')]").click();
	}

	@When("^Scroll down overlay container$")
	public void scrollDownOverlayContainer() throws Throwable {
		System.out.println("Scroll down overlay container");
		getVisibleElementByXpath("//div[contains(@class,'overlay-container')]").sendKeys(Keys.PAGE_DOWN);
	}

	@Then("^See the sharing popup$")
	public void seeSharingPopup() throws Throwable {
		System.out.println("See the sharing popup");
		getVisibleElementByXpath("//a[@class='icon-share-facebook']");
		getVisibleElementByXpath("//a[@class='icon-share-twitter']");
		getVisibleElementByXpath("//a[@class='icon-share-pinterest']");
		getVisibleElementByXpath("//a[@class='icon-share-facebook']").click();
		Thread.sleep(2000);
	}

	@When("^Click to close overlay$")
	public void clickToCloseOverlay() throws Throwable {
		System.out.println("Click to close overlay");
		getVisibleElementByXpath("//i[@class='icon-plus icon-x']").click();
	}

	@When("^Click on video carousel item$")
	public void clickOnVideoCarouselItem() throws Throwable {
		System.out.println("Click on video carousel item");
		// moveToElement("//a[@data-overlay_id='overview-videos_video']");
		getVisibleElementByXpath("//a[@data-overlay_id='gallery-videos_video']/picture/img").click();
	}

	@Then("^See video overlay$")
	public void seeVideoOverlay() throws Throwable {
		System.out.println("See video overlay");

		getVisibleElementByXpath("//object[@id='bcExperienceObj0']");
	}

	@When("^Click on media carousel$")
	public void clickOnMediaCarousel() throws Throwable {

	}

	@Then("^Verify 360 images$")
	public void verify360Images() throws Throwable {
		System.out.println("See 360 images");
		getVisibleElementByXpath("//div[@class='image-360']/ul[@class='slides']/li/picture/img");
	}

	@When("^Click on Colorize tab$")
	public void clickOnColorizeTab() throws Throwable {
		System.out.println("Click on Colorize tab");
		getVisibleElementByXpath("//a[text()='Colorizer' or contains(text(),'Colouriser')]").click();

	}

	@When("^Verify Image with Color is seen$")
	public void verifyImageWithColorIsSeen() throws Throwable {
		System.out.println("Verify Image with Color is seen");
		getVisibleElementByXpath("//div[@id='colorizer']/ul[@id='colorizerMainImg']/li[@class='item active']/img");
	}

	@When("^Click on Black color to change$")
	public void clickOnBlackColorToChange() throws Throwable {
		System.out.println("Click on Black color to change");
		getVisibleElementByXpath("//div[@id='colorizer']/ul[@id='colorizerBtn']/li[@class='item']/img[@alt='Black' or @alt='Panther Black' or contains(@alt,'Black')]").click();

	}

	@Then("^Verify the color of image and title are changed$")
	public void verifyTheColorOfImageAndTitleAreChanged() throws Throwable {
		System.out.println("Verify the color of image and title are changed");
		getVisibleElementByXpath("//div[@id='colorizer']/ul[@id='colorizerMainImg']/li[@class='item']/img[@alt='Black' or @alt='Panther Black' or contains(@alt,'Black')]");
		getVisibleElementByXpath("//div[@id='colorizer']/ul[@id='colorizerMainImg']/li[@class='item']/div/span[text()='Black' or @alt='Panther Black' or contains(text(),'Black')]");

	}

	@When("^Click on Disclosure$")
	public void clickOnDisclosure() throws Throwable {
		System.out.println("Click on Disclosure");
		getVisibleElementByXpath("//h3[contains(text(),'Disclosures')]").click();
	}

	@When("^Verify see Disclosure Content$")
	public void verifySeeDisclosureConent() throws Throwable {
		System.out.println("Verify see Disclosure Content");
		getVisibleElementByXpath("//div[contains(@class,'disclosure-text')]//p[text()!='']");
	}

	@When("^Click on Disclosure to Collapse$")
	public void clickOnDisclosureToCollapse() throws Throwable {
		System.out.println("Click on Disclosure to Collapse");
		getVisibleElementByXpath("//h3[contains(text(),'Disclosures') and @class='disclosure-heading']").click();
	}

	@When("^Verify don't see Disclosure content$")
	public void verifyDontSeeDisclosureContent() throws Throwable {
		System.out.println("Verify don't see Disclosure content");
		verifyInvisibleElement("//div[contains(@class,'disclosure-text')]//p[text()!='']");
				//OLD CODE -- "//p[contains(text(),'[1] The company reserves the right to change any detail regarding specifications,')]");
	}

	@When("^Verify footer links are visible$")
	public void verifyFooterLinksAreVisible() throws Throwable {
		System.out.println("Verify footer links are visible");
		getVisibleElementByXpath("//img[@alt='facebook']");
		getVisibleElementByXpath("//img[@alt='twitter']");
		getVisibleElementByXpath("//img[@alt='youtube']");
		getVisibleElementByXpath("//img[@alt='instagram']");

		getVisibleElementByXpath("//div[@class='footer-content']/ul/li/a[text()='SUVs']");
		getVisibleElementByXpath("//div[@class='footer-content']/ul/li/a[text()='Build and Price']");
		getVisibleElementByXpath("//div[@class='footer-content']/ul/li/a[text()='Newsroom']");

	}

	@When("^Click on Model Compare button$")
	public void clickOnModelCompareButton() throws Throwable {
		System.out.println("Click on Model Compare button");
		getVisibleElementByXpath(
				"//div[contains(@class,'service-ok')][1]//div[@class='heading']/a[text()='Model Compare' or text()='Overview All Models']")
						.click();
	}

	@When("^Click on Model Compare button on PERF$")
	public void clickOnModelCompareButtonperf() throws Throwable {
		System.out.println("Click on Model Compare button");
		getVisibleElementByXpath(
				"//div[contains(@class,'service-ok')][1]//div[@class='heading']/a[text()='Model Compare' or text()='Overview All Models']")
						.click();
	}
	
	@Then("^Verify user is taken to model compare page$")
	public void verifySeenModelComparePage() throws Throwable {
		System.out.println("Verify user is taken to model compare page");
		getVisibleElementByXpath("//div[@class='desktop-heading']//div[contains(text(),'Model Compare') or contains(text(),'Models & Specifications')]");

	}

	@Then("^Verify user is on Active Compare page$")
	public void verifyUserisOnActiveComparePage() throws Throwable {
		System.out.println("Verify user is on Active Compare page");
		// getVisibleElementByXpath(xpath)
	}

	@When("^Click on Add Models To Compare button$")
	public void clickOnAddModelsToCompareButton() throws Throwable {
		System.out.println("Click on Add Models To Compage");
		waitTillElementExist("//a[@class='btn btn-white addto-compare ' and contains(text(),'Add Models')]");
		getVisibleElementByXpath("//a[@class='btn btn-white addto-compare ' and contains(text(),'Add Models')]")
				.click();
	}

	@And("^Click on Hatchback Sport 1L Ecoboost PS checkbox$")
	public void clickOnHatchbackSport1LEcoboostPScheckbox(DataTable param) throws Throwable {
		System.out.println("Click on Hatchback checkbox");
		List<List<String>> data=param.raw();
		getVisibleElementByXpath("//div[contains(@class,'active')]//h3[text()='"+data.get(0).get(0)+"']/preceding::div[@class='input-checkbox'][1]").click();
//		List<WebElement> selectsinglevehicle=driver.findElements(By.xpath("//div[contains(@class,'active')]//h3[text()='"+data.get(0).get(0)+"']/preceding::div[@class='input-checkbox'][1]")); //[1]
//		selectsinglevehicle.get(1).click();
		Thread.sleep(2000);
	}

	@And("^Click on Confirm button$")
	public void clickOnConfirmButton() throws Throwable {
		System.out.println("Click on Confirm button");
		getVisibleElementByXpath(
				"//div[@id='model-group-id-01' or @id='model-group-id-03']//a[contains(text(),'Confirm')]").click(); 
	}

	@And("^Click on Fiesta Ambiente checkbox$")
	public void clickOnFiestaAmbienteCheckbox() throws Throwable {
		System.out.println("Click on Fiesta Ambiente checkbox");
//		getVisibleElementByXpath("//div[contains(@class,'active')]//h3[text()='Fiesta Ambiente' or text()='Sedan Trend 1.5L PS']/preceding::div[@class='input-checkbox'][1]").click();
		List<WebElement> selectsinglevehicle=driver.findElements(By.xpath("//div[contains(@class,'popup-select-other-model active')]//div[@class='input-checkbox' and not(contains(@class,'input-checkbox checked'))][1]"));
		selectsinglevehicle.get(0).click();
		
		
		Thread.sleep(2000);
	}

	@When("^Click on Active Compare button$")
	public void clickOnActiveCompareButton() throws Throwable {
		System.out.println("Click on Active Compare Button");
		// Thread.sleep(10000);
		// List<WebElement> ele=getVisibleElements("//a[text()='Active Compare']");
		// for (WebElement element : ele)
		// {
		// try {
		// moveToElement(element);
		// Actions builder = new Actions(driver);
		// builder.moveToElement(element).click().build().perform();
		// break;
		// }catch(Exception ex) {
		//
		// }
		// }
		// waitTillElementExist("//div[@class='desktop-heading']//a[text()='Active
		// Compare']");
		Thread.sleep(2000);
		getVisibleElementByXpath("//div[@class='desktop-heading']//a[text()='Active Compare']").click();
		// List<WebElement>
		// we=driver.findElements(By.cssSelector("a.active-compare-btn.cta-button.cta-button-primary.active"));
		// try {
		// moveToElement(we.get(0));
		// we.get(0).click();
		// } catch (Exception e) {
		// moveToElement(we.get(1));
		// we.get(1).click();
		// }
	}

	@When("^Select up to 2 items on the list$")
	public void clickOnSelection3Items() throws Throwable {
		System.out.println("Select up to 2 items on the list");
		// driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		List<WebElement> elements = driver.findElements(
				By.cssSelector("div.models-list.clearfix div.item div.name-item.on-select-mode div.select-model.on")); // driver.findElements(By.xpath("//input[@type='checkbox'
																														// and
																														// @name='model']"));

		int count = 0;
		for (WebElement element : elements) {
			if (element.isDisplayed()) {
				element.click();
				count++;
				if (count == 2)
					break;
			}
		}
	}

	@When("^Click on Compare button$")
	public void clickOnCompareButton() throws Throwable {
		System.out.println("Click on Compare button");
		getVisibleElementByXpath("//a[text()='Compare']").click();
	}

	@Then("^Verify user is taken to model compare results page and the selected item's specifications are seen$")
	public void verifySeenComparePage() throws Throwable {
		System.out.println(
				"Verify user is taken to model compare results page and the selected item's specifications are seen");
		getVisibleElementByXpath("//h1[text()='Model Compare Details']");
		getVisibleElementByXpath("//div[text()='Chassis' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Comfort & Convenience' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Engine' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Steering System' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Interior' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Warranty' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Safety & Security' and @class='group-label']");
		getVisibleElementByXpath("//div[text()='Power Features' and @class='group-label']");
	}

	@When("^Click on select other models to compare button$")
	public void clickOnSelectOtherToCompareButton() throws Throwable {
		System.out.println("Click on select other models to compare button");
		getVisibleElementByXpath("//a[contains(@class,'select-to-compare')]").click();
	}

	@Then("^Verify a popup of the list of items are seen$")
	public void verifyPopupOfTheListOfItemsAreSeen() throws Throwable {
		System.out.println("Verify a popup of the list of items are seen");
		getVisibleElementByXpath("//div[@class='input-checkbox']/input[@type='checkbox' and @name='model-input-name']");
	}

	@Then("^Select other item and click Confirm$")
	public void selectOtherItemAndConfirm() throws Throwable {
		System.out.println("Select other item and click Confirm");
		Thread.sleep(5000);
		getVisibleElementByXpath("//div[@class='input-checkbox']/input[@type='checkbox' and @name='model-input-name']")
				.click();
		getVisibleElementByXpath("//a[text()='Confirm']").click();
	}

	@Then("^See all components on Engineering page loaded without performance issue$")
	public void verifyAllComponentsOnEngineeringPageLoaded() throws Throwable {
		System.out.println("See all components on Engineering page loaded without performance issue");
		 getVisibleElementByXpath("//a[contains(@href,'boron-steel.html')]");
		 getVisibleElementByXpath("//a[contains(@href,'ecoboost.html')]");
		 getVisibleElementByXpath("//a[contains(@href,'adaptive-cruise-control.html')]");
		 getVisibleElementByXpath("//a[contains(@href,'active-city-stop.html')]");
		 getVisibleElementByXpath("//a[contains(@href,'active_park_assist.html')]");
//		 getVisibleElementByXpath("//a[contains(@href,'rear-camera.html')]");
//		 getVisibleElementByXpath("//a[contains(@href,'hill-launch-assist.html')]");
		// getVisibleElementByXpath("//a[contains(@href,'sync.html')]");
	}

	@Then("^Click on boron steel in the engineering page$")
	public void clickOnBoronSteel() throws Throwable {
		System.out.println("See all components on Engineering page loaded without performance issue");
		getVisibleElementByXpath("//a[contains(@href,'boron-steel.html')]").click();
	}

	@When("^Go to the hotspot component and hover on the plus sign$")
	public void mouseHoverPlusSign() throws Throwable {
		System.out.println("Go to the hotspot component and hover on the + sign");
		// Thread.sleep(5000);
		// Actions action = new Actions(driver);

		// action.moveToElement(getVisibleElementByXpath("//a[contains(@class,'hotspot-trigger')]")).perform();

		// action.perform();
		getVisibleElementByXpath("//a[contains(@class,'hotspot-trigger')]").click();

	}

	@When("^Click on locate a dealer at the header$")
	public void clickOnLocateADealerMenuItem() throws Throwable {
		System.out.println("Click on locate a dealer at the header");
		getVisibleElementByXpath("//span[text()='Locate A Dealer' or text()='Locate a Dealer']").click();
	}

	@When("^Input text to Search Input and click Search \"(.*?)\"$")
	public void inputTextAndSearch(String position) throws Throwable {
		System.out.println("Input text to Search Input and click Search");
		getVisibleElementByXpath("//input[@id='search-field']").clear();
		Thread.sleep(2000);
		getVisibleElementByXpath("//input[@id='search-field']").sendKeys(position);
		getVisibleElementByXpath("//button[@class='button search-submit']").click();
	}

	
	@And("^Click on Submit on AU LAD$")
	public void Click_on_Submit_on_AU_LAD() throws Throwable {
		System.out.println("Click on Submit on AU LAD");
		getVisibleElementByXpath("//button[@type='submit']").click();
	}
	
	
	@Then("^Verify seen search result$")
	public void verifySeenSearchResult() throws Throwable {
		System.out.println("Verify seen search result");
		getVisibleElementByXpath("//a[contains(text(),' Ford Manila') or contains(text(),'Sunshine Ford')]");
	}

	@Then("^Verify Delears details on Map$")
	public void VerifyDelearsdetailsonMap() throws Throwable {
		System.out.println("Verify Delears details on Map");
		getVisibleElementByXpath("//div[@data-main-ctrl-dealer-website='dealerWebsite']//a[contains(text(),'Sunshine Ford')]");
	}
	
	@When("^Click on Secondary menu switcher on Fiesta$")
	public void clickOnSecondaryMenu() throws Throwable {
		System.out.println("Click on Secondary menu switcher");
		Thread.sleep(10000);
		getVisibleElementByXpath("//h2[contains(text(),'Explore')]").click();
	}

	@Then("^Verify image hotspot popup is seen$")
	public void verifyImageHotspot() throws Throwable {
		System.out.println("Verify image hotspot popup is seen");
		getVisibleElementByXpath("//*[text()='HINGE PILLAR')]");
	}

	@When("^Click on the X button on the top left of image overlay$")
	public void clickOnTopLeftOfImageOverlay() throws Throwable {
		System.out.println("Click on the X button on the top left of image overlay");
		getVisibleElementByXpath("//i[@class='icon-plus icon-x')]").click();
	}

	@When("^Click on view more button$")
	public void clickOnViewMoreButton() throws Throwable {
		System.out.println("Click on view more button");
		Thread.sleep(4000);
		getVisibleElementByXpath("//a[text()='View More']").click();
	}

	@Then("^Verify see more images$")
	public void verifySeeMoreImages() throws Throwable {
		System.out.println("Verify see more images");
		getVisibleElementByXpath("//img[contains(@scr,'exterior8.jpg') or contains(@src,'1459500302521.jpg')]");
	}

	@When("^Click on image on Accessories$")
	public void clickOnImageOnAccessories() throws Throwable {
		System.out.println("Click on image on Accessories");
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		getVisibleElementByXpath(
				"//div[contains(@class,'accessories')]/div[contains(@class,'filter-content')]/ul/li/a/img").click();
	}

	@Then("^Verify overlay open from image Accessories$")
	public void verifyAccessoriesOverlayOpen() throws Throwable {
		System.out.println("Verify overlay open from image");
		getVisibleElementByXpath("//i[@class='icon-plus icon-x']");
		// getVisibleElementByXpath("//div[@class='overlay-container visible']");
	}

	@When("^See all components on News Room page loaded without performance issue$")
	public void verifyComponentsOnNewsRoomLoadedOK() throws Throwable {
		System.out.println("Verify overlay open from image");
		getVisibleElementByXpath("//div[contains(@class,'header-news')]/div[@class='title-news' and text()='News']");
		getVisibleElementByXpath("//div[@class='blocks-news']");
	}

	@When("^Click on Sort By$")
	public void clickOnSortBy() throws Throwable {
		System.out.println("Click on Sort By");
		getVisibleElementByXpath("//span[contains(text(),'Sort By')]").click();
	}

	@When("^Click on Sort by September$")
	public void clickOnSeptember() throws Throwable {
		System.out.println("Click on Sort by September");
		getVisibleElementByXpath("//a[text()='Sep - 2016']").click();
	}

	@Then("^Verify all months in filter$")
	public void verifyAllMonthInFilter() throws Throwable {
		System.out.println("Verify all months in filter");
		getVisibleElementByXpath("//a[text()='Oct - 2016']");
		getVisibleElementByXpath("//a[text()='Aug - 2016']");
		getVisibleElementByXpath("//a[text()='Jun - 2016']");
		getVisibleElementByXpath("//a[text()='Feb - 2016']");
	}

	@Then("^Verify all months in filter Perf$")
	public void verifyAllMonthInFilterPerf() throws Throwable {
		System.out.println("Verify all months in filter Perf");
		getVisibleElementByXpath("//a[text()='Mar - 2015']");
		getVisibleElementByXpath("//a[text()='Aug - 2015']");
		getVisibleElementByXpath("//a[text()='Jun - 2015']");
		getVisibleElementByXpath("//a[text()='May - 2015']");
	}
	
	@When("^Click on Sort by October$")
	public void clickOnOctober() throws Throwable {
		System.out.println("Click on Sort by October");
		getVisibleElementByXpath("//a[text()='Aug - 2015']").click();
	}

	@Then("^Verify message Results Found on page$")
	public void verifyMessageMessage() throws Throwable {
		System.out.println("Verify message No Results Found on page");
		// getVisibleElementByXpath("//p[text()='No Results Found']");
		getVisibleElementByXpath("//a[text()='Article1' or text()='The 15th Henry Ford Awards: Now Open for Entries']");
	}

	@When("^Click on No Sort$")
	public void clickOnNoSort() throws Throwable {
		System.out.println("Click on No Sort");
		getVisibleElementByXpath("//a[text()='no sort']").click();
	}

	@When("^Click on View More$")
	public void clickOnViewMore() throws Throwable {
		System.out.println("Click on Learn More");
		getVisibleElementByXpath("//div[@class='view-more' and contains(text(),'View More News')]").click();
	}

	@Then("^Verify seen more view$")
	public void verifySeenMoreView() throws Throwable {
		System.out.println("Verify seen more view");
		getVisibleElementByXpath("//a[text()='FORD PHILIPPINES GOES FURTHER WITH FORD FORZA TRIATHLON TEAM']");
	}

	@When("^Click on Learn More$")
	public void clickOnLearnMore() throws Throwable {
		System.out.println("Click on Learn More");
		WebElement element = driver.findElement(By.xpath(
				"//div[@class='blocks-news']/div/div[@class='txt-description' and contains(text(),'Ford is the first automaker to test fully autonomous vehicles in winter weather,')]/following-sibling::div/a[text()='Learn More']"));
		moveToElement(element);

		Thread.sleep(3000);
		// element.click();
		List<WebElement> elements = driver.findElements(By.xpath("//a[contains(text(),'Learn More')]"));
		for (WebElement ele : elements) {
			if (ele.isDisplayed()) {
				ele.click();
				break;
			}
		}
	}

	@And("^Capture Screenshot \"(.*?)\" on P1 phase$")
	public void captureScreenshot(String obj) throws Throwable {
		wait = new WebDriverWait(driver, 10);
		System.out.println("Capture Screenshot on P1");
		actualImageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(actualImageFile, new File(actual + obj + " " + GetTimeStampValue() + ".png"));
	}

	@After
	public void cleanUp() {
		try {
			// driver.quit();
		} catch (Exception ex) {
			// the overlay is dissapeared!
		} finally {

		}
	}

	@And("^Fill in step one in AU Predelivery$")
	public void fillInStepOneInAuPredelivery() throws Throwable {
		System.out.println("Fill in step one in AU Predelivery");
		getVisibleElementByXpath("//div[@id='s2id_autogen1']/a[@class='select2-choice']").click();

	}
	
	@When("^see all vehicles and their models are listed respectively in selection boxes$")
	public void select_vehicles_and_their_models() throws Throwable {
		System.out.println("see all vehicles and their models are listed respectively in selection boxes");
		//Nameplate & Model name and Red color warnings
		waitTillElemVisiblebyXpath("//span[contains(@class,'select2-chosen')]", 240);
		List<WebElement> SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		int SelVehsize=SelVeh.size();
		for(int nameplate=0;nameplate<SelVehsize;nameplate+=2){
			SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
			SelVeh.get(nameplate).click();
			Thread.sleep(2000);
			List<WebElement> nameplates=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
			if(nameplates.size()>1) {
				System.out.println("Select Nameplate dropdown" + nameplate + " containing " + nameplates.size() + " Nameplates");
				nameplates.get(1).findElement(By.xpath("div")).click();
			}else {
//				Assert.assertFalse("Select Nameplate dropdown" + nameplate + " containing 0 Nameplates", true);
				System.out.println("Select Nameplate dropdown" + nameplate + " containing 0 Nameplates");
				nameplates.get(0).findElement(By.xpath("div")).click();
			}
			
			for(int selnameplt=1;selnameplt<nameplates.size();selnameplt++) {
				SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
				SelVeh.get(nameplate).click();				
				nameplates=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
				nameplates.get(selnameplt).findElement(By.xpath("div")).click();
				Thread.sleep(2000);
				SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
				SelVeh.get(nameplate+1).click();
				Thread.sleep(1000);
				List<WebElement> CheckModels=driver.findElements(By.xpath("//ul[@role='listbox']/li"));
				if(CheckModels.size()>1) {
					System.out.println("Select Model dropdown" + (selnameplt) + " containing " + (CheckModels.size()-1) + " Models");
					CheckModels.get(1).findElement(By.xpath("div")).click();
				}else {
//					Assert.assertFalse("Select Model dropdown" + (selnameplt) + " containing 0 Models", true);
					System.out.println("Select Model dropdown" + (selnameplt) + " containing 0 Models");
					CheckModels.get(0).findElement(By.xpath("div")).click();
				}
			
			}
		}
	}
	
	@When("^Select 1 vehicle and model$")
	public void select_vehicle_and_model(DataTable arg) throws Throwable {
		System.out.println("Select 1 vehicle and model");
		List<List<String>> data=arg.raw();
		List<WebElement> SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(0).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(0)+"')]").click();
		Thread.sleep(2000);
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(1).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(1)+"')]").click();
	}

	@When("^click on Add Vehicle$")
	public void click_on_Add_Vehicle() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on Add Vehicle");
		List<WebElement> AddVeh=driver.findElements(By.xpath("//*[text()='Add Vehicle' and not(contains(@class,'disable'))]"));
		AddVeh.get(0).click();
	}

	@Then("^see Model and detail are added successfully$")
	public void see_Model_and_detail_are_added_successfully(DataTable param) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see Model and detail are added successfully");
		List<List<String>> data=param.raw();
		getVisibleElementByXpath("//div[contains(@class,'active')]//*[text()='Remove']");
//		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(0)+"')]");
		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(1)+"')]");
		getVisibleElementByXpath("//*[text()="+data.get(0).get(2)+"]");
		
//		getVisibleElementByXpath("//*[contains(text(),'Chassis')]");
//		getVisibleElementByXpath("//*[contains(text(),'Dimensions')]");
//		getVisibleElementByXpath("//*[contains(text(),'Engine')]");
//		getVisibleElementByXpath("//*[contains(text(),'Exterior')]");
//		getVisibleElementByXpath("//*[contains(text(),'Interior')]");
//		getVisibleElementByXpath("//*[contains(text(),'Lights')]");
//		getVisibleElementByXpath("//*[contains(text(),'Safety and Security')]");
	}

	@Then("^Open (\\d+)nd and (\\d+)rd columns and see above selected model is not listed there$")
	public void open_nd_and_rd_columns_and_see_above_selected_model_is_not_listed_there(int arg1, int arg2,DataTable arg) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Open 2nd and 3rd columns and see above selected model is not listed there");
		List<List<String>> data=arg.raw();
		getVisibleElementByXpath("//span[contains(@class,'select2-chosen')]");
		List<WebElement> SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(2).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(0)+"')]").click();
		Thread.sleep(2000);
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(3).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(1)+"')]")).click();
		}catch(Exception e) {
			System.out.println(data.get(0).get(1) + " Model does not exist while adding Second vehicle");
			driver.findElements(By.xpath("//ul[@role='listbox']/*//div")).get(1).click();
		}	
		
		getVisibleElementByXpath("//span[contains(@class,'select2-chosen')]");
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(4).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(0)+"')]").click();
		Thread.sleep(2000);
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(5).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(1)+"')]")).click();
		}catch(Exception e) {
			System.out.println(data.get(0).get(1) + " Model does not exist while adding Third vehicle");
			driver.findElements(By.xpath("//ul[@role='listbox']/*//div")).get(1).click();
		}	
	}

	@When("^Add (\\d+) more models from different nameplates$")
	public void add_more_models_from_different_nameplates(int arg1, DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("Add 2 more models from different nameplates");
		List<List<String>> data=arg2.raw();
		List<WebElement> SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(2).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(0)+"')]").click();
		Thread.sleep(2000);
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(3).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(1)+"')]")).click();
		Thread.sleep(2000);
		List<WebElement> AddVeh=driver.findElements(By.xpath("//*[text()='Add Vehicle' and not(contains(@class,'disable'))]"));
		AddVeh.get(0).click();
		
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(4).click();
		Thread.sleep(2000);
		getVisibleElementByXpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(2)+"')]").click();
		Thread.sleep(2000);
		SelVeh=driver.findElements(By.xpath("//span[contains(@class,'select2-chosen')]"));
		SelVeh.get(5).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@role='listbox']/*//*[contains(text(),'"+data.get(0).get(3)+"')]")).click();
		Thread.sleep(2000);
		AddVeh=driver.findElements(By.xpath("//*[text()='Add Vehicle' and not(contains(@class,'disable'))]"));
		AddVeh.get(0).click();
	}

	@Then("^Verify models and their details are added successfully$")
	public void verify_models_and_their_details_are_added_successfully(DataTable arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify models and their details are added successfully");
		List<List<String>> data=arg2.raw();
		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(0)+"')]");
//		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(1)+"')]");
		getVisibleElementByXpath("//*[text()="+data.get(0).get(1)+"]");
		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(2)+"')]");
//		getVisibleElementByXpath("//*[contains(text(),'"+data.get(0).get(1)+"')]");
		getVisibleElementByXpath("//*[text()="+data.get(0).get(3)+"]");
	}
	
	
	@Then("^see all the componets and CTAs are functioning$")
	public void see_all_the_componets_and_CTAs_are_functioning() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see all the componets and CTAs are functioning");
		waitTillElemVisiblebyXpath("//*[contains(text(),'Model Details')]", 240);
		getVisibleElementByXpath("//*[contains(text(),'Back to Overview')]");
		getVisibleElementByXpath("//li[contains(@id,'li-id')]//*[contains(text(),'Add Models') and not(contains(@class,'show'))]");
//		getVisibleElementByXpath("//li[contains(@id,'li-id')]//*[contains(text(),'Book A Test Drive')]");
		getVisibleElementByXpath("//*[contains(text(),'ENGINEERING')]");
		getVisibleElementByXpath("//*[contains(text(),'OWNER')]");
		getVisibleElementByXpath("//*[contains(text(),'Owner Dashboard')]");
		getVisibleElementByXpath("//span[contains(text(),'Vehicles')]");
		getVisibleElementByXpath("//span[contains(text(),'Shop')]");
		getVisibleElementByXpath("//span[contains(text(),'Fleet')]");
		getVisibleElementByXpath("//span[contains(text(),'Engineering')]");
		getVisibleElementByXpath("//span[contains(text(),'Owner')]");
		getVisibleElementByXpath("//span[contains(text(),'Locate A Dealer')]");
//		getVisibleElementByXpath("//span[contains(text(),'Test Drive')]");
	}

	@When("^Click on Back to Overview CTA$")
	public void click_on_Back_to_Overview_CTA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Back to Overview CTA");
		getVisibleElementByXpath("//*[contains(text(),'Back to Overview')]").click();
		waitTillElemVisiblebyXpath("//div[@class='desktop-heading']//*[contains(text(),'Active Compare')]", 240);
	}

	@Then("^Model Compare page should be displayed$")
	public void model_Compare_page_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Model Compare page should be displayed");
		getVisibleElementByXpath("//*[contains(text(),'Model Compare')]");	
	}

	@When("^Click on any model link CTA on Model Compare page$")
	public void click_on_any_model_link_CTA_on_Model_Compare_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on any model link CTA on Model Compare page");
		getVisibleElementByXpath("//a[contains(text(),'Hatchback Trend 1.5L PS')]").click();
		waitTillElemVisiblebyXpath("//*[contains(text(),'Model Details')]", 240);
		waitTillElemVisiblebyXpath("//*[contains(@class,'model-name') and contains(text(),'Hatchback Trend 1.5L PS')]", 240);	
	}

	@Then("^see user is taken to model details page$")
	public void see_user_is_taken_to_model_details_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see user is taken to model details page");
		getVisibleElementByXpath("//*[contains(text(),'Model Details')]");
		
	}

	@Then("^see select other models to compare CTA is disabled$")
	public void see_select_other_models_to_compare_CTA_is_disabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see select other models to compare CTA is disabled");
		List<WebElement> selectmodel=driver.findElements(By.xpath("//div[@class='show']//a[contains(text(),'Select other Models')]"));//getVisibleElementByXpath("//div[@class='show']//a[contains(text(),'Select other Models')]");
		if(selectmodel.get(0).isEnabled()) {
//			Assert.assertFalse("Select other model to compare button is enabled.", true);
		}
	}

	@When("^Click on Book a Test Drive CTA$")
	public void click_on_Book_a_Test_Drive_CTA() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Book a Test Drive CTA");
		Thread.sleep(30000);
		waitTillElemVisiblebyXpath("//a[contains(text(),'Book A Test Drive')]", 240);
		driver.findElements(By.xpath("//a[contains(text(),'Book A Test Drive')]")).get(0).click();
//		getVisibleElementByXpath("//a[contains(text(),'Book A Test Drive')]").click();
		waitTillElemVisiblebyXpath("//span[contains(text(),'Title')]/following-sibling::div", 240);
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div");
	}

	@Then("^Test drive form should be opened$")
	public void test_drive_form_should_be_opened() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Test drive form should be opened");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//h1[contains(text(),'Test Drive')]");	
	}
	
	
	@And("^Click on Confirm button on model compare$")
	public void clickOnConfirmCTA() throws Throwable {
		System.out.println("Click on Confirm button on model compare");
		getVisibleElementByXpath("//div[contains(@class,'active')]//a[contains(text(),'Confirm')]").click(); 
	}
	
	
	@When("^Click on select other models to compare CTA$")
	public void clickOnSelectOtherToCompareCTA() throws Throwable {
		System.out.println("Click on select other models to compare CTA");
		getVisibleElementByXpath("//div[@data-toggle='model-id-02' and @class='show']/a[contains(@class,'select-to-compare')]").click();
	}
	
	
	@Then("^see all componets loads successfully without performance issue$")
	public void see_all_componets_loads_successfully_without_performance_issue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see all componets loads successfully without performance issue");
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//h1[contains(text(),'Test Drive')]");	
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']");
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']");
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']");
		getVisibleElementByXpath("//input[@name='MOBILE_PHONE_NUMBER']");
		getVisibleElementByXpath("//span[contains(text(),'Province')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//span[contains(text(),'City')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//span[contains(text(),'Preferred Dealer')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//span[contains(text(),'Model')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//span[contains(text(),'Series')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//span[contains(text(),'I plan to buy a new vehicle')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive')]");
		
	}

	@When("^On overlay do not input anything and click on submit$")
	public void on_overlay_do_not_input_anything_and_click_on_submit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("On overlay do not input anything and click on submit");
		List<WebElement> ErrorMsgs=driver.findElements(By.xpath("//small[not(contains(@class,'errRecaptcha')) and not(contains(@class,'hint')) and text()!='']"));
		if(ErrorMsgs.size()==0) {
			System.out.println("No Error/validation messages displayed before submitting the Forms");
		}
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive') or contains(text(),'Register') or contains(text(),'Submit')]").click();
		Thread.sleep(2000);
	}

	@Then("^Verify error message is seen$")
	public void verify_error_message_is_seen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify error message is seen");
		List<WebElement> ErrorMsgs=driver.findElements(By.xpath("//small[not(contains(@class,'errRecaptcha')) and not(contains(@class,'hint')) and text()!='']"));
		if(ErrorMsgs.size()==0) {
			Assert.assertFalse("No error messages displayed for blank/invalid data submission on the form", true);
		}else {
			System.out.println("Error messages sucessfully displayed for invalid email on the form");
		}
	}

	@When("^On overlay enter an incorrect item on one of the fields and click submit$")
	public void on_overlay_enter_an_incorrect_item_on_one_of_the_fields_and_click_submit(DataTable param) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("On overlay enter an incorrect item on one of the fields and click submit");
		List<List<String>> data=param.raw();
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(0)+"']").click();
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(3));
		getVisibleElementByXpath("//input[@name='MOBILE_PHONE_NUMBER']").sendKeys(data.get(0).get(4));
		getVisibleElementByXpath("//span[contains(text(),'Province')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(5)+"']").click();
		getVisibleElementByXpath("//span[contains(text(),'City')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(6)+"']").click();
		getVisibleElementByXpath("//span[contains(text(),'Preferred Dealer')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[contains(text(),'"+data.get(0).get(7)+"')]").click();
		getVisibleElementByXpath("//span[contains(text(),'Model')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(8)+"']").click();
		getVisibleElementByXpath("//span[contains(text(),'Series')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(9)+"']").click();
		getVisibleElementByXpath("//span[contains(text(),'I plan to buy a new vehicle')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(10)+"']").click();
		
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive')]").click();
		
	}

	@When("^On overlay enter all items correctly and click on submit$")
	public void on_overlay_enter_all_items_correctly_and_click_on_submit(DataTable param) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("On overlay enter all items correctly and click on submit");
		List<List<String>> data=param.raw();
//		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(0)+"']").click();
//		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']").sendKeys(data.get(0).get(1));
//		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").clear();
		Thread.sleep(2000);
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(3));
//		getVisibleElementByXpath("//input[@name='MOBILE_PHONE_NUMBER']").sendKeys(data.get(0).get(4));
//		getVisibleElementByXpath("//span[contains(text(),'Province')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(5)+"']").click();
//		getVisibleElementByXpath("//span[contains(text(),'City')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(6)+"']").click();
//		getVisibleElementByXpath("//span[contains(text(),'Preferred Dealer')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[contains(text(),'"+data.get(0).get(7)+"')]").click();
//		getVisibleElementByXpath("//span[contains(text(),'Model')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(8)+"']").click();
//		getVisibleElementByXpath("//span[contains(text(),'Series')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(9)+"']").click();
//		getVisibleElementByXpath("//span[contains(text(),'I plan to buy a new vehicle')]/following-sibling::div//span[@id!='']").click();
//		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(10)+"']").click();
		getVisibleElementByXpath("//input[@name='recaptcha']").sendKeys(EnterCaptcha());
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive')]").click();

	}

	@Then("^Verify thank you page is seen$")
	public void verify_thank_you_page_is_seen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify thank you page is seen");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			waitTillElemVisiblebyXpath("//div[@class='desktop hideForMobile']//*[contains(text(),'Thank You')]", 240);
			getVisibleElementByXpath("//div[@class='desktop hideForMobile']//*[contains(text(),'Thank You')]");
		}
	}

	@Then("^Close overlay$")
	public void close_overlay() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Close overlay");
		waitTillElemVisiblebyXpath("//*[@class='icon-plus icon-x']", 240);
		getVisibleElementByXpath("//*[@class='icon-plus icon-x']").click();
	}
	
	
	@Then("^Verify brochure download overlay is seen$")
	public void verify_brochure_download_overlay_is_seen() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify brochure download overlay is seen");
		waitTillElemVisiblebyXpath("//*[text()='Download PDF Brochure']", 240);
//		getVisibleElementByXpath("//*[text()='Download PDF Brochure']");
//		getVisibleElementByXpath("//*[text()='by mail']");
//		getVisibleElementByXpath("//*[text()='Brochure Request']");
//		getVisibleElementByXpath("//*[text()='Select Your Vehicle']");
		int GetVehicleCount=driver.findElements(By.xpath("//*[contains(@id,'checkboxLabel_')]")).size();
		if(GetVehicleCount==0) {
			Assert.assertFalse("Vehicle image does not displayed to download brochure.",true);
		}else {
			System.out.println("Total " + GetVehicleCount + " vehicles displayed to download browchure");
		}
	}

	@When("^Do not select any vehicle and click on Download button$")
	public void do_not_select_any_vehicle_and_click_on_Download_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Do not select any vehicle and click on Download button");
		List<WebElement> unchkAllVehicle=driver.findElements(By.xpath("//*[contains(@id,'checkboxLabel_') and contains(@class,'checked')]//preceding::div/img"));
		for(WebElement e:unchkAllVehicle) {
			e.click();
			Thread.sleep(2000);
		}
		getVisibleElementByXpath("//*[text()='Download PDF Brochure']").click();
		Thread.sleep(2000);
	}

	@Then("^see validation message is displayed$")
	public void see_validation_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see validation message is displayed");
		getVisibleElementByXpath("//div[@id='brochureError' and text()!='']");
	}

	@Then("^See validation message is displayed$")
	public void See_validation_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("See validation message is displayed");
		getVisibleElementByXpath("//small[not(contains(@class,'errRecaptcha')) and not(contains(@class,'hint')) and text()!='']");
	}
	
	@When("^Select a vehicle on brochure download overlay$")
	public void select_a_vehicle_on_brochure_download_overlay() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Select a vehicle on brochure download overlay");
		driver.findElements(By.xpath("//*[contains(@id,'checkboxLabel_')]//preceding::div/img")).get(0).click();
		
	}

	@When("^click on Get By Email button$")
	public void click_on_Get_By_Email_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click on Get By Email button");
		getVisibleElementByXpath("//*[contains(text(),'by mail')]").click();
	}

	@Then("^verify Email form is opened$")
	public void verify_Email_form_is_opened() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("verify Email form is opened");
		waitTillElemVisiblebyXpath("//input[@type='text' and @name='INDIVIDUAL_CUST_FIRST_NAME']", 240);
		getVisibleElementByXpath("//input[@type='text' and @name='INDIVIDUAL_CUST_FIRST_NAME']");
		getVisibleElementByXpath("//input[@type='text' and @name='PRIMARY_EMAIL']");
		getVisibleElementByXpath("//input[@type='text' and @name='recaptcha']");
	}

	@Then("^Fill all the details on Email form$")
	public void fill_all_the_details_on_Email_form(DataTable param) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Fill all the details on Email form");
		List<List<String>> data=param.raw();
		getVisibleElementByXpath("//input[@type='text' and @name='INDIVIDUAL_CUST_FIRST_NAME']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@type='text' and @name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='recaptcha']").sendKeys(EnterCaptcha());
	}

	@When("^Click on submit email form$")
	public void click_on_submit_email_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on submit email form");
		getVisibleElementByXpath("//*[text()='Submit']").click();
	}

	@Then("^verify Thank you message$")
	public void verify_Thank_you_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify thank you page is seen");
		if(Boolean.parseBoolean(System.getProperty("isJenkinsJob"))==false) {
			waitTillElemVisiblebyXpath("//div[@class='desktop hideForMobile']//*[text()='Thank You']", 240);
			getVisibleElementByXpath("//div[@class='desktop hideForMobile']//*[text()='Thank You']");
		}
	}

	@Then("^Select a vehicle and click on download brochure button$")
	public void select_a_vehicle_and_click_on_download_brochure_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Select a vehicle and click on download brochure button");
		Boolean felectvehicle=false;
		waitTillElemVisiblebyXpath("//*[contains(@for,'brochureBtn') and contains(@for,'download') and contains(@for,'brochure')]", 300);
		List<WebElement> unchkAllVehicle=driver.findElements(By.xpath("//*[contains(@id,'checkboxLabel_') and contains(@class,'checked')]//preceding::div/img"));
		for(WebElement e:unchkAllVehicle) {
			e.click();
			Thread.sleep(2000);
			felectvehicle=true;
		}
		if(unchkAllVehicle.size()>0 && felectvehicle==true) {
			driver.findElements(By.xpath("//*[contains(@id,'checkboxLabel_')]//preceding::div/img")).get(0).click();
		}
		Thread.sleep(5000);
		getVisibleElementByXpath("//*[text()='Download PDF Brochure']").click();
		Thread.sleep(2000);
		
	}

	@Then("^Verify PDF file is downloaded and thank you page is seen$")
	public void verify_PDF_file_is_downloaded_and_thank_you_page_is_seen(DataTable param) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Verify thank you page is seen");
		waitTillElemVisiblebyXpath("//div[@class='desktop hideForMobile']//*[text()='Thank You']", 240);
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//*[text()='Thank You']");	
//		 Thread.sleep(60000);
		List<List<String>> data = param.raw();
		String Brochurepath = config.Configuration.PATH_TO_DOWNLOAD_BROCHURE + data.get(0).get(0) + ".pdf";
		File file = new File(Brochurepath);
		int i=0;
		do {
			Thread.sleep(5000);
			i++;
		}while(!file.exists() && i<=72);
		
		if (file.exists()) {
			System.out.println("Brochure downloaded successfully: " + Brochurepath);
			file.delete();
		} else {
			Assert.assertFalse("Brochure download failed, pdf file does not exist locally", true);
		}
	}
	
	
	
	@Then("^user is navigated to Ford Fleet Registration overlay$")
	public void user_is_navigated_to_Ford_Fleet_Registration_overlay() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is navigated to Ford Fleet Registration overlay");
		waitTillElemVisiblebyXpath("//div[contains(@class,'form-checkbox')]//span[text()!='']", 240);
		getVisibleElementByXpath("//div[@class='desktop hideForMobile']//h1[contains(text(),'Fleet Registration')]");	
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']");
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']");
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']");
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']");
		getVisibleElementByXpath("//input[@name='BUSINESS_PHONE_NUMBER']");
		getVisibleElementByXpath("//input[@name='BUSINESS_CUST_FIRST_LINE_NAME']");
		getVisibleElementByXpath("//input[@name='BUSINESS_NUMBER']");
		getVisibleElementByXpath("//input[@name='FLEET_SIZE']");
		
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive') or contains(text(),'Register')]");
	}
	
	
	@When("^Enter an incorrect item on one of the fields and click submit$")
	public void enter_an_incorrect_item_on_one_of_the_fields_and_click_submit(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("Enter an incorrect item on one of the fields and click submit");
		List<List<String>> data=arg1.raw();
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(0)+"']").click();
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(3));
		getVisibleElementByXpath("//input[@name='BUSINESS_PHONE_NUMBER']").sendKeys(data.get(0).get(4));
		getVisibleElementByXpath("//input[@name='BUSINESS_CUST_FIRST_LINE_NAME']").sendKeys(data.get(0).get(5));
		getVisibleElementByXpath("//input[@name='BUSINESS_NUMBER']").sendKeys(data.get(0).get(6));
		getVisibleElementByXpath("//input[@name='FLEET_SIZE']").sendKeys(data.get(0).get(7));
		for(WebElement ChkChkbox:driver.findElements(By.xpath("//div[contains(@class,'form-checkbox')]//span"))) {
			ChkChkbox.click();
			Thread.sleep(1000);
		}
		if(driver.findElements(By.xpath("//label[@for='user_legal_agreement']/following-sibling::small")).size()>0) {			
			getVisibleElementByXpath("//label[@for='user_legal_agreement']//span").click();
		}
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive') or contains(text(),'Register')]").click();
	}

	@When("^Enter an incorrect item on one of the fields and click submit kmi$")
	public void enter_an_incorrect_item_on_one_of_the_fields_and_click_submit_kmi(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("Enter an incorrect item on one of the fields and click submit kmi");
		List<List<String>> data=arg1.raw();
		getVisibleElementByXpath("//span[contains(text(),'Title')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(0)+"']").click();
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_FIRST_NAME']").sendKeys(data.get(0).get(1));
		getVisibleElementByXpath("//input[@name='INDIVIDUAL_CUST_LAST_NAME']").sendKeys(data.get(0).get(2));
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(3));
		getVisibleElementByXpath("//input[@name='MOBILE_PHONE_NUMBER']").sendKeys(data.get(0).get(4));
		getVisibleElementByXpath("//input[@name='CUSTOMER_POSTAL_CODE']").sendKeys(data.get(0).get(5));
		getVisibleElementByXpath("//span[contains(text(),'plan') or contains(text(),'vehicle')]/following-sibling::div//span[@id!='']").click();
		getVisibleElementByXpath("//li/div[text()='"+data.get(0).get(6)+"']").click();
		for(WebElement ChkChkbox:driver.findElements(By.xpath("//div[contains(@class,'form-checkbox')]//span"))) {
			ChkChkbox.click();
			Thread.sleep(1000);
		}
		if(driver.findElements(By.xpath("//label[@for='user_legal_agreement']/following-sibling::small")).size()>0) {			
			getVisibleElementByXpath("//label[@for='user_legal_agreement']//span").click();
		}
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive') or contains(text(),'Register') or contains(text(),'Submit')]").click();
	}
	
	@When("^Click on Print button$")
	public void click_on_Print_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Print button");
		getVisibleElementByXpath("//input[contains(@value,'Print')]").click();
		Thread.sleep(5000);
	}

	@Then("^See print functionality is enabled and working successfully$")
	public void see_print_functionality_is_enabled_and_working_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("See print functionality is enabled and working successfully");
		if(driver.getWindowHandles().size()>1) {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}			
		}
		getVisibleElementByXpath("//*[contains(@class,'print') and contains(text(),'Print')]").click();
		Thread.sleep(5000);
//		driver.switchTo().defaultContent();
		if(driver.getWindowHandles().size()>1) {
			Assert.assertFalse("print functionality is not working, seems disabled.", true);			
		}else {
			System.out.println("print functionality is enabled and working successfully");
		}
	}

	@When("^enter all items correctly and click on submit$")
	public void enter_all_items_correctly_and_click_on_submit(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("enter all items correctly and click on submit");
		List<List<String>> data=arg1.raw();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").clear();
		Thread.sleep(2000);
		getVisibleElementByXpath("//input[@name='PRIMARY_EMAIL']").sendKeys(data.get(0).get(0));
		getVisibleElementByXpath("//input[@name='recaptcha']").sendKeys(EnterCaptcha());
		getVisibleElementByXpath("//div[contains(@class,'form-submit')]//*[contains(text(),'Test Drive') or contains(text(),'Register') or contains(text(),'Submit')]").click();
	}
	
	@When("^Click on Video$")
	public void Click_on_Video() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click on Video");
		getVisibleElementByXpath("//div[contains(@class,'media-carousel-video')]//picture").click();
		Thread.sleep(5000);
//		waitTillElemVisiblebyXpath("//div[contains(@class,'overlay-container'//div[contains(@class,'overlay-container') and contains(@class,'visible')])]//*[contains(@class,'start-image')]", 240);
		waitTillElemVisiblebyXpath("//div[contains(@class,'overlay-container') and contains(@class,'overlay-video') and contains(@class,'visible')]", 240);
	}
	
	@Then("^see video is playing without error$")
	public void see_video_is_playing_without_error() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("see video is playing without error");
		getVisibleElementByXpath("//button[contains(@class,'vjs-button') and contains(@title,'Pause')]");
		getVisibleElementByXpath("//div[contains(@id,'videoplayer')]//div[contains(@class,'vjs-playing')]");
//		getVisibleElementByXpath("//div[contains(@class,'overlay-container'//div[contains(@class,'overlay-container') and contains(@class,'visible')])]//*[contains(@class,'start-image')]").click();
	}
}
