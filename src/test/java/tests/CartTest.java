package tests;

import base.BaseTest;
import data.LoginData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    void shouldAddProductToCart() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);

        productsPage.addBackpackToCart();
        productsPage.openCart();

        Assertions.assertTrue(cartPage.hasItems());
    }
}
