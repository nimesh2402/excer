package com.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {

	long waitSixtySec;

	public enum Halt {
		SIXTY(60l), THIRTY(30l), TEN(10l), FIVE(5l);

		private long wait;

		Halt(long wait) {
			this.wait = wait;
		}

		public long getWait() {
			return wait;
		}
	}

	public WebDriver wd;

	public WebDriverWait wait;

	public CommonUtility(WebDriver wd) {
		this.wd = wd;
		waitSixtySec = Halt.SIXTY.getWait();
	}

	// Send keys action to a specific element
	public boolean sendKeysToElement(final String strPath, Long lSeconds, final String strLocatorType,
			String strSendKeys) {
		WebElement webElement;
		switch (strLocatorType) {
		case "cssSelector": {
			webElement = wd.findElement(By.cssSelector(strPath));
			waitForElementToAppear(webElement, lSeconds);
			webElement.clear();
			webElement.sendKeys(strSendKeys);
			return true;
		}
		default:
			webElement = wd.findElement(By.xpath(strPath));
			waitForElementToAppear(webElement, lSeconds);
			webElement.clear();
			webElement.sendKeys(strSendKeys);
			return true;
		}
	}

	// Click on the element
	public boolean clickOnElement(final String strPath, Long lSeconds, final String strLocatorType) {
		WebElement webElement;
		switch (strLocatorType) {
		case "cssSelector": {
			webElement = wd.findElement(By.cssSelector(strPath));
			waitForElementToAppear(webElement, lSeconds);
			webElement.click();
			return true;
		}
		default:
			webElement = wd.findElement(By.xpath(strPath));
			waitForElementToAppear(webElement, lSeconds);
			webElement.click();
			return true;
		}
	}

	// Wait for element to appear
	public boolean waitForElementToAppear(WebElement webElement, Long waitTime) {
		boolean blWebElementPresence = false;
		try {
			wait = new WebDriverWait(wd, waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
			if (webElement.isDisplayed()) {
				blWebElementPresence = true;
			}
		} catch (TimeoutException toe) {
			return blWebElementPresence;

		} catch (Exception e) {
			return blWebElementPresence;
		}
		return blWebElementPresence;
	}

}