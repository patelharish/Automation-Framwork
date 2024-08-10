package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BasePage;
import com.driver.DriverFactory;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userNameTextBox;

	@FindBy(name = "password")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginbtn;
	
	public void loginToApplication(String userNameValue, String passwordValue) {
		
		super.sendKeys(userNameTextBox, "user name text box", userNameValue);
		super.sendKeys(passwordTextBox, "password text box", passwordValue);
		super.click(loginbtn, "Login Btn");
	}

}
