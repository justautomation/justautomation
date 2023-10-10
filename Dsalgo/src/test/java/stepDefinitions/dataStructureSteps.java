package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utilities.Helper;
import fileReader.ConfigFileReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.dataStructure;
import pageObjects.registerPage;
import pageObjects.signInPage;

public class dataStructureSteps extends BaseClass {

	ConfigFileReader configFileReader = new ConfigFileReader();;

	@Then("User click Get Started button for Data Structure Introduction card")
	public void user_click_get_started_button_for_data_structure_introduction_card() {
		dsPage = new dataStructure(Helper.getDriver());
		dsPage.clickGetStartedBtn();
	}

	@Then("User should redirected to Data Structure Introduction page")
	public void user_should_redirected_to_data_structure_introduction_page() {
		homePage = new HomePage(Helper.getDriver());
		String url = homePage.verifyPage();
		assertEquals(url, configFileReader.getDSPageUrl());
	}

	@When("User click Try Here button in the Data Structure Introduction page")
	public void user_click_Try_Here_button_in_the_data_structure_introduction_page() {
		dsPage.clickTimeComplexity();
		dsPage.clickTryHere();
	}

	@Then("User should be redirected to try Text Editor page")
	public void user_should_be_redirected_to_try_Text_Editor_page() {
		assertEquals(dsPage.verifyTryEditorPage(), configFileReader.getTextEditorPageUrl());
	}

}
