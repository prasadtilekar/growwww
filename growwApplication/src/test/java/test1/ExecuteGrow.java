package test1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom1.BaseClass;
import pom1.HomePage;
import pom1.LoginPage;
import pom1.PINPage;

import utilities.utility;

public class ExecuteGrow extends BaseClass {
	
	private WebDriver driver;
	private LoginPage login;
	private PINPage pin;
	private HomePage homepage;
	private SoftAssert soft;
	
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters ("browser")
	public void launchBrowser(String browser)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("Before Test");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver =launchChrome();
		}	
		else
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver =launchFireFox();
			}
		}
	}
	@BeforeClass
	public void browserLaunch()
	{
		System.out.println("Before Class");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 login =new LoginPage(driver);
		 pin =new PINPage(driver);
		 homepage =new HomePage(driver);
		 soft = new SoftAssert ();
	}
	
	@BeforeMethod 
	public void logInApp() throws InterruptedException
	{
		System.out.println("Before method");
		Thread.sleep(1000);
		driver.get("https://groww.in/login");
		login.sendEmail();
		login.clickContinue();
		login.sendPassword();
		login.clickSubmit();
		pin.enterPIN();
	}
	
	@Test 
	public void ValidateMutualfundIcon () throws InterruptedException
	{
		testID = 100;
		System.out.println("Test1");
		
		Thread.sleep(3000);
		homepage.ClickOnMutualFund();
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://groww.in/dashboard/explore/mutual-funds");
		System.out.println(url);
		
	}
	@Test 
	public void ValidateGoldIcon () throws InterruptedException
	{
		testID = 101;
		System.out.println("Test2");
		Thread.sleep(3000);
		homepage.clickOnGold();
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://groww.in/dashboard/explore/gold");
		System.out.println(url);
		//soft.assertAll();
		
	}
	
	@Test 
	public void ValidateStocksIcon () throws InterruptedException
	{
		testID = 103;
		System.out.println("Test3");
		Thread.sleep(3000);
		homepage.clickOnStocks();
		String url = driver.getCurrentUrl();
		
		if(url.equals("https://kite.zerodha.com/dashboard"))
		{
			System.out.println("Dashboard link is "+url);
		}
		else
		{
			Assert.fail();
		}
		
		
	}
	
	@AfterMethod 
	public void logoutApp (ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			utility.takeScreenshot(driver, testID);
		}
		Thread.sleep(10000);
		System.out.println("After Method");
		
		Thread.sleep(3000);
		homepage.clickOnDropdown();
		homepage.clickOnLogout();
	}
	
	@AfterClass
	public void closeRef ()
	{
		System.out.println("After Class");
		login =null;
		pin =null;
		homepage =null;
		soft =null;
		
	}
	
	@AfterTest
	public void closeApp ()
	{
		System.out.println("After test");
		driver.close();
		driver = null;
		System.gc();
	}
	
	
	
	
	

}
