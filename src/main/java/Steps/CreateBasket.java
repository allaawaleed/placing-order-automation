package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class CreateBasket extends BasePage {
	WebDriverWait wait;
	Actions action;

	public CreateBasket(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);

	}

	@FindBy(className = "product_img_link")
	WebElement blouseImag;

	@FindBy(className = "ajax_add_to_cart_button")
	WebElement addToCart;

	@FindBy(className = "icon-ok")
	WebElement okButton;

	@FindBy(linkText = "Proceed to checkout")
	WebElement proceedToCheckoutButton;

	public void createBasket() {
		action.moveToElement(blouseImag).perform();
		waitForVisabilty(By.className("ajax_add_to_cart_button"), 10);
		addToCart.click();
		if (proceedToCheckoutButton.isDisplayed()) {
			Log.info("Popup opeened and text is:  " + okButton.getText());
			proceedToCheckoutButton.click();
		}
	}

}
