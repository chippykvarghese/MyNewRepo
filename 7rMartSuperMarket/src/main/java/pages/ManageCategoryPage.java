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
    @FindBy(xpath="//input[@name='category']") WebElement categoryField;
    @FindBy(xpath = "//*[@id='134-selectable']") WebElement groupSelectionField;
    @FindBy(xpath="//*[@id='main_img']") WebElement fileUploadField; 
    @FindBy(xpath="//input[@name='top_menu' and @value='no']") WebElement topMenuRadioButton;
    @FindBy(xpath="//input[@name='show_home' and @value='no']") WebElement leftMenuRadioButton; 
    @FindBy(xpath="//button[@name='create']") WebElement saveButton;
    @FindBy(xpath="//*[@id='form']/div/div[5]/a") WebElement cancelButton;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
    
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
    	waitUtility.setExplicitWait(driver, groupSelectionField);
    	groupSelectionField.click();
    	return this;
    } 
        
    public ManageCategoryPage selectTheImageToUploadFileUploadField(WebElement fileUploadField, String filePath) {
        waitUtility.setExplicitWait(driver, fileUploadField);
        fileUploadUtility.fileUploadUsingSendKeys(fileUploadField, filePath); 
        return this;
    }

    public ManageCategoryPage clickOnTopMenuRadioButton()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(topMenuRadioButton));
    	pageUtility.checkTheCheckbox(topMenuRadioButton);
        return this;
    }
    public ManageCategoryPage clickOnLeftMenuRadioButton()
    {
    	 wait.until(ExpectedConditions.elementToBeClickable(leftMenuRadioButton));
    	 pageUtility.checkTheCheckbox(leftMenuRadioButton);
    	 return this;
    }
    
    public ManageCategoryPage clickOnSaveButton()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    	return this;  
    }
    
    public String getTheSuccessMessage()
    {
        waitUtility.setExplicitWait(driver, successMessage);
        return successMessage.getText();
    }
   
 }

