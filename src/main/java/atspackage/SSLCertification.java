package atspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DesiredCapabilities descap = DesiredCapabilities.chrome();
		//descap.acceptInsecureCerts();
		descap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		descap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions chropt = new ChromeOptions();
		chropt.merge(descap);
		
		System.setProperty("Webdriver.chrome.driver","");
		WebDriver driver = new ChromeDriver(chropt);
		driver.get("");

	}

}
