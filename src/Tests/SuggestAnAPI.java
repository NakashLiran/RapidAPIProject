package Tests;

import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Helpers.BrowserHelper;
import Pages.APISuggestionPage;
import Pages.LogIn;
import Pages.RapidAPILandingPage;

public class SuggestAnAPI {
	/*
	 * This test case tests suggestion API process completion.
	 */
	@Test
	public void SuggestAnAPIProcessCompletedSuccessfully(){
		//Initialize browser.
		WebDriver driver = BrowserHelper.initBrowser();
		
		String expectedSuccessText = "Thanks for the suggestion. We can't wait to see what you'll create with the API!";
		Random rnd = new Random(5);
		
		//Navigates to RapidAPI home page.
		BrowserHelper.navigateToRapidAPIHomePage(driver);
		RapidAPILandingPage landingPage = new RapidAPILandingPage(driver);
		//Login execution.
		LogIn login = landingPage.clcikOnLoginButton();
		login.login("liran_nakash@walla.co.il", "38801981");
		
		//Suggestion API process.
		APISuggestionPage suggestedAPI = landingPage			
				.clickOnSuggestAnAPIButton();
		suggestedAPI.enter();
		String apiName = "testAutomationAPI" + rnd.nextInt();
		String email = "TestAutomation" + rnd.nextInt() + "@gmail.com";
		suggestedAPI.fillAPIName(apiName);
		suggestedAPI.fillYourEmail(email);
		suggestedAPI.selectAreYouTheAPICreator(true);
		suggestedAPI.submit();
		String ActualText = suggestedAPI.getEndOfProcessText();
		
		//Assertion.
		assertEquals("Failed to complete API suggestion.", expectedSuccessText,
				ActualText.trim());
		//Closing browser at the end of the test.
		BrowserHelper.closeBrowser(driver);
	}
}
