package com.automation.businessObject;

public class ConfigurationBusinessObjectPoJo {

	String URL, UserName, UserPassword, PostMessage;

	public String getBaseURL() {
		return URL;
	}

	public void setBaseURL(String URL) {
		this.URL = URL;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}

	public String getPostMessage() {
		return PostMessage;
	}

	public void setPostMessage(String PostMessage) {
		this.PostMessage = PostMessage;
	}
}