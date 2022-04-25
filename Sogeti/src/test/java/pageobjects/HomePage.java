package pageobjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.qa.util.ConfigReader;
import com.qa.util.Util;

public class HomePage {
	WebDriver driver;
	ConfigReader configReader;
	Properties prop;
	Util util;
	String ServicesClassBefore;
	String AutomationClassBefore;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[contains(@name,'_field')])[1]")
	WebElement Firstname;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[2]")
	WebElement Lastname;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[3]")
	WebElement Email;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[4]")
	WebElement PhoneNumber;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[5]")
	WebElement CompanyName;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[6]")
	WebElement CountryName;
	
	@FindBy(xpath = "(//*[contains(@name,'_field')])[7]")
	WebElement MessageBox;
	
	@FindBy(xpath = "//*[text()='I agree']")
	WebElement Click_on_agree;

	@FindBy(xpath = "//*[@class='acceptCookie']")
	WebElement Accept_cookie;

	// @FindBy(xpath = "(//div[@class='wrapper']//span)[3]")
	@FindBy(xpath = "//li[@data-levelname='level2']")
	WebElement Services_link;

	// @FindBy(xpath = "//*[text()='Automation']")
	@FindBy(xpath = "//*[@data-levelname=\"level2\"]/div[2]/ul/li[4]")
	WebElement Automation_link;
	
	
	@FindBy(xpath = "//div[@class='page-heading']")
	WebElement Automation_text;
	

	@FindBy(xpath = "//*[text()='Worldwide']")
	WebElement dropdown_worlwide;

	public void Accept_cookies() {
		Accept_cookie.click();
	}

	public void Service_link() {
		ServicesClassBefore = Services_link.getAttribute("class");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		util = new Util();
		util.Mouse_Actions(driver, Services_link);
	}

	public void Automationlink_displayed() {
		AutomationClassBefore = Automation_link.getAttribute("class");
		Automation_link.isDisplayed();
	}

	public void Agree_button() {
		Click_on_agree.click();
	}
	
	public void Enterall_deatails()
	{
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		Firstname.sendKeys(prop.getProperty("Name"));
		Lastname.sendKeys(prop.getProperty("LastName"));
		Email.sendKeys(prop.getProperty("CompanyName"));
		PhoneNumber.sendKeys(prop.getProperty("MobileNumber"));
		CompanyName.sendKeys(prop.getProperty("CompanyName"));
		CountryName.sendKeys(prop.getProperty("CountryName"));
		MessageBox.sendKeys(prop.getProperty("Message"));
	}
	
	public void Automation_Click() {
		Automation_link.click();
	}
	
	public void Dropdown_button() {
		dropdown_worlwide.click();
	}
	
	public void verifytest_links() {
		

		List<WebElement> images = driver.findElements(By.xpath("//*[@id='country-list-id']/ul/li/a"));
		System.out.println(images.size());

		for (int index = 0; index < images.size(); index++) {
			WebElement image = images.get(index);
			String imageURL = image.getAttribute("href");
			// String imageURL = image.getText();
			System.out.println("URL of Image " + (index + 1) + " is: " + imageURL);

			verifyLinkActive(imageURL);

		}

	}

	public static void verifyLinkActive(String linkUrl) {
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}

	
	public void verifySelectedServicesAndAutomation() {
		String ServicesClassAfter = Services_link.getAttribute("class");
		String AutomationClassAfter = Automation_link.getAttribute("class");
		Assert.assertNotEquals(ServicesClassBefore, ServicesClassAfter);
		Assert.assertNotEquals(AutomationClassBefore, AutomationClassAfter);
	}
	
	public void Automation_text()
	{
		Automation_text.isDisplayed();
		
	}

}
