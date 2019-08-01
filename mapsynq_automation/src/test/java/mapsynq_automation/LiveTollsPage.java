package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLiveTollsPage;
import mapsynq.qa.testbase.BaseClass;


public class LiveTollsPage extends BaseClass {

	MapsynqLiveTollsPage maplivetoll;

	public LiveTollsPage()
	{
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqLiveTollsPage");
		init();
		maplivetoll = new MapsynqLiveTollsPage();
	}

	@Test
	public void CheckTolls()
	{
		hideAdd("Hide the advatisement");
		maplivetoll.livetoll();
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
