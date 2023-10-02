package stepDefinitions;

import org.junit.Assert;

import Utilities.Helper;
import fileReader.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class homePageSteps extends BaseClass {
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Given("User is on homepage of DS Algo")
	public void user_is_on_homepage_of_DS_Algo() {
		homePage = new HomePage(Helper.getDriver());
		Helper.openPage(configFileReader.getHomePageUrl());
		Assert.assertTrue(homePage.isDropdownDisplayed());
	}

	@When("User click on {string} for the different option without login")
	public void user_click_on_for_the_different_option_without_login(String getStartedBtn) {
		Assert.assertTrue(homePage.isDropdownDisplayed());
		homePage.getStartedButtonClick();
	}

	@Then("User should get error message")
	public void user_should_get_error_message() {
		Assert.assertTrue(homePage.isDropdownDisplayed());
		homePage.getStartedButtonClick();
	}

}
