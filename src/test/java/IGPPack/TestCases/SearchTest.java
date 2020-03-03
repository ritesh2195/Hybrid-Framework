	package IGPPack.TestCases;

	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Base.base;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.LoginPage;
	import IGPPack.Pages.SearchPage;
	import IGPPack.Utilities.ExtentManager;
	
	public class SearchTest extends base {
	
	@BeforeClass
	public void  setUp() {
		
	readPropertyFile();
		
	}
	
	@Test
	public void searchTest()  {
		
	report=ExtentManager.getInstance();
		
	test=report.startTest("SearchTest");
			
	test.log(LogStatus.INFO, "SearchTest started");	
	
	openingBrowser(prop.getProperty("Browser"));
	
	navigate("AppURL");
	
	LaunchPage page=new LaunchPage(driver, test);
	
	page.goLogin();
	
	LoginPage loginPage=new LoginPage(driver, test);
	
	loginPage.doLogin(prop.getProperty("mail"), prop.getProperty("password"));
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	SearchPage searchTest=new SearchPage(driver, test);
	
	searchTest.searchingItem(prop.getProperty("itemType"), prop.getProperty("pincode"));
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	boolean result=isSearchPageElementPresent();
		
	if(result==true) {
		
	reportPass("Search Test is Passed");	
		
	}else if(result==false) {
		
	reportFail("Search Test is failed");	
		
	}
	}
		
	@AfterMethod
	public void tearDown(ITestResult result) {
		
	if(ITestResult.FAILURE==result.getStatus()) {
		
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
