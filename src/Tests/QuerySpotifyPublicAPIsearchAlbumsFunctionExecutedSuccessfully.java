package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Helpers.BrowserHelper;
import Pages.LogIn;
import Pages.RapidAPILandingPage;
import Pages.SpotifyPublicAPIPage;

public class QuerySpotifyPublicAPIsearchAlbumsFunctionExecutedSuccessfully {

	/*
	 * This test case tests "SearchAlbum" functionality (in 'Music' category).
	 */
	private String email = "liran_nakash@walla.co.il";
	private String password = "38801981";
	@Test
	public void test() throws InterruptedException {
		// Initialize browser.
		WebDriver driver = BrowserHelper.initBrowser();
		String expectedSuccessText = "Success 200";

		// Navigates to RapidAPI home page.
		BrowserHelper.navigateToRapidAPIHomePage(driver);
		RapidAPILandingPage landingPage = new RapidAPILandingPage(driver);

		// Login execution.
		LogIn login = landingPage.clcikOnLoginButton();
		login.login(email,password);

		// Testing 'searchAlbum' function.
		landingPage.clickOnMusicCategory();
		SpotifyPublicAPIPage spotifyPublicAPI = landingPage
				.clickOnSpotifyPublicAPI();
		spotifyPublicAPI.SearchAlbum("Bob Marley", true);
		String resultText = spotifyPublicAPI.getCallbackText();

		// Assertion.
		assertEquals("Function testing Failed. Actual callback text is:"
				+ resultText, resultText.trim(), expectedSuccessText);

		// Closing browser at the end of the test.
		BrowserHelper.closeBrowser(driver);
	}
}
