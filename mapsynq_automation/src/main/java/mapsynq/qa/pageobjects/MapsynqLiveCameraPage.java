package mapsynq.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mapsynq.qa.testbase.BaseClass;
import mapsynq.qa.utilities.ReuseableComponents;

public class MapsynqLiveCameraPage extends BaseClass {

	public  MapsynqLiveCameraPage()
	{
		PageFactory.initElements(dr, this);
	}

	@FindBy(xpath="//*[@id='news_menu']/div[1]/label[2]/span/h2")
	WebElement camera_btn;

	@FindBy(xpath="//*[@id='txtSearchCamerasingapore']")
	WebElement camera_search;
	String value = prop.getProperty("camera_value");

	@FindBy(xpath="//*[@id='c1711']/a")
	WebElement camera_click;

	@FindBy(xpath="//*[@id='ifCam']")
	WebElement frame_path;

	@FindBy(xpath="/html/body/div/label/b")
	WebElement get_camera_value_map;

	public void livecam()
	{
		ReuseableComponents.clickElement(camera_btn, "Open camera tab");
		ReuseableComponents.clearElementandEnterText(camera_search, value, "Enter camera name");
		ReuseableComponents.clickElement(camera_click, "Select camera");
		ReuseableComponents.frame(frame_path, get_camera_value_map, value, "Verify camera value");
	}

}
