package com.waits;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;

public class ImplicitWaitActions {

	private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);

	public void setImplicitWait() {
		try {
			DriverFactory.getInstance().getDriver().manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
			logger.info("implicit wait time is set to " + Constants.IMPLICIT_WAIT_TIME);

		} catch (Exception e) {
			logger.error("Error occured while setting the implicit wait " + e.getMessage());
		}
	}
}
