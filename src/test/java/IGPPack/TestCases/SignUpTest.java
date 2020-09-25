	package IGPPack.TestCases;

	import IGPPack.Pages.ValidationPage;
	import IGPPack.Utilities.Constant;
	import IGPPack.managers.PageObjectManager;
	import org.testng.Assert;
	import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import IGPPack.Base.base;
import IGPPack.Pages.LaunchPage;
import IGPPack.Pages.SignUpPage;
import IGPPack.Utilities.ExtentManager;

	@Listeners(ListenerTest.class)
	
	public class SignUpTest extends BaseClass {

	PageObjectManager pageObjectManager;
	LaunchPage launchPage;
	SignUpPage signUpPage;
	ValidationPage validationPage;

	@Test
	public void signUpTest() {

	pageObjectManager = new PageObjectManager(driver);

	launchPage = pageObjectManager.getLaunchPage();

	launchPage.goSignUp();

	signUpPage = pageObjectManager.getSignUpPage();

	signUpPage.setEmail(Constant.mail);

	signUpPage.setPassword(Constant.password);

	signUpPage.setCountry(Constant.country);

	signUpPage.setMobileNo(Constant.mobile);

	signUpPage.clickSubmit();

	signUpPage.setFirstName(Constant.firstName);

	signUpPage.setLastName(Constant.lastName);

	signUpPage.setDOB();

	signUpPage.clickSignUp();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	validationPage = pageObjectManager.getValidationPage();
	
	String result=validationPage.verifySignUpTest();

	Assert.assertEquals(result,Constant.mail);
	

	}

	}
