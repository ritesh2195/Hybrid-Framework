	package IGPPack.TestCases;

	import java.util.HashMap;
	import IGPPack.Pages.ValidationPage;
	import IGPPack.managers.FileReaderManager;
	import IGPPack.managers.PageObjectManager;
	import org.testng.Assert;
	import org.testng.SkipException;
	import org.testng.annotations.*;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.LoginPage;
	import IGPPack.Utilities.DataUtil;
	import IGPPack.Utilities.MyXLSReader1;

	@Listeners(ListenerTest.class)
	
	public class LoginTest extends BaseClass {

	PageObjectManager pageObjectManager;
	LaunchPage launchPage;
	LoginPage loginPage;
	ValidationPage validationPage;

	@DataProvider
	public Object[][] getData() {
		
	Object[][] obj=null;
		
	try{

	xls=new MyXLSReader1(FileReaderManager.getInstance().getConfigReader().getExcelFilePath());
	
	obj = DataUtil.getTestData(xls, "LoginTest", "Data");
	
	} catch(Exception e) {
		
	e.printStackTrace();
	
	}
	
	return obj;
		
	}
	@Test(dataProvider="getData")
	public void loginTest(HashMap<String, String> map) throws InterruptedException {

	if(!DataUtil.isRunnable(xls, "LoginTest", "Testcases") || map.get("Runmode").equals("N")) {
		
	throw new SkipException("throwing exception becouse runmode set to N");	
		
	}

	pageObjectManager= new PageObjectManager(driver);

	launchPage=pageObjectManager.getLaunchPage();

	launchPage.goLogin();
	
	Thread.sleep(5000);
	
	loginPage=pageObjectManager.getLoginPage();

    loginPage.doLogin(map.get("Username"), map.get("Password"));

	validationPage=pageObjectManager.getValidationPage();

    String expectedRes = map.get("ExpectedResult");

    boolean expectedResult = true;

	if (expectedRes.equalsIgnoreCase("Success")) {

	} else if (expectedRes.equalsIgnoreCase("Failure")) {

     expectedResult = false;

        }

     if (expectedResult) {

		 boolean actualResult = validationPage.verifyLoginTest();

		 if (actualResult == expectedResult) {

			 loginPage.Logout();

		 }
	 }
     else {

	  loginPage.navigateHomePage();

      Assert.fail("LoginTest got failed");

        }

	}

	}
