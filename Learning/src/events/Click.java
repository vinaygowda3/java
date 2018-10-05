package events;

import java.io.IOException;

import org.openqa.selenium.By;

import crm.TestNgBasics;

public class Click {
	public String click(String elementId,String locatorVal) throws IOException
	{
		String retVal=null;
		if(elementId.equals("css"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.cssSelector(locatorVal)).click();
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				retVal="FAIL-"+locatorVal+" not found";
			}			
		}
		else if(elementId.equals("xpath"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.xpath(locatorVal)).click();
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				ScreenShot.captureScreenShot();
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		else if(elementId.equals("linktext"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.linkText(locatorVal)).click();
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		else if(elementId.equals("name"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.name(locatorVal)).click();
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		else if(elementId.equals("id"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.id(locatorVal)).click();
				
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				ScreenShot.captureScreenShot();
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		
		return retVal;
	}
}
