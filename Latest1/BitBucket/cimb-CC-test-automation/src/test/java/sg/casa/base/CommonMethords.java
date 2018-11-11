package sg.casa.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.ford.automation.base.BaseTest;
import com.google.common.io.Files;

import net.serenitybdd.core.annotations.findby.By;

public class CommonMethords extends BaseTest{

	
//User click on Application Information Panels
	//User click on Contact Information Panel
	public static  String ApplicationInformation_ContactInformation_PanelClick () {	
		String xpath = ".//*[@id='form-box-2']/div/div[1]/h2/span[1]";
		return xpath;//form[contains(@name,'vm.formJI')]//*[@id='form-box-1']/div/div[1]/h2/span[1]
	}
	
	//User click on Contact Information Panel
	public static  String ApplicationInformation_AddressInformation_PanelClick () {	
		String xpath = ".//*[@id='form-box-3']/div/div[1]/h2/span[1]";
		return xpath;
	}
	
	//User click on Job Information Panel
	public static  String ApplicationInformation_JobInformation_PanelClick () {	
		String xpath = ".//*[@id='form-box-4']/div/div[1]/h2/span[1]";
		return xpath;
	}

	//User click on Account Preferences Panel
	public static  String ApplicationInformation_AccountPreferences_PanelClick () {	
		String xpath = ".//*[@id='form-box-5']/div/div[1]/h2/span[1]";
		return xpath;
	}
	
//User click on Your Declaration Button	
	public static  String ApplicationInformation_YourDeclerationButtonClick () {	
		String xpath = SG_CASA_UI_Elements.YourDeclaration_Button;
		return xpath;
	}
	
	//User click on Upload Doc Button	
		public static  String ApplicationInformation_uploaddocButtonClick () {	
			String xpath = SG_CASA_UI_Elements.UploadDoc_Button;
			return xpath;
		}
	
		
		//User click on Processing Page Submit Feedback - Arpit
			public static void SubmitFeedbackClick (WebDriver driver) {	
				driver.findElement(org.openqa.selenium.By.xpath((SG_CASA_UI_Elements.ProcessingPage_SubmitFeedback))).click();
			}
			
		//User click on Review Submit Button - Arpit	
			public static  String BeforeYouSubmit_ReviewSubmitButtonClick () {	
				String xpath = SG_CASA_UI_Elements.ReviewSubmitButton;
				return xpath;
			}

//Need to Refactor..................	
	public static  String Joint_ApplicationInformation_PersonalInformation_PanelClick () {	
		String xpath = "//form[contains(@name,'vm.formJI')]//*[@id='form-box-1']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	public static  String Joint_ApplicationInformation_ContactInformation_PanelClick () {	
		String xpath = "//form[contains(@name,'vm.formJI')]//*[@id='form-box-2']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	public static  String Joint_ApplicationInformation_AddressInformation_PanelClick () {	
		String xpath = "//form[contains(@name,'vm.formJI')]//*[@id='form-box-3']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	public static  String Joint_ApplicationInformation_JobInformation_PanelClick () {	
		String xpath = "//form[contains(@name,'vm.formJI')]//*[@id='form-box-4']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	public static  String Joint_ApplicationInformation_AccountPreferences_PanelClick () {	
		String xpath = "//form[contains(@name,'vm.formJI')]//*[@id='form-box-5']/div/div[1]/h2/span[1]";
		return xpath;
	}

//Cross Sell
//User click on Fixed Deposit Panel
	public static  String CrossSell_FixedDeposit_PanelClick () {	
		String xpath = ".//*[@id='form-box-8']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	
//User click on Credit Panel
	public static  String CrossSell_Credit_PanelClick () {	
		String xpath = ".//*[@id='form-box-6']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	
//User click on Supplementary Card
	public static  String CrossSell_SupplementaryCard_PanelClick() {	
		String xpath = ".//*[@id='form-box-7']/div/div[1]/h2/span[1]";
		return xpath;
	}	
	
	//Get String Value
	public static String GetNumbersConvertToStringValue (Double number) {	
	//	String text = Double.toString(number).split("\\.")[0];
		int i = Integer.valueOf(number.intValue());
		return String.valueOf(i);
	}
	
	//Select Dropdown Value
	public static void SelectDropdown (String ElementPath, String selectValue, WebDriver driver) {	
		//WebDriver driver = null;
	 	// @SuppressWarnings("null")
		Select SelecEelement =new Select(driver.findElement(By.xpath(ElementPath)));
		int index = 0;
	    for (WebElement option : SelecEelement.getOptions()) {
	        if (option.getText().equalsIgnoreCase(selectValue))
	            break;
	        index++;
	    }
	    SelecEelement.selectByIndex(index);		
//	 	 SelecEelement.selectByVisibleText(selectValue);
		//return selectValue;
	}
	
	public static void SelectDropdown (WebElement selectobj, String selectValue) {	
		Select SelecEelement =new Select(selectobj);
		int index = 0;
	    for (WebElement option : SelecEelement.getOptions()) {
	        if (option.getText().equalsIgnoreCase(selectValue))
	            break;
	        index++;
	    }
	    SelecEelement.selectByIndex(index);		
	}
	
	public static void SelectDropdownPartialtext (WebElement selectobj, String selectValue) {	
		Select SelecEelement =new Select(selectobj);
		int index = 0;
	    for (WebElement option : SelecEelement.getOptions()) {
	        if (option.getText().toLowerCase().contains(selectValue.toLowerCase()))
	            break;
	        index++;
	    }
	    SelecEelement.selectByIndex(index);		
	}
	
	public static void selectcheckbox(WebElement checkboxelement, String actionToperform) {
		try {
			if (actionToperform.equals("check")) {
				if (!checkboxelement.isSelected()) {
					checkboxelement.click();
				}
			} else if (actionToperform.equals("uncheck")) {
				if (checkboxelement.isSelected()) {
					checkboxelement.click();
				}
			}
		}catch(Exception e){
			System.out.println("given checkbox element does not exist on UI.");
		}
	}
	
	protected boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
	
	//Downloaded Document Name - Arpit
	public static String getDownloadedDocumentName(String downloadDir, String fileExtension)
	{	
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 20; 
		try 
		{					
			Path downloadFolderPath = Paths.get(downloadDir);
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do 
			{
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}
				
				for (WatchEvent<?> event : watchKey.pollEvents())
				{
					 WatchEvent.Kind<?> kind = event.kind();
					if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) 
					{
						String fileName = event.context().toString();
						//System.out.println("New File Created:" + fileName);
						if(fileName.endsWith(fileExtension))
						{
							downloadedFileName = fileName;
							System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " + 

fileName);
							Thread.sleep(500);
							found = true;
							break;
						}
					}
				}
				if(found)
				{
					return downloadedFileName;
				}
				else
				{
					currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		}
		catch (Exception e)
		{
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}
	
	public static boolean findelementsvisible(List<WebElement> element) {
		boolean flag=false;
		for(WebElement readelements:element) {
			if(readelements.isDisplayed())
				flag=true;
		}
		return flag;
	}
	
	public String SaveAsfilewithuniquename(String absolutefilepath, String sourcefile) throws IOException, InterruptedException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyHHmmss");
		String newfile=sdf.format(cal.getTime());
		String newfilename = absolutefilepath + newfile + filehandlingfeatures.validfile;
//		new File(newfilename).createNewFile();
		Files.copy(new File(sourcefile), new File(newfilename));
		Thread.sleep(1000);
		return newfilename;
	}
	
//	public static inputifNodefaultvalue(WebElement element) {
//		boolean flag=false;
//			if(element.get)
//				flag=true;
//	}
}
