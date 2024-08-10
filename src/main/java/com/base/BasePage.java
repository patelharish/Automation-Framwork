package com.base;

import org.openqa.selenium.WebElement;

import com.alert.AlertActions;
import com.iframe.IframeActions;
import com.javascript.JavascriptActions;
import com.report.ExtentFactory;
import com.waits.ExplicitWaitActions;

public class BasePage {

	protected AlertActions alertActions;

	protected IframeActions iframeActions;

	protected JavascriptActions javascriptActions;

	protected ExplicitWaitActions explicitwaitActions;

	protected BasePage() {

		alertActions = new AlertActions();
		iframeActions = new IframeActions();
		javascriptActions = new JavascriptActions();
		explicitwaitActions = new ExplicitWaitActions();
	}

	public void click(WebElement element, String elementName) {

		explicitwaitActions.waitForElementToClickable(element, elementName);

		element.click();
		ExtentFactory.getInstance().passTest(elementName + " is clicked.");
	}

	public void sendKeys(WebElement element, String elementName, String value) {

		explicitwaitActions.waitForElementToBePresent(element, elementName);

		element.clear();

		element.sendKeys(value);

		ExtentFactory.getInstance().passTest(value + " is enetered in " + elementName);

	}

	public boolean isElementSelecting(WebElement element, String elementName) {

		explicitwaitActions.waitForElementToBePresent(element, elementName);

		return element.isSelected();
	}

	public void selectCheckBox(WebElement element, String elementName) {
		
		if(this.isElementSelecting(element, elementName) == false) {
			this.click(element, elementName);
		}
		
		else {
			ExtentFactory.getInstance().failTest(elementName+" is already selected");
		}
				
	}
}
