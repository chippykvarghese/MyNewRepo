package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath ="//input[@name='username']") WebElement usernameField;
	@FindBy(xpath ="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath ="//button[@type='submit']") WebElement signinButton;
    @FindBy(xpath ="//section[@class='content']") WebElement dashboardElement;
    @FindBy(xpath ="//div[contains(@class, 'alert-danger')]") WebElement errorMessage;
	
	
	public LoginPage enterUserNameOnUserNameField(String username)
	{
		usernameField.sendKeys(username);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
		return this;
	}
	
	public LoginPage clickOnSigninButton() 
	{
		WaitUtility waitUtility=new WaitUtility();
		waitUtility.setExplicitWait(driver, signinButton);
		signinButton.click();
	    return this;
	}
	
	public boolean isDashboardElementDisplayed() 
	{
        return dashboardElement.isDisplayed();
    }
	
	public boolean isErrorMessageDisplayed() 
	{
        return errorMessage.isDisplayed();
    }
	
}
