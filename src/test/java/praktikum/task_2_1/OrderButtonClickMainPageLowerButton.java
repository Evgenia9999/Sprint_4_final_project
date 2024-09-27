package praktikum.task_2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


class OrderButtonClickMainPageLowerButton {

    private WebDriver driver;
    private By buttonLowerForOrder = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private By ImportantQuestions = By.xpath(".//div[text()='Вопросы о важном']");
    private By cookieButton = By.id("rcc-confirm-button");

    public OrderButtonClickMainPageLowerButton(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonLower() {
        driver.findElement(cookieButton).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(ImportantQuestions));

        driver.findElement(buttonLowerForOrder).click();

    }
}




