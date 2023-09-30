package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDET_129_BDD_SD {
	
	public static WebDriver driver;
	String URL = "https://juice-shop.herokuapp.com/#/register";
	
	By dismissBtn = By.xpath("//button//span[text()='Dismiss']");
	By emailID = By.id("emailControl");
	By passwordTxt = By.id("passwordControl");
	By confirmPassword = By.id("repeatPasswordControl");
	By secQnBox = By.xpath("//div[@id='mat-select-value-1']/span");
	By secQn = By.xpath("//span[text()=' Your eldest siblings middle name? ']");
	By secQnAns = By.id("securityAnswerControl");
	
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(dismissBtn).click();
		driver.findElement(emailID).sendKeys("arpita@gmail.com");
	   
	}

	@Given("some other precondition")
	public void some_other_precondition() {
		
	
		driver.findElement(passwordTxt).sendKeys("arpita@123");
		driver.findElement(confirmPassword).sendKeys("arpita@123");
		driver.findElement(secQnBox).click();
		driver.findElement(secQn).click();
		driver.findElement(secQnAns).sendKeys("kumar");
	}
	  

	@When("I complete action")
	public void i_complete_action() {
	  
	}

	@When("some other action")
	public void some_other_action() {
	  
	}

	@When("yet another action")
	public void yet_another_action() {
	   
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	 
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	
	}
	

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	
	}

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
	  
	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {
	   
	}

	@Given("I want to write a step with name2")
	public void i_want_to_write_a_step_with_name2() {
	 
	}

	@Then("I verify the Fail in step")
	public void i_verify_the_fail_in_step() {
	  
	}


}
