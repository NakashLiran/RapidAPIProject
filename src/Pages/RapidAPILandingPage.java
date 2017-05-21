package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Helpers.BrowserHelper;

public class RapidAPILandingPage {
	WebDriver driver;

	public RapidAPILandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LogIn clcikOnLoginButton() {

		WebElement loginButton = driver.findElement(By.className("profile"));
		loginButton.click();
		return new LogIn(driver);
	}

	public void clickOnMusicCategory() {
		driver.findElement(
				By.xpath("//*[@id='root']/div/div[1]/div/div[1]/div[3]/div[1]/div/ul/li[2]/a"))
				.click();
	}

	public BlogPage clickOnBlog() {
		driver.findElement(By.xpath("//a[text()='Blog']")).click();
		return new BlogPage(driver);
	}

	public ProjectsPage clickOnMyApps() {
		driver.findElement(By.xpath("//a[text()='My Apps']")).click();
		return new ProjectsPage(driver);
	}

	public DocsPage clickOnDocs() {
		driver.findElement(By.xpath("//a[text()='Docs']")).click();
		return new DocsPage(driver);
	}

	public AboutPage clickOnAbout() {
		driver.findElement(By.xpath("//a[text()='About']")).click();
		return new AboutPage(driver);
	}

	public RapidAPILandingPage clickOnMarketplace() {
		driver.findElement(By.xpath("//a[text()=' Marketplace ']")).click();
		return new RapidAPILandingPage(driver);
	}

	public SpotifyPublicAPIPage clickOnSpotifyPublicAPI() {
		driver.findElement(By.xpath("//a[@href='/package/SpotifyPublicAPI']"))
				.click();
		return new SpotifyPublicAPIPage(driver);

	}

	public APISuggestionPage clickOnSuggestAnAPIButton() {
		driver.findElement(By.className("suggest-api-button")).click();
		BrowserHelper.switchToLastTab(driver);
		return new APISuggestionPage(driver);
	}
}
