package pages;

import base.BasePage;
import data.CheckoutData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By confirmationMessage =
            By.cssSelector("[data-test='complete-header']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInformation(CheckoutData data) {
        waitForVisibility(firstName).sendKeys(data.getFirstName());
        waitForVisibility(lastName).sendKeys(data.getLastName());
        waitForVisibility(postalCode).sendKeys(data.getPostalCode());
    }

    public void clickContinue() {
        waitForClickability(continueButton).click();
    }

    public void clickFinish() {
        waitForClickability(finishButton).click();
    }

    public boolean isPurchaseCompleted() {
        return waitForVisibility(confirmationMessage).isDisplayed();
    }

    public boolean isFinishButtonDisplayed() {
        return waitForVisibility(finishButton).isDisplayed();
    }

}
