package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.UserInfo;
import Utilities.BasePage;

public class LoginScreen extends BasePage {
	WebDriverWait wait;

	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(className = "login")
	WebElement loginButton;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	UserInfo userInfo = new UserInfo();

	public void loginByCreatedUser() {
		loginButton.click();
		waitForVisabilty(By.xpath("//h3[contains(text(),'Already registered?')]"), 10);
		// userInfo.getEmail()
		emailField.sendKeys("billie.lockman@hotmail.com");
		// userInfo.getPassword()
		passwordField.sendKeys("27080");
		signInButton.click();
	}

}
