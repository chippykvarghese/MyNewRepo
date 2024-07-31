package testscripts;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base 
{
    @Test
   public void verifyTheUserCanAddANewsSuccessfullyOnManageNewsPage() 
   {
     String username = ExcelUtility.getString(1, 0, "ManageNewsPage");
	 String password = ExcelUtility.getString(1, 1, "ManageNewsPage"); 
     String news = "First News";
     LoginPage loginPage = new LoginPage(driver);
     loginPage.enterUserNameOnUserNameField(username)
              .enterPasswordOnPasswordField(password)
              .clickOnSigninButton();
     ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
     manageNewsPage.clickonManageNewsLink()
                   .clickOnNewButton()
                   .enterANewNewsOnNewsField(news);
     boolean isNewsAddedSuccessfully = manageNewsPage.isNewNewsCreated();
     assertTrue(isNewsAddedSuccessfully, "User is unable to add a news on the Manage News page");
   }
}

