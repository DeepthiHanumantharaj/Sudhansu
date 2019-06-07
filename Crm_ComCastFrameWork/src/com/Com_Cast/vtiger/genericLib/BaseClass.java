package com.Com_Cast.vtiger.genericLib;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Com_Cast.vtiger.ObectRepositoryLib.HomePage;
import com.Com_Cast.vtiger.ObectRepositoryLib.Login;

public class BaseClass {
	public static WebDriver driver;
	public static FileLib flib = new FileLib();
   
	@BeforeClass
	public void configBC() throws Throwable {
		String browserName=flib.getPropertyKeyValue("browser");
		if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver(); 
		}else if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
	
}
	@BeforeMethod
	public void configBM() throws Throwable {
		String uRL = flib.getPropertyKeyValue("url");
		String uSER = flib.getPropertyKeyValue("username");
		String pASSWORD = flib.getPropertyKeyValue("password");
		driver.get(uRL);
		Login lp = PageFactory.initElements(driver,Login.class);
		    lp.loginToApp(uSER, pASSWORD);
		    Thread.sleep(2000);	
	}
	
	@AfterMethod
	public void configAM() {
	HomePage hp = PageFactory.initElements(driver,HomePage.class);
	hp.logOut();
	}
	
   @AfterClass
   public void configAC() {
	   driver.close();
   }
		
	
}
