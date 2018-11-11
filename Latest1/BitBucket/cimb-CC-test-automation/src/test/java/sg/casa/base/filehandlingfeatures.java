package sg.casa.base;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class filehandlingfeatures extends filehandling{
	public static final String validfile=".png";
	public static final String invalidfile=".docx";
	public static final String fileuploadpath=System.getProperty("user.dir") + "/src/test/resources/fileupload/";
	
	public void uploadfile(WebDriver driver,WebElement elementstoclick, String filetobeuploaded) throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].style = ''; arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible';", elementstoclick);
		elementstoclick.sendKeys(filetobeuploaded);
		new File(filetobeuploaded).deleteOnExit();
	}
	
}