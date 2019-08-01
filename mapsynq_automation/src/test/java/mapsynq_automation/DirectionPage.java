package mapsynq_automation;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqDirectionPage;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.TestdataUtility;

public class DirectionPage extends BaseClass {

	MapsynqDirectionPage mapdirection;

	public DirectionPage()
	{
		super();
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqDirectionPage");
		init();
		mapdirection = new MapsynqDirectionPage();
	}

	@DataProvider(name = "dataprovidermethod")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr=
				TestdataUtility.getExcelData(System.getProperty("user.dir")+ "\\src\\test\\resources\\Input.xlsx","Direction");
		return(retObjArr);
	}

	@Test (dataProvider = "dataprovidermethod")
	public void CheckDirection(String from, String to)
	{
		hideAdd("Hide the advatisement");
		mapdirection.getdirection(from, to);
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
