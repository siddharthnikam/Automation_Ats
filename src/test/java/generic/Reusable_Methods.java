package generic;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class Reusable_Methods {
	
	public static WebDriver driver;
	private static Actions action;
	private static Properties prop;
	private static FileInputStream fis;
	private static Robot robot;
	private static DesiredCapabilities descap;
	private static ChromeOptions chropt;
	
	//*****************************************************
	// --- Method to initialize the driver
	public void initializeDriver()
	{
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Siddharth.Nikam\\work\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\java\\resources\\chromedriver.exe");
		
	}
	
	//*****************************************************
	//--- method to invoke the desired browser and maximize it
	public WebDriver invokeBrowser()
	{
		driver = new ChromeDriver(chropt);
		driver.manage().window().maximize();
		return driver;
	}
	
	//*****************************************************
	// --- Method to invoke URL
	
	public void invokeUrl()
	{
		String url_to_test=prop.getProperty("url");
		driver.get(url_to_test);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	//*****************************************************
	// --- Property file reader
	
	public void propertyFileReader() throws IOException
	{
		prop = new Properties();
		;
		fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\data.properties"));
		
		prop.load(fis);
	}
	
	
	//*****************************************************
	//--  mousehower over element
	
	public void mouseHower(WebElement ele)
	{
		action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	//******************************************************
	// --- Selecting an element from Dropdown
	
	public void select_DropdownOptions(WebElement ele,String expected_option)
	{
		Select selectdropdown = new Select(ele);
		List <WebElement> dropdown_options = selectdropdown.getOptions();
		
		for (WebElement element: dropdown_options)
		{
			if(element.getText().contains(expected_option))
			{
				element.click();
				break;
			}
		}	
			 
	}
	
	
	//********************************************************
	// --- Upload file using Robot class
	
	public void upload_file_using_Robot(String filePath) throws InterruptedException
	{
		StringSelection strsel = new StringSelection(filePath);
		Clipboard clipb = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipb.setContents(strsel,null);
			
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//***************************************************************
	// --- Upload file using Auto IT
	
	public void upload_File_Using_AutoIT(String exepath) throws IOException
	{
		Runtime.getRuntime().exec(exepath);
	}
	
	
	//*************************************************************
	// --- Handling Cookies and SSL Certificate
	
	public void desired_Capabilities()
	{
		descap = DesiredCapabilities.chrome();
		descap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		descap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}
	
	public void chrome_Options()
	{
		chropt = new ChromeOptions();
		chropt.merge(descap);
	}
}
   