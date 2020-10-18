package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class ConfirmOrder extends BasePage {
	WebDriverWait wait;

	public ConfirmOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);

	}

	@FindBy(className = "bankwire")
	WebElement bankwirButton;

	@FindBy(xpath = "//*[contains(text(),'confirm')]")
	WebElement confirmButton;

	public void selectPaymentAndConfrim() {
		waitForVisabilty(By.xpath("//h1[contains(text(),' payment method')]"), 10);
		Log.info("Web navigates user correclty to  "
				+ driver.findElement(By.xpath("//h1[contains(text(),' payment method')]")).getText());
		bankwirButton.click();

		waitForVisabilty(By.xpath("//h1[contains(text(),'Order summary')]"), 10);
		Log.info("Web navigates user correclty to  "
				+ driver.findElement(By.xpath("//h1[contains(text(),'Order summary')]")).getText());

		Log.info("Web displays all details for:  " + driver.findElement(By.className("page-subheading")).getText());
		confirmButton.click();
	}

	public void orderConfirmation() {
		waitForVisabilty(By.xpath("//h1[contains(text(),'Order confirmation')]"), 10);
		Log.info("Web navigates user correclty to  "
				+ driver.findElement(By.xpath("//h1[contains(text(),'Order confirmation')]")).getText());

	}

}
