package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.ExcelReader;
import Utilities.Helper;
import fileReader.ConfigFileReader;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.registerPage;

public class registerPageSteps extends BaseClass {
	ConfigFileReader configFileReader = new ConfigFileReader();;
	private static Logger demoLogger = LogManager.getLogger(signInPageSteps.class.getName());

	String message;
	String username;
	String password;
	String confirmPassword;

	@Given("New user is on Register page")
	public void new_user_is_on_register_page() {
		homePage = new HomePage(Helper.getDriver());
		Helper.openPage(configFileReader.getHomePageUrl());
		regPage = new registerPage(Helper.getDriver());
		homePage.clickRegisterBtn();
		demoLogger.info("User is on Register Page");
	}

	@When("User click on register button")
	public void user_click_on_register_button() {
		homePage.clickRegisterBtn();
	}

	@Then("User should land on Register page")
	public void user_should_land_on_Register_page() {
		String url = homePage.verifyPage();
		assertEquals(url, configFileReader.getRegisterPageUrl());

	}

	@When("^User click on register button with username \"([^\"]*)\" and password (\\d+) as blank$")
	public void user_click_on_register_button_with_username_and_password_as_blank(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
			System.out.println("hello");
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		confirmPassword = testdata.get(rownumber).get("confirmpassword");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		if (username == null) {
			regPage.loginPass(password);

		} else if (password == null) {
			regPage.loginUsrname(username);

		} else if (username != null && password != null) {
			regPage.login(username, password);
		}

		regPage.clickRegisterBtn();

	}

	@When("^User enter username \"([^\"]*)\" and password (\\d+) but confirm password as blank$")
	public void user_enter_username_and_password_but_confirm_password_as_blank(String sheetname, Integer rownumber)

			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
			System.out.println("hello");
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		confirmPassword = testdata.get(rownumber).get("confirmpassword");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		if (username == null) {
			regPage.loginPass(password);
			regPage.clickRegisterBtn();
			assertTrue(message.contains(regPage.verifyUsernameValidationMessage()));

		} else if (password == null) {
			regPage.loginUsrname(username);
			regPage.clickRegisterBtn();
			assertTrue(message.contains(regPage.verifyPasswordValidationMessage()));

		} else if (username != null && password != null && confirmPassword == null) {
			regPage.login(username, password);
			regPage.clickRegisterBtn();
			assertEquals(message, regPage.verifyConfirmPasswordValidationMessage());
		}
	}

	@When("^User enter username \"([^\"]*)\" and password (\\d+) less than 8 chars$")
	public void user_enter_username_and_password_less_than_8_chars(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");
		password = testdata.get(rownumber).get("password");
		confirmPassword = testdata.get(rownumber).get("confirmpassword");
		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		regPage.loginUsrPass(username, password, confirmPassword);

		regPage.clickRegisterBtn();

		assertEquals(message.trim(), regPage.verifyMismatchValidationMessage().trim());

	}

	@When("^User enter username \"([^\"]*)\" and password (\\d+) as blank$")
	public void user_enter_username_and_password_as_blank(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		if (username == null) {
			regPage.loginPass(password);
			regPage.clickRegisterBtn();
			assertTrue(message.contains(regPage.verifyUsernameValidationMessage()));

		} else if (password == null) {
			regPage.loginUsrname(username);
			regPage.clickRegisterBtn();
			assertTrue(message.contains(regPage.verifyPasswordValidationMessage()));

		} else if (username != null && password != null) {
			regPage.login(username, password);
			regPage.clickRegisterBtn();
			assertTrue(message.contains(regPage.verifyUsernameValidationMessage()));
			assertTrue(message.contains(regPage.verifyPasswordValidationMessage()));

		}

	}

	@When("^User enter username \"([^\"]*)\" and password (\\d+) with numeric value only$")
	public void user_enter_username_and_password_with_numeric_value_only(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		confirmPassword = testdata.get(rownumber).get("confirmpassword");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		regPage.loginUsrPass(username, password.substring(1, password.length() - 1),
				password.substring(1, password.length() - 1));

		regPage.clickRegisterBtn();
		assertEquals(message, regPage.verifyMismatchValidationMessage());

	}

	@When("^User enter username \"([^\"]*)\" as blank and password (\\d+) with valid value$")
	public void user_enter_username_as_blank_and_password_with_valid_value_only(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		confirmPassword = testdata.get(rownumber).get("confirmpassword");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		regPage.loginPassConfirmPass(password, confirmPassword);

		regPage.clickRegisterBtn();
		assertEquals(message, regPage.verifyUsernameValidationMessage());

	}

	@When("^User enter username \"([^\"]*)\" and different password (\\d+) and confirm password$")
	public void user_enter_username_and_different_password_and_confirm_password(String sheetname, Integer rownumber)
			throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		username = testdata.get(rownumber).get("username");

		password = testdata.get(rownumber).get("password");

		confirmPassword = testdata.get(rownumber).get("confirmpassword");

		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		regPage.loginUsrPass(username, password, confirmPassword);

		regPage.clickRegisterBtn();
		assertEquals(message, regPage.verifyMismatchValidationMessage());

	}

	@When("^User enter valid username \"([^\"]*)\" and password (\\d+) and confirm password$")
	public void user_enter_valid_username_and_different_password_and_confirm_password(String sheetname,
			Integer rownumber) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String, String>> testdata = null;
		try {
			testdata = reader.getData(
					"C://Users//Gurbax Gill/git/justautomation/Dsalgo/src/test/resources/Exceldata/Register.xlsx",
					sheetname);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		password = testdata.get(rownumber).get("password");
		confirmPassword = testdata.get(rownumber).get("confirmpassword");
		message = testdata.get(rownumber).get("expectedmessage");

		demoLogger.info("User Enter username as \" " + username + " \"and Password as \" " + password + "\" ");

		String uniqueUsrname = "NumpyNinjaUser" + Integer.toString(((new Random().nextInt(10)) + 1));
		regPage.loginUsrPass(uniqueUsrname, password.trim(), confirmPassword.trim());

		regPage.clickRegisterBtn();

		System.out.println("excel file message: " + message + " " + uniqueUsrname);

		System.out.println("logged in msg: " + regPage.verifyLoggedInMsg());
		assertEquals(message + uniqueUsrname, regPage.verifyLoggedInMsg());

	}

}
