package mapsynq.qa.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import mapsynq.qa.testbase.BaseClass;

public class ScreenshotUtility extends BaseClass {

	public static String capturescreen(WebDriver driver, String screenshotname)
	{
		try
		{
			TakesScreenshot scr = (TakesScreenshot) driver;
			File source = scr.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
			String destin = System.getProperty("user.dir")+ "\\src\\test\\resources\\Screenshot\\" +screenshotname+timestamp+ ".png";
			File destination = new File(destin);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken" + screenshotname);
			return destin;
		}

		catch (Exception e)
		{
			System.out.println("Error message" + e.getMessage());
		}
		return "";
	}
}
