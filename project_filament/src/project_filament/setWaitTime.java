package project_filament;

import org.openqa.selenium.WebDriver;

public class setWaitTime {

	public void threadWait(String identifier, String value, WebDriver driver) {
		// TODO Auto-generated method stub
		try{
			int getValueint = Integer.parseInt(value);
			Thread.sleep(getValueint);
		}catch(Exception e){
			System.out.println("Error:"+e);
		}
	}

}
