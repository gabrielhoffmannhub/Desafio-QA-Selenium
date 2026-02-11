package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return waitForVisibility(addBackpack).isDisplayed();
    }

    public void addBackpackToCart() {
        waitForClickability(addBackpack).click();
    }

    public void openCart() {
        waitForClickability(cartIcon).click();
    }
}

