package comman_pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriver {

	public static WebDriver web() {
		 WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
}
