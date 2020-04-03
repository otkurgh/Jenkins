package jenkins.pages;


import java.util.List;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import jenkins.base.BaseClass;

public class ResultPage extends BaseClass {

	public ResultPage showResults() {
		
								
  List<WebElement> list=driver.findElements(By.tagName("a"));
  
  System.out.println("There are " + list.size()+ " results found....");
	
	return this;
	}
	
	
	
	public SeleniumPage targetLink() {
		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		  
		  for(WebElement elem:list) {
			
			  if(elem.getText().equals("Selenium")) {
				  
				  elem.click();
				  break;
				  
				  
			  }
		  
		  }
		
		
		
		
		return new SeleniumPage();
	}
	
}
