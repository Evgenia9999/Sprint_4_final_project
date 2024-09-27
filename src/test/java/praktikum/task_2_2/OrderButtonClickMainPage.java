package praktikum.task_2_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class OrderButtonClickMainPage {

    private WebDriver driver;
    private By buttonForOrder = By.className("Button_Button__ra12g");

    public OrderButtonClickMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonUpper() {
        driver.findElement(buttonForOrder).click();
    }
}




