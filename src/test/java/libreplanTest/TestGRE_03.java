package libreplanTest;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestGRE_03 {
	WebDriver driver;
	//RemoteWebDriver driver;
	@Before
	//Connexion à l'application
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
			System.setProperty("webdriver.ie.driver","C:\\Users\\Formation\\Desktop\\Documents\\IEDriverServer.exe");   
			driver = new InternetExplorerDriver();  			
		}
		if(nav.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Formation\\Desktop\\Documents\\chromedriver.exe");   
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

	/*
	public void creerUnWorker() throws InterruptedException{
	//Test de connexion à l'application
			PageConnexion pageLogin = PageFactory.initElements(driver, PageConnexion.class);
			pageLogin.seConnecter("admin", "admin");
			Thread.sleep(2000);
			PageMenu pageCal = PageFactory.initElements(driver, PageMenu.class);
			//Test de creation d'un participant
			//acces à la page de la liste des participants
			
			pageCal.listWorkers();
			Thread.sleep(2000);
			ListWorkers pageListeWorker = PageFactory.initElements(driver, ListWorkers.class);
			assertTrue(pageListeWorker.verifTableau());
			assertTrue(pageListeWorker.verifChamp());
			assertTrue(pageListeWorker.verifBouton());
			
			pageListeWorker.clickCreate();
			CreateWorker creerUnWorker = PageFactory.initElements(driver, CreateWorker.class);
			assertTrue(creerUnWorker.verifBlock1());
			assertTrue(creerUnWorker.verifblock2());
			//Creation du participant
			//block1 details perso
			
			creerUnWorker.block1("Jean", "DU", "jdu");
			//creation d'un utilisateur et de ses identifiants de connection
			creerUnWorker.block2("jdu", "$jdumdp1", "jdu@test.fr");
			assertTrue(pageListeWorker.verifMessage("Worker saved"));
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "AA", "aze");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "ZZ", "zea");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DT", "zer");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "ZG", "zzt");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "ZT", "zpo");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "BC", "rez");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "CB", "eza");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "AC", "aez");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "CA", "zre");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DA", "etr");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DB", "ter");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DC", "rze");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DD", "eaz");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "AD", "art");	
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			pageListeWorker.clickCreate();
			creerUnWorker.block1("Jean", "DT", "tea");
			creerUnWorker.bouttonSAVE.click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			assertTrue(pageListeWorker.verifCreaJeanDUjdu("jdu", "Jean", "DU"));
			assertTrue(pageListeWorker.moreOptions());
			pageListeWorker.navListWorker();
			Thread.sleep(2000);
			pageCal.deconnexion();
			
}
*/
	@Test
	public void gre_03() throws InterruptedException{
		PageConnexion pageLogin = PageFactory.initElements(driver, PageConnexion.class);
		pageLogin.seConnecter("admin", "admin");
		Thread.sleep(5000);
		PageMenu pageCal = PageFactory.initElements(driver, PageMenu.class);
		pageCal.listWorkers();
		Thread.sleep(2000);
		ListWorkers pageListeWorker = PageFactory.initElements(driver, ListWorkers.class);
		assertTrue(pageListeWorker.verifTableau());
		assertTrue(pageListeWorker.verifChamp());
		assertTrue(pageListeWorker.verifBouton());
		pageListeWorker.clickCreate();
		CreateWorker creerUnWorker = PageFactory.initElements(driver, CreateWorker.class);
		assertTrue(creerUnWorker.verifBlock1());
		assertTrue(creerUnWorker.verifCheckBoxDefault());
		assertTrue(creerUnWorker.verifMessageErreur());
		assertTrue(creerUnWorker.MessErreur1("Marie", "DU", "mdu"));
		assertTrue(creerUnWorker.MessErreur2());
		Thread.sleep(2000);
		assertTrue(creerUnWorker.MessErreur3("Du", "123456", "654321", "du@test.fr"));
		assertTrue(creerUnWorker.MessErreur45("jdu", "jdu", "123456"));
		creerUnWorker.CreerUtilisateur2("mdu", "mdu");
		Thread.sleep(2000);
		assertTrue(pageListeWorker.verifCreaUtilisateur("mdu", "Marie", "DU"));
	}
	@After 
	public void fermer() {
		driver.close();
	}
}