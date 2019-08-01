package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqLiveIncidents;
import mapsynq.qa.testbase.BaseClass;

public class LiveIncidentPage extends BaseClass {
	MapsynqLiveIncidents mapLive;
	String thread;

	public LiveIncidentPage() {
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqLiveIncidents");
		init();		
		mapLive=new MapsynqLiveIncidents();
	}


	@Test
	public void ClickandValidateIncident()
	{
		hideAdd("Hide the advatisement");
		mapLive.clickIncident();
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}

}
