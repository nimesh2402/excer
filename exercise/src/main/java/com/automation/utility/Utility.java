package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.automation.businessObject.ConfigurationBusinessObjectPoJo;

public class Utility {

	public static ConfigurationBusinessObjectPoJo getConfiguration() {
		ConfigurationBusinessObjectPoJo configbo = new ConfigurationBusinessObjectPoJo();
		File file = new File(".\\config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
			configbo.setBaseURL(prop.getProperty("URL"));
			configbo.setUserName(prop.getProperty("UserName"));
			configbo.setUserPassword(prop.getProperty("UserPassword"));
			configbo.setPostMessage(prop.getProperty("PostMessage"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configbo;
	}

}