package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class APISuggestionPage {

	WebDriver driver;

	public APISuggestionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enter() {
		WebElement e = driver.findElement(By.tagName("body"));
		e.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public void fillAPIName(String apiName) {
		WebElement e = driver.findElement(By
				.xpath("//span[text()='API Name']/../.."));
		WebElement t = e.findElement(By.tagName("input"));
		t.sendKeys(apiName);
	}

	public void fillYourEmail(String email) {
		WebElement e = driver.findElement(By
				.xpath("//span[text()='Your email']/../.."));
		WebElement t = e.findElement(By.tagName("input"));
		t.sendKeys(email);
	}

	public void selectAreYouTheAPICreator(boolean areYouThAPICreator) {
		WebElement e;
		if (areYouThAPICreator) {
			e = driver
					.findElement(By
							.xpath("//*[@id='37087272']/div/div[3]/div/div[1]/div/ul/li[1]/div[1]/div[3]"));
		} else {
			e = driver
					.findElement(By
							.xpath("//*[@id='37087272']/div/div[3]/div/div[1]/div/ul/li[2]/div[1]/div[3]"));
		}
		e.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void submit() {
		WebElement e = driver.findElement(By.tagName("body"));
		e.sendKeys(Keys.PAGE_DOWN);
		e.sendKeys(Keys.PAGE_DOWN);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		driver.findElement(By.cssSelector(".button-wrapper.submit")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	public String getEndOfProcessText() {
		return driver.findElement(
				By.xpath("//*[@id='1109556']/div[1]/div/div[2]")).getText();
	}

}
