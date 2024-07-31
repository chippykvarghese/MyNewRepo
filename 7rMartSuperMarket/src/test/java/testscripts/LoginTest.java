package testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndCorrectPassword()
	{
	    String username = ExcelUtility.getString(1, 0, "LoginPage");
	    String password = ExcelUtility.getString(1, 1, "LoginPage");
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
	    boolean isDashboardDisplayed = loginpage.isDashboardElementDisplayed();
	    Assert.assertTrue(isDashboardDisplayed, "The user is unable to login with correct user name and correct password");
	}

	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndWrongPassword()
	{		
		String username = ExcelUtility.getString(1, 2, "LoginPage");
		String password = ExcelUtility.getString(1, 3, "LoginPage");
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
	    boolean isErrorMessageDisplayed = loginpage.isErrorMessageDisplayed();
	    Assert.assertTrue(isErrorMessageDisplayed, "The user is able to login with wrong user name and wrong password");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndCorrectPassword()
	{
		
		String username = ExcelUtility.getString(1, 2, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
	    boolean isErrorMessageDisplayed = loginpage.isErrorMessageDisplayed();
	    Assert.assertTrue(isErrorMessageDisplayed, "The user is able to login with wrong user name and wrong password");
	}
	
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndWrongPassword()
	{
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 3, "LoginPage");
	    LoginPage loginpage = new LoginPage(driver);
	    loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
	    boolean isErrorMessageDisplayed = loginpage.isErrorMessageDisplayed();
	    Assert.assertTrue(isErrorMessageDisplayed, "The user is able to login with wrong user name and wrong password");
	}

}