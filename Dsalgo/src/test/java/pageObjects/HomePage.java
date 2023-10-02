package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utilities.Helper;
import fileReader.ConfigFileReader;
import stepDefinitions.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public HomePage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	By dataStructureDropDwn = By.xpath("//a[contains(text(), 'Data Structures')]");
	By getStartedButton = By.xpath("//a[contains(@href, 'data-structures-introduction')]");
	By errorMessage = By.xpath("//div[contains(text(), 'You are not logged in')]");

	public boolean isDropdownDisplayed() {
		return driver.findElement(dataStructureDropDwn).isDisplayed();
	}

	public void getStartedButtonClick() {
		Helper.webClick(driver.findElement(getStartedButton));
	}

	public boolean verifyErrorMessage() {
		this.driver = Helper.getDriver();
		return driver.findElement(errorMessage).isDisplayed();
	}
}
