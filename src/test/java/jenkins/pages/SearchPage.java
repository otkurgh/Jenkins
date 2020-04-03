package jenkins.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import jenkins.base.BaseClass;


public class SearchPage extends BaseClass {

	
	public SearchPage homepage() {

		driver.get("https://www.google.com");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		System.out.println("The page title is confirmed....");
		
		return this;	
		
	}
	
	public ResultPage result() {
		WebElement textbox=driver.findElement(By.name("q"));
		textbox.sendKeys("Selenium");
		textbox.sendKeys(Keys.ENTER);
		System.out.println("Page turns into result paage.....");
		return new ResultPage();
	}
	
	
	
	
}
