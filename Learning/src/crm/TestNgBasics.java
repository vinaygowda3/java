package crm;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import events.ScreenShot;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import util.Frames;
import util.TestUtil;

@Test
public class TestNgBasics {
	public static WebDriver driver;
	
	//@BeforeClass
	public void Browser(){
		System.setProperty("webdriver.chrome.driver", "D:/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
/*	@DataProvider
	public Object [][] GetLoginData() throws InvalidFormatException{
		Object data [][] = TestUtil.GetTestData("login");
		return data;
		
	}
	
	*/
	@DataProvider
	public Object[][]  GetUserData() throws InvalidFormatException{
		Object[][] userdata = TestUtil.arrayExcelData("login");
		return userdata;
		
	}
	
//	@Test(dataProvider = "GetUserData")
//	public void loginTest(String username, String password){
//		
//		
//		driver.findElement(By.name("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//input[@value='Login']")).submit();	
//	}
	public void Login(){
				// Configure the Action
		
		try {
			String Adminusername = TestUtil.getExcelData("login",2,0);
			String Adminpassword = TestUtil.getExcelData("login",2,1);
			driver.findElement(By.name("username")).sendKeys(Adminusername);
			driver.findElement(By.name("password")).sendKeys(Adminpassword);
			driver.findElement(By.xpath("//input[@value='Login']")).submit();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		/*			
			driver.switchTo().frame(1);
			String VerifyText = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
			System.out.println(VerifyText);
			String ActualText = "HOME";
			if(VerifyText.equalsIgnoreCase(ActualText))
			{  			
				TestUtil.writeToExcel("login",2,2,"Pass");
				System.out.println("Login sucessfull");
				ScreenShot.captureScreenShot();
			}
			else
			{
				TestUtil.writeToExcel("login",2,2,"Fail");
				System.out.println("Login failed");
			}
//			driver.switchTo().defaultContent();
			*/
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@AfterClass
	public void teardown(){
		driver.quit();
	}
}
