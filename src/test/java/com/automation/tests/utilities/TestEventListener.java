package com.automation.tests.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestEventListener implements ITestListener {
	private static ExtentReportsUtility extentUtilityObject;

	@Override
	public void onTestStart(ITestResult result) {
		extentUtilityObject.startSingleTestReport(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentUtilityObject.logTestPassed(result.getMethod().getMethodName()+" is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentUtilityObject.logTestFailed(result.getMethod().getMethodName()+" is failed");
	}

	@Override
	public void onStart(ITestContext context) {
		extentUtilityObject = ExtentReportsUtility.getInstance();
		extentUtilityObject.initializeExtentReport();

	}

	@Override
	public void onFinish(ITestContext context) {
		extentUtilityObject.endReport();

	}

	
	

}
