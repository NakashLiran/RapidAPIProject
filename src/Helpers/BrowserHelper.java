package Helpers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserHelper {

	private static String maximizeCommand = "--start-maximized";
	private static String rapidAPIUrl = "https://rapidapi.com/";
	private static String credentials = "credentials_enable_service";
	private static String enableManagerCommand = "profile.password_manager_enabled";
	private static String experimentalOption = "prefs";
	private static String chromeDriverExeName = "chromedriver.exe";
	private static String chromeDriverProperty = "webdriver.chrome.driver";

	public static WebDriver initBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments(maximizeCommand);

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put(credentials, false);
		prefs.put(enableManagerCommand, false);
		options.setExperimentalOption(experimentalOption, prefs);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty(chromeDriverProperty,chromeDriverExeName);
		WebDriver driver = new ChromeDriver(capabilities);
		return driver;
	}

	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public static void navigateToRapidAPIHomePage(WebDriver driver) {
		driver.get(rapidAPIUrl);
	}

	public static void switchToLastTab(WebDriver driver) {
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
		}
	}

	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}
