package com.flip.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flip.qa.base.BasePage;
import com.flip.qa.util.TestUtil;

public class LoginPage extends BasePage{
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;

	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;

	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement submit;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pwd){
//		String parentWindow = driver.getWindowHandle();
//		Set<String> windowHandles = driver.getWindowHandles();
//		Iterator<String> iterator = windowHandles.iterator();
//		while (iterator.hasNext()) {
//		   String handle = iterator.next();
//		   if (!handle.contains(parentWindow)) {
//		                    // Switch to popup 
//		                    driver.switchTo().window(handle);
//		                    // Add code to find element 
//		       }
//		}
//		// Switch back to original window
//		driver.switchTo().window(parentWindow);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		username.sendKeys(uname);
		password.sendKeys(pwd);
		System.out.println(" iiiiiiiiiiiiiiiiiiiiii");
		
		
		Actions builder = new Actions(driver);
		builder.moveToElement(submit).click(submit);
		builder.perform();
	
		
		return new HomePage();
		
	}
}
