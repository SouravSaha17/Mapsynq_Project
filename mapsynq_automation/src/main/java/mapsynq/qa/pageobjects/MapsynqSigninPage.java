package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqSigninPage extends BaseClass{

	public  MapsynqSigninPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='div_header']/div[2]/div[4]/a[1]")
	WebElement click_signin_tab;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/h5")
	WebElement verify_signin_page;

	@FindBy(xpath="//*[@id='name']")
	WebElement signin_username;

	@FindBy(xpath="//*[@id='password']")
	WebElement signin_password;

	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td/div/div/div[2]/div[1]/form/table/tbody/tr[6]/td[2]/div[1]/input")
	WebElement signin_btn;

	@FindBy(xpath = "//*[@id='div_header']/a")
	WebElement login_page_verification;

	public void signup(String uname, String password)
	{
		ReuseableComponents.clickElement(click_signin_tab, "Click Sign in tab");
		String actual_value = ReuseableComponents.getTextValue(verify_signin_page, "Verify Sign In page");
		String expected_value = prop.getProperty("verify_signin_page_value");
		ReuseableComponents.checklogin("contains", expected_value, actual_value, "Verify signin page");

		ReuseableComponents.clearElementandEnterText(signin_username, uname, "Enter username");
		ReuseableComponents.clearElementandEnterText(signin_password, password, "Enter Password");
		ReuseableComponents.clickElement(signin_btn, "Click sign in button");

		String Actual_value = ReuseableComponents.getAttributeValue(login_page_verification, "href", "Get heading value");
		String Expected_value = prop.getProperty("login_page_verification_value");
		ReuseableComponents.checklogin("contains", Expected_value, Actual_value, "Verify landing page");
	}

}
