package pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	@FindBy (xpath = "//input[@id='login_email1']")
	private WebElement email;
	
	@FindBy (xpath = "//span[text()='Continue']")
	private WebElement continuebtn;
	
	@FindBy (xpath = "//input[@id='login_password1']")
	private WebElement password;
	
	@FindBy (xpath = "//span[text()='Submit']")
	private WebElement submit;
	
	public LoginPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendEmail()
	{
		email.sendKeys("prasadtilekar7@gmail.com");
		
	}
	
	public void clickContinue()
	{
		continuebtn.click();
	}
	
	public void sendPassword()
	{
		password.sendKeys("pasha@9623");
		
	}
	
	public void clickSubmit()
	
	{
		submit.click();
	}
}
