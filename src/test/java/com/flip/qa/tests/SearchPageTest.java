package com.flip.qa.tests;

import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.flip.qa.base.BasePage;
import com.flip.qa.pages.HomePage;
import com.flip.qa.pages.LoginPage;
import com.flip.qa.pages.ResultsPage;
import com.flip.qa.util.TestUtil;

public class SearchPageTest extends BasePage{

	HomePage homepage;
	LoginPage loginpage;
	ResultsPage rp;
	 
	public SearchPageTest(){
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
			
	}
	
	@Test(priority=1)
	public void searchProductTest() throws InterruptedException{
		//System.out.println(prop.getProperty("username")+"username");
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		rp = new ResultsPage();
		rp= homepage.search(prop.getProperty("searchip"));
		Thread.sleep(20000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Adidas Shoes - Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		
	}
	
	@Test(priority = 2)
	public void fetchItemTest() throws InterruptedException{
		rp = new ResultsPage();
		//driver.switchTo().frame(1);
		rp.fetchResults();
		System.out.println("I m in fetch2");
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
