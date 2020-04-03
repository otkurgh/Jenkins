package jenkins.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import jenkins.utils.screenShot;


public class BaseClass {

	public static WebDriver driver;
	//public Page page;
    
    

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	public void setExtent() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");// Title of the report
		htmlReporter.config().setReportName("Functional Report");// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Tester Name", "Otkur");
		extent.setSystemInfo("OS", "Mac");

	}

	@AfterClass
	public void endReport() {

		extent.flush();
		driver.quit();

	}

	
	@BeforeMethod
	@Parameters(value= {"browser"})
	public void setUp(@Optional("chrome")String browser) {

		try {
			if(browser.equals("chrome")) {
	        WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser is launched...");
		
			
		} else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser is launched...");

		} else {
			
			System.out.println("No browser defined in xml file...");
			
		}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			//page=new Page(driver);
			
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			screenShot.captureScreenshot(driver, result.getName(), "target/screenshots/");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIPPED IS " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName());
		}

		driver.close();
	}
	
}
