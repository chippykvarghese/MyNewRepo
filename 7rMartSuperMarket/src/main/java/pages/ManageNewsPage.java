package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class='fa fa-newspaper widget-stat-icon']") WebElement manageNewsLink;
	@FindBy(xpath="//h1[@class='m-0 text-dark']") WebElement manageNews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']") WebElement enterOnNewsField;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successfulAlert;

    public ManageNewsPage clickonManageNewsLink() {
	manageNewsLink.click();
	return this;
    }
    public ManageNewsPage clickOnNewButton() {
	newButton.click();
	return this;
    }
    public ManageNewsPage enterANewNewsOnNewsField(String news) {
	enterOnNewsField.sendKeys(news);
	saveButton.click();
	return this;
    }
    public boolean isManageNewsDisplayed() 
    {
    boolean manageNewsPage=manageNews.isDisplayed();
    return manageNewsPage;
    }
    public boolean isNewNewsCreated() 
    {
    boolean isNewsCreated=successfulAlert.isDisplayed();
    return isNewsCreated;
    }
}