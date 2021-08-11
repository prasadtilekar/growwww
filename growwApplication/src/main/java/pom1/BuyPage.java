package pom1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPage {
	WebDriver driver;
	@FindBy (xpath ="//input[@type='text']")
	WebElement searchBox;
	
	@FindBy (xpath = "//input[@type='number']")
	WebElement value;
	
	@FindBy (xpath ="//span[text()= 'BUY']")
	WebElement buyButton;
	
	public BuyPage (WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		 
	}
	
	public void ClickOnSearch () 
	{
//		searchBox.sendKeys("tata power company");
//		searchBox.sendKeys(Keys.ARROW_DOWN);
//		searchBox.click();
//		searchBox.sendKeys(Keys.ENTER);
		
		Actions act =new Actions (driver);
		act.moveToElement(searchBox).perform();
		act.sendKeys(searchBox, "tata power company").perform();
		act.click(searchBox).perform();
		act.sendKeys(searchBox,Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		System.out.println("pass");
		
	}
	
	public void SendValue (String a)
	{
		value.sendKeys(a);
	}
	
	public void ClickOnBuy ()
	{
		String text =buyButton.getText();
		System.out.println(text);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
