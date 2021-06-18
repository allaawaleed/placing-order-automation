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


		action.moveToElement(womencategory).pause(5).perform();
		action.moveToElement(blousesSubCategory).pause(5).perform();
		blousesSubCategory.click();


		waitForVisabilty(By.className("cat-name"), 10);
		Log.info("Verify that system navigate user correctly to blocus sub categry and it dispalus -> "
				+ blousTitle.getText());

	}

}
