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

	@FindBy(id = "login")
	private WebElement loginLink;

	@FindBy(id = "sign_up")
	private WebElement signupLink;
	
	@FindBy(xpath="/html/body[@class='home_view v2 simple-header p1 modal-open']/div[@class='modal']/div[@class='modal-table']/div[@class='modal-cell']/div[@class='signup modal-content']/div[@class='panel-padding panel-body']/div[@class='text-center']/a[@class='create-using-email btn-block padded-btn-block  row-space-2 btn btn-primary btn-block btn-large large icon-btn']")
	private WebElement signupBtn;
	
	@FindBy(id ="inputFirst")
	private WebElement inputFirst;
	
	@FindBy(id = "inputLast")
	private WebElement inputLast;

	@FindBy(id = "inputEmail")
	private WebElement inputEmail;
	
	@FindBy(id = "inputPassword")
	private WebElement inputPassword;
	
	@FindBy(id = "inputConfirmPassword")
	private WebElement inputConfirmPassword;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.pw.mini.selenium.pageobjects.AirbnbPage#getPageLoadCondition()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ExpectedCondition<WebElement> getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(loginLink);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.pw.mini.selenium.pageobjects.AirbnbPage#getPageUrl()
	 */
	@Override
	protected String getPageUrl() {
		return "/";
	}

	public void login(final String userName, final String pwd) {
		loginLink.findElement(By.tagName("a")).click();

		WebElement emailAddressBox = getDriver().findElement(
				By.id("signin_email"));
		WebElement pwdBox = getDriver().findElement(By.id("signin_password"));
		WebElement loginBtn = getDriver().findElement(By.id("user-login-btn"));

		emailAddressBox.sendKeys(userName);
		pwdBox.sendKeys(pwd);

		loginBtn.click();

	}

	public ExpectedCondition<WebElement> isLoginError() {
		return ExpectedConditions.visibilityOf(getDriver().findElement(
				By.id("notice")));
	}

	public ExpectedCondition<WebElement> isSignedIn() {
		return ExpectedConditions.visibilityOf(getDriver().findElement(
				By.id("header-avatar-trigger")));
	}

	public void doSignUp(String firstName, String lastName, String emailId,
			String pwd) {

		signupLink.findElement(By.tagName("a")).click();
		
		signupBtn.click();
		
		
		inputFirst.findElement(By.tagName("input")).sendKeys(firstName);
		
		inputLast.findElement(By.tagName("input")).sendKeys(lastName);
		inputEmail.findElement(By.tagName("input")).sendKeys(emailId);
		inputPassword.findElement(By.tagName("input")).sendKeys(pwd);
		inputConfirmPassword.findElement(By.tagName("input")).sendKeys(pwd);
		
		
		inputFirst.submit();
		
	}
}