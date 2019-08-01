package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqLiveTollsPage extends BaseClass {

	public  MapsynqLiveTollsPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='news_menu']/div[1]/label[3]/span/h2")
	WebElement toll_btn;

	@FindBy(xpath="//*[@id='txtSearchERPsingapore']")
	WebElement toll_search;
	String value = prop.getProperty("toll_value");

	@FindBy(xpath="//*[@id='e66']/a")
	WebElement toll_click;

	@FindBy(xpath="//*[@id='myDropdownList']")
	WebElement frame_path;

	@FindBy(xpath="/html/body/label/b")
	WebElement get_toll_value_map;

	public void livetoll()
	{
		ReuseableComponents.clickElement(toll_btn, "Open tolls tab");
		ReuseableComponents.clearElementandEnterText(toll_search, value, "Enter tolls name");
		ReuseableComponents.clickElement(toll_click, "Select toll");
		ReuseableComponents.frame(frame_path, get_toll_value_map, value, "Verify tolls value");
	}
}
