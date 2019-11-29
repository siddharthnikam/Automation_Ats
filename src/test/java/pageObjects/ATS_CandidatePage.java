package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATS_CandidatePage {
	
	public ATS_CandidatePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//*[@href='/candidate/']")
	WebElement candidate_link;
	
	@FindBy (xpath="//*[@id='preventClose']")
	WebElement add_candidate_button;

	@FindBy (xpath="//*[@id='validatedCustomFile']//following-sibling::label")
	WebElement browse_resume;
	
	public void click_CandidateIcon()
	{
		candidate_link.click();
	}
	
	public void click_AddCandidate()
	{
		add_candidate_button.click();
	}
	
	public WebElement click_BrowseButton()
	{
		return browse_resume;
	}
}
