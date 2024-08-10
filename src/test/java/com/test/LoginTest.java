package com.test;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.properties.TestDataLoader;

public class LoginTest extends BaseTest {

	@Test
	public void loginWithValidUserNameAndValidPassword() {

		LoginPage lg = new LoginPage();

		lg.loginToApplication(TestDataLoader.getInstance().getUserName(), TestDataLoader.getInstance().getPassword());
		

	}

}
