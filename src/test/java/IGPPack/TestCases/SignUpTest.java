	package IGPPack.TestCases;

	import IGPPack.Pages.ValidationPage;
	import IGPPack.Utilities.Constant;
	import IGPPack.managers.PageObjectManager;
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
		
	report=ExtentManager.getInstance();
		
	test=report.startTest("LoginTest");
			
	test.log(LogStatus.INFO, "SignUp Test started");
		
	//openingBrowser(prop.getProperty("browserType"));
	
	test.log(LogStatus.INFO, "Browser got opened");
	
	//navigate("AppURL");
	
	test.log(LogStatus.INFO, "Application url got launched");

	pageObjectManager = new PageObjectManager(driver,test);

	launchPage = pageObjectManager.getLaunchPage();
	
	//LaunchPage launchPage=new LaunchPage(driver, test);
	
	launchPage.goSignUp();

	signUpPage = pageObjectManager.getSignUpPage();
	
	//SignUpPage signUpPage=new SignUpPage(driver, test);
	
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
	
	if(result==Constant.mail) {
		
	reportPass("SignUp Test is Successfull");
		
	}else {
		
	reportFail("SignUp Test is not Successfull");	
		
	}
	
	}

	}
