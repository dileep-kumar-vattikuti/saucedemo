package stepdef;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='user-name']")
	WebElement user_input;
	@FindBy(xpath = "//input[@id='password']")
	WebElement pass_input;
	@FindBy(xpath="//input[@id='login-button']")
	WebElement login_button;
	@FindBy(xpath="//*[@id='header_container']/div[2]/span")
	WebElement product;
	@FindBy(xpath="//*[@id='login_button_container']/div/form/div[3]/h3")
	WebElement error;
	@Before
	public void setUp() {
		driver = WebDriverSingleton.getDriverInstance();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		driver.get("https://www.saucedemo.com/");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String Username, String Password) {
		
		user_input.click();
	    user_input.sendKeys(Username);
	    pass_input.sendKeys(Password);
	   
	}
	@When("Click on Login button")
	public void click_on_login_button() {
		 login_button.click();
	}
	
	@Then("User login sucessfully")
	public Boolean user_login_sucessfully() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(product));
		Boolean status = false;
	    if(product.getText().contains("Products")) {
	    	status = true;
	    }
	    return status;
	}
	
	@When("User enters  {string} and {string}")
	public void user_enters_and1(String string, String string2) {
		user_input.click();
	    user_input.sendKeys(string);
	    pass_input.sendKeys(string2);
	}

	@Then("User should not login successful")
	public Boolean user_should_not_login_successful() {
		Boolean status = false;
	    if(error.getText().contains("Username and password do not match")) {
	    	status = true;
	    }
	    return status;
	}

	
}
