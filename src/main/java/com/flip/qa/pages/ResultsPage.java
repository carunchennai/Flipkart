package com.flip.qa.pages;





import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flip.qa.base.BasePage;
import com.flip.qa.util.TestUtil;

public class ResultsPage extends BasePage{
	
	@FindBy(xpath="//a[starts-with(@title,'Hyperon')]")
	//div/descendant::div[@class='_2mylT6']")
	WebElement resultItem;
	
	public ResultsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public ResultsPage fetchResults() throws InterruptedException{
		Thread.sleep(1000);
		System.out.println("okay");
		//resultItem.click();
		driver.switchTo().frame(resultItem);
		Actions builder = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(resultItem));
		builder.moveToElement(resultItem).click(resultItem);
	
		return new ResultsPage();
	}

	

}
