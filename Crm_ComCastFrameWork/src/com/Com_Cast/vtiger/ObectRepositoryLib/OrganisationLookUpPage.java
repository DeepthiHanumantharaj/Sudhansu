package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganisationLookUpPage {
	@FindBy(id="search_txt")
	private WebElement organisationLookUpSrchEdt;
	
   @FindBy(name="search")
    private WebElement organisationLookUpSrchBtn;
    
   @FindBy(xpath="(//a[@href='javascript:window.close();'])[1]")
   private WebElement organisationNameLnk;

public WebElement getOrganisationLookUpSrchEdt() {
	return organisationLookUpSrchEdt;
}

public WebElement getOrganisationLookUpSrchBtn() {
	return organisationLookUpSrchBtn;
}

public WebElement getOrganisationNameLnk() {
	return organisationNameLnk;
}
   
   
}  
