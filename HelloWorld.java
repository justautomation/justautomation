
/**************************hardcoded inputs*******************************************/


//package selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//

//public class HelloWorld {
//
//	public static void main(String[] args) {
//		
//	//	System.setProperty("webdriver.chrome.driver", "/Users/praveenkumarsharma/eclipse-workspace/Hello-Selenium/src/test/resources/drivers/chromedriver-mac-x64");
//		ChromeDriver driver = new ChromeDriver();
//		//driver.get("https://amazon.com");
//		driver.get("https://numpyninja.com/contact");
//		
//		WebElement frstname = driver.findElement(By.name("first-name"));
//		frstname.sendKeys("Arpita");
//		WebElement lstname = driver.findElement(By.name("last-name"));
//		lstname.sendKeys("Ghosh");
//		WebElement email = driver.findElement(By.name("email"));	
//		email.sendKeys("arpita@ghosh.com");
//		WebElement phnum = driver.findElement(By.name("phone"));	
//		phnum.sendKeys("998888777777");
//		WebElement msgtxt = driver.findElement(By.id("textarea_comp-l1c0ku07"));
//		msgtxt.sendKeys("this is my firdt selenium class");
//		WebElement sendbtn = driver.findElement(By.id("comp-l1c0ku0e3"));	
//		sendbtn.click();
//		
//	}	
//}
/**************************************************************************************/


	package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	

public class HelloWorld {
	
	static ChromeDriver driver;
	
	public static void main(String[] args) {
		
	//	System.setProperty("webdriver.chrome.driver", "/Users/praveenkumarsharma/eclipse-workspace/Hello-Selenium/src/test/resources/drivers/chromedriver-mac-x64");
		
		driver = new ChromeDriver();
		driver.get("https://numpyninja.com/contact");
		// New changes 
		 testContactForm("arpita","ghosh","arpi@ghosh.com","12234455","hello");
		 testContactForm("arpita","ghosh","","12234455","hello");
		testContactForm("arpita","ghosh","arpighosh.com","12234455","hello");
		testContactForm("arpita","ghosh","arpighosh.com","","hello");
		testContactForm("","","arpighosh.com","12234455","hello");

		
	}	
	public static void testContactForm(String fstnm,String lstnm,String mailad,String phonum,String msg) {
		WebElement frstname = driver.findElement(By.name("first-name"));
		frstname.sendKeys(fstnm);
		WebElement lstname = driver.findElement(By.name("last-name"));
		lstname.sendKeys(lstnm);
		WebElement email = driver.findElement(By.name("email"));	
		email.sendKeys(mailad);
		WebElement phnum = driver.findElement(By.name("phone"));	
		phnum.sendKeys(phonum);
		WebElement msgtxt = driver.findElement(By.id("textarea_comp-l1c0ku07"));
		msgtxt.sendKeys(msg);
		driver.navigate().refresh();
		
	    WebElement sendbtn = driver.findElement(By.id("comp-l1c0ku0e3"));	
	    sendbtn.click();
				
	}
}