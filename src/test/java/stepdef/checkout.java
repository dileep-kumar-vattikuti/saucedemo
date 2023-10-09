package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checkout {
	WebDriver driver;
	@FindBy(xpath="//*[@id='checkout']")
	WebElement checkout_button;	
	@FindBy(xpath="//*[@id='first-name']")
	WebElement firstname;
	@FindBy(xpath="//*[@id='last-name']")
	WebElement lastname;
	@FindBy(xpath="//*[@id='postal-code']")
	WebElement zip_code;
	@FindBy(xpath="//*[@id='continue']")
	WebElement continue_button;
	@FindBy(xpath="//*[@id='finish']")
	WebElement finish_button;
	@FindBy(xpath="//*[@id='checkout_complete_container']/h2")
	WebElement Thank;
	@FindBy(xpath="//*[@id='shopping_cart_container']/a")
	WebElement icon;
	@FindBy(xpath="//h3[contains(text(),'Error: Last Name is required')]")
	WebElement lastname_error;
	
	@Before
	public void setUp() {
		driver = WebDriverSingleton.getDriverInstance();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	
	@When("click on addtocart icon")
	public void click_on_addtocart_icon() {
	   icon.click();
	}

	@When("click on checkout button")
	public void click_on_checkout_button() {
	    checkout_button.click();
	}

	@Then("Enter firstname and lastname and zipcode details")
	public void enter_firstname_and_lastname_and_zipcode_details() {
	   firstname.sendKeys("dileep");
	   lastname.sendKeys("kumar");
	   zip_code.sendKeys("518502");
	}

	@Then("click on continue button and click on finish button")
	public void click_on_continue_button_and_click_on_finish_button() {
	   continue_button.click();
	   finish_button.click();
	}

	@Then("Validate order is sucessful")
	public Boolean validate_order_is_sucessful() {
		Boolean status = false;
		if(Thank.getText().contains("Thank")) {
			status = true;
		}
		return status;
	}
	@When("click on continue button")
	public void click_on_continue_button() {
		continue_button.click();
	}

	@Then("Validate checkout is not sucessful")
	public Boolean validate_checkout_is_not_sucessful() {
		Boolean status = false;
		if(lastname_error.getText().contains("Error: Last Name is required")) {
			status = true;
		}
		return status;
	}

}
