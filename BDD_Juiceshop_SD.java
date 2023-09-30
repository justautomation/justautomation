package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDD_Juiceshop_SD {
	
	public static WebDriver driver;
	String URL = "https://juice-shop.herokuapp.com/#/register";
	
	By dismissBtn = By.xpath("//button//span[text()='Dismiss']");
	By emailID = By.id("emailControl");
	By passwordTxt = By.id("passwordControl");
	By confirmPassword = By.id("repeatPasswordControl");
	By secQnBox = By.xpath("//div[@id='mat-select-value-1']/span");
	By secQn = By.xpath("//span[text()=' Your eldest siblings middle name? ']");
	By secQnAns = By.id("securityAnswerControl");

	
	@Given("user open the juiceshop application register page")
	public void user_open_the_juiceshop_application_register_page() {
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(dismissBtn).click();
		
	}    

	@When("user enter emailis as {string} in juiceshop application register page")
	public void user_enter_emailis_as_in_juiceshop_application_register_page(String string) {
		driver.findElement(emailID).sendKeys(string);  
	}

	@When("user enter password as {string} in juiceshop application register page")
	public void user_enter_password_as_in_juiceshop_application_register_page(String string) {
		driver.findElement(passwordTxt).sendKeys(string);
	}

	@When("user enter confirmpassword as {string} in juiceshop application register page")
	public void user_enter_confirmpassword_as_in_juiceshop_application_register_page(String string) {
		driver.findElement(confirmPassword).sendKeys(string);
	}

	@When("user enter securityquestion as {string} in juiceshop application register page")
	public void user_enter_securityquestion_as_in_juiceshop_application_register_page(String string) {
		driver.findElement(secQnBox).click();
		driver.findElement(secQn).click();

	}

	@When("user enter securityquestionAns as {string} in juiceshop application register page")
	public void user_enter_securityquestion_ans_as_in_juiceshop_application_register_page(String string) {
		driver.findElement(secQnAns).sendKeys(string);

	}

	@Then("user clicks registerbutton in juiceshop application register page")
	public void user_clicks_registerbutton_in_juiceshop_application_register_page() {
	   
	}


}
