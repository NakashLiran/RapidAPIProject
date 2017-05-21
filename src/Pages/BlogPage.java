package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {

	WebDriver driver;

	public BlogPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnTwitterIcon() {
		driver.findElement(By.xpath("//a[@id='sfsiid_twitter']")).click();
	}

}
