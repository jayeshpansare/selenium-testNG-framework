package project_filament;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Check the error message
 *  
 **/
public class ErrorCheck {

	/**
	 * Check error assert equal to 
	 * @param rowNo 
	 * @param rowNo2 
	 * @param driver 
	 **/
	public void error_equal(String identifier, String veriable, String value, String rowNo, WebDriver driver) {
		
		switch(identifier){
			case "xpath":
				String message = driver.findElement(By.xpath(veriable)).getText();	
				try{
					Assert.assertEquals(value, message);
				}catch(Exception e){	
				}
				break;
			default:
			
				break;
			}
	}

	/**
	 * Check the message is containt or not 
	 * 
	 ***/
	public void error_containt(String identifier, String veriable, String value, String rowNo, WebDriver driver) {
		switch(identifier){
			case "xpath":
				String get_note = driver.findElement(By.xpath(veriable)).getText();
				try{
					Assert.assertTrue(get_note.contains(value));
				}catch(Exception e){
					
				}
				break;
			default:
				break;
		}
	}

}
