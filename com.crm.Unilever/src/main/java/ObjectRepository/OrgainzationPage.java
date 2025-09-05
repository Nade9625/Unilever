package ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Unilever.GenericLibrary.FileUtils;
import com.crm.Unilever.GenericLibrary.SeleniumUtility;

public class OrgainzationPage {
	
@FindBy(xpath = "//img[@alt='Create Organization...']")
private WebElement plusIcon;

@FindBy(name="accountname")
private WebElement orgname;

@FindBy(name = "website")
private WebElement websiteName;

@FindBy(name = "industry")
private WebElement industryname;

@FindBy(xpath = "//input[@value='U']")
private WebElement userradio;

@FindBy(xpath = "//input[@value='T']")
private WebElement GROUPradio;

@FindBy(id = "phone")
private WebElement phoneno;

@FindBy(name = "notify_owner")
private WebElement notifycheckbox;

@FindBy(name = "bill_street")
private WebElement billstret;

@FindBy(name = "ship_street")
private WebElement shipstreet;

@FindBy(xpath = "//input[@class='crmbutton small save']")
private WebElement savebtn;

@FindBy(xpath = "//input[@class='crmbutton small cancel']")
private WebElement cancelbtn;


public OrgainzationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getPlusIcon() {
	return plusIcon;
}


public WebElement getOrgname() {
	return orgname;
}


public WebElement getWebsiteName() {
	return websiteName;
}


public WebElement getIndustryname() {
	return industryname;
}


public WebElement getUserradio() {
	return userradio;
}


public WebElement getGROUPradio() {
	return GROUPradio;
}


public WebElement getPhoneno() {
	return phoneno;
}


public WebElement getNotifycheckbox() {
	return notifycheckbox;
}


public WebElement getBillstret() {
	return billstret;
}


public WebElement getShipstreet() {
	return shipstreet;
}


public WebElement getSavebtn() {
	return savebtn;
}


public WebElement getCancelbtn() {
	return cancelbtn;
}

public void createOrg(WebDriver driver,String orgname,String web,String billadd,String shipadd) throws EncryptedDocumentException, IOException {
	OrgainzationPage op=new OrgainzationPage(driver);
	op.getPlusIcon().click();
	op.getOrgname().sendKeys(orgname);
	op.getWebsiteName().sendKeys(web);
	WebElement industry = op.getIndustryname();
	SeleniumUtility  sutil=new SeleniumUtility();
	FileUtils f=new FileUtils();
	String name = f.readDataFromExcel("TestingData", 1, 2);
	sutil.selectOptionByVisibeText(industry, name);
	op.getGROUPradio().click();
	//op.getPhoneno().sendKeys(phone);
	op.getBillstret().sendKeys(billadd);
	op.getShipstreet().sendKeys(shipadd);
	op.getSavebtn().click();
	
	
	
	
	
}


}
