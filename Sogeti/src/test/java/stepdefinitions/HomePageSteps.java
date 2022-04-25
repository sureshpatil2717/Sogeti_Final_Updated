package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qa.util.ConfigReader;
import com.qa.util.Util;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

public class HomePageSteps {

	HomePage homePage;
	WebDriver driver;
	String PRODUCT = "apple iphone 13";
	ConfigReader configReader;
	Properties prop;
	String Actual;
	String Expected;
	

	@Given("^I launch Chrome Browser$")
	public void i_launch_chrome_browser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	

	
	@Given("user is on Home page")
	public void user_is_on_home_page() {
		homePage = new HomePage(driver);
		homePage.Accept_cookies();
		
	}

	@When("I Hover over Services Link")
	public void i_hover_over_services_link() {
	    
		homePage.Service_link();
	}

	@Then("I should see Automation Link")
	public void i_should_see_automation_link() 
	{
		homePage.Automationlink_displayed();
	}

	@Then("I click on Automation Link")
	public void i_click_on_automation_link() {
		homePage.Automation_Click();
	}

	@Then("I should see Automation Page")
	public void i_should_see_automation_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("^I verify Automation text is visible in Automation Page$")
    public void i_verify_automation_text_is_visible_in_automation_page() throws Throwable {
        homePage.Automation_text();
    }


	@Then("I Verify that the Services and Automation are selected")
	public void i_verify_that_the_services_and_automation_are_selected() {
		homePage.verifySelectedServicesAndAutomation();
	}
	@When("I Enter all details in the form")
	public void i_enter_all_details_in_the_form() 
	{
		homePage.Enterall_deatails();
		
	}

	@When("I click on I agree checkbox")
	public void i_click_on_i_agree_checkbox() 
	{
		homePage.Agree_button();
	    
	}
	
	@When("I click on dropdown")
	public void i_click_on_dropdown() {
		homePage.Dropdown_button();
	}

	@When("I verfiy dropdown list are working fine")
	public void i_verfiy_dropdown_list_are_working_fine() {
		homePage.verifytest_links();
	}
	
	
}
