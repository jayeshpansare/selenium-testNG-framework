package project_filament;
/**
 * Created by jayesh pansare
 * 
 * For get the input, checkbox, radio, dropdown, submit, buttons
**/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class setInput {
	public void setInputs(String identifier, String veriable, String value,
			WebDriver driver) {
		// TODO Auto-generated method stub
		switch(identifier){
		case "name":
			WebElement getInputByName = driver.findElement(By.name(veriable));
			getInputByName.sendKeys(value);
			break;
		case "id":
			WebElement getInputById = driver.findElement(By.id(veriable));
			getInputById.sendKeys(value);
			break;
		case "cssName":
			WebElement getInputByCssName = driver.findElement(By.className(veriable));
			getInputByCssName.sendKeys(value);
			break;
		case "xpath":
			WebElement getInputByXpath = driver.findElement(By.xpath(veriable));
			getInputByXpath.sendKeys(value);
			break;
		default:
		    break;
	
		}
	}
	/**
	 * click on button 
	 * 
	 **/

	public void clickOnBtn(String identifier, String veriable, WebDriver driver){
		switch(identifier){
		case "xpath":
			driver.findElement(By.xpath(veriable)).click();
			break;
		case "link":
			driver.findElement(By.linkText(veriable)).click();
			break;
		case "id":
			driver.findElement(By.id(veriable)).click();
			break;
		case "textlink":
			driver.findElement(By.linkText(veriable)).click();
			break;
		default:
			break;
			
		}
		
	}
	
}
