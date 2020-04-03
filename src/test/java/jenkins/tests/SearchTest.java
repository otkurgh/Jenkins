package jenkins.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import jenkins.base.BaseClass;
import jenkins.pages.ResultPage;
import jenkins.pages.SearchPage;
import jenkins.pages.SeleniumPage;

public class SearchTest extends BaseClass {

	SearchPage search =new SearchPage();
	ResultPage result = new ResultPage();
	SeleniumPage sel=new SeleniumPage();
	
	
	@Test
	public void searchResultTest() throws InterruptedException {
		
		test=extent.createTest("googleSearch");
		search.homepage();
		search.result();
		result.showResults();
		result.targetLink();
		sel.pageConfirm();
		Assert.assertEquals(sel.pageTitle, "7 Science-Based Health Benefits of Selenium");	
	}
	
	
}
