package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.browsers.BrowserConfiguration;
import com.automation.businessObject.ConfigurationBusinessObjectPoJo;
import com.automation.pageObjects.LoginPage;
import com.automation.utility.Utility;

public class LoginTests extends BrowserConfiguration {

	LoginPage loginPage;
	ConfigurationBusinessObjectPoJo objConfigurationBusinessObjectPoJo;

	@Test(testName = "LoginCreateAndPostAMessage", description = "Login into the facebook application, post a message and verify it.")
	public void Login_Create_And_Post_A_Message() {
		objConfigurationBusinessObjectPoJo = Utility.getConfiguration();
		loginPage = new LoginPage(driver);
		// Login into the application
		loginPage.Login(objConfigurationBusinessObjectPoJo.getUserName().toString(),
				objConfigurationBusinessObjectPoJo.getUserPassword().toString());

		String strExpected = loginPage.PostAMessage(objConfigurationBusinessObjectPoJo.getPostMessage().toString());
		// Assertion for the created post
		Assert.assertEquals(objConfigurationBusinessObjectPoJo.getPostMessage().toString(), strExpected.toString());
	}
}