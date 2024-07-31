package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
		
			public WebDriver driver;//selenium providing interface is an WebDriver
			
			@BeforeMethod	
			public void initializeBrowser()
			{
				driver=new ChromeDriver();//browser initialization or initialize the ChromeDriver to driver.Chrome driver is an preDefined/implemented class
				driver.get("https://groceryapp.uniqassosiates.com/admin/login");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			    driver.manage().window().maximize();//maximize the window
			}
			@AfterMethod
			public void driverQuitAndClose()
			{
			driver.close();	
			}
			

	}


