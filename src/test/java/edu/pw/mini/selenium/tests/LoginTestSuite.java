package edu.pw.mini.selenium.tests;

import java.util.Date;
import java.util.UUID;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import edu.pw.mini.selenium.DriverFactory;
import edu.pw.mini.selenium.pageobjects.AirbnbHomePage;

/**
 * @author SAMBATH
 *
 */
public class LoginTestSuite extends DriverFactory {

	@Test
	public void simpleLoginFailTest(){
		AirbnbHomePage page = new AirbnbHomePage().openPage(AirbnbHomePage.class);
		page.login("TestUser@gmail.com", "123343");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(page.isLoginError());
	}
	
	
	@Test
	public void simpleLoginTest(){
		AirbnbHomePage page = new AirbnbHomePage().openPage(AirbnbHomePage.class);
		page.login("vignezds@gmail.com", "v1i1k1i1");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(page.isSignedIn());
	}
	
	@Test
	public void simpleSignupTest(){
		AirbnbHomePage page = new AirbnbHomePage().openPage(AirbnbHomePage.class);
		UUID uuid = UUID.randomUUID();
		page.doSignUp("first", "last", uuid.toString()+"@cuvox.de", "123456789");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(page.isSignedIn());
	}
		
}