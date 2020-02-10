package com.flip.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.flip.qa.util.TestUtil;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;
	
	public BasePage(){
	
		try{
			FileInputStream fileInput = new FileInputStream("/Users/Archu/Documents/workspace/TestFlip/src/main/java/com/flip/qa/config/config.properties");
			prop = new Properties();
			prop.load(fileInput);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
			
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
	
			System.setProperty("webdriver.chrome.driver","/Users/Archu/Downloads/chromedriver 2");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("URL"));
		}	else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/Archu/Downloads/geckodriver");
			ProfilesIni listProfiles = new ProfilesIni();
			FirefoxProfile ffprofile = listProfiles.getProfile("default");
			FirefoxOptions ffOptions = new FirefoxOptions();
			driver = new FirefoxDriver(ffOptions.setProfile(ffprofile));
			
		} 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));	
		 
	}
	
}
