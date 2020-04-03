package jenkins.pages;

import jenkins.base.BaseClass;

public class SeleniumPage extends BaseClass {

	public String pageTitle;
	
   public SeleniumPage pageConfirm() {
	   
	   pageTitle=driver.getTitle();
	   
	   System.out.println("The title of the page is" + pageTitle);
	   
	   return this;
   }
	
	
}
