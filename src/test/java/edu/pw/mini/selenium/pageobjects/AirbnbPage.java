/**
 * 
 */
package edu.pw.mini.selenium.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import edu.pw.mini.selenium.DriverFactory;

/**
 * @author SAMBATH
 *
 */
public abstract class AirbnbPage<T> {

	private static final String BASE_URL = "https://airbnb.com";

	private static final Long LOAD_TIMEOUT = 30l;

	private static final Long REFRESH_RATE = 5l;

	@SuppressWarnings("unchecked")
	public  <X> T openPage(Class<T> pageClazz) {
		T page = PageFactory.initElements(getDriver(), pageClazz);
		getDriver().get(BASE_URL + getPageUrl());
		ExpectedCondition<X> pageLoadCondition = ((AirbnbPage<T>) page)
				.getPageLoadCondition();
		waitForPageToLoad(pageLoadCondition);
		return page;
	}

	
	protected WebDriver getDriver(){
		return DriverFactory.getDriver();
	}

	protected  abstract <X> ExpectedCondition<X> getPageLoadCondition();

	protected abstract String getPageUrl();

	private <X> void waitForPageToLoad(ExpectedCondition<X> pageLoadCondition) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(LOAD_TIMEOUT,
				TimeUnit.SECONDS).pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

		wait.until(pageLoadCondition);
	}

}
