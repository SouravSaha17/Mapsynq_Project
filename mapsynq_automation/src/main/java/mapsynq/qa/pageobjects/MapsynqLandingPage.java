package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqLandingPage extends BaseClass {

	public  MapsynqLandingPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='div_header']/a")
	WebElement login_page_verification;

	public void getElement()
	{
		String Actual_value = ReuseableComponents.getAttributeValue(login_page_verification, "href", "Get heading value");
		String Expected_value = prop.getProperty("login_page_verification_value");
		ReuseableComponents.checklogin("contains", Expected_value, Actual_value, "Verify landing page");
	}

}
