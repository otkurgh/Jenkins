package jenkins.utils;

import java.io.File;

import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class screenShot {

	public static String captureScreenshot(WebDriver driver, String screenshotFileName, String filePath) {
		String screenshotPath = null;
		
		LocalDateTime currenttime=LocalDateTime.now();
		String time = currenttime.toString();
		String timestamp=time.replace(":", "").replace(".", "");
		
				screenshotPath = "target/screenshots" + screenshotFileName + timestamp + ".png";	
        try {
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		

		} catch (Exception e) {
			System.out.println( e);
		
		}
		System.out.println("Screenshot Captured: " + screenshotPath);
		return screenshotPath;
	}
	
	
	public static String captureScreenshotElement(WebDriver driver, String screenshotFileName, WebElement element) {
		
		String screenshotPath = null;
				screenshotPath = "target/screenshots/" + screenshotFileName + ".png";
		
        try {
			File screenshotFile =element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		

		} catch (Exception e) {
			System.out.println( e);
		
		}
		System.out.println("Screenshot Captured: " + screenshotPath);
		return screenshotPath;
	}
	
}
