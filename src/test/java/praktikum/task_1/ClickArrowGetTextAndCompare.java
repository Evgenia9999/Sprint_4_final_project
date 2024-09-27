package praktikum.task_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class ClickArrowGetTextAndCompare {

    private WebDriver driver;
    private By cookieButton = By.id("rcc-confirm-button");


    public ClickArrowGetTextAndCompare(WebDriver driver) {
        this.driver = driver;
    }


    public void clickArrowAndGetText(String arrow, String textFromArrow, String text) {
        driver.findElement(cookieButton).click();
        driver.findElement(By.xpath(arrow)).click();
        String resultTextAfterClick = driver.findElement(By.id(textFromArrow)).getText();

        assertThat(text, is(resultTextAfterClick));
    }
}

