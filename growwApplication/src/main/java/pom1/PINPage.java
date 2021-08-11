package pom1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PINPage {
	
	@FindBy (xpath = "//input[@class='otpinput88']")
	List<WebElement> pinBox;
	
	public PINPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPIN()
	
	{
		
		String[] pins = {"9","6","2","3"};
		
		
		for(int i=0;i<pinBox.size();i++)
		
		pinBox.get(i).sendKeys(pins[i]);
		
		
	}
	
	
	
	
	
	

}
