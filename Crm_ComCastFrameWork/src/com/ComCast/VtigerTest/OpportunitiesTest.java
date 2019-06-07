package com.ComCast.VtigerTest;

import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.Com_Cast.vtiger.ObectRepositoryLib.HomePage;
import com.Com_Cast.vtiger.ObectRepositoryLib.OpportunitiesPage;
import com.Com_Cast.vtiger.genericLib.BaseClass;


@Test
public class OpportunitiesTest extends BaseClass {

	
	public void deleteMultioleOpportunityTest() throws Throwable{
		
	   //navigate to opportunity page
		Reporter.log("step 1: navigate to opportunity page",true);
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToOpportunitiesPage();
	
     //navigate to Quick create Dropdown
		
      OpportunitiesPage oprtnPage = PageFactory.initElements(driver, OpportunitiesPage.class);  	    
	  oprtnPage.navigateToQuiccreateDD(oprtnPage.getQuickCreateDD(), "New Organization");
		
	   //create new organization
	   Reporter.log("step 2:create new organisation",true);
	   
	  oprtnPage.createOrganisation(flib.getExcelSheetData("Sheet1", 4, 2));
	  Thread.sleep(2000);
	  
	  //move control back to homepage
	  hp.getHomeImg().click();
	  
	  // navigate to Quick Dropdown & create two opportunity
	  Reporter.log("step 3: create two new opportunity",true);
	  
	  for(int rownum=4;rownum<6;rownum++) {  
	  oprtnPage.navigateToQuiccreateDD(oprtnPage.getQuickCreateDD(), "New Opportunity");
	  oprtnPage.createOppornty(flib.getExcelSheetData("Sheet1",rownum, 3));
	  hp.getHomeImg().click();
	  }
	  
	  //navigate to opportunity page
	  Reporter.log("step 4:navigate to opportunity page",true);
	  
	    hp.navigateToOpportunitiesPage();
	  
	  //select all opportunities available & delete
	    Reporter.log("step 5:select all opportunities & delete",true);
	  oprtnPage.getMultipleSelectCheckbox().click();
	   oprtnPage.getDeleteBtn().click();
	   
	   //handle alert pop-Up 
	   Reporter.log("step 6: Handle the alert pop-up",true);
	  Alert alt = driver.switchTo().alert();
	  alt.accept();
		
	 //verify & validate
	  Reporter.log("step 7:veryfy & validate",true);
	String expMessage  = flib.getExcelSheetData("Sheet1", 4, 4);
	String actMessage = oprtnPage.getVerifyText().getText();
	boolean status = actMessage.contains(expMessage);
	Assert.assertTrue(status);
	
}
}