package com.Com_Cast.vtiger.ObectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {
	
	
	@FindBy(xpath="//img[@alt='Import Leads']")
	private WebElement importImg;
	
   @FindBy(id="import_file")
   private WebElement browseButton;
   
   @FindBy(name="next")
   private WebElement nextBtn;
   
   @FindBy(name="import")
   private WebElement importBtn;

   @FindBy(name="cancel")
   private WebElement finishBtn;
   
   
   @FindBy(xpath="//img[@alt='Export Leads']")
   private WebElement exportImg;
   
   @FindBy(xpath="//input[@name='Export']")
   private WebElement exportLeadsBtn;
   
   @FindBy(xpath="(//td[contains(text(),'Showing Records')])[1]")
   private WebElement showingRsltTxt;
   
   @FindBy(xpath="//td[text()='Leads >> Export ']")
   private WebElement exportLeadsVerificationtxt;
   
   
public WebElement getExportLeadsVerificationtxt() {
	return exportLeadsVerificationtxt;
}

public WebElement getShowingRsltTxt() {
	return showingRsltTxt;
}

public WebElement getImportImg() {
	return importImg;
}

public WebElement getBrowseButton() {
	return browseButton;
}

public WebElement getNextBtn() {
	return nextBtn;
}

public WebElement getImportBtn() {
	return importBtn;
}

public WebElement getFinishBtn() {
	return finishBtn;
}

public WebElement getExportImg() {
	return exportImg;
}

public WebElement getExportLeadsBtn() {
	return exportLeadsBtn;
}
   
   
   
   
   



}
