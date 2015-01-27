package com.seleniumtests.core;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;


public class CustomVerification {
	private  StringBuffer verificationErrors;
	
	public CustomVerification() {
		verificationErrors = new StringBuffer();
	}
	
	public void verifyTrue(String msg, Boolean b) {
		try {
			AssertJUnit.assertTrue(b.booleanValue());
		} catch(Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}
	
	public void verifyFalse(String msg, Boolean b) {
		try {
			AssertJUnit.assertFalse(b.booleanValue());
		} catch(Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}
	
	public void verifyTrue(String elementDefinition, String elementLocator, Boolean b, String pageURL) {
		try {
			AssertJUnit.assertTrue(b.booleanValue());
		} catch(Error e) {
			verificationErrors.append(e);
			Reporter.log("Verification failed for element: " + elementDefinition + ", Element Locator: "
					+ elementLocator + "On Page: " + pageURL);
		}
	}
	
	public void verifyEquals(String msg, String s1, String s2) {
		try {
			AssertJUnit.assertEquals(s1, s2);
		} catch(Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}
	
	public void clearVerificationErrors() {
		verificationErrors = new StringBuffer();
	}
	
	public void checkForVerificationErrors() {
		String verificationErrorString = verificationErrors.toString();
		clearVerificationErrors();
		if(!"".equals(verificationErrorString))
			Assert.fail(verificationErrorString);
	}
}
