package com.crm.Unilever.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation extends BaseClass implements ITestListener {
	 SeleniumUtility sutil=new SeleniumUtility();
	 JavaUtility jutil=new JavaUtility();
	
	 ExtentReports report;
	 ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getName();
	test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getName();
		test.log(Status.PASS, methodname+"passes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	 String name = result.getName();
	try {
		sutil.getscrrenshot(driver, name);
	} catch (IOException e) {
	
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		String format = jutil.getDateAndTime();
	ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReports/report"+format+".html");
	reporter.config().setDocumentTitle("Unilever Project");
	reporter.config().setReportName("Unilver Execution Reporter");
	reporter.config().setTheme(Theme.DARK);
	
	 report=new ExtentReports();
	 report.attachReporter(reporter);
	 report.setSystemInfo("url", "http://localhost:8888");
	 report.setSystemInfo("OS", "Windows");
	 report.setSystemInfo("Browser", "chrome");
	 report.setSystemInfo("Test Engineer", "Nade Ali");
	}

	@Override
	public void onFinish(ITestContext context) {
	report.flush();
	}
	
}
