package com.automation.tests.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility {
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	
	public static ExtentReportsUtility extentObject;
	
	private ExtentReportsUtility() {
		
	}
	
	public static ExtentReportsUtility getInstance() {
		if(extentObject==null) {
			extentObject = new ExtentReportsUtility();
		}
		return extentObject;
	}
	public void initializeExtentReport() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(Constants.EXTENT_REPORT_PATH);
		report.attachReporter(spark);
		report.setSystemInfo("Application", "salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Mickey Mouse");
		
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("salesforce regression test");
		spark.config().setTheme(Theme.DARK);
		
	}
	public void startSingleTestReport(String methodName) {
		testLogger = report.createTest(methodName);
	}
	
	public void endReport() {
		report.flush();
	}
	public void logTestPassed(String text) {
		testLogger.log(Status.PASS,MarkupHelper.createLabel(text,ExtentColor.GREEN));
		
	}
	public void logTestFailed(String text) {
		testLogger.log(Status.PASS,MarkupHelper.createLabel(text,ExtentColor.RED));
		
	}
	public void logTestFailedWithException(Throwable e) {
		testLogger.log(Status.FAIL,e);
		
	}
	
	public void screenCapture(String path) {
		testLogger.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build()); 
		
	}

}
