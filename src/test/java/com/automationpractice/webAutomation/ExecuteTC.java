package com.automationpractice.webAutomation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Steps.CategoryPage;
import Steps.CreateNewUser;
import Steps.LoginScreen;
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

	@Test(priority = 1, enabled = false, description = "Verify create new account by valid data")

	public void verifyHomeScreen() throws InterruptedException {
		Log.info("Verify create new account by valid data");
		CreateNewUser createUser = new CreateNewUser(driver);
		// Click on The Sign In Button
		createUser.createNewValidAccount();
		assertThat(createUser.getSubTitle().getText(), containsString("Welcome to your account"));

	}

	@Test(priority = 2, enabled = true, description = "Verify login by the created user")

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
		// Click on The Sign In Button
		subcategory.openSubCategory();
		assertThat(subcategory.getBlousTitle().getText(), containsString("Blouses"));

	}

}
