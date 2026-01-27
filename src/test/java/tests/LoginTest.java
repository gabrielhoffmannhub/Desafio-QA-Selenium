package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest {

    private WebDriver driver;

    @Test
    public void shouldLoginWithValidCredentials() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        Assertions.assertTrue(productsPage.isPageDisplayed());
    }

    @Test
    public void shouldNotLoginWithInvalidPassword() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "wrong_password");

        By errorMessage = By.cssSelector("[data-test='error']");
        Assertions.assertTrue(driver.findElement(errorMessage).isDisplayed());

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
