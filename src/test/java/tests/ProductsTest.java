package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest {

    private WebDriver driver;

    @Test
    public void shouldDisplayProductsPage() {
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
