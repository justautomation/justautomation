package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helper;
import fileReader.ConfigFileReader;
import stepDefinitions.BaseClass;

public class dataStructure extends BaseClass {

	WebDriver driver;
	ConfigFileReader configFileReader;

	public dataStructure(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	By getStartedBtn = By.xpath("//div/a[@href= 'data-structures-introduction']");
	By timeComplexity = By.xpath("//div/ul/a[@href='time-complexity']");
	By tryHere = By.xpath("//a[@href='/tryEditor']");
	By runBtn = By.xpath("//button[@onclick=\"runit()\"]");

	public void clickGetStartedBtn() {
		Helper.webClick(driver.findElement(getStartedBtn));
	}

	public void clickTimeComplexity() {
		Helper.webClick(driver.findElement(timeComplexity));
	}

	public void clickTryHere() {
		Helper.webClick(driver.findElement(tryHere));
	}

	public String verifyTryEditorPage() {
		assertTrue(driver.findElement(runBtn).isDisplayed());
		return driver.getCurrentUrl();
	}

}
