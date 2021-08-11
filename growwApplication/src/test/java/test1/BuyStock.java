package test1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom1.BaseClass;
import pom1.BuyPage;
import pom1.HomePage;
import pom1.LoginPage;
import pom1.PINPage;

public class BuyStock extends BaseClass{

	private WebDriver driver;
	private LoginPage login;
	private PINPage pin;
	private HomePage homepage;
	private BuyPage buy;
	int testID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
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
			driver =launchFireFox();
		}
		
	}
	
	@BeforeClass
	public void launchApplication()
	{
		System.out.println("Before Class");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 login =new LoginPage(driver);
		 pin =new PINPage(driver);
		 homepage =new HomePage(driver);
		 buy =new BuyPage(driver);
		 
	}
	
	@BeforeMethod 
	public void loginApp()
	{
		System.out.println("Before Method");
		driver.get("https://groww.in/login");
		login.sendEmail();
		login.clickContinue();
		login.sendPassword();
		login.clickSubmit();
		pin.enterPIN();
		homepage.clickOnStocks();
		
	}
	
	@Test 
	public void ValidateStockBuy ()
	{
		testID = 100;
		System.out.println("Test");
		
		buy.ClickOnSearch();
		buy.SendValue("1");
		buy.ClickOnBuy();
	}
	
	@AfterMethod 
	public void logoutApp () throws InterruptedException
	{
		Thread.sleep(3000);
		homepage.clickOnDropdown();
		homepage.clickOnLogout();
	}
	
	@AfterClass
	public void closeObject ()
	{

		
		 login=null;
		 pin=null;
		 homepage=null;
		 buy=null;
	}
	
	@AfterTest
	public void closeApp ()
	{
		driver.close();
	}
}
