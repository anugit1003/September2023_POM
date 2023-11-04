package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "header")
	private WebElement header;
	 
	@FindBy(id = "un")
	private WebElement userNameEle;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	public String getForgotPasswordText() {
		String text = getTextFromElement(header, "The header");
		return text;
	}
	public void enterUserName(String userNameStr) {
		enterText(userNameEle, userNameStr, "User Name");
		
	}
	
	public CheckYourEmailPage testContinue() {
		clickElement(continueButton, " click continue");
		CheckYourEmailPage emailPage = new CheckYourEmailPage(driver);
		return emailPage;
	}

}
