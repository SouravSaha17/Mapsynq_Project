package mapsynq_automation;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqForgotPasswordPage;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.TestdataUtility;

public class ForgotPasswordPage extends BaseClass {

	MapsynqForgotPasswordPage mapforgotpassword;

	public ForgotPasswordPage()
	{
		super();
	}

	@DataProvider(name = "dataprovidermethod")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr=
				TestdataUtility.getExcelData(System.getProperty("user.dir")+ "\\src\\test\\resources\\Input.xlsx","ForgotPassword");
		return(retObjArr);
	}

	@BeforeMethod
	public void initilasation() 
	{
		logger = report.startTest("MapsynqForgotPasswordPage");
		init();
		mapforgotpassword = new MapsynqForgotPasswordPage();
	}

	@Test (dataProvider = "dataprovidermethod")
	public void PasswordReset(String email)
	{
		hideAdd("Hide the advatisement");
		mapforgotpassword.forgotpassword(email);
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}
}
