package mapsynq_automation;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mapsynq.qa.pageobjects.MapsynqRegisterPage;
import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.TestdataUtility;

public class RegisterForm extends BaseClass {

	MapsynqRegisterPage mapRegister;

	public RegisterForm() {
		super();
	}

	@DataProvider(name = "dataprovidermethod")
	public Object[][] createData1() throws IOException {
		Object[][] retObjArr=
				TestdataUtility.getExcelData(System.getProperty("user.dir")+ "\\src\\test\\resources\\Input.xlsx","Register");
		return(retObjArr);
	}

	@BeforeMethod
	public void initilasation() 
	{
		//startTest("MapsynqRegisterPage");
		logger = report.startTest("MapsynqRegisterPage");
		init();		
		mapRegister=new MapsynqRegisterPage();
	}

	@Test (dataProvider = "dataprovidermethod")
	public void CreateNewProfile(String First_Name, String Last_Name, String Date, String Email, String Password) throws InterruptedException
	{
		//String First_Name; String Last_Name; String Date; String Email; String Password;
		System.out.println("first test");
		//mapLive.hideAdd();
		//ReuseableComponents.wait(thread, 1);
		hideAdd("Hide the advatisement");
		mapRegister.formFill(First_Name, Last_Name, Date, Email, Password);
	}

	@AfterMethod
	public void close()
	{
		dr.quit();
		report.endTest(logger);
	}

}
