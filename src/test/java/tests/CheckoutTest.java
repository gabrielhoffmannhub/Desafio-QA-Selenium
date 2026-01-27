package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class CheckoutTest {

    private WebDriver driver;

    @Test
    public void shouldProceedToCheckout() {
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

        cartPage.clickCheckout();

        checkoutPage.fillCheckoutInformation("João", "Silva", "12345");
        checkoutPage.clickContinue();

        By finishButton = By.id("finish");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));

        Assertions.assertTrue(driver.findElement(finishButton).isDisplayed());

    }
        @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
