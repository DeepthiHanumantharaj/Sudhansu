package com.ComCast.VtigerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Com_Cast.vtiger.ObectRepositoryLib.HomePage;
import com.Com_Cast.vtiger.ObectRepositoryLib.LeadsPage;
import com.Com_Cast.vtiger.genericLib.BaseClass;


public class LeadsTest extends BaseClass {
	
	
	/**
	 * provides test casese for LEADS module
	 *@author sudhansu sekhar
	 */
	
	public String filePath;

	@Test(priority=1)
	     public void importTest() throws Throwable {
		
		 filePath = flib.getPropertyKeyValue("filepath");
		 
		//navigate to Leads page  
		Reporter.log("step1: navigate to Leads page ",true);

		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToLeadsPage();
		
		//create object to Leads page And get the objects 
		Reporter.log("step2:create Object to Leadspage and get the objects",true);
		
	  LeadsPage lp = PageFactory.initElements(driver, LeadsPage.class);
	       lp.getImportImg().click();
	       lp.getBrowseButton().sendKeys(filePath);
	       lp.getNextBtn().click();
	       lp.getImportBtn().click();
	       lp.getFinishBtn().click();
	       
	    //capture the confirmation message and verify
	     Reporter.log("step3:capture the confirmation message and verify",true);
	     
	       
	  String  actResult =  lp.getShowingRsltTxt().getText();    
		String expResult = flib.getExcelSheetData("Sheet1", 1, 3) ;
		boolean status = actResult.contains(expResult);
          Assert.assertTrue(status);
	}
	
	
	
	@Test(priority=2)
	public void  exportTest() throws Throwable {
		
		//navigate to Leads page 
		Reporter.log("step1: navigate to Leads page ",true);
	
		
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.navigateToLeadsPage();
		
		
		//create object to Leads page And get the objects 
		Reporter.log("step2:create Object to Leadspage and get the objects",true);
		
		
		
	 LeadsPage lp = PageFactory.initElements(driver, LeadsPage.class);
		lp.getExportImg().click();
		lp.getExportLeadsBtn().click();
		
		 //capture the confirmation message and verify
	     Reporter.log("step3:capture the confirmation message and verify",true);
	     
		
		String actResult = lp.getExportLeadsVerificationtxt().getText();
		String expResult = flib.getExcelSheetData("Sheet1", 2, 3);
		boolean status = actResult.contains(expResult);
        Assert.assertTrue(status);
	}
	

}
