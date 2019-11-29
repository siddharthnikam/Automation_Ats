package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import generic.Reusable_Methods;
import pageObjects.ATS_CandidatePage;
import pageObjects.ATS_HomePage;
import pageObjects.ATS_JobPage;
import pageObjects.ATS_LandingPage;

public class Jobs_AddJob extends Reusable_Methods {
	
	public Reusable_Methods reusemethods;
	public ATS_HomePage atshomepage;
	public ATS_LandingPage atslandingpage;
	public ATS_JobPage atsjobpage;
	public ATS_CandidatePage atscandidatepage;
	
	@BeforeTest
	public void initialize_Driver() throws IOException
	{
		reusemethods = new Reusable_Methods(); // object of reusable class
		reusemethods.initializeDriver();     // initializing the driver
		reusemethods.desired_Capabilities();
		reusemethods.chrome_Options();
		reusemethods.invokeBrowser();         // invoking chrome browser
		reusemethods.propertyFileReader();      // loading the property file
		reusemethods.invokeUrl();              // get URL from property file
	}
	
	
	/* -------------LOGGING INTO ATS -------------------------- */
	@Test(priority=0)         
	public void Login() throws InterruptedException
	{
		atslandingpage = new ATS_LandingPage(driver);
		atslandingpage.login("sidd1609", "Passw0rd");
		Thread.sleep(2000);
	}
	
	/* ------------NAVIGATING TO JOB MODULE---------------- */
	
	@Test(priority=1)
	public void job_Module_Navigation() throws InterruptedException
	{
		atshomepage = new ATS_HomePage(driver);
		atshomepage.click_Dashboard();
		Thread.sleep(1000);
		atshomepage.navigate_To_JobsModule();
	}
	
	@Test(priority=2)
	public void add_New_Job() throws InterruptedException
	{
		atsjobpage = new ATS_JobPage(driver);
		atsjobpage.click_AddJob();                   // clicking add job button
		Thread.sleep(2000);
		
		 //BASICS 
 		atsjobpage.get_JobTitle("Consultant"); // entering the jobTitle
		reusemethods.select_DropdownOptions(atsjobpage.get_ApplicationForm(),"Resume Required");   // seleting from application form
		System.out.println("Resume Required set");
		atsjobpage.get_ReqId();  // entering the req ID
		System.out.println("Requirement ID set");
		Thread.sleep(3000);
		reusemethods.select_DropdownOptions(atsjobpage.get_JobType(),"Permanent");
		System.out.println("Job type set");
		reusemethods.select_DropdownOptions(atsjobpage.get_JobTime(),"Part Time");
		System.out.println("Job time set");
		
		atsjobpage.get_Location_Address();
		System.out.println("Location set");
		atsjobpage.get_Salary();
		System.out.println("Salary set");
		reusemethods.select_DropdownOptions(atsjobpage.get_SalaryType(),"Hourly");
		System.out.println("hourly pass");
		reusemethods.select_DropdownOptions(atsjobpage.get_Department(),"Support");
		System.out.println("Support Pass");
		atsjobpage.click_BasicsNext();
		
		// ADDITIONAL DETAILS AND DESCRIPTION 
		
		atsjobpage.get_ClientManager();
		atsjobpage.get_Number_Of_Resources();
		atsjobpage.click_CalenderIcon();
		atsjobpage.get_Date("30/December/2019");
		
		atsjobpage.get_TextArea();
		atsjobpage.click_BasicsNext();
		
		reusemethods.select_DropdownOptions(atsjobpage.get_HiringManagers(),"sidd1609");
		reusemethods.select_DropdownOptions(atsjobpage.get_Recruiters(),"sidd1609");
		atsjobpage.get_Coordinators();
		reusemethods.select_DropdownOptions(atsjobpage.get_HiringProcess(),"External Client");//		atsjobpage.click_addJob_on_Popup();
		
		
} 

	/*@Test(priority=2)
	public void add_New_Candidate() throws InterruptedException
	{
		atscandidatepage = new ATS_CandidatePage(driver);
		atscandidatepage.click_CandidateIcon();
		atscandidatepage.click_AddCandidate();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(atscandidatepage.click_BrowseButton()).click().perform();
		System.out.println("Browse clicked");
		reusemethods.upload_file_using_Robot("C:\\Users\\Siddharth.Nikam\\Downloads\\SACHIN PANDEY Resume.docx");
	}*/
	
	/*@Test(priority=2)
		public void add_New_Candidate() throws InterruptedException, IOException
		{
		atscandidatepage = new ATS_CandidatePage(driver);
		atscandidatepage.click_CandidateIcon();
		atscandidatepage.click_AddCandidate();
		Thread.sleep(2000);
		
		reusemethods.upload_File_Using_AutoIT("C:\\Users\\Siddharth.Nikam\\Documents\\uploadfile.exe");
		
		} */
	
	@Test
	public void logout()
	{
		
	}
}
