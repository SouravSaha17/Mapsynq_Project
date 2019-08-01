package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLiveCameraPage;
import mapsynq.qa.testbase.BaseClass;

public class LiveCameraPage extends BaseClass {

	MapsynqLiveCameraPage maplivecam;

	public LiveCameraPage()
	{
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqLiveCameraPage");
		init();
		maplivecam = new MapsynqLiveCameraPage();
	}

	@Test
	public void CheckLiveCam()
	{
		hideAdd("Hide the advatisement");
		maplivecam.livecam();
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
