package Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.UserInfo;
import Utilities.BasePage;
import Utilities.Log;

public class CreateNewUser extends BasePage {
	WebDriverWait wait;

	public CreateNewUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	@FindBy(className = "login")
	WebElement loginButton;

	@FindBy(xpath = "//h1[contains(text(),'Authentication')]")
	WebElement authTitle;

	@FindBy(id = "email_create")
	WebElement createEmailField;

	@FindBy(id = "SubmitCreate")
	WebElement createButton;

	@FindBy(xpath = "//h1[contains(text(),'Create an account')]")
	WebElement infoTitle;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement day;

	@FindBy(id = "months")
	WebElement month;

	@FindBy(id = "years")
	private WebElement year;

	@FindBy(id = "company")
	WebElement company;

	@FindBy(id = "address1")
	WebElement mainAddress;

	@FindBy(id = "address2")
	WebElement secondAddress;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "id_state")
	WebElement stateField;

	@FindBy(id = "postcode")
	WebElement postCode;

	@FindBy(id = "other")
	WebElement other;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "phone_mobile")
	WebElement mobile;

	@FindBy(id = "alias")
	WebElement addressAlias;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	@FindBy(className = "info-account")
	WebElement subTitle;

	@FindBy(className = "logout")
	WebElement logoutButton;

	// UserInfo userInfo = new UserInfo();

	public WebElement getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(WebElement subTitle) {
		this.subTitle = subTitle;
	}

	public void createNewValidAccount() {
		UserInfo userInfo = new UserInfo();
		Log.info("Looking for Sign In button");
		waitForVisabilty(By.className("login"), 5);
		if (loginButton.isDisplayed()) {
			loginButton.click();

		} else {
			Log.info("Failed to locate Sign in button and Login button ->" + loginButton.isDisplayed());
		}

		Log.info("System should navigate user to Authonication screen");
		waitForVisabilty(By.xpath("//h1[contains(text(),'Authentication')]"), 5);
		createEmailField.sendKeys(userInfo.getEmail());

		Log.info("email" + userInfo.getEmail().toString());
		createButton.click();
		Log.info("System should navigate user to information screen");

		waitForVisabilty(By.xpath("//h1[contains(text(),'Create an account')]"), 10);
		Log.info("Verify that Create Account screed is displayed" + infoTitle.isDisplayed());

		// Start fill the mandatory fields with valid data
		firstName.sendKeys(userInfo.getFirstName());
		lastName.sendKeys(userInfo.getLastName());
		password.sendKeys(userInfo.getPassword());
		Log.info("passowrd" + userInfo.getPassword().toString());
		// day.sendKeys(userInfo.getDay());
		day.sendKeys("27");
		Log.info("day" + userInfo.getDay().toString());
		// month.sendKeys(userInfo.getMonth());
		month.sendKeys("November ");
		Log.info("month" + userInfo.getMonth().toString());
		// year.sendKeys(userInfo.getYear());
		year.sendKeys("1990");
		Log.info("year" + userInfo.getYear().toString());
		company.sendKeys(userInfo.getCompany());
		mainAddress.sendKeys(userInfo.getMainAddress());
		secondAddress.sendKeys(userInfo.getSecondAddress());
		cityField.sendKeys(userInfo.getCityField());
		stateField.sendKeys(userInfo.getStateField());
		postCode.sendKeys(userInfo.getPostCode());
		mobile.sendKeys(userInfo.getMobile());
		addressAlias.sendKeys(userInfo.getAddressAlias());
		registerButton.click();

		waitForVisabilty(By.className("logout"), 10);
		Log.info("System created account succesffuly and navigate user "
				+ "to the My Account screen and displayed Logout button" + logoutButton.isDisplayed());

	}

// TODO 
	public void userInfo() {
		// Start fill the mandatory fields with valid data
//		firstName.sendKeys(userInfo.getFirstName());
//		lastName.sendKeys(userInfo.getLastName());
//		password.sendKeys(userInfo.getPassword());
//		Log.info("passowrd" + userInfo.getPassword().toString());
//		day.sendKeys(userInfo.getDay());
//		Log.info("day" + userInfo.getDay().toString());
//		month.sendKeys(userInfo.getMonth());
//		Log.info("month" + userInfo.getMonth().toString());
//		year.sendKeys(userInfo.getYear());
//		Log.info("year" + userInfo.getYear().toString());
//		company.sendKeys(userInfo.getCompany());
//		mainAddress.sendKeys(userInfo.getMainAddress());
//		secondAddress.sendKeys(userInfo.getSecondAddress());
//		cityField.sendKeys(userInfo.getCityField());
//		stateField.sendKeys(userInfo.getStateField());
//		postCode.sendKeys(userInfo.getPostCode());
//		mobile.sendKeys(userInfo.getMobile());
//		addressAlias.sendKeys(userInfo.getAddressAlias());
//		registerButton.click();

	}

}
