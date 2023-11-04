package com.automation.tests.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.tests.utilities.PropertiesUtility;

public class BaseTest {
	static Logger logger = LogManager.getLogger(BaseTest.class.getName());
	
	private Properties props;
	
	private WebDriver driver;

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public void goToUrl(String url) {
		getDriver().get(url);
		logger.info(url + "is entered");
	}

	public void maximizeBrowser() {
		getDriver().manage().window().maximize();
		logger.info("browser window has maximized");
	}
	
	public void initializeProperties() {
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties props = propUtility.loadFile("applicationDataProperties");
		//logger.info(props);
		setProps(props);
		
	}
	public void launchBrowser(String browserName) {

		switch (browserName) {
		case "firefox":
			setDriver(new FirefoxDriver());
			logger.info("firefox driver initialized");
			break;
		case "chrome":
			setDriver(new ChromeDriver());
			logger.info("chrome driver initialized");
			break;
		default:
			logger.error("you have not entrered the correct browser");
		}
	}
	
	public void quitBrowser() {
		logger.info("Quitting the browser");
		getDriver().quit();
	}

}
