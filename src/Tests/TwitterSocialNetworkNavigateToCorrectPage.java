package Tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Helpers.BrowserHelper;
import Pages.BlogPage;
import Pages.LogIn;
import Pages.RapidAPILandingPage;

public class TwitterSocialNetworkNavigateToCorrectPage {
	/*
	 * This test case tests that clicking on 'Twitter' icon from 'Blog' section
	 * Navigates to 'Twitter' social network correct page.
	 */
	private String email="liran_nakash@walla.co.il";
	private String password="38801981";
	private String expectedTwitterUrl = "https://twitter.com/Rapid_API";
	
	@Test
	public void VerifyTwitterSocialNetworkNavigateToCorrectPage() {		
		// Initialize browser.
		WebDriver driver = BrowserHelper.initBrowser();

		// Navigates to RapidAPI home page.
		BrowserHelper.navigateToRapidAPIHomePage(driver);
		RapidAPILandingPage landingPage = new RapidAPILandingPage(driver);

		// Login execution.
		LogIn login = landingPage.clcikOnLoginButton();
		login.login(email,password);

		// Testing navigation to correct page after clicking on 'Twitter' icon.
		BlogPage blog = landingPage.clickOnBlog();
		blog.clickOnTwitterIcon();
		BrowserHelper.switchToLastTab(driver);
		String actualUrl = driver.getCurrentUrl();
		
		// Assertion.
		Assert.assertEquals(
				"Wrong page is opened while clicking on Twitter button",
				actualUrl, expectedTwitterUrl);

		// Closing browser at the end of the test.
		BrowserHelper.closeBrowser(driver);
	}

}