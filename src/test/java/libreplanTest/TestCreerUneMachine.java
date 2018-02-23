package libreplanTest;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreerUneMachine {

	//WebDriver driver;
	RemoteWebDriver driver;
	@Before
	//Connexion � l'application
	public void setup() throws MalformedURLException {
		//driver = new FirefoxDriver();
		//WebDriver browser=null;  
		
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
	public void creerUneMachine() throws InterruptedException{
	//Test de connexion � l'application
			PageConnexion pageLogin = PageFactory.initElements(driver, PageConnexion.class);
			pageLogin.seConnecter("admin", "admin");
			Thread.sleep(2000);
			PageMenu pageCal = PageFactory.initElements(driver, PageMenu.class);
			pageCal.listMachine();
			ListMachine pageListMachine = PageFactory.initElements(driver, ListMachine.class);
			assertTrue(pageListMachine.verifTableau());
			assertTrue(pageListMachine.verifChamp());
			assertTrue(pageListMachine.verifBouton());
			pageListMachine.selectBoutonCreate();
			CreateMachine creerMachine = PageFactory.initElements(driver, CreateMachine.class);
			assertTrue(creerMachine.verifBlockCreateMachine());
			//assertTrue(creerMachine.boutonDispo());
			creerMachine.blockCreateMachine("MACHINETEST1", "MACHINETEST1");
			assertTrue(creerMachine.verifMessage("Machine \"MACHINETEST1\" saved"));
			creerMachine.retournerListeMachine();
			Thread.sleep(5000);
			assertTrue(pageListMachine.verifCreaMACHINETEST("MACHINETEST1", "MACHINETEST1", "MACHINETEST1"));
			
			
			
}			
}
