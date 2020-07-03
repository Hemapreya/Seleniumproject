package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeTest {
	
	public static WebDriver driver;

	@Given("^click the sign in button$")
	public void click_the_sign_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","E:\\selenium driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
	}

	@When("^user navigates to sign in page$")
	public void user_navigates_to_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//span[@class='nav-line-2 '][1]")).click();
	   // driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']/a/span")).click();   
	}

	@When("^user needs to enter the details$")
	public void user_needs_to_enter_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebElement u= driver.findElement(By.xpath("//input[@id='ap_email']"));
		u.sendKeys("skhemapreya@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		WebElement p= driver.findElement(By.xpath("//input[@id='ap_password']"));
		p.sendKeys("ready@1go");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
	}

	@Then("^Account successfully created message should be displayed$")
	public void account_successfully_created_message_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String exp_message = "Hello, Hema";	
    	String actual = driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]/span")).getText(); // another simple xpath(By.xpath("//a[@id='nav-link-accountList']/span"))
    	System.out.println(actual);
    	if(exp_message.equalsIgnoreCase(actual)){
    		System.out.println("Strings are Equal");
    	}
    	else {
    		System.out.println("Strings are not equal");
    	}
    	Thread.sleep(60000);
    	driver.quit();
	}


}
