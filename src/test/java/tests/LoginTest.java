package tests;

import base.BaseTest;
import data.LoginData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.VALID_PASSWORD);

        Assertions.assertTrue(productsPage.isDisplayed());
    }

    @Test
    void shouldNotLoginWithInvalidPassword() {
        loginPage.open();
        loginPage.login(LoginData.VALID_USERNAME, LoginData.INVALID_PASSWORD);

        Assertions.assertTrue(loginPage.isErrorDisplayed());
    }
}
