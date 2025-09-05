package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Unilever.GenericLibrary.SeleniumUtility;

public class HomePage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgElement;
	
	@FindBy(linkText = "Contacts")
   private WebElement contactEle;	
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesele;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}

	public WebElement getOrgElement() {
		return orgElement;
	}

	public WebElement getContactEle() {
		return contactEle;
	}

	public WebElement getOpportunitiesele() {
		return opportunitiesele;
	}

	public WebElement getSignout() {
		return signout;
	}

	public void logout(WebDriver driver) {
		SeleniumUtility sutil=new SeleniumUtility();
		HomePage hp=new HomePage(driver);
		WebElement element = hp.getLogoutimg();
		sutil.mouseHover(driver, element);
		hp.getSignout().click();
	}
	
	

}
