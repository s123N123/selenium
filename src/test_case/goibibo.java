package test_case;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import comman_pkg.goibibo_url;
import comman_pkg.url;
import comman_pkg.webdriver;

public class goibibo  {
	public static void test1() throws IOException, InterruptedException {
		// step 1: set system property so this code should know the location of
		
		//System.setProperty("webdriver.chrome.driver", "H:\\it\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		set_property.Property();
		
		// step 2:create the object for chrome driver
		WebDriver driver = new ChromeDriver();
		// define impliciate wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	
		//driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		// launch Uri
		driver.get(url.url());

		WebDriverWait exp_wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		// .click();
		exp_wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class=\"sc-ieecCq gToiRQ fswDownArrow\"]"))).click();

		// create webelement variable for text & click
		List<WebElement> text_webelement = driver
				.findElements(By.xpath("//div[contains(@class,\"DayPicker-Day\") and @aria-selected=\"true\"]/p"));
		List<WebElement> click_webelement = driver
				.findElements(By.xpath("//div[contains(@class,\"selected DayPicker-Day--today\")]"));
		// fetch the count of constituent of list
		int count = text_webelement.size();

		// iterate through the entire list select value depending on comparison
		for (int i = 0; i < count; i++) {
			String list_value = text_webelement.get(i).getText();
			System.out.println("today date " + list_value);
			if (list_value.equalsIgnoreCase("5")) {
				click_webelement.get(i).click();
				break;
			} else {
				System.out.println("deired date is not found in iteeration" + i + ",hence retrying");

			}
		}
		exp_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"fswTrvl__done\"]")))
				.click();
		driver.quit();
	}
}
