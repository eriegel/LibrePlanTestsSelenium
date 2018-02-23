package libreplanTest;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestCreerDesProgressTypes {
	WebDriver driver;
	//RemoteWebDriver driver;
	@Before
	//COnnexion à l'application
	public void setup() throws MalformedURLException {
		//driver = new FirefoxDriver();		
		//RemoteWebDriver driver;
		String nav =  System.getProperty("browser");
		//Firefox's geckodriver requires you to specify its location.  
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(nav);
		
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		URL url_hub = new URL("http://192.168.2.26:4444/wd/hub");

		driver = new RemoteWebDriver(url_hub,cap);*/
		
		if(nav.equals("internet explorer")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Formation\\Desktop\\Documents\\IEDriverServer.exe");   
			driver = new ChromeDriver();  			
		}
		if(nav.equals("chrome")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Formation\\Desktop\\Documents\\chromedriver.exe");   
			driver = new ChromeDriver();  			
		}
		if(nav.equals("firefox")) {
			//FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
			//options.addPreference("browser.tabs.remote.autostart",  false);
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Formation\\Desktop\\Documents\\geckodriver.exe");   
			driver = new FirefoxDriver();  			
		}	
		driver.get("http://localhost:8085/libreplan");
	}
	
	@Test
	
	public void creerDesProgressTypes() throws InterruptedException {
		//Test de connexion à l'application
		PageConnexion pageLogin = PageFactory.initElements(driver, PageConnexion.class);
		pageLogin.seConnecter("admin", "admin");
		Thread.sleep(2000);
		PageMenu pageCal = PageFactory.initElements(driver, PageMenu.class);
		//Test de creation d'un type de progress
		pageCal.accesProgress();
		Thread.sleep(2000);
		PageProgress pageProgress = PageFactory.initElements(driver, PageProgress.class);
		pageProgress.clickBoutonCreate();
		Thread.sleep(2000);
		CreateProgressType createProgressType = PageFactory.initElements(driver, CreateProgressType.class);
		createProgressType.creaTypeProgress1("Type avancement -Test1", "10.00");
		Thread.sleep(2000);
		assertTrue("Verification failed: Element1 and Element2 are not same.","Progress Type \"Type avancement -Test1\" saved".equals(driver.findElement(By.id(pageCal.prefix()+"s7")).getText()));
		Thread.sleep(2000);
		assertTrue(createProgressType.contientLaReference("Type avancement -Test1"));
		pageProgress.clickBoutonCreate();
		Thread.sleep(2000);
		createProgressType.creaTypeProgress2("Type avancement -Test2");
		Thread.sleep(2000);
		assertTrue("Verification failed: Element3 and Element4 are not same.","Progress Type \"Type avancement -Test2\" saved".equals(driver.findElement(By.id(pageCal.prefix()+"47")).getText()));
		assertTrue(createProgressType.contientLaReference("Type avancement -Test2"));
	}
	@After 
	public void fermer() {
		driver.close();
	}
}
	