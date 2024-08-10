package com.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;
import com.report.ExtentFactory;

public class CofigLoader {

	private Logger logger = LogManager.getLogger(CofigLoader.class);

	private Properties prop;

	private CofigLoader() {
		FileReader reader = null;
		try {
			reader = new FileReader(Constants.CONFIG_FILE_PATH);
		} catch (FileNotFoundException e) {
			logger.error("Exception ocured while reading the config file");
			ExtentFactory.getInstance().failTest("Exception ocured while reading the config file");
		}

		prop = new Properties();

		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Constants.EXECUTION_ENV = getPropertyValue("environment");
	}

	private static CofigLoader instance = new CofigLoader();

	public static CofigLoader getInstance() {
		return instance;
	}

	public String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}
