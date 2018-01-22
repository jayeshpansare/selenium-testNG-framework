package project_filament;
/**
 * Created By jayesh pansare
 * Date: 01/01/2018
 * project: Shoulin Filament
 *  For testing project
 **/

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class filament_main {
	static WebDriver driver;
	
	public static void main(String[] args){
	}
	
	@SuppressWarnings({ "deprecation", "deprecation" })
	@Test(dataProvider="exceldata")
	public void sho_filament(String rowNo, String TC_no, String function, String identifier, String veriable, String value){
		
		if(TC_no!=null){			
			 switch(function){
			case "Open_Browser":
				System.out.println("Start Chorm Browser");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(value);
				WriteExcel writexe = new WriteExcel();
				writexe.writeFunction(rowNo, "Yes");				
				break;
			case "verifylink":
				List<WebElement> links = driver.findElements(By.tagName("a"));
				
				Iterator<WebElement> get_link = links.iterator();
				String get_all_links = null;
				while(get_link.hasNext()){
					String url = get_link.next().getAttribute("href");
					Verifylinks verify = new Verifylinks();
					verify.Verifylink(rowNo, url);
					get_all_links = url+'|'+get_all_links;
				}
				System.out.println(get_all_links);
				
				WriteExcel writexelink = new WriteExcel();
				writexelink.writeFunction(rowNo, get_all_links);
				break;
			case "verifyimage":
				List<WebElement> img_link = driver.findElements(By.tagName("img"));
				
				Iterator<WebElement> get_img_link = img_link.iterator();
				String get_all_img_links = null;
				while(get_img_link.hasNext()){
					String url_img = get_img_link.next().getAttribute("src");
					Verifylinks verify = new Verifylinks();
					verify.Verifylink(rowNo, url_img);
					get_all_img_links = url_img+'|'+get_all_img_links;
				}
				
				WriteExcel writexeimg = new WriteExcel();
				writexeimg.writeFunction(rowNo, get_all_img_links);
				break;
			case "sendInput":
				setInput getInput = new setInput();	
				getInput.setInputs(identifier, veriable, value, driver);
				
				WriteExcel writexeInput = new WriteExcel();
				writexeInput.writeFunction(rowNo, "Yes");
				
				break;
			case "click":
				setInput clickBtn = new setInput();
				clickBtn.clickOnBtn(identifier, veriable, driver);
				
				WriteExcel writexeclick = new WriteExcel();
				writexeclick.writeFunction(rowNo, "Yes");
				
				break;
			case "wait":
				setWaitTime getTime = new setWaitTime();
				getTime.threadWait(identifier, value, driver);
				
				WriteExcel writexewait = new WriteExcel();
				writexewait.writeFunction(rowNo, "Yes");
				
				break;
			case "error_equal":
				
				ErrorCheck ErrorCheckmsg = new ErrorCheck();
				ErrorCheckmsg.error_equal(identifier, veriable, value, rowNo, driver);
				
				WriteExcel writexeeq = new WriteExcel();
				writexeeq.writeFunction(rowNo, "Yes");
				
				break;
			case "error_containt":
				ErrorCheck ErrorCheckms = new ErrorCheck();
				ErrorCheckms.error_containt(identifier, veriable, value, rowNo, driver);
				
				break;
			default:
				break;
				
			}
		}
	}
	
	@DataProvider(name="exceldata")
	public Object[][] passdata(){
		Exceldata getExcelFile = new Exceldata("C:\\Users\\jayesh\\workspace4\\project_filament\\IP_excelfile\\joomla_excel.xlsx");
		int lastRowCount = getExcelFile.getTotalRow(2);
		Object[][] data = new Object[lastRowCount][6];
		for(int i=1; i<lastRowCount;i++){
			data[i][0] = getExcelFile.getData(2, i, 0);
			data[i][1] = getExcelFile.getData(2, i, 2);
			data[i][2] = getExcelFile.getData(2, i, 3);
			data[i][3] = getExcelFile.getData(2, i, 4);
			data[i][4] = getExcelFile.getData(2, i, 5);
			data[i][5] = getExcelFile.getData(2, i, 6);
		}
	
		return data;

	}
	
	@AfterMethod
	public void takescreenshort(ITestResult result){
		if(ITestResult.FAILURE == result.getStatus()){
			TakeScreenShort screenShort = new TakeScreenShort();
			screenShort.capture("img",driver);
		}
	}
	
	@AfterTest
	public void closebrowser(){
		//driver.close();
	}
}
