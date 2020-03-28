	package IGPPack.TestCases;

	import java.util.HashMap;
	import org.testng.ITestResult;
	import org.testng.SkipException;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Base.base;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.LoginPage;
	import IGPPack.Utilities.DataUtil;
	import IGPPack.Utilities.ExtentManager;
	import IGPPack.Utilities.MyXLSReader1;
	
	public class LoginTest extends base {
		
	@BeforeClass
	public void setUp() {
		
	readPropertyFile();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
	Object[][] obj=null;
		
	try{
		
	xls=new MyXLSReader1(prop.getProperty("excelFilePath"));
	
	obj=DataUtil.getTestData(xls, "LoginTest", "Data");
	
	} catch(Exception e) {
		
	e.printStackTrace();
	
	}
	
	return obj;
		
	}
	@Test(dataProvider="getData")
	public void loginTest(HashMap<String, String> map) throws InterruptedException {
		
	report=ExtentManager.getInstance();
		
	test=report.startTest("LoginTest");
		
	test.log(LogStatus.INFO, "LoginTest started");
		
	if(!DataUtil.isRunnable(xls, "LoginTest", "Testcases") || map.get("Runmode").equals("N")) {
		
	throw new SkipException("throwing exception becouse runmode set to N");	
		
	}
		
	openingBrowser(map.get("Browser"));
	
	test.log(LogStatus.INFO, "Browser got opened");
	
	navigate("AppURL");
	
	test.log(LogStatus.INFO, "Application url got launched");
	
	LaunchPage launchPage=new LaunchPage(driver, test);
	
	launchPage.goLogin();
	
	Thread.sleep(5000);
	
	LoginPage loginPage=new LoginPage(driver, test);
	
	loginPage.doLogin(map.get("Username"),map.get("Password"));
	
	boolean actualResult=isElementPresent();
	
	String expectedRes = map.get("ExpectedResult");
	
	boolean expectedResult = false;
		
	if(expectedRes.equalsIgnoreCase("Failure")) {
			
	expectedResult = false;
			
	}else if(expectedRes.equalsIgnoreCase("Success")) {
			
	expectedResult = true;
			
		}
		
	if(actualResult==expectedResult) {
			
	reportPass("LoginTest got passed");
			
	}else {
			
	reportFail("LoginTest got failed");
			
		}
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
        if(ITestResult.FAILURE==result.getStatus()){
    	
        test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
    	
	takeScreenshot();
	
 }
	if(report!=null) {
		
	report.endTest(test);
	
	report.flush();
	
	if(driver!=null) {
		
	driver.quit();	
		
	}
		
	}
		
	}
	
	}
