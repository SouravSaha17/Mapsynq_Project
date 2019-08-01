package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLandingPage;
import mapsynq.qa.testbase.BaseClass;

public class LandingPage extends BaseClass {

	MapsynqLandingPage mapLanding;
	String thread;

	public LandingPage()
	{
		super();
	}

	@BeforeMethod
	public void initilasation() {
		logger = report.startTest("MapsynqLandingPage");
		init();
		mapLanding = new MapsynqLandingPage();		
	}

	@Test
	public void GetElementAndValidate()
	{
		hideAdd("Hide the advatisement");
		mapLanding.getElement();
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
