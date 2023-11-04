package com.automation.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.automation.pages.base.BasePage;
import com.automation.pages.login.LoginPage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);	
		
	}
	
	@FindBy(id = "userNavLabel")
	private WebElement userNameLabel;
	
	@FindBy(css = "#userNav-menuItems > a:nth-child(5)")
	private WebElement logoutele;

	public String getUserNameLabelText() {
		String text = getTextFromElement(userNameLabel, "username label");
		return text;
	}
	
	public void clickUserNameLabel() {
		userNameLabel.click();
	}
	public LoginPage clickLogoutLink() {
		logoutele.click();
		LoginPage loginpage = new LoginPage(driver);
		return loginpage;
		
	}
	
}
