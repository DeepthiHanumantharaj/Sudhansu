package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrganisationLookup {
	@FindBy(name="accountname")
	private WebElement organisationNameEdt;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement organisationSaveBtn;

	public WebElement getOrganisationNameEdt() {
		return organisationNameEdt;
	}

	public WebElement getOrganisationSaveBtn() {
		return organisationSaveBtn;
	}

}
