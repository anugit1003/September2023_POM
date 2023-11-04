package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;
import com.automation.pages.home.HomePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "username")
	private WebElement userId;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "Login")
	private WebElement loginButton;

	@FindBy(id = "header")
	private WebElement invalidLoginMessage;

	@FindBy(id = "error")
	private WebElement errorMessage;

	@FindBy(id = "rememberUn")
	private WebElement rememberMe;
	
	@FindBy(id = "forgot_password_link")
	private WebElement forgotPassword;

	public void enterUserName(String userName) {
		enterText(userId, userName, "user name");
	}

	public void enterPassword(String passwordStr) {
		enterText(password, passwordStr, "login password");
	}

	public HomePage clickLogin(String login) {
		clickElement(loginButton, login);
		HomePage homePage = new HomePage(driver);
		return homePage;

	}

	public String getErrorMessageLabelText() {
		return getTextFromElement(invalidLoginMessage, "errormessage label");
	}

	public String getErrorMessageLabelText1() {
		return getTextFromElement(errorMessage, "errormessage label");
	}

	public void clickRememberMe() {
		clickCheckBox(rememberMe, "Remember Me");
	}

	public boolean isRememberMeSelected() {
		return isElementSelected(rememberMe, "Remember Me");
	}
	
	public String getUserNameText() {
		return getTextFromElement(userId, "username");
	}
	
	public  ForgotPasswordPage clickForgotPassword() {
		clickElement(forgotPassword, "Forgot Password");
		ForgotPasswordPage forgotpwd = new ForgotPasswordPage(driver);
		return forgotpwd;
	}
	
}
