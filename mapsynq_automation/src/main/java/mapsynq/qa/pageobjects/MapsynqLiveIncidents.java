package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqLiveIncidents extends BaseClass {
	
	public  MapsynqLiveIncidents()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='news_menu']/div[1]/label[1]/span/h2")
	WebElement incident_btn;

	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident;

	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident_value;

	@FindBy(xpath="//*[@id='Incidents0']/div/div[2]")
	WebElement incident_value_map;


	public void clickIncident()
	{					
		ReuseableComponents.clickElement(incident_btn, "Click incident button");
		ReuseableComponents.clickElement(incident, "Click incident");
		String expectedvalue = ReuseableComponents.getTextValue(incident_value, "Get incident text value");		
		String actualvalue = ReuseableComponents.getTextValue(incident_value_map, "Get incident text value from map");
		ReuseableComponents.checklogin("equals", expectedvalue, actualvalue, "Verify live incident");
	}

}

