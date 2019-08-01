package mapsynq_automation;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqSigninPage;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.TestdataUtility;

public class SigninPage extends BaseClass{

	MapsynqSigninPage mapsignin;

	public SigninPage()
	{
		super();
	}

	@DataProvider(name = "dataprovidermethod")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr=
				TestdataUtility.getExcelData(System.getProperty("user.dir")+ "\\src\\test\\resources\\Input.xlsx","SignIn");
		return(retObjArr);
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqSigninPage");
		init();
		mapsignin = new MapsynqSigninPage();
	}

	@Test (dataProvider = "dataprovidermethod")
	public void login(String user_name, String pass_word)
	{
		hideAdd("Hide the advatisement");
		mapsignin.signup(user_name, pass_word);
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
