package mapsynq.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mapsynq.qa.utilities.ScreenshotUtility;

public class BaseClass {

	public static Properties prop;
	public static WebDriver dr;
	public static ExtentReports report;
	public static ExtentTest logger;

	public BaseClass()
	{
		prop = new Properties();
		FileInputStream file=null;
		try {
			file = new FileInputStream(".//src/test/resources/application.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void hideAdd(String desc)
	{
		try
		{
			Thread.sleep(4000);
			dr.findElement(By.xpath("//*[@id='ad_toggle']")).click();
			logger.log(LogStatus.PASS, "Hide the advatisement");
		} 
		catch (InterruptedException e) 
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL,desc , image);
			e.printStackTrace();
		}

	}

	public static void startTest(String name)
	{
		String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

		report = new ExtentReports(System.getProperty("user.dir")+ "\\src\\test\\resources\\Reports\\" +name+timestamp+ ".html");

	}
	public static void endReport()
	{
		report.flush();
	}

	public static void init()
	{
		String desc = "Open Browser and Enter URL";
		String Browser = prop.getProperty("Browser_Name");
		try
		{
			switch(Browser)
			{
			case "Chrome":
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-extensions");
				options.addArguments("start-maximized");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("disable-infobars");
				dr = new ChromeDriver(options);
				break;
			}  

			case "Chrome_Headless":
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-extensions");
				options.addArguments("start-maximized");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("--headless","--disable-gpu");
				options.addArguments("disable-infobars");
				dr = new ChromeDriver(options);
				break;
			}
			}
			dr.get(prop.getProperty("URL"));
			logger.log(LogStatus.PASS, desc);
		}

		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL,desc , image);

		}

	}

}
