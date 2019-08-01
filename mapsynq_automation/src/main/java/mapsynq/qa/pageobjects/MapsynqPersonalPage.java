package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqPersonalPage extends BaseClass {

	public  MapsynqPersonalPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='info_panel']/div[1]/div/a[2]")
	WebElement personal_btn;

	@FindBy(xpath="//*[@id='me_menu']/div[1]/input")
	WebElement signin_btn;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/h5")
	WebElement verify_signin_page;

	public void personaltab()
	{
		ReuseableComponents.clickElement(personal_btn, "Open personal tab");
		ReuseableComponents.clickElement(signin_btn, "Click sign in button");

		String actual_value = ReuseableComponents.getTextValue(verify_signin_page, "Get static text value");
		String expected_value = prop.getProperty("verify_signin_page_value");
		ReuseableComponents.checklogin("contains", expected_value, actual_value, "Verify personal tab");
	}

}
