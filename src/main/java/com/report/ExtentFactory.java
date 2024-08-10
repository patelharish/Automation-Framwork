package com.report;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.driver.DriverFactory;

public class ExtentFactory {

	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>(); // for thread safe to support the parrelel execution

	private ExtentFactory() { // private constructor : you cannot create the object outside of the class

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() { // where ever we require object of this class we can call this method
		return instance;
	}

	public void setExtent(ExtentTest obj) {
		extent.set(obj);
	}

	public ExtentTest getExtentTest() {
		return extent.get();
	}

	public void removeTest() {
		extent.remove();
	}

	// screenshot code
	public static String captureApplicationScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getInstance().getDriver(); // type casted driver
																								// object in
																								// takescreenshot

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		byte[] fileContent = null;

		try {
			fileContent = FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Base64.getEncoder().encodeToString(fileContent);
	}
	// end
	
	// button click operations // these steps are added into extentTest report
	public static void clickPass(String btnName) {
		getInstance().getExtentTest().pass(btnName+ "button is clicked");
	}
	
	public static void clickFail(String btnName) {
		getInstance().getExtentTest().fail("Error occured while clicking on "+btnName);
	}
	
	// sendkeys operations
	public static void sendKeysPass(String value, String elementName) {
		getInstance().getExtentTest().pass(value+ "is entered in "+elementName);
	}
	
	public static void senKeysFail(String value, String elementName) {
		getInstance().getExtentTest().fail("Error occured while entering "+value+" in text box "+elementName);
	}
	
	//pass tests
	
	public static void passTest(String message) {
		getInstance().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}
	
	// fail tests
	public static void failTest(String message) {
		getInstance().getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(captureApplicationScreenshot()).build());
	}
	
	
}
