package mapsynq.qa.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import mapsynq.qa.testbase.BaseClass;


public class ReuseableComponents extends BaseClass {

	public static void clickElement(WebElement element, String desc)
	{
		try
		{
			element.click();
			logger.log(LogStatus.PASS, desc);
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
	}

	public static void clearElementandEnterText(WebElement element,String text, String desc) 
	{
		try
		{
			element.clear();
			element.sendKeys(text);
			logger.log(LogStatus.PASS, desc);
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
	}

	public static String getTextValue(WebElement element, String desc)
	{
		try
		{
			String Value;
			Value = element.getText();
			System.out.println(Value);
			logger.log(LogStatus.PASS, desc);
			return Value;
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
		return "";
	}

	public static String getAttributeValue(WebElement element, String name, String desc)
	{
		try
		{
			String Value;
			Value = element.getAttribute(name);
			System.out.println(Value);
			logger.log(LogStatus.PASS, desc);
			return Value;
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
		return "";
	}


	public static void dropdown(WebElement element, String type, String dropdown_value, String desc)
	{
		try
		{
			switch(type)
			{
			case"value":
				Select obj = new Select(element);
				obj.selectByValue(dropdown_value);
				break;

			case"visibletext":
				Select obj1 = new Select(element);
				obj1.selectByVisibleText(dropdown_value);
				break;

			case"index":
				int index = Integer.parseInt(dropdown_value);
				Select obj2 = new Select(element);
				obj2.selectByIndex(index);
				break;

			}
			logger.log(LogStatus.PASS, desc);
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
	}

	public static void dateSelector(String date_value, String desc)
	{
		try
		{
			List<WebElement> Col1 = dr.findElements(By.tagName("td"));
			for(WebElement cell2 : Col1)
			{
				if(cell2.getText().equals(date_value))
				{
					cell2.click();
					break;
				}
			}
			logger.log(LogStatus.PASS, desc);
		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
	}

	public static void checklogin(String Type, String Expected, String Actual, String desc)
	{
		try
		{
			switch(Type)
			{
			case"equal":
				if(Expected .equals(Actual))
				{
					logger.log(LogStatus.PASS, desc);
					System.out.println("Verified Text");
				}
				else
				{
					String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
					String image = logger.addScreenCapture(Snapshot);
					logger.log(LogStatus.FAIL, desc, image);
					System.out.println("N");
				}
				break;

			case"contains":

				if(Expected .contains(Actual))
				{
					logger.log(LogStatus.PASS, desc);
					System.out.println("Verified Text");
				}
				else
				{
					String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
					String image = logger.addScreenCapture(Snapshot);
					logger.log(LogStatus.FAIL, desc, image);
					System.out.println("N");
				}
				break;

			}
		}

		catch(Exception e)

		{

			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);

		}
	}


	public static void frame(WebElement element1,WebElement element2, String expected_value, String desc)
	{
		try
		{
			dr.switchTo().frame(element1);
			WebElement XYZ = element2;
			String SOU = XYZ.getText();
			System.out.println(SOU);
			if(SOU .contains(expected_value))
			{
				logger.log(LogStatus.PASS, desc);
				System.out.println("Verified Text");
			}
			else
			{
				String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
				String image = logger.addScreenCapture(Snapshot);
				logger.log(LogStatus.FAIL, desc, image);
				System.out.println("N");
			}

			dr.switchTo().parentFrame();
			logger.log(LogStatus.PASS, desc);

		}
		catch(Exception e)
		{
			String Snapshot = ScreenshotUtility.capturescreen(dr, desc);
			String image = logger.addScreenCapture(Snapshot);
			logger.log(LogStatus.FAIL, desc, image);
		}
	}

}


