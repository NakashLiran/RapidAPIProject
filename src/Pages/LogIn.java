package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {

	WebDriver driver;

	public LogIn(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String email, String password) {
		fillEmailTextBox(email);
		fillPassword(password);
		clickOnLogInButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void clickOnLogInButton() {
		WebElement loginButton = driver.findElement(By
				.className("login-button"));
		loginButton.click();
	}

	private void fillPassword(String password) {
		WebElement passwordElement = driver
				.findElement(By.id("login-password"));
		passwordElement.sendKeys(password);

	}

	private void fillEmailTextBox(String email) {
		WebElement emailElement = driver.findElement(By.id("login-email"));
		emailElement.sendKeys(email);
	}

}
