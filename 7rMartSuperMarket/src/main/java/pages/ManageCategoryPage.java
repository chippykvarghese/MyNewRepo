package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage 
 {
	WaitUtility waitUtility;
    WebDriverWait wait;
    public WebDriver driver;
    PageUtility pageUtility;
    FileUploadUtility fileUploadUtility;
	
    public ManageCategoryPage(WebDriver driver)
    {
    	this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtility = new WaitUtility();
        pageUtility = new PageUtility();
        fileUploadUtility = new FileUploadUtility();
    }
    @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton; 
    @FindBy(xpath="//input[@id='category']") WebElement categoryField;
    @FindBy(xpath = "//li[@id='134-selectable']") WebElement groupSelectionField;
    @FindBy(xpath="//*[@id='main_img']") WebElement fileUploadField; 
    @FindBy(xpath="//input[@name='top_menu' and @value='no']")WebElement topMenuRadioButton;
    @FindBy(xpath="//input[@name='show_home' and @value='no']")WebElement leftMenuRadioButton;
    @FindBy(xpath="//button[@name='create']")WebElement saveButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessageAlert;
    
    public ManageCategoryPage navigateToManageCategoryPage(String manageCategoryUrl)
    {
    	driver.navigate().to(manageCategoryUrl);
    	return this;
    }
    
    public ManageCategoryPage clickOnNewButton()
    {   
       newButton.click();
       return this;
    }
    public ManageCategoryPage enterTextInCategoryField(String newCategoryName)
    {
    	categoryField.sendKeys(newCategoryName);
    	return this;
    }
    public ManageCategoryPage selectTheDiscountGroup()
    {
    	groupSelectionField.click();
    	return this;
    } 
        
    public ManageCategoryPage selectTheImageToUploadFileUploadField(String filePath) 
    {	
    	fileUploadField.sendKeys(filePath);
        return this;			
    }

    public ManageCategoryPage clickOnTopMenuRadioButton()
    {
    	WaitUtility waitUtility=new WaitUtility();
		waitUtility.setExplicitWait(driver, topMenuRadioButton);
		topMenuRadioButton.click();
	    return this;
    }
    
    public ManageCategoryPage clickOnLeftMenuRadioButton() 
    {
    	WaitUtility waitUtility=new WaitUtility();
		waitUtility.setExplicitWait(driver, leftMenuRadioButton);
		leftMenuRadioButton.click();
	    return this;   
    }
    
    public ManageCategoryPage clickOnSaveButton() 
    {
    	WaitUtility waitUtility=new WaitUtility();
		waitUtility.setExplicitWait(driver, saveButton);
		saveButton.click();
	    return this;   
    }
     public boolean verifySuccessAlertIsDisplayed() {
       return wait.until(ExpectedConditions.visibilityOf(successMessageAlert)).isDisplayed();
    }
 }

   

   
 

