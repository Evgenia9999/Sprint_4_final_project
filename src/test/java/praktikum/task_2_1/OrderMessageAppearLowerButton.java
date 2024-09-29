package praktikum.task_2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class OrderMessageAppearLowerButton {
    private WebDriver driver;

    public OrderMessageAppearLowerButton(WebDriver driver) {
        this.driver = driver;
    }

    private By yesInConfirmationMessage = By.xpath(".//button[text()='Да']");
    private By confirmationMessageTitle = By.cssSelector(".Order_ModalHeader__3FDaJ");
    private By orderConfirmedMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public void waitForConfirmationMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> (driver.findElement(confirmationMessageTitle).getText() != null
                && !driver.findElement(confirmationMessageTitle).getText().isEmpty()
        ));
    }

    public void confirmationButtonYesClick() {
        driver.findElement(yesInConfirmationMessage).click();
    }

    public void orderWasConfirmedMessage() {

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(driver -> (driver.findElement(orderConfirmedMessage).getText() != null
                && !driver.findElement(orderConfirmedMessage).getText().isEmpty()
        ));
    }
}
