package edu.pw.mini.selenium.tests;

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
	public void SimpleLoginFailTest(){
		AirbnbHomePage page = new AirbnbHomePage().openPage(AirbnbHomePage.class);
		page.login("TestUser@gmail.com", "123343");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(page.isLoginError());
	}
	
	
	@Test
	public void SimpleLoginTest(){
		AirbnbHomePage page = new AirbnbHomePage().openPage(AirbnbHomePage.class);
		page.login("vignezds@gmail.com", "v1i1k1i1");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(page.isSignedIn());
	}
	
	
}