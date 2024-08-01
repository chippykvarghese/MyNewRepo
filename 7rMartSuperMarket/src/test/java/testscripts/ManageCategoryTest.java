package testscripts;
import java.awt.AWTException;
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
	    String categoryText = ExcelUtility.getString(1, 2, "ManageCategoryPage");
        String manageCategoryUrl = ExcelUtility.getString(1, 3, "ManageCategoryPage");         
        String filePath = ExcelUtility.getString(1, 4, "ManageCategoryPage");;
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
		boolean alertForSuccess = manageCategoryPage.verifySuccessAlertIsDisplayed();
	    Assert.assertTrue(alertForSuccess, "The new category was not added successfully");
    }
}



