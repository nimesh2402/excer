package com.automation.objectRepository;

public interface IWebLocators {

	public interface ILogin {
		String strUserNameLoc = "//input[@type=\"email\"]";
		String strUserPasswordLoc = "//input[@name=\"pass\"]";
		String strLoginButtonLoc = "//input[@type=\"submit\"]";
	}

	public interface IHome {
		String strCreatePostLoc = "[aria-label=\"What's on your mind, Shailendra?\"]";
		String strPostMessageLoc = "[class=\"_1mf7 _4r1q _4jy0 _4jy3 _4jy1 _51sy selected _42ft\"]";
		String strPostedMessageGetLoc = "//p[contains(.,\"Hello World\")]";
	}

}
