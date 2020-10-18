package com.automationpractice.webAutomation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Steps.CategoryPage;
import Steps.ConfirmOrder;
import Steps.CreateBasket;
import Steps.CreateNewUser;
import Steps.LoginScreen;
import Steps.OrderHistory;
import Steps.ProceedToCheeckout;
import Utilities.Log;

public class ExecuteTC {
	WebDriver driver;
	CreateNewUser cr;

	@BeforeSuite
	public void setup() throws InterruptedException {
		Log.info("------ Launch browser ------");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
// I didn't run it because all Selenium tests on desktop run on a screen resolution of 1024x768 by default
		// driver.manage().window().setSize(new Dimension(1024, 768));
	}

	@BeforeMethod
	public void startNewTestCase() {
		Log.info("--------------------------New Test Case-------------------------------");
	}

	@AfterMethod
	public void endTestCase() {
		Log.info("------------------Test Case Execution DONE-----------------------");
	}

	@Test(priority = 1, enabled = true, description = "Verify create new account by valid data")

	public void verifyHomeScreen() throws InterruptedException {
		Log.info("Verify create new account by valid data");
		CreateNewUser createUser = new CreateNewUser(driver);
		// Click on The Sign In Button
		createUser.createNewValidAccount();
		assertThat(createUser.getSubTitle().getText(), containsString("Welcome to your account"));

	}

	@Test(priority = 2, enabled = false, description = "Verify login by the created user")

	public void loginScenario() throws InterruptedException {
		Log.info("Verify login by the created user");
		LoginScreen lgoin = new LoginScreen(driver);
		// Click on The Sign In Button
		lgoin.loginByCreatedUser();
		// assertThat(lgoin.getSubTitle().getText(), containsString("Welcome to your
		// account"));

	}

	@Test(priority = 3, enabled = true, description = "Verify open sub-category")

	public void openSubcategory() throws InterruptedException {
		Log.info("Verify open sub-category");
		CategoryPage subcategory = new CategoryPage(driver);
		subcategory.openSubCategory();
		assertThat(driver.getCurrentUrl(), containsString("id_category=7"));

	}

	@Test(priority = 4, enabled = true, description = "Verify add item to the basket and check basket")

	public void creatBasket() throws InterruptedException {
		Log.info("Verify add item to the basket and check basket");
		CreateBasket basket = new CreateBasket(driver);
		basket.createBasket();
		assertThat(driver.getCurrentUrl(), containsString("order"));

	}

	@Test(priority = 5, enabled = true, description = "Verify proceed in the checkout and accept Terms & confidtions")

	public void proceedCheckout() throws InterruptedException {
		Log.info("Verify proceed in the checkout and accept Terms & confidtions");
		ProceedToCheeckout proceedCheckout = new ProceedToCheeckout(driver);
		proceedCheckout.cart();

		assertThat(driver.findElement(By.xpath("//h1[contains(text(),' payment method')]")).getText(),
				containsString("PAYMENT"));
	}

	@Test(priority = 6, enabled = true, description = "Verify check payment and confirm order")

	public void confrimOrder() throws InterruptedException {
		Log.info("Verify check payment and confirm order");
		ConfirmOrder confirm = new ConfirmOrder(driver);
		// Select payment
		confirm.selectPaymentAndConfrim();
		// Check order confrimation
		confirm.orderConfirmation();
		assertThat(driver.findElement(By.className("cheque-indent")).getText(), containsString("complete"));

	}

	@Test(priority = 7, enabled = true, description = "Validate that order placed")

	public void orderHistory() throws InterruptedException {
		Log.info("Validate that order placed");
		OrderHistory orderH = new OrderHistory(driver);
		orderH.orderHistory();

		assertThat(driver.findElement(By.className("history_method")).getText(), containsString("Bank"));

	}

	@AfterClass
	public void CloseBrowser() {

		driver.quit();
	}

}
