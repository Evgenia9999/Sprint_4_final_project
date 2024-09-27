package praktikum.task_2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class FillInRentingDetailsSecondFormLowerButton{
    private WebDriver driver;
    public FillInRentingDetailsSecondFormLowerButton(WebDriver driver) {
        this.driver = driver;}

    private final By rentingTitle = By.className("Order_Header__BZXOb");

    private By timeField = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Когда привезти самокат']");
    private By calenderDate = By.cssSelector(".react-datepicker__day.react-datepicker__day--020");
    private By rentingPeriodField = By.cssSelector(".Dropdown-placeholder");
    private By rentingPeriodChoice = By.xpath(".//div[@class='Dropdown-menu']/div[3]");
    private By collorCheckBox = By.cssSelector(".Checkbox_Input__14A2w");
    private By curierComment = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    public void fillInFields(String comment) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(rentingTitle).getText() != null
                && !driver.findElement(rentingTitle).getText().isEmpty()
        ));
        driver.findElement(timeField).click();
        driver.findElement(calenderDate).click();
        driver.findElement(rentingPeriodField).click();
        driver.findElement(rentingPeriodChoice).click();
        driver.findElement(collorCheckBox).click();
        driver.findElement(curierComment).sendKeys(comment);
    }
    public void orderButtonClick() {
        driver.findElement(orderButton).click();
    }
}
