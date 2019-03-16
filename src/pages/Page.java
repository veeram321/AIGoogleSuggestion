package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Page {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String photoPath;
	public static String facebookLogin;
	public static String facebookPassword;
	public static String facebookMessage;
		
	public Page() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/data/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		photoPath = prop.getProperty("photoPath");
		facebookLogin = prop.getProperty("faceBookLogin");
		facebookPassword = prop.getProperty("faceBookPassword");
		facebookMessage = prop.getProperty("faceBookMessage");
	}
	
	
	public static void initialization(){
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "src/data/drivers/chromedriver.exe");	
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		}
						
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
}

