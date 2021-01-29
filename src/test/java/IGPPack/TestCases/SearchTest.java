	package IGPPack.TestCases;

	import IGPPack.Pages.ValidationPage;
	import IGPPack.Utilities.Constant;
    import IGPPack.managers.PageObjectManager;
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

	PageObjectManager pageObjectManager;
	LaunchPage launchPage;
	LoginPage loginPage;
	SearchPage searchPage;
	ValidationPage validationPage;

	@Test
	public void searchTest() throws InterruptedException {

	pageObjectManager = new PageObjectManager(driver);

	launchPage = pageObjectManager.getLaunchPage();

	loginPage = pageObjectManager.getLoginPage();

	searchPage = pageObjectManager.getSearchPage();

	validationPage = pageObjectManager.getValidationPage();

	launchPage.goLogin();

	loginPage.doLogin(Constant.loginEmail,Constant.loginPassword);

	Thread.sleep(5000);

	searchPage.searchItem(Constant.Item);

	String searchText=searchPage.getText();
	
	searchPage.selectProduct();

	String actualText=validationPage.validateText();

	Assert.assertEquals(searchText,actualText);

	searchPage.setDeliveryDetails(Constant.Pincode);

	searchPage.checkOutProduct();

	searchPage.setDelivery();

	boolean result=validationPage.verifySearchTest();

	Assert.assertTrue(result);

	}
	}
