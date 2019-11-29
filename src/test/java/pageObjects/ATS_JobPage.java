package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ATS_JobPage {
	
	public ATS_JobPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//*[@id='job_datatable_filter']/label/input")
	WebElement search;
	
	@FindBy (xpath ="//*[@id='preventClose']")
	WebElement add_job;
	
	@FindBy (xpath ="//*[@id='job_datatable_previous']")
	WebElement previous;
	
	@FindBy (xpath ="//*[@id='job_datatable_next']")
	WebElement dashboard_next;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']/a/i")
	WebElement back_arrow;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[1]/a")
	WebElement all;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[2]/a")
	WebElement open;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[3]/a")
	WebElement closed;
	
	@FindBy (xpath = "//*[@class='candidate_page_back_btn']//following-sibling::li[4]/a")
	WebElement published;
	
	
	//------------------ BASICS --------------------
	
	@FindBy (xpath="//*[@class='modal-header']//following-sibling::div/div/div/div/div/div/input")
	WebElement job_title;
	
	@FindBy (xpath="//*[@id='id_application_form']")
	WebElement application_form;
	
	@FindBy (xpath="//*[@id='id_request_id']")
	WebElement req_id;
	
	@FindBy (xpath="//*[@id='id_job_type']")
	WebElement job_type;
	
	@FindBy (xpath="//*[@id='id_job_time']")
	WebElement job_time;
	
	@FindBy (xpath="//*[@id='id_location']")
	WebElement location_address;
	
	@FindBy (xpath="//*[@id='id_salary']")
	WebElement salary;
	
	@FindBy (xpath="//*[@id='id_salary_type']")
	WebElement salary_type;
	
	@FindBy (xpath="//*[@id='id_department']")
	WebElement department;
	
	@FindBy (xpath="//*[@class='modal-footer']/button[2]")
	WebElement basics_next_button;
	
	
	// ------------ ADDITIONAL DETAILS AND DESCRIPTION ---------------
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[1]/div[1]/div/div//following-sibling::input[1]")
	WebElement client_manager;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[1]/div[2]/div[1]/div//following-sibling::input[1]")
	WebElement no_of_resources;
	
	@FindBy (xpath ="//*[@id='input']")
	WebElement date_opened;
	
	// Calender webelements
	@FindBy (xpath ="//*[text()='event']")
	WebElement calender_icon;
	
	@FindBy (xpath ="//*[@class ='gj-modal']/div/div/div/div[1]/i")
	WebElement calender_previous;
	
	@FindBy (xpath ="//*[@role='period']//following-sibling::div/i")
	WebElement calender_next;
	
	@FindBy (xpath ="//*[@role='period']")
	WebElement calender_monthyear;
	
	@FindBy (xpath ="//*[@role='calendar']")
	WebElement outer_Calender;
	
	@FindBy(xpath="//*[text()='Ok']")
	WebElement calender_Ok;
	//--------------------------------------------------
	
	@FindBy (xpath ="//*[text()='Additional Details & Description']")
	WebElement add_dtl_n_desc;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]")
	WebElement textarea;
	
	@FindBy ( xpath="//*[text()='Back']")
	WebElement basics_back_button;
	

	//-------------- HIRING TEAM AND STAGES ----------------------------
	
	@FindBy (xpath="//*[@id='id_Hiring_Manager']")
	WebElement hiring_managers;
	
	
	@FindBy (xpath ="//*[@class='tabbed-content']/div[3]/div[2]/div/div/input")
	WebElement coordinators;
	
	@FindBy (xpath="//*[@id='id_Recruiter']")
	WebElement recruiters;
	
	@FindBy (xpath="//*[@class='tabbed-content']/div[3]/div[2]/div[2]/div/select")
	WebElement hiring_process;
	
	@FindBy (xpath="//*[text()='Add Job']")   // find a new xpath for this
	WebElement popup_add_job_button;
	
	
	public void click_AddJob()
	{
		add_job.click();
	}
	
	public void get_JobTitle(String jb_title)
	{
		job_title.sendKeys(jb_title);
	}
	
	public WebElement get_ApplicationForm()
	{
		return application_form;
	}
	
	public void get_ReqId()
	{
		req_id.sendKeys("78765s");
	}
	
	public WebElement get_JobType()
	{
		return job_type;
	}
	
	public WebElement get_JobTime()
	{
		return job_time;
	}
	
	public void get_Location_Address()
	{
		location_address.sendKeys("Pune");
	}
	
	public void get_Salary()
	{
		salary.sendKeys("50000");
	}
	
	public WebElement get_SalaryType()
	{
		return salary_type;
	}
	
	public WebElement get_Department()
	{
		return department;
	}
	
	public void click_BasicsNext()
	{
		basics_next_button.click();
	}
	
	public void get_ClientManager()
	{
		client_manager.sendKeys("Haresh Tetgure");
	}
	
	public void get_Number_Of_Resources()
	{
		no_of_resources.sendKeys("2");
	}
	
	public void click_CalenderIcon()
	{
		calender_icon.click();
	}
	
	public WebElement get_FullCalender()
	{
		return outer_Calender;
	}
	
	
	public void get_Date(String input_date)  // In format : 30/December/2019
	{
		String input_day,input_month,input_year,input_monthyear,combined_monthyear; // splited content of user inputted date
		String cal_date,retrieved_calendarmonthyear;    // retrieved from website
		String dateArray[] = input_date.split("/");   // aplitting the date
		input_day = dateArray[0].trim();  // assigining date
		input_month = dateArray[1].trim();  // assigning month
		input_year = dateArray[2].trim();  // assigning year
		combined_monthyear =input_month+" "+input_year;  // combining user inputed month and year together
		input_monthyear = combined_monthyear.trim();
		
		System.out.println(input_day);
		System.out.println(input_month);
		System.out.println(input_year);

		System.out.println("The input month year is :"+input_monthyear);		
		retrieved_calendarmonthyear = calender_monthyear.getText().trim();
		System.out.println("The rtrvd month year is : "+retrieved_calendarmonthyear);
		
		while(!input_monthyear.contains(calender_monthyear.getText()))
		{
			
			calender_next.click();
		}
		List<WebElement> rows,columns;
		rows = outer_Calender.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				cal_date = columns.get(j).getText();
				if(cal_date.equals(input_day))
				{
					columns.get(j).click();
					break;
				}
			}
		}
		
		calender_Ok.click();
		
	}

	18002583838

	public void get_TextArea()
	{
		textarea.sendKeys("Candidate added via automation");
	}
	
	public WebElement get_HiringManagers()
	{
		return hiring_managers;
	}
	
	public WebElement get_Recruiters()
	{
		return recruiters;
	}
	
	public void get_Coordinators()
	{
		coordinators.sendKeys("Amol");
	}
	
	public WebElement get_HiringProcess()
	{
		return hiring_process;
	}
	
	public void click_addJob_on_Popup()
	{
		popup_add_job_button.click();
	}
}
	