package jenkins.tests;

import org.testng.annotations.Test;

import jenkins.base.BaseClass;
import jenkins.pages.ResultPage;
import jenkins.pages.SearchPage;

public class GoogleTest extends BaseClass {

	SearchPage search =new SearchPage();
	ResultPage result = new ResultPage();

	@Test
	public void googleSearch() {
		test=extent.createTest("googleSearch");
		search.homepage();
		search.result();
		result.showResults();

	}

}
