package com.seleniumtests.dataobject;

import java.io.IOException;
//import java.util.Properties;

import org.testng.annotations.DataProvider;

public class RegistrationData {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userName;
	private String country;
	private String email;
	private String password;
	private String confirmPassword;

	/*private Properties properties = new Properties();

	public RegistrationData() throws IOException {
		properties.load(RegistrationData.class
				.getResourceAsStream("/registrationdata.properties"));
		firstName = properties.getProperty("firstname");
		lastName = properties.getProperty("lastname");
		phoneNumber = properties.getProperty("phonenumber");
		userName = properties.getProperty("username");
		country = properties.getProperty("country");
		email = properties.getProperty("email");
		password = properties.getProperty("password");
		confirmPassword = properties.getProperty("confirmpassword");
	}
*/
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@DataProvider(name = "regData")
	public static Object[][] getRegistrationData() throws IOException {
		RegistrationData registrationData1 = new RegistrationData();
		registrationData1.setFirstName("first name 1");
		registrationData1.setLastName("last name 1");
		registrationData1.setPhoneNumber("1234567890");
		registrationData1.setUserName("seleniumuser1");
		registrationData1.setCountry("ANGOLA");
		registrationData1.setEmail("test1@selenium.com");
		registrationData1.setPassword("123456");
		registrationData1.setConfirmPassword("123456");
		
		RegistrationData registrationData2 = new RegistrationData();
		registrationData2.setFirstName("first name 2");
		registrationData2.setLastName("last name 2");
		registrationData2.setPhoneNumber("1234561234");
		registrationData2.setUserName("seleniumuser2");
		registrationData2.setCountry("TURKEY");
		registrationData2.setEmail("test2@selenium.com");
		registrationData2.setPassword("456123");
		registrationData2.setConfirmPassword("456123");
		
		return new RegistrationData[][] { { registrationData1 } ,
				{ registrationData2 } };
	}

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		return new Object[][] { { "first name 1", "password1" },
				{ "first name 2", "password2" } };
	}
}
