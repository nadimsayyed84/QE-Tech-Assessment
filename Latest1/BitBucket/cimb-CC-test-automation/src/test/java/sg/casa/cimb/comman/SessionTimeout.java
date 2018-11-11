package sg.casa.cimb.comman;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.JavascriptExecutor;
import com.ford.automation.base.BaseTest;
import cucumber.api.java.en.When;
import sg.casa.base.*;

public class SessionTimeout extends BaseTest{
	
	//Getting Started Page...................................................................
	public String User_Nationality ="";
	Boolean isSingaporePR = false;
	
	@When("^User Execute Without CrossSell Testcases$")
	public void user_Execute_Without_CrossSell_Testcases() throws Throwable {
	  
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.open('','testwindow','width=400,height=200')");
		driver.close();
		driver.switchTo().window("testwindow");
		js.executeScript("window.moveTo(0,0);");
		js.executeScript("window.resizeTo(1450,1000);");
		
		driver.get(IbaseUrl.FastSaver);
		Thread.sleep(40000);
		SessionTimeoutWorkFlow.VerifySessionTimeout(driver);
		
	}
	

}