package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class remove {
	WebDriver driver;
	@FindBy(xpath="//*[@id='remove-sauce-labs-backpack']")
	WebElement remove_button;
	@FindBy(xpath="//*[@id='continue-shopping']")
	WebElement continue_shopping;
	@FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack']")
	WebElement add_to_cart_button;
	
	@Before
	public void setUp() {
		driver = WebDriverSingleton.getDriverInstance();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	@Then("click on remove button and empty in your cart list")
	public Boolean click_on_remove_button_and_empty_in_your_cart_list() {
		remove_button.click();
		continue_shopping.click();
		Boolean status = false;
		if(add_to_cart_button.getText().contains("Add to cart")) {
			status = true;
		}
		return status;
	}
}
