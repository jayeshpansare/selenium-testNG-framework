package project_filament;
/**
 * Created By jayesh pansare
 * Date: 05/01/2018
 * project: Shoulin Filament
 * Lib for get driver, 
 * Note only chorm driver we implement other driver not working.  
 **/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class setBrowser {

	public setBrowser(String nameOfBrowser, String URL, WebDriver driver) {
		switch(nameOfBrowser){
			case "chorm":
				System.out.println("Start Chorm Browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\chromedriver.exe");
				driver = new ChromeDriver();
				get(driver, URL);
				
				System.out.println("End Chorm Browser");
				break;
			case "firefox":
				/* System.setProperty("webdriver.gecko.driver","C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\geckodriver.exe");
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setCapability("marionette", true);
				
				System.out.println("Start FirefoxDriver");
				driver = new FirefoxDriver();
				get(driver, "http://uksdesigns.com/ad/index1.html");
				System.out.println("End of FirefoxDriver");*/
				break;
			case "IE":
				/* System.setProperty("webdriver.ie.driver", "C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\IEDriverServer.exe");
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		        
				driver = new InternetExplorerDriver();
				*/
				System.out.println("Ie");
				break;
			default:
				System.out.println("Start Chorm Browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\chromedriver.exe");
				driver = new ChromeDriver();
				get(driver, "http://uksdesigns.com/ad/index1.html");
				System.out.println("End Chorm Browser");
				break;
		}
	}
	
	/**
	 * Set url  
	 ***/
	private void get(WebDriver driver, String getUrl) {
		driver.get(getUrl);
		System.out.println("Enter Url :"+getUrl);
	}
}
