package com.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // for thread safe to support the parrelel execution

	private DriverFactory() { // private constructor means: you can not create the object for this driverfactory some other class
								
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	public void setDriver(WebDriver driverObj) {
		driver.set(driverObj);
	}

	public WebDriver getDriver() {
		return driver.get();
	}
}
