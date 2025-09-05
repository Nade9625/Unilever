package com.crm.Unilever.Organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Unilever.GenericLibrary.BaseClass;
import com.crm.Unilever.GenericLibrary.FileUtils;
import com.crm.Unilever.GenericLibrary.JavaUtility;
import com.crm.Unilever.GenericLibrary.ListenerImplementation;

import ObjectRepository.HomePage;
import ObjectRepository.OrgainzationPage;
@Listeners(ListenerImplementation.class)
public class CreateOrgainzation extends BaseClass {
	FileUtils f=new FileUtils();
	
	@Test
	public void createOrg() throws EncryptedDocumentException, IOException {
		
		HomePage hp=new HomePage(driver);
		hp.getOrgElement().click();
		OrgainzationPage op=new OrgainzationPage(driver);
		String orgname = f.readDataFromExcel("TestingData", 2, 0);
		String website = f.readDataFromExcel("TestingData", 1, 1);
		String billingaddress = f.readDataFromExcel("TestingData", 1, 4);
		String shipaddress = f.readDataFromExcel("TestingData", 1, 5);
		op.createOrg(driver, orgname, website, billingaddress, shipaddress);
	}
	
	@Test
	public void delete() {
		
	}

}
