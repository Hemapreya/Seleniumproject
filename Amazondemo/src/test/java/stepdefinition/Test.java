package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import basedriver.Basetest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test extends Basetest{

	static WebDriver driver;
	@Given("^Enter the text needed to search$")
	public void enter_the_text_needed_to_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=Basetest.driverlaunch("https://www.amazon.in/");
	}

	@When("^user navigates to search page$")
	public void user_navigates_to_search_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement s= driver.findElement(By.id("twotabsearchtextbox"));
        s.sendKeys("redmi 8");
        driver.findElement(By.xpath("//input[@tabindex='10']")).click();
	}
		

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		test=extent.createTest("Test1","Succesfully Executed");
		String exp_message = "redmi 8";	
    	String actual = driver.findElement(By.xpath("//div[@id='search']/span/div/span/h1/div/div/div/div/span[3]")).getText();
    	System.out.println(actual);
    	String actual1=actual.replace('"',' ').trim();
    	System.out.println(actual1);
    	if(exp_message.equalsIgnoreCase(actual1)){
    		System.out.println("Strings are Equal");
    		test.log(Status.PASS,MarkupHelper.createLabel("PASSED",ExtentColor.GREEN));
    	}
    	else {
    		System.out.println("Strings are not equal");
    		test.log(Status.FAIL,MarkupHelper.createLabel("FAIL",ExtentColor.RED));
    	}
	    Basetest.driverquit(driver);
	}
}
