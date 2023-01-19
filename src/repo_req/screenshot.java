package repo_req;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	
		// no need create object
		static WebDriver driver;

		public static void main(String[] args) throws IOException {
			// Create object for Chromedriver

			System.setProperty("webdriver.chrome.driver", "H:\\it\\selenium\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.get("https://www.goibibo.com/");

			driver.manage().window().maximize();
			//casting
			TakesScreenshot ss = (TakesScreenshot) driver;
			// soucrce connect to last stepsss
			File source = ss.getScreenshotAs(OutputType.FILE);

			File filename = new File("C:\\Users\\hp\\Desktop\\selenum\\FBO.PNG");

			// save file in fileutiles
			 FileUtils.copyFile(source, filename);// call src and dest.

			if (filename.exists()) {
				System.out.println("screenshot is exist" + filename);
				filename.delete();
				System.out.println("old screenshot is del.");
				FileUtils.copyFile(source, filename);// call src and dest.
				System.out.println("screenshot copy in directory ");
			} else {
				System.out.println("screenshot doesent exist ");
				FileUtils.copyFile(source, filename);// call src and dest.
				System.out.println("screenshot copy in directory " + filename);
			}
			driver.quit();

		}
	}
