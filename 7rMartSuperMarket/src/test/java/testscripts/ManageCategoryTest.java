package testscripts;
import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base 
{
	@Test
	public void verifyCanAddANewCategory() throws AWTException {
		String username = ExcelUtility.getString(1, 0, "ManageCategoryPage");
	    String password = ExcelUtility.getString(1, 1, "ManageCategoryPage");  
        String manageCategoryUrl = "https://groceryapp.uniqassosiates.com/admin/list-category";       
        String categoryText = "New Category";
        String filePath = "C:\\Users\\Windows 11\\Pictures\\Screenshots\\ABC.png";
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username)
                 .enterPasswordOnPasswordField(password)
                 .clickOnSigninButton();
        ManageCategoryPage manageCategoryPage = new ManageCategoryPage(driver);
		manageCategoryPage.navigateToManageCategoryPage(manageCategoryUrl)
                          .clickOnNewButton()
                          .enterTextInCategoryField(categoryText)
                          .selectTheDiscountGroup()
                          .selectTheImageToUploadFileUploadField(filePath)
                          .clickOnTopMenuRadioButton()
                          .clickOnLeftMenuRadioButton()
                          .clickOnSaveButton();
        boolean successMessageAlert = manageCategoryPage.getTheSuccessMessage().contains("Category Created Successfully");
        Assert.assertTrue(successMessageAlert, "Unable to add a new category");
    }
}



