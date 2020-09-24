	package IGPPack.TestCases;

	import IGPPack.Pages.ValidationPage;
	import IGPPack.Utilities.Constant;
	import junit.framework.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.LoginPage;
	import IGPPack.Pages.SearchPage;
	import IGPPack.Utilities.ExtentManager;

	@Listeners(ListenerTest.class)

	public class SearchTest extends BaseClass {

	@Test
	public void searchTest() throws InterruptedException {
		
	report=ExtentManager.getInstance();
		
	test=report.startTest("SearchTest");
			
	test.log(LogStatus.INFO, "SearchTest started");	

	LaunchPage page=new LaunchPage(driver, test);
	
	page.goLogin();
	
	LoginPage loginPage=new LoginPage(driver, test);
	
	loginPage.doLogin(Constant.loginEmail,Constant.loginPassword);

	Thread.sleep(5000);

	SearchPage searchTest=new SearchPage(driver, test);
	
	searchTest.searchItem(Constant.Item);
	
	searchTest.selectProduct();

	searchTest.setDeliveryDetails(Constant.Pincode);

	searchTest.checkOutProduct();

	searchTest.setDelivery();

	ValidationPage validationPage=new ValidationPage(driver);

	boolean result=validationPage.verifySearchTest();

	Assert.assertTrue(result);

	if(result) {

		reportPass("Search Test is Passed");

	}else {

	reportFail("Search Test is failed");

	Assert.fail();

	}
	}

	}
