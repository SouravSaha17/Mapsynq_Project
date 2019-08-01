package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqForgotPasswordPage extends BaseClass{

	public  MapsynqForgotPasswordPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='div_header']/div[2]/div[4]/a[1]")
	WebElement click_signin_tab;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/h5")
	WebElement forgot_password_heading;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/div[2]/div[1]/form/table/tbody/tr[6]/td[2]/div[1]/a")
	WebElement forgot_password_btn;

	@FindBy(xpath="//*[@id='name']")
	WebElement forgot_password_email;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/form/div[2]/input[2]")
	WebElement reset_btn;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/h5")
	WebElement verify_signin_page;

	public void forgotpassword(String email)
	{
		ReuseableComponents.clickElement(click_signin_tab, "Click Sign in tab");
		ReuseableComponents.clickElement(forgot_password_btn, "Click forgot password");

		String actual = ReuseableComponents.getTextValue(forgot_password_heading, "Get forgot password heading");
		String expected = prop.getProperty("verify_forgot_password_page_value");
		ReuseableComponents.checklogin("contains", expected, actual, "Verify forgot password page");

		ReuseableComponents.clearElementandEnterText(forgot_password_email, email, "Enter email id");
		ReuseableComponents.clickElement(reset_btn, "Click reset button");

		String actual_value = ReuseableComponents.getTextValue(verify_signin_page, "Verify sign in page");
		String expected_value = prop.getProperty("verify_signin_page_value");
		ReuseableComponents.checklogin("contains", expected_value, actual_value, "Verify signin page");
	}

}
