package praktikum.task_2_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

class FillInFormPersonalDetailsLowerButton {

    private WebDriver driver;

    private By name = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");
    private By surname = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Фамилия']");
    private By address = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']");
    private By stationField = By.cssSelector(".select-search__input");
    private By station = By.cssSelector(".select-search__row[data-index='3']");
    private By phone = By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']");

    private By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    public FillInFormPersonalDetailsLowerButton(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInFields(String userName, String userSurname, String userAddress, String userPhone) {

        driver.findElement(name).sendKeys(userName);
        driver.findElement(surname).sendKeys(userSurname);
        driver.findElement(address).sendKeys(userAddress);
        driver.findElement(stationField).click();
        driver.findElement(station).click();
        driver.findElement(phone).sendKeys(userPhone);
    }

    public void nextButtonClick() {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(nextButton));
        driver.findElement(nextButton).click();
    }
}
