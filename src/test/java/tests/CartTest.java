package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest {

    private WebDriver driver;

    @Test
    public void shouldAddProductToCart() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"
        );

        driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assertions.assertTrue(cartPage.hasItemsInCart());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
