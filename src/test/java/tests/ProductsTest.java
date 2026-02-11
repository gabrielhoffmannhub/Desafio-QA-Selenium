package tests;

import base.BaseTest;
import data.LoginData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsTest extends BaseTest {

    @Test
    void shouldDisplayProductsPageAfterLogin() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);

        Assertions.assertTrue(productsPage.isDisplayed());
    }
}
