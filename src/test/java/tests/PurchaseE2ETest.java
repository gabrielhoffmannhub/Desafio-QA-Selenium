package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;

public class PurchaseE2ETest {

    private WebDriver driver;

    @Test
    public void shouldCompletePurchaseSuccessfully() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\drivers\\chromedriver.exe"
        );
        driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assertions.assertTrue(cartPage.hasItemsInCart());

        cartPage.clickCheckout();

        checkoutPage.fillCheckoutInformation("João", "Silva", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        By confirmationMessage = By.className("complete-header");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));

        Assertions.assertTrue(driver.findElement(confirmationMessage).isDisplayed());


    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
