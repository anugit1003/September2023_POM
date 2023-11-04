package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class CheckYourEmailPage extends BasePage {

	public CheckYourEmailPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "header")
	private WebElement emailheader;
	
	@FindBy(xpath = "//*[@id=\"forgotPassForm\"]/a")
	private WebElement returnLogin;
	
	public String getCheckYourEmailText() {
		String text = getTextFromElement(emailheader, "the header");
		return text;
	}
	public LoginPage returnToLogin() {
		clickElement(returnLogin, "Return to login");
		LoginPage page = new LoginPage(driver);
		return page;
		
	}

}
