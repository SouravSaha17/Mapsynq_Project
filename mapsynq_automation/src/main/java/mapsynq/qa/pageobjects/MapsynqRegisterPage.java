package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqRegisterPage extends BaseClass {

	public MapsynqRegisterPage() 
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath = "//*[@id='div_header']/div[2]/div[4]/a[2]")
	WebElement click_register_btn;

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td/div/h5")
	WebElement verify_register_page;

	@FindBy(xpath = "//*[@id='profile_first_name']")
	WebElement first_name;

	@FindBy(xpath = "//*[@id='profile_last_name']")
	WebElement last_name;

	@FindBy(xpath = "//*[@id='profile_country']")
	WebElement country_select;
	String Country = prop.getProperty("country_value");

	@FindBy(xpath = "//*[@id='profile_gender_M']")
	WebElement gender;

	@FindBy(xpath = "//*[@id='profile_dob']")
	WebElement dob;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div/select[1]")
	WebElement month;
	String Month = prop.getProperty("month_value");

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div/select[2]")
	WebElement year;
	String Year = prop.getProperty("year_value");

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/table/tbody/tr/td")
	WebElement date;

	@FindBy(xpath = "//*[@id='profile_email']")
	WebElement email;

	@FindBy(xpath = "//*[@id='user_name']")
	WebElement username;

	@FindBy(xpath = "//*[@id='password']")
	WebElement password;

	@FindBy(xpath = "//*[@id='identity[password_confirmation]']")
	WebElement confirm_password;

	@FindBy(xpath = "//*[@id='chk_agree']")
	WebElement agree_tnc;

	@FindBy(xpath = "//*[@id='new_profile']/table/tbody/tr[15]/td[2]/input")
	WebElement create_profile_btn;

	@FindBy(xpath = "//*[@id='new_profile']/div[2]")
	WebElement failed_error;

	@FindBy(xpath = "/html/body/div[1]/div/a[3]")
	WebElement back_home_screen;

	@FindBy(xpath = "//*[@id='div_header']/a")
	WebElement login_page_verification;

	public void formFill(String fname, String lname, String date_value, String email_value, String password_value) throws InterruptedException
	{
		ReuseableComponents.clickElement(click_register_btn, "Click Register button");

		String actualvalue_verify = ReuseableComponents.getTextValue(verify_register_page, "Verify register page");
		String expectedvalue_verify = prop.getProperty("Verify_register_page_value");
		ReuseableComponents.checklogin("contains", expectedvalue_verify, actualvalue_verify, "Verify register page");

		ReuseableComponents.clearElementandEnterText(first_name, fname, "Enter first name");
		ReuseableComponents.clearElementandEnterText(last_name, lname, "Enter last name");
		ReuseableComponents.dropdown(country_select, "value", Country, "Select country");
		ReuseableComponents.clickElement(gender, "Select Gender");
		ReuseableComponents.clickElement(dob, "Select Date of Birth");
		ReuseableComponents.dropdown(month, "value", Month, "Select month of Date of Birth");
		ReuseableComponents.dropdown(year, "value", Year, "Select year of Date of Birth");
		ReuseableComponents.dateSelector(date_value, "Date Select");
		ReuseableComponents.clearElementandEnterText(email, email_value, "Enter Email id");
		ReuseableComponents.clearElementandEnterText(password, password_value, "Enter password");
		ReuseableComponents.clearElementandEnterText(confirm_password, password_value, "Confirm password");
		ReuseableComponents.clickElement(agree_tnc, "Agree terms and condition");
		ReuseableComponents.clickElement(create_profile_btn, "Click create profile button");

		String expectedvalue = prop.getProperty("login_page_verification_value");
		String actualvalue = ReuseableComponents.getAttributeValue(login_page_verification, "href","Get heading value");
		ReuseableComponents.checklogin("contains", expectedvalue, actualvalue, "Verify landing page");
	}
}


