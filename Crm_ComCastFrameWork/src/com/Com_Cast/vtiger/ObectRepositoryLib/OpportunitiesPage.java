package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Com_Cast.vtiger.genericLib.BaseClass;
import com.Com_Cast.vtiger.genericLib.WebDriverCommonUtils;

public class OpportunitiesPage extends BaseClass {

	@FindBy(id="qccombo")
	private WebElement quickCreateDD;
	
	
	@FindBy(id="selectCurrentPageRec")
	private WebElement multipleSelectCheckbox;
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//span[contains(text(),'No Opportunity Found !')]")
	private WebElement verifyText;
	
	
	public WebElement getVerifyText() {
		return verifyText;
	}

	public WebElement getMultipleSelectCheckbox() {
		return multipleSelectCheckbox;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getQuickCreateDD() {
		return quickCreateDD;
		
	}
	
	public void navigateToQuiccreateDD( WebElement element, String option) {
		WebDriverCommonUtils commUtils = PageFactory.initElements(driver, WebDriverCommonUtils.class);
        commUtils.select(element, option);
	}
	
	
	

	public void createOrganisation(String organisationName) throws Throwable {
		CreateOrganisationLookup createOrg = PageFactory.initElements(driver, CreateOrganisationLookup.class);
		  createOrg.getOrganisationNameEdt().sendKeys(organisationName);
		  createOrg.getOrganisationSaveBtn().click();
	}
	 public void createOppornty(String opportunityName) throws Throwable {
		 CreateOpportunityLookUp createOpprtn = PageFactory.initElements(driver, CreateOpportunityLookUp.class);
		 createOpprtn.getLookupOpportuniNameEdt().sendKeys(opportunityName);
		 createOpprtn.getOrganisationlookUpBtn().click();
		 WebDriverCommonUtils commUtils = new WebDriverCommonUtils();
		       commUtils.getWindowIDs();
		       driver.switchTo().window(WebDriverCommonUtils.childWindowID);
		OrganisationLookUpPage orgLookup = PageFactory.initElements(driver, OrganisationLookUpPage.class);
		     orgLookup.getOrganisationLookUpSrchBtn().sendKeys(flib.getExcelSheetData("Sheet1", 4, 2));
		     orgLookup.getOrganisationLookUpSrchBtn().click();
		     orgLookup.getOrganisationNameLnk().click();
		     driver.switchTo().window(WebDriverCommonUtils.parentWindowID);
		     createOpprtn.getLookUpSaveBtn().click();
	       
	 }
	
	
	
}
