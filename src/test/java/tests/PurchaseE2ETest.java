package tests;

import base.BaseTest;
import data.CheckoutData;
import data.LoginData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PurchaseE2ETest extends BaseTest {

    @Test
    void shouldCompletePurchaseSuccessfully() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assertions.assertTrue(cartPage.hasItems());

        cartPage.clickCheckout();

        checkoutPage.fillInformation(CheckoutData.valid());
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        Assertions.assertTrue(checkoutPage.isPurchaseCompleted());
    }
}
