package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpotifyPublicAPIPage {

	WebDriver driver;

	public SpotifyPublicAPIPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SearchAlbum(String albumName, boolean clickOnTestFunctionButton)
			throws InterruptedException {

		clickOnAPIFunction("searchAlbums");
		query(albumName, clickOnTestFunctionButton);
	}

	private void clickOnAPIFunction(String apiFunctionName)
			throws InterruptedException {
		Thread.sleep(3000);
		String xpath = String.format("//span[text()='%s']", apiFunctionName);
		driver.findElement(By.xpath(xpath)).click();

	}

	private void query(String queryText, boolean clickOnTestButton) {
		WebElement e = driver.findElement(By.className("test-area"));
		WebElement e1 = e.findElement(By
				.xpath("//input[@class='parameter-value']"));
		e1.sendKeys(queryText);
		if (clickOnTestButton) {
			clickOnTestFunctionButton();
		}
	}

	public void clickOnTestFunctionButton() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement e = driver.findElement(By.className("test-button"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", e);
	}

	public String getCallbackText() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement e = driver.findElement(By.className("response-success"));
		return e.getText();
	}

}
