package jenkins.pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import jenkins.base.BaseClass;

public class ResultPage extends BaseClass {

	public ResultPage showResults() {
		
								
  List<WebElement> list=driver.findElements(By.tagName("a"));
  
  System.out.println("There are " + list.size()+ " results found....");
	
	return this;
	}
	

	public SeleniumPage targetLink() throws InterruptedException {
		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		for(int i=0; i<3; i++) {
			  js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",list.get(51));
			  Thread.sleep(1000);;
			  js.executeScript("arguments[0].setAttribute('style', 'background:white; border:2px solid red;');",list.get(51));
			  Thread.sleep(1000);
		  }
				
		  list.get(51).click();
				
		
				  
				 
		
		  
		  
		
		return new SeleniumPage();
	}
	
}
