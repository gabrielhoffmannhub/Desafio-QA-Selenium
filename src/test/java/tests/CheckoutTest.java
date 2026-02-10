package tests;

import base.BaseTest;
import data.CheckoutData;
import data.LoginData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {

    @Test
    void shouldProceedToCheckout() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.fillInformation(CheckoutData.valid());
        checkoutPage.clickContinue();

        Assertions.assertTrue(checkoutPage.isFinishButtonDisplayed());
    }

}
