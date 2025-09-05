package com.crm.Unilever.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	SeleniumUtility sutil=new SeleniumUtility();
	FileUtils f=new FileUtils();
   public static WebDriver driver;
   
   
	@BeforeSuite
	public void connectToDatabase() {
		Reporter.log("database connected",true);
	}
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		sutil.maximizeBrowser(driver);
		sutil.implicitWait(driver);
		String URL = f.readDataFromProperty("url");
		driver.get(URL);
	}
	@BeforeMethod
	public void login() throws IOException {
	LoginPage lp=new LoginPage(driver);
	String UN = f.readDataFromProperty("username");
	String PW = f.readDataFromProperty("password");
	lp.login(driver, UN, PW);
	}
	
	@AfterMethod
	public void logoutFromVtiger() {
		HomePage hp=new HomePage(driver);
	
		hp.logout(driver);
	}
	
	@AfterTest
	public void closeBrowser() {
		sutil.closebrowser(driver);
	}
	
	@AfterSuite
	public void disconnectDatabase() {
		Reporter.log("databse disconnected",true);
	}
	
	
}
