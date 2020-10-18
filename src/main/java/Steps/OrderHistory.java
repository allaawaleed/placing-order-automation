package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class OrderHistory extends BasePage {
	WebDriverWait wait;

	public OrderHistory(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);

	}

	@FindBy(className = "account")
	WebElement accountLink;

	@FindBy(xpath = "//span[contains(text(),'history')]")
	WebElement historyLink;

	public void orderHistory() {

		accountLink.click();
		waitForVisabilty(By.xpath("//h1[contains(text(),'My account')]"), 10);
		Log.info("Web navigates user correctly to "
				+ driver.findElement(By.xpath("//h1[contains(text(),'My account')]")).getText());

		historyLink.click();
		waitForVisabilty(By.xpath("//h1[contains(text(),'Order history')]"), 10);
		Log.info("Web navigates user correctly to "
				+ driver.findElement(By.xpath("//h1[contains(text(),'Order history')]")).getText());

	}

}
