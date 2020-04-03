package jenkins.pages;


import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import jenkins.base.BaseClass;

public class ResultPage extends BaseClass {

	public ResultPage showResults() {
		
								
	
  List<WebElement> list=driver.findElements(By.tagName("a"));
  
  for(WebElement elem:list) {
	
	  System.out.println(elem.getAttribute("href"));
  
  }
	
	return this;
	}
	
	
	
}
