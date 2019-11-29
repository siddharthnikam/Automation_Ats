package atspackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Siddharth.Nikam\\ATS_Project\\src\\test\\java\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://192.168.10.34:8000/candidate/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='div_id_username']/div[1]/input")).sendKeys("sidd1609");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Passw0rd");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='modal']//following-sibling::nav/div/div/ul/li/i")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Jobs']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("preventClose")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='modal-header']//following-sibling::div/div/div[1]/div[1]/div[1]/div/input")).sendKeys("Developer");
		WebElement job_type = driver.findElement(By.id("id_job_type"));
		
		Select sel = new Select(job_type);
		sel.selectByVisibleText("Contract");
		
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='event']")).click();
		
		String cal_date;
		WebElement outer_Calender = driver.findElement(By.xpath("//*[@role='calendar']"));
		
		// ------ Selecting the month
		//**************************
		
		
		while(!driver.findElement(By.xpath("//*[@role='period']")).getText().contains("January 2020"))
		{
			driver.findElement(By.xpath("//*[@role='period']//following-sibling::div/i")).click();
		}
		
		
		
		//******************************************
		//Selecting the date
		
		List<WebElement> rows,columns;
		rows = outer_Calender.findElements(By.tagName("tr"));
		for(int i=1;i<rows.size();i++)
		{
			columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				cal_date = columns.get(j).getText();
				System.out.println("SUcess");
				if(cal_date.equals("29"))
				{
					columns.get(j).click();
					break;
				}
			}
		}
		
		driver.findElement(By.xpath("//*[text()='Ok']")).click();;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//WebElement whole_calender = driver.findElement(By.xpath("//*[@class='gj-modal']/div[1]"));
		
		// to get the month year combination from calender		
		
		String retrieved_monthyear = driver.findElement(By.xpath("//div[@role = 'navigator']//div[@role = 'period']")).getText();
		System.out.println(retrieved_monthyear);
		
	/*	// to get user input
		String user_day,user_month,user_year;
		String user_date = "25/January/2020";
		String date[]=user_date.split("/");
		
		user_day = date[0];
		user_month = date[1];
		user_year = date[2];
		
		System.out.println("The day is:"+user_day);
		System.out.println("The month is :"+user_month);
		System.out.println("The year is:"+user_year);
		
		String user_monthyear = user_month +" "+user_year;
		
		System.out.println(user_monthyear);
		WebElement next_arrow=driver.findElement(By.xpath("//*[@class='gj-modal']/div/div/div/div[3]/i"));
		
		while(!user_monthyear.equalsIgnoreCase(retrieved_monthyear))
		{			
			next_arrow.click();
			Thread.sleep(5000);
			retrieved_monthyear = driver.findElement(By.xpath("//div[@role = 'navigator']//div[@role = 'period']")).getText();
			user_monthyear = user_monthyear ;
//			WebDriverWait wait = new WebDriverWait(driver,15);
//			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class ='gj-modal']/div/div/div/div[3]/i")));			
		}
	*/		
		
		
		
		
	}

}
