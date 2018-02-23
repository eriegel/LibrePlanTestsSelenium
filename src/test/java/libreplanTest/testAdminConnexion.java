package libreplanTest;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class testAdminConnexion {

	//WebDriver driver;
	RemoteWebDriver driver;
	
	@Before
	//Connexion � l'application
	public void setup() throws MalformedURLException {
		//driver = new FirefoxDriver();		
		//RemoteWebDriver driver;
		String nav =  System.getProperty("browser");
		//Firefox's geckodriver requires you to specify its location.  
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(nav);
		
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		URL url_hub = new URL("http://192.168.2.26:4444/wd/hub");

		driver = new RemoteWebDriver(url_hub,cap);
		/*
		if(nav.equals("chrome")) {
			browser = new ChromeDriver();  			
		}
		if(nav.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
			options.addPreference("browser.tabs.remote.autostart",  false);
			System.setProperty("webdriver.gecko.driver","C:\\FORMATION\\installeurs\\Selenium\\geckodriver.exe");   
			browser = new FirefoxDriver(options);  			
		}		*/	
		driver.get("http://localhost:8085/libreplan");
	}
	
	@Test
	//Test de connexion � l'application
	public void seLoguer() throws Exception {
		PageConnexion pageLogin = PageFactory.initElements(driver, PageConnexion.class);
		PageCalendrier pageAccueil = pageLogin.seConnecter("admin", "admin");
		Thread.sleep(2000);
		WebElement connectedUser = driver.findElement(By.xpath("//div[@class='user-area']/table[1]/tbody/tr[1]/td[2]"));
		assertEquals("user: admin", connectedUser.getText());
	}

}
