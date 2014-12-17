/**
 * 
 */
package edu.pw.mini.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author SAMBATH
 *
 */
public class AirbnbHomePage extends AirbnbPage<AirbnbHomePage> {

	
	@FindBy(id="login")
	private WebElement loginLink;
	
	@FindBy(id="sign_up")
	private WebElement signupLink;
	

	/* (non-Javadoc)
	 * @see edu.pw.mini.selenium.pageobjects.AirbnbPage#getPageLoadCondition()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ExpectedCondition<WebElement> getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginLink);
	}

	/* (non-Javadoc)
	 * @see edu.pw.mini.selenium.pageobjects.AirbnbPage#getPageUrl()
	 */
	@Override
	protected String getPageUrl() {
		return "/";
	}
	
	public void login(final String userName, final String pwd){
		loginLink.findElement(By.tagName("a")).click();
		
		WebElement emailAddressBox = getDriver().findElement(By.id("signin_email"));
		WebElement pwdBox = getDriver().findElement(By.id("signin_password"));
		WebElement loginBtn = getDriver().findElement(By.id("user-login-btn"));

		
		emailAddressBox.sendKeys(userName);
		pwdBox.sendKeys(pwd);
		
		loginBtn.click();
		
	}
	
	public ExpectedCondition<WebElement> isLoginError(){
		return ExpectedConditions.visibilityOf(getDriver().findElement(By.id("notice")));
	}
	
	public ExpectedCondition<WebElement> isSignedIn(){
			return ExpectedConditions.visibilityOf(getDriver().findElement(By.id("header-avatar-trigger")));
	}

}
