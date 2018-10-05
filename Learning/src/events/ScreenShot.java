package events;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import crm.TestNgBasics;

public class ScreenShot {
	public static void captureScreenShot() throws IOException
	{
		File src = ((TakesScreenshot) TestNgBasics.driver).getScreenshotAs(OutputType.FILE);
		//EventFiringWebDriver edr = new EventFiringWebDriver(TestNgBasics.driver);
		//File src =  edr.getScreenshotAs(OutputType.FILE);
		
		StringBuffer failedPicPath = new StringBuffer();
		failedPicPath.append("D:/selenium/ScreenShots/");
		String fn = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString(); 
		failedPicPath.append(fn);
		failedPicPath.append(".jpg");
		
		FileUtils.copyFile(src, new File(failedPicPath.toString()));
	}
}
