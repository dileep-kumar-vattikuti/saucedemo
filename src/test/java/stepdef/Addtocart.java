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
import io.cucumber.java.en.Then;



public class Addtocart {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack']")
	WebElement add_to_cart_button;
	@FindBy(xpath="//*[@id='shopping_cart_container']/a")
	WebElement icon;
	@FindBy(xpath="//*[@id='item_4_title_link']/div")
	WebElement product_name;
	
	@Before
	public void setUp() {
		driver = WebDriverSingleton.getDriverInstance();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}

	
	
	@Then("click on any product Addtocart button")
	public void click_on_any_product_addtocart_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(add_to_cart_button));
		Thread.sleep(1000);
	    add_to_cart_button.click();
	}

	@Then("click on addtocart icon and check selected product is displayed")
	public Boolean click_on_addtocart_icon_and_check_selected_product_is_displayed() {
		icon.click();
		Boolean status = false;
		if(product_name.getText().contains("Backpack")) {
			status = true;
		}
		return status;
	}

	

}
