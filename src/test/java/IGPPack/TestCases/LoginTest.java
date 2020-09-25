	package IGPPack.TestCases;

	import java.util.HashMap;
	import IGPPack.Pages.ValidationPage;
	import org.testng.Assert;
	import org.testng.SkipException;
	import org.testng.annotations.*;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.LoginPage;
	import IGPPack.Utilities.DataUtil;
	import IGPPack.Utilities.ExtentManager;
	import IGPPack.Utilities.MyXLSReader1;

	@Listeners(ListenerTest.class)
	
	public class LoginTest extends BaseClass {

	@DataProvider
	public Object[][] getData() {
		
	Object[][] obj=null;
		
	try{
		
	//xls=new MyXLSReader1(prop.getProperty("excelFilePath"));

	xls=new MyXLSReader1(config.getExcelFilePath());
	
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

	LaunchPage launchPage=new LaunchPage(driver);
	
	launchPage.goLogin();
	
	Thread.sleep(5000);
	
	LoginPage loginPage=new LoginPage(driver, test);

    loginPage.doLogin(map.get("Username"), map.get("Password"));

    ValidationPage validationPage = new ValidationPage(driver);

    String expectedRes = map.get("ExpectedResult");

    boolean expectedResult = true;

	if (expectedRes.equalsIgnoreCase("Success")) {

	} else if (expectedRes.equalsIgnoreCase("Failure")) {

     expectedResult = false;

        }

     if (expectedResult) {

		 boolean actualResult = validationPage.verifyLoginTest();

		 if (actualResult == expectedResult) {

			 reportPass("LoginTest got passed");

			 loginPage.Logout();

		 }
	 }
     else {

	  loginPage.navigateHomePage();

      reportFail("LoginTest got failed");

      Assert.fail("LoginTest got failed");

        }

	}

	}
