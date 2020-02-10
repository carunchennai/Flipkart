package com.flip.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flip.qa.base.BasePage;

public class HomePage extends BasePage{

	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(xpath="//input[@class='LM6RPg']")
	WebElement searchtext;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public ResultsPage search(String searchString){
		 searchtext.sendKeys(searchString);
		 searchtext.submit();
		return new ResultsPage();
		
		
	}
}
