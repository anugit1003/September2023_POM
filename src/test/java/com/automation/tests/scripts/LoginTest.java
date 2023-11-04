package com.automation.tests.scripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.home.HomePage;
import com.automation.pages.login.CheckYourEmailPage;
import com.automation.pages.login.ForgotPasswordPage;
import com.automation.pages.login.LoginPage;
import com.automation.tests.base.BaseTest;
import com.automation.tests.utilities.Constants;

public class LoginTest extends BaseTest {
	static Logger logger = LogManager.getLogger(LoginTest.class.getName());

	@BeforeClass
	public void setUp() {
		initializeProperties();
		launchBrowser(getProps().getProperty(Constants.BROWSER));
		goToUrl(getProps().getProperty(Constants.SALESFORCE_URL));
		maximizeBrowser();
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		quitBrowser();
	}

	@Test
	public void testLogin() throws InterruptedException {

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUserName(getProps().getProperty(Constants.SF_USER_NAME));
		loginPage.enterPassword(getProps().getProperty(Constants.SF_PASSWORD));
		HomePage homePage = loginPage.clickLogin("login");
		Thread.sleep(3000);
		String actualUserNameLabel = homePage.getUserNameLabelText();
		Assert.assertEquals(actualUserNameLabel, "Anuradha Jackson");
		logger.info("Login successful");
	}
	@Test
	public void testInvalidLogin() throws InterruptedException {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUserName(getProps().getProperty(Constants.SF_USER_NAME));
		loginPage.enterPassword("");
		loginPage.clickLogin("login");
		String errorMessage = loginPage.getErrorMessageLabelText();
		Assert.assertEquals(errorMessage,"Please enter your password");
		Thread.sleep(3000);
		
	}
	@Test
	public void testInvalidLogin1() throws InterruptedException {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUserName("123");
		loginPage.enterPassword("22131");
		loginPage.clickLogin("login");
		String errorMessage1 = loginPage.getErrorMessageLabelText1();
		Assert.assertEquals(errorMessage1,"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		Thread.sleep(3000);
	}
	@Test
	public void testRememberMe() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUserName(getProps().getProperty(Constants.SF_USER_NAME));
		loginPage.enterPassword(getProps().getProperty(Constants.SF_PASSWORD));
		loginPage.clickRememberMe();
		HomePage homePage = loginPage.clickLogin("login");
		String actualUserNameLabel = homePage.getUserNameLabelText();
		Assert.assertEquals(actualUserNameLabel, "Anuradha Jackson");
		logger.info("Login successful");
		//click logout - return a Login Page
		homePage.clickUserNameLabel();
		loginPage = homePage.clickLogoutLink();
		String userIdText = loginPage.getUserNameText();
		Assert.assertEquals(userIdText, "agorpalli@agorpalli.com");
		boolean isSelected = loginPage.isRememberMeSelected();
		Assert.assertEquals(isSelected, true);
		logger.info("test case passed");
	}
	
	@Test
	public void testForgotPassword() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterUserName(getProps().getProperty(Constants.SF_USER_NAME));
		loginPage.clickForgotPassword();
		ForgotPasswordPage forgotPwdPage = new ForgotPasswordPage(getDriver());
		String passwordText = forgotPwdPage.getForgotPasswordText();
		Assert.assertEquals(passwordText, "Forgot Your Password");
		logger.info(" Forgot Password Text is validated");
		forgotPwdPage.enterUserName("agorpalli@agorpalli.com");
		forgotPwdPage.testContinue();
		
		CheckYourEmailPage emailPage = new CheckYourEmailPage(getDriver());
		String emailText = emailPage.getCheckYourEmailText();
		Assert.assertEquals(emailText, "Check Your Email");
		logger.info("Check Your Email Text is validated");
		emailPage.returnToLogin();
		
		
		
	}
	
	

}
