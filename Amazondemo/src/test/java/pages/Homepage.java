package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {
	@FindBy(id="twotabsearchtextbox") WebElement hp;
	WebDriver driver;
	Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
