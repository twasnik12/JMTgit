package Com.BCT.Commons;

import java.io.FileInputStream;



import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {


	public static WebDriver driver;
	public static Properties p;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;




	//To read properties file
	public   BaseClass(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Tathagat\\eclipse-workspace\\Browser_Compatibility_Testing\\src\\main\\java\\Com\\BCT\\property\\Config.properties");
			p.load(f);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


//			To launch Browser
	public void launch() {
		
		if((p.getProperty("BrowserName")).equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver107\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get(p.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}else if((p.getProperty("BrowserName")).equalsIgnoreCase("firefox")){
WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			  driver.get(p.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if((p.getProperty("BrowserName")).equalsIgnoreCase("IE")){
			WebDriverManager.iedriver().setup();
						driver = new InternetExplorerDriver();
						  driver.get(p.getProperty("url"));
							driver.manage().window().maximize();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					}
		
	}public void launchParallal(String BrowserName) {

		System.out.println("Browser name is :"+BrowserName);

		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "E://edge driver//msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}

	}


