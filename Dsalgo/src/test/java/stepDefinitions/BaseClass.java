package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.arrayPage;
import pageObjects.dataStructure;
import pageObjects.graphPage;
import pageObjects.listPage;
import pageObjects.queuePage;
import pageObjects.registerPage;
import pageObjects.signInPage;
import pageObjects.stackPage;
import pageObjects.treePage;

public class BaseClass {
	public LandingPage landingPage;
	public HomePage homePage;
	public signInPage loginPage;
	public registerPage regPage;
	public dataStructure dsPage;
	public arrayPage arryPage;
	public listPage listPg;
	public stackPage stackPg;
	public queuePage queuePg;
	public treePage treePg;
	public graphPage graphPg;

	public static WebDriver driver;
	String title;

	public WebDriver setDriver(String browser) {
		ChromeOptions options = new ChromeOptions();
		options.setImplicitWaitTimeout(Duration.ofSeconds(20));
		options.addArguments("--remote-allow-origins=*");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().clearDriverCache().setup();
			WebDriverManager.edgedriver().clearResolutionCache().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().clearDriverCache().setup();
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().clearDriverCache().setup();
			WebDriverManager.safaridriver().clearResolutionCache().setup();
			driver = new SafariDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	

}
