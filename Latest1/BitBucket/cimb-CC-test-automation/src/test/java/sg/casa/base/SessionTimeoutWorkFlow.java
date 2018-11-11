package sg.casa.base;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SessionTimeoutWorkFlow {
	
	public static void VerifySessionTimeout(WebDriver driver) throws InterruptedException {
		try {
			//Verify the Pop up Element is Exsit.
			 WebElement model = driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='sessionTimeout']/div"));
			 Assert.assertEquals(true, model.isDisplayed());
			String msg = driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='sessionTimeout']/div/div/div[2]/div/div/p[1]")).getText();
			System.out.println("warning Messge : " + msg);
			Thread.sleep(30000);
			String msg1 = driver.findElement(org.openqa.selenium.By.xpath(".//*[@id='sessionTimeout']/div/div/div[2]/div/div/p[2]")).getText();
			System.out.println("Timeout Messge : " + msg1);
		} catch (NoAlertPresentException ex) {
			System.out.println("No Pop up message");
		}

	
	}

}
