package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATS_HomePage  {
	
	
	@FindBy(xpath="//*[@id='modal']//following-sibling::nav/div/div/ul/li/i")
	WebElement dashboard_btn;
	
	@FindBy(xpath ="//*[text()='Jobs']")
	WebElement job_briefcase;
	
	@FindBy(xpath = "//*[@class='shutter-out-horizontal']")
	WebElement profile_dropdown;
	
	
	
	public ATS_HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public void click_Dashboard()
	{
		 dashboard_btn.click();
	}
	
	public void navigate_To_JobsModule()
	{
		job_briefcase.click();
	}
	
	public WebElement profile()
	{
		return profile_dropdown;
		
	}
	
	

}
