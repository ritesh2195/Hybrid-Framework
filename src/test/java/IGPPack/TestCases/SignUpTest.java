	package IGPPack.TestCases;

	import IGPPack.Utilities.Constant;
	import IGPPack.managers.PageObjectManager;
	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;
	import IGPPack.Pages.LaunchPage;
	import IGPPack.Pages.SignUpPage;
	import java.util.List;

	@Listeners(ListenerTest.class)
	
	public class SignUpTest extends BaseClass {

	PageObjectManager pageObjectManager;
	LaunchPage launchPage;
	SignUpPage signUpPage;

	@Test
	public void signUpTest() throws InterruptedException {

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

	Thread.sleep(5000);

	List<String> userDetails = signUpPage.verifySignUpTest();

	String userName = userDetails.get(0);

	System.out.println(userName);

	String userEmail = userDetails.get(1);

	System.out.println(userEmail);

	String actualName = Constant.firstName.toLowerCase()+ " "+ Constant.lastName.toLowerCase();

	String actualEmail = Constant.mail.toLowerCase();

	Assert.assertEquals(userEmail,actualEmail);

	Assert.assertEquals(userName.toLowerCase(),actualName);

	}

	}
