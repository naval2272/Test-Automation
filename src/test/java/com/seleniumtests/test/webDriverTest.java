package com.seleniumtests.test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.seleniumtests.core.CustomVerification;
import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.dataobject.RegistrationData;
import com.seleniumtests.pageobject.NewRegistrationPage;


public class webDriverTest extends SelTestCase {

	/**
	 * Method to test if correct content is displayed in the user interface
	 * @param registrationData
	 */
	
	@Test(dataProvider = "regData", dataProviderClass = RegistrationData.class)
	public void testRegistrationNew(RegistrationData registrationData) {

		driver.get(appURL);
		NewRegistrationPage registration = PageFactory.initElements(driver,
				NewRegistrationPage.class);
		registration.registerNewUser(registrationData);
		assert driver
				.findElement(By.tagName("body"))
				.getText()
				.contains("Thank you for registering. "
								+ "You may now sign-in using the user name and password you've just entered.");
	}
	
	
	/**
	 * Test method execution disrupts when any assertion fails
	 */
	//@Test
	public void hardAssertion() {
		driver.get(appURL);
		Assert.assertTrue("first name field is missing",
				driver.findElements(By.name("firstName")).size() == 1);
		
		// Deliberate  test failure
		Assert.assertTrue("last name field is missing",
				driver.findElements(By.name("wrongLastName")).size() == 1);
		Assert.assertTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 1);
		
		Assert.assertTrue("email address field is missing",
				driver.findElements(By.name("userName")).size() == 1);
	}
	
	
	/**
	 * Test method to see implementation of soft assertion
	 */
	@Test
	public void softAssertion() {
		driver.get(appURL);
		CustomVerification customVerification = new CustomVerification();
		
		customVerification.verifyTrue("First name field is missing",
				driver.findElements(By.name("firstName")).size() == 1);
		
		// Deliberate  test failure but yet test execution continues
		customVerification.verifyTrue("last name field is missing",
				driver.findElements(By.name("wrongLastName")).size() == 1);
		customVerification.verifyTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 1);
		customVerification.verifyTrue("email address field is missing",
				driver.findElements(By.name("userName")).size() == 1);
		
		customVerification.checkForVerificationErrors();
	}
}
