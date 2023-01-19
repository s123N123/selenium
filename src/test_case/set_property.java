package test_case;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class set_property {
	public static String Property() {
		String path = System.setProperty("webdriver.chrome.driver",
				"H:\\it\\selenium\\chromedriver_win32\\chromedriver.exe");
		return path;
	}

}
