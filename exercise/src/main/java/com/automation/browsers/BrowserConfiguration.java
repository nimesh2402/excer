package com.automation.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.automation.businessObject.ConfigurationBusinessObjectPoJo;
import com.automation.utility.Utility;

public class BrowserConfiguration {
	public WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser" })
	public void browserConfiguration(String browser) {
		ConfigurationBusinessObjectPoJo objConfigurationBusinessObjectPoJo = Utility.getConfiguration();
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"..\\PostMessageAtFacebook\\SeleniumBrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
		} else if (browser.equalsIgnoreCase("ie")) {
		}
		driver.get(objConfigurationBusinessObjectPoJo.getBaseURL());
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDownBrowser() {
		driver.quit();
	}
}