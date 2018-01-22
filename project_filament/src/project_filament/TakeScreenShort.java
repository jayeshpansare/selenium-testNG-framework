package project_filament;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShort {
	
	public void capture(String string, WebDriver driver) {
		TakesScreenshot Screenshorts = (TakesScreenshot)driver;
		File Source = Screenshorts.getScreenshotAs(OutputType.FILE);
		try {
			Random rand = new Random();
			int  screen_no = rand.nextInt(50) + 1;	
			FileUtils.copyFile(Source, new File("./Screenshort/"+screen_no+"_error.png"));
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
}
