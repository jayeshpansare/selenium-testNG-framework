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
		case "Id":
			WebElement getInputById = driver.findElement(By.id(veriable));
			getInputById.sendKeys(value);
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
		default:
			break;
			
		}
		
	}
	
}
