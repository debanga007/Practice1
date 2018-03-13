package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.asserts.SoftAssert;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FirstTest 
{
	
	WebDriver driver;
	SoftAssert sassert=new SoftAssert();
	Scenario scenario;
	

	@Before
	public void setup(Scenario scenario)
	{
		this.scenario=scenario;
		System.out.println("Starting execution.." +scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			//String screenshotName=scenario.getName().replaceAll(" ", "_");
			scenario.embed( ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}

	@Given("^I open Google.com$")
	public void mymethod1()
	{
		//System.setProperty("webdriver.chrome.driver","G://Old Java Projects//LocalGit//PracticeProject//drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=V5x-WrnCO4-GX6bWv6AG");
		driver.manage().window().maximize();
		System.out.println("Initializes browser");
	}
	@Given("^I type name in Search box$")
	public void i_type_name_in_Search_box() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("Debanga");
		System.out.println("indentifies and Types text");
	}

	@When("^I click on search$")
	public void i_click_on_search() throws Throwable {
	  //driver.findElement(By.name("btnK")).click();
	  driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	  System.out.println("clicks on search");
	}

	@Then("^I should see matching search results$")
	public void i_should_see_matching_search_results() throws Throwable {
		String text=driver.findElement(By.xpath("//*[text()[contains(.,'Debanga mean')]]")).getText();
		if(driver.findElement(By.xpath("//*[text()[contains(.,'Debanga mean')]]")).isDisplayed())
		{
		Assert.assertEquals(text, "Debanga - First Name Meaning - What does Debanga mean?","Test Pass !");
		System.out.println("Test Passed");
		}
		else
		{
			Assert.assertEquals(false, "Test Failed !");
			System.out.println("Test Failed");
		}
	  
	}
	
	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	  driver.close();
	  driver.quit();
	  System.out.println("Close browser");
	}
	
	@Given("^I type surname in Search box$")
	public void i_type_surname_in_Search_box() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("Mukherjee");
		System.out.println("indentifies and Types text");
	}

	@Then("^I should see matching image results$")
	public void i_should_see_matching_image_results() throws Throwable {
		String img=driver.findElement(By.xpath(".//div[@role='heading']//span[text()[contains(.,'Mukherjee')]]")).getText();
		if(driver.findElement(By.xpath(".//div[@role='heading']//span[text()[contains(.,'Mukherjee')]]")).isDisplayed())
		{
		//Assert.assertEquals(img, "Debanga Mukherjee","Test Pass !");
		sassert.assertEquals(img, "Debanga Mukherjee","result verficiation");
		System.out.println("Test Passed");
		sassert.assertAll();
		}
		else
		{
			//Assert.assertEquals(false, "Test Failed !");
			sassert.assertEquals(false, "Test Failed !");
			System.out.println("Test Failed");
			sassert.assertAll();
		}
		
	}
}