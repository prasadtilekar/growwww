package pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath =  "//div[text()='Mutual Funds']")
	WebElement mutualFund;
	
	@FindBy (xpath =  "//div[text()='Gold']")
	WebElement gold;
	
	@FindBy (xpath =  "//div[text()='Stocks']")
	WebElement stock;
	
	@FindBy (xpath =  "//div[@class='valign-wrapper']")
	WebElement dropdown;
	
	@FindBy (xpath =  "//div[text()='Log Out']")
	WebElement logout;
	
	public  HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnMutualFund ()
	{
		mutualFund.click();
	}
	
	public void clickOnStocks ()
	{
		stock.click();
	}
	
	public void clickOnGold ()
	{
		gold.click();
	}
	
	public void clickOnDropdown ()
	{
		dropdown.click();
	}
	
	public void clickOnLogout ()
	{
		logout.click();
	}
	
	
	
	
	
	

}
