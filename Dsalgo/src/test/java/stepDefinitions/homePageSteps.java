package stepDefinitions;

import static org.testng.Assert.assertEquals;

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
//		Assert.assertTrue(homePage.isDropdownDisplayed());
	}

	@When("^User click on \"([^\"]*)\" for the data structure option without login$")
	public void user_click_on_for_the_data_structure_option_without_login(String getStartedBtn) {
		Assert.assertTrue(homePage.isDropdownDisplayed());
		homePage.getStartedButtonClick(getStartedBtn);
	}

	@Then("^User should get error message \"([^\"]*)\"$")
	public void user_should_get_error_message(String errorMsg) {
		Assert.assertEquals(homePage.verifyErrorMessage(), errorMsg);
	}

	@When("^User click on \"([a-zA-Z]{1,})\" from drop down menu without login$")
	public void user_click_on_from_drop_down_menu_without_login(String arrayLink) {
		homePage.selectDropdownOption();
	}
	
	@When("^User click on \"([a-zA-Z]{1,})\" button$")
	public void user_click_on_button(String register) {
		homePage.clickRegisterBtn(register);
	}
	
	@Then("User should redirected to Register page")
	public void user_should_redirected_to_page() {
		String url = homePage.verifyRegisterPage();
		assertEquals(url,configFileReader.getRegisterPageUrl());
	}
	

}
