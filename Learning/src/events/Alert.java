package events;

import org.openqa.selenium.By;

import crm.TestNgBasics;

public class Alert {
	
	public String alert(String elementId,String locatorVal)
	{
		String retVal=null;
		if(elementId.equals("css"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.cssSelector(locatorVal)).click();
				org.openqa.selenium.Alert alt = TestNgBasics.driver.switchTo().alert();
				alt.dismiss();
				
				
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
				org.openqa.selenium.Alert alt = TestNgBasics.driver.switchTo().alert();
				alt.accept();
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		else if(elementId.equals("linktext"))
		{
			try 
			{
				TestNgBasics.driver.findElement(By.linkText(locatorVal)).click();
				org.openqa.selenium.Alert alt = TestNgBasics.driver.switchTo().alert();
				alt.accept();
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
				org.openqa.selenium.Alert alt = TestNgBasics.driver.switchTo().alert();
				String actmsg=alt.getText();
				System.out.println(actmsg);
				alt.accept();
				
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
				org.openqa.selenium.Alert alt = TestNgBasics.driver.switchTo().alert();
				String actmsg=alt.getText();
				System.out.println(actmsg);
				alt.accept();
				Thread.sleep(1000);
				retVal="PASS-Clicked on "+locatorVal;
			} 
			catch (Exception e) 
			{
				retVal="FAIL-"+locatorVal+" not found";
			}
		}
		
		return retVal;
	}

}
