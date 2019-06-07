package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOpportunityLookUp {
	
	@FindBy(name="potentialname")
	private WebElement lookupOpportuniNameEdt;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement organisationlookUpBtn;
	
	@FindBy(xpath="//input[@value='  Save']")
	private WebElement lookUpSaveBtn;

	public WebElement getLookupOpportuniNameEdt() {
		return lookupOpportuniNameEdt;
	}

	public WebElement getOrganisationlookUpBtn() {
		return organisationlookUpBtn;
	}

	public WebElement getLookUpSaveBtn() {
		return lookUpSaveBtn;
	}

	
	
}
