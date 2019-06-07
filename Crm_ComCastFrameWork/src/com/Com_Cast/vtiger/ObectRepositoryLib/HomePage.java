package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Com_Cast.vtiger.genericLib.BaseClass;
import com.Com_Cast.vtiger.genericLib.WebDriverCommonUtils;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="(//td[@class='tabUnSelected'])[1]/a")
	   private WebElement homeImg;
	
     @FindBy(xpath="//span[text()=' Administrator']/../../td[2]")
     private WebElement logOutImg;
     
     @FindBy(xpath="//a[text()='Sign Out']")
     private WebElement logOutText; 
	
     @FindBy(xpath="(//a[text()='Leads'])[1]")
 	private WebElement leadsText;

	@FindBy(xpath="(//a[text()='Opportunities'])[1]")
	private WebElement opportunitiesText;

	public WebElement getHomeImg() {
		return homeImg;
	}

	public WebElement getLogOutImg() {
		return logOutImg;
	}

	public WebElement getLogOutText() {
		return logOutText;
	}

	public WebElement getLeadsText() {
		return leadsText;
	}

	public WebElement getOpportunitiesText() {
		return opportunitiesText;
	}
	public void logOut() {
		WebDriverCommonUtils wcu = new WebDriverCommonUtils();
		wcu.moveMouse(logOutImg);
		logOutText.click();
	}
    public void navigateToLeadsPage() {
    	leadsText.click();
    }
    public void navigateToOpportunitiesPage() {
    	opportunitiesText.click();
    	
    }
    
    	
    
}

