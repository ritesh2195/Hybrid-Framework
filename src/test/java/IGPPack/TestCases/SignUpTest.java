	package IGPPack.TestCases;

	import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import IGPPack.Base.base;
import IGPPack.Pages.LaunchPage;
import IGPPack.Pages.SignUpPage;
import IGPPack.Utilities.ExtentManager;
	
	public class SignUpTest extends base {
	
	@BeforeClass
	public void  setUp() {
		
	readPropertyFile();	
		
	}
	
	@Test
	public void signUpTest() {
		
	report=ExtentManager.getInstance();
		
	test=report.startTest("LoginTest");
			
	test.log(LogStatus.INFO, "SignUp Test started");
		
	openingBrowser(prop.getProperty("browserType"));
	
	test.log(LogStatus.INFO, "Browser got opened");
	
	navigate("AppURL");
	
	test.log(LogStatus.INFO, "Application url got launched");
	
	LaunchPage launchPage=new LaunchPage(driver, test);
	
	launchPage.goSignUp();
	
	SignUpPage page=new SignUpPage(driver, test);
	
	page.doSignUp();
	
	boolean result=verifyingSignUp();
	
	if(result==true) {
		
	reportPass("SignUp Test is Successfull");
		
	}else if(result==false) {
		
	reportFail("SignUp Test is not Successfull");	
		
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
