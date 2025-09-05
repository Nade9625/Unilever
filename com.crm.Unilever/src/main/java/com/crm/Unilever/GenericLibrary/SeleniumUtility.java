package com.crm.Unilever.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility  {
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void closebrowser(WebDriver driver) {
		driver.quit();
		
		
	}
	
	public void getscrrenshot(WebDriver driver,String name) throws IOException {
		JavaUtility jutil=new JavaUtility();
		String format = jutil.getDateAndTime();
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+name+format+".png");
		Files.copy(src, dest);
	}
	
	public void selectOptionByVisibeText(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByContainsVisibleText(value);
	}
	public void explicitWait(WebDriver driver,String title,String locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}

}
