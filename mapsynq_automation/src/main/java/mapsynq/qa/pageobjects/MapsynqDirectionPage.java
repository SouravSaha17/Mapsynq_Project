package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqDirectionPage extends BaseClass {

	public MapsynqDirectionPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='info_panel']/div[1]/div/a[1]")
	WebElement direction_btn;

	@FindBy(xpath="//*[@id='poi_from']")
	WebElement direction_from;

	@FindBy(xpath="//*[@id='poi_to']")
	WebElement direction_to;

	@FindBy(xpath="//*[@id='btnClear']")
	WebElement clear_route_btn;

	@FindBy(xpath="//*[@id='get_direction']")
	WebElement get_direction_btn;

	public void getdirection(String from_value, String to_value)
	{
		ReuseableComponents.clickElement(direction_btn, "Open direction tab");
		ReuseableComponents.clearElementandEnterText(direction_from, from_value, "Enter start destination");
		ReuseableComponents.clearElementandEnterText(direction_to, to_value, "Enter end destination");
		ReuseableComponents.clickElement(clear_route_btn, "Clear route");
	}

}
