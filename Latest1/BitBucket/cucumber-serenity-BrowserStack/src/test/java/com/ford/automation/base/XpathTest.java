package com.ford.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class XpathTest extends BaseTest{
	
	public static void VerifXpath (String Xpath, WebDriver driver) {
		boolean present;
		try {
		   driver.findElement(By.xpath(Xpath));
		  
		   present = true;
		   System.out.println("correct Xpath : "+ present);
		   		
		   driver.findElement(By.xpath(Xpath)).click();
		   System.out.println("User Perform the Action.......");
		
		} catch (Exception e) {
		   present = false;
		   System.out.println("Incorrect Xpath : "+ present);
		}
	
	}
}