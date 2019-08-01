package mapsynq_automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqPersonalPage;
import mapsynq.qa.testbase.BaseClass;

public class PersonalPage extends BaseClass {

	MapsynqPersonalPage mappersonal;

	public PersonalPage()
	{
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqPersonalPage");
		init();
		mappersonal = new MapsynqPersonalPage();
	}

	@Test
	public void CheckPersonalBtn()
	{
		hideAdd("Hide the advatisement");
		mappersonal.personaltab();
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
