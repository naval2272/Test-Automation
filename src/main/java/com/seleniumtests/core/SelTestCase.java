package com.seleniumtests.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class SelTestCase {

	protected WebDriver driver;
	protected String appURL;

	@BeforeSuite
	@Parameters("appURL")
	public void setEnv(
			@Optional("http://newtours.demoaut.com/mercuryregister.php") String appURL) {
		this.appURL = appURL;
	}

	@BeforeMethod()
	@Parameters("browser")
	public void launchBrowser(@Optional("FF") String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32"
					+ "\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
					+ ".png";
			File failureImageFile = new File(failureImageFileName);
			FileUtils.moveFile(imageFile, failureImageFile);
		}
		driver.close();
		driver.quit();
	}
}
