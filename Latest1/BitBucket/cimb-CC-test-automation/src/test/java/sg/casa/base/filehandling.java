package sg.casa.base;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public abstract class filehandling extends SG_CASA_UI_Elements{
	
	public void Signhere(WebDriver driver,WebElement wbCanvas) throws InterruptedException {
		Actions actionBuilder=new Actions(driver);          
		Action drawOnCanvas=actionBuilder
		                .contextClick(wbCanvas)
		                .moveToElement(wbCanvas,8,8)
		                .clickAndHold(wbCanvas)
		                .moveByOffset(120, 120)
		                .moveByOffset(60,70)
		                .moveByOffset(-140,-140)
		                .release(wbCanvas)
		                .build();
		drawOnCanvas.perform();
		Thread.sleep(1300);
		for(WebElement clickSave:saveSignature) {
			if(clickSave.isDisplayed()) {
				clickSave.click();
				break;
			}
		}		
	}
	
	public HashMap<String,Integer> getexcelcolnumber(Sheet sheet,int rowtostart) {
		HashMap<String,Integer> getexcelcol=new HashMap<String,Integer>();
		Row Rw=sheet.getRow(rowtostart);
		int colnumber=0;
		Iterator<Cell> cell=Rw.cellIterator();
		while(cell.hasNext()) {
			String celvalue=cell.next().getStringCellValue();
			getexcelcol.put(celvalue, colnumber++);	
		}
		return getexcelcol;
	}
	
	public abstract void uploadfile(WebDriver driver,WebElement elementstoclick, String filetobeuploaded) throws Exception;
	
}

