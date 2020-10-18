package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BasePage;
import Utilities.Log;

public class CategoryPage extends BasePage {
	WebDriverWait wait;
	Actions action;

	public CategoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
		action = new Actions(driver);
	}

	@FindBy(linkText = "Women")
	WebElement womencategory;

	@FindBy(linkText = "Blouses")
	WebElement blousesSubCategory;

	@FindBy(className = "cat-name")
	WebElement subCategoryTitle;

	@FindBy(xpath = "//*[contains(text(),'Blouses')]")
	WebElement blousTitle;

	public WebElement getBlousTitle() {
		return blousTitle;
	}

	public void setBlousTitle(WebElement blousTitle) {
		this.blousTitle = blousTitle;
	}

	public void openSubCategory() {
		// Using Action to hover on menu and select subcategory

//		action.moveToElement(womencategory).build().perform();
//		blousesSubCategory.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,250)", "");

		action.moveToElement(womencategory).pause(5).perform();
		action.moveToElement(blousesSubCategory).pause(5).perform();
		blousesSubCategory.click();

		// action.moveToElement(blousesSubCategory).click().perform();

		waitForVisabilty(By.className("cat-name"), 10);
		Log.info("Verify that system navigate user correctly to blocus sub categry and it dispalus -> "
				+ blousTitle.getText());

	}

}
