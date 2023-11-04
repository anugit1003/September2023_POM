package com.automation.pages.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	static Logger logger = LogManager.getLogger(BasePage.class.getName());

	protected WebDriver driver;

	private WebDriverWait wait;

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		logger.info(data + " - extracted the text from " + objectName);
		return data;
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			logger.info("data is entered in the " + objectName);
		} else {
			logger.error(objectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			logger.info(objectName + "button is clicked");
		} else {
			logger.error(objectName + " button element is not enabled");
		}
	}

	public void clickCheckBox(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			logger.info(objectName + "checkbox is clicked");
		} else {
			logger.error(objectName + " checkbox is already selected");
		}

	}

	public boolean isElementSelected(WebElement ele, String objectName) {
		logger.info(objectName + " is selected");
		return ele.isSelected();
	}

	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOf(ele));
		logger.info(objectName + " is waited for visibility using fluent wait");
	}

	public void waitForVisibility(WebElement ele, int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void clearElement(WebElement ele, String objectNam) {
		if (ele.isDisplayed()) {
			ele.clear();
			logger.info(objectNam + "is cleared");
		} else {
			logger.error(objectNam + "is not displayed");
		}
	}

	/*
	 * public void findElementByAndClick(By by) { WebElement element =
	 * getDriver().findElement(by); element.click();
	 * 
	 * }
	 * 
	 * public void findIframeAndSwitchTo(By by) { WebElement element =
	 * getDriver().findElement(by); getDriver().switchTo().frame(element);
	 * 
	 * }
	 */

}
