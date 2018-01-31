package project_filament;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public SelectDropdown(String identifier, String veriable, String value,
			String rowNo, WebDriver driver) {
		switch(identifier){
		case "id":
			 Select selectitem = new Select(driver.findElement(By.id(veriable)));
			 selectitem.selectByValue(value);
			break;
		case "xpath":
			Select selectitemxpath = new Select(driver.findElement(By.xpath(veriable)));
			selectitemxpath.selectByValue(value);
			break;
		case "name":
			Select selectitemname = new Select(driver.findElement(By.name(veriable)));
			selectitemname.selectByValue(value);
			break;
		default:
			break;
		
		}

		  
		  
	}

}
