package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATS_LandingPage {
	
	@FindBy (xpath="//*[@id='div_id_username']/div/input")
	private WebElement Un;
	
	@FindBy (xpath="//*[@id='div_id_password']/div/input")
	WebElement Pwd;
	
	@FindBy (xpath="//*[@class='login-btn']/button")
	WebElement login_button;
	

  public ATS_LandingPage(WebDriver driver) {
		
	  //this.driver = driver;
	  PageFactory.initElements(driver, this);
	}

  public void login(String username,String password)
	{
	    
		Un.sendKeys(username);
		Pwd.sendKeys(password);
		login_button.click();
	}
  
  }