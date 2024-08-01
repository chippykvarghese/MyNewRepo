package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageNewsPage {
	public WebDriver driver;
	 WebDriverWait wait;

	public ManageNewsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']") WebElement enterOnNewsField;
	@FindBy(xpath="//button[text()='Save']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessageAlert;

    public ManageNewsPage navigateToManageNewsPage(String manageNewsUrl)
    {
    	driver.navigate().to(manageNewsUrl);
    	return this;
    }
    
    public ManageNewsPage clickOnNewButton() {
	    newButton.click();
	    return this;
    }
    
    public ManageNewsPage enterANewNewsOnNewsField(String news) {
	    enterOnNewsField.sendKeys(news);
	    return this;
    }
    
    public ManageNewsPage clickOnSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }
    
    public boolean verifySuccessAlertIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(successMessageAlert)).isDisplayed();
     }
}