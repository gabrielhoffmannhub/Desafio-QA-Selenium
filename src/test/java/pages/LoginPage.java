package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        waitForVisibility(username).sendKeys(user);
        waitForVisibility(password).sendKeys(pass);
        waitForClickability(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return waitForVisibility(errorMessage).isDisplayed();
    }
}
