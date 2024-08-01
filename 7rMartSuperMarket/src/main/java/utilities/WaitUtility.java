package utilities;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	     public static final long EXPLICITWAIT=20;
	     public static final long IMPLICITWAIT=10;
	     public static final long FLUENTWAIT=30;
	     public static final long FLUENTWAITPOLLING=5;
	
	public void setExplicitWait(WebDriver driver,WebElement element)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		   
	}
	public void setImplicitWait(WebDriver driver) 
	{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));
    }
	
	public void setFluentWait(WebElement element, WebDriver driver) {
	    Wait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(FLUENTWAIT))
	            .pollingEvery(Duration.ofSeconds(FLUENTWAITPOLLING))
	            .ignoring(NoSuchElementException.class);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
}
