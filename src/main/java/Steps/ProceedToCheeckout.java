package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class ProceedToCheeckout extends BasePage {
	WebDriverWait wait;

	public ProceedToCheeckout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);

	}

	@FindBy(className = "page-heading")
	WebElement cartSummry;

	@FindBy(linkText = "Proceed to checkout")
	WebElement proceedButton;

	@FindBy(name = "processAddress")
	WebElement processAddressButton;

	@FindBy(name = "processCarrier")
	WebElement processCarrier;

	@FindBy(xpath = "//input[@id='cgv']")
	WebElement acceptTerms;

	public void cart() {
		waitForVisabilty(By.className("page-heading"), 10);

		if (cartSummry.isDisplayed()) {
			Log.info("Web displays " + cartSummry.getText());

			proceedButton.click();

			waitForVisabilty(By.xpath("//h1[contains(text(),'Addresses')]"), 10);
			Log.info("Web navigates user correclty to  "
					+ driver.findElement(By.xpath("//h1[contains(text(),'Addresses')]")).getText());
			processAddressButton.click();

			waitForVisabilty(By.xpath("//h1[contains(text(),'Shipping')]"), 10);
			Log.info("Web navigates user correclty to  "
					+ driver.findElement(By.xpath("//h1[contains(text(),'Shipping')]")).getText());

			acceptTerms.click();
			if (acceptTerms.isSelected()) {
				processCarrier.click();
			} else {
				Log.info("You need to accept terms and condition");
				// TODO to handle this scenario
			}

		}

		else {
			Log.info(">>> System failed to open summary screen");
		}
	}

}
