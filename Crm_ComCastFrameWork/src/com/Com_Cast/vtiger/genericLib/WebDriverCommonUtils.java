package com.Com_Cast.vtiger.genericLib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonUtils extends BaseClass{
	
	public static String parentWindowID;
	public static String childWindowID;
	public void waitAndClickElementInGUI(WebElement element) throws Throwable {
int count = 0;
while(count<20) {
	try {
		element.click();
		break;
	}catch(Exception e) {
		Thread.sleep(1000);
		count++;
	}
   }		
}
	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
public void moveMouse(WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
public void select(WebElement element,String option) {
	Select sel = new Select(element);
	sel.selectByVisibleText(option);	
}
public void waitForElementPresent(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void getWindowIDs() {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	parentWindowID = it.next();
	childWindowID = it.next();
}	
}
