package com.flip.qa.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flip.qa.base.BasePage;
import com.flip.qa.pages.HomePage;
import com.flip.qa.pages.LoginPage;

public class LoginPageTest extends BasePage{
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}

	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public  void Validatelogin(){
		
		homepage= new HomePage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	
		
	}
	
}
