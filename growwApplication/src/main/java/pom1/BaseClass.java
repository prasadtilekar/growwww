package pom1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver launchChrome ()
	{
		System.setProperty("webdriver.chrome.driver","C:\\database\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		return driver;
	}
	public WebDriver launchFireFox ()
	{
		System.setProperty("webdriver.gecko.driver","C:\\database\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		
		return driver;
	}
	
}
