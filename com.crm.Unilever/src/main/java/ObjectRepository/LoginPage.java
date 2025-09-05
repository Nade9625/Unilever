package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "user_name")
	private WebElement untbx;
	
	@FindBy(name = "user_password")
	private WebElement pwtbx;
	
	@FindBy(id = "submitButton")
	private WebElement lgbtn;
	
	//initilzation
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	//bussiness logic 
	public void login(WebDriver driver,String un,String pw) {
		LoginPage lp=new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
	}
	

}
