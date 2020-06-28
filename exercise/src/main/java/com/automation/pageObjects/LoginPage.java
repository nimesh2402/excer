package com.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.objectRepository.IWebLocators.IHome;
import com.automation.objectRepository.IWebLocators.ILogin;
import com.automation.utility.CommonUtility;
import com.automation.utility.CommonUtility.Halt;

public class LoginPage extends InitPage implements ILogin, IHome {

	CommonUtility commonUtility;
	long waitSixtySec;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		commonUtility = new CommonUtility(driver);
		waitSixtySec = Halt.SIXTY.getWait();
	}

	public boolean Login(String strUsername, String strUserPassword) {
		commonUtility.sendKeysToElement(strUserNameLoc, waitSixtySec, "xpath", strUsername);
		commonUtility.sendKeysToElement(strUserPasswordLoc, waitSixtySec, "xpath", strUserPassword);
		commonUtility.clickOnElement(strLoginButtonLoc, waitSixtySec, "xpath");
		return true;
	}

	public String PostAMessage(String strPostMessage) {
		WebDriverWait wait;
		wait = new WebDriverWait(driver, 10);

		// Create a post
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strCreatePostLoc)));
		driver.findElement(By.cssSelector(strCreatePostLoc)).click();
		driver.findElement(By.cssSelector(strCreatePostLoc)).sendKeys(strPostMessage);

		// Post the message
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(strPostMessageLoc)));
		driver.findElement(By.cssSelector(strPostMessageLoc)).click();

		// Get the posted message from the facebook
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strPostedMessageGetLoc)));
		return driver.findElement(By.xpath(strPostedMessageGetLoc)).getText().toString();
	}
}