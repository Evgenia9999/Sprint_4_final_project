package praktikum;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
class OrderMessageAppearLowerButton {
    private WebDriver driver;

    public OrderMessageAppearLowerButton(WebDriver driver) {
        this.driver = driver;
    }

    private By yesInConfirmationMessage = By.xpath(".//button[text()='Да']");
    private By confirmationMessageTitle = By.cssSelector(".Order_ModalHeader__3FDaJ");
    private By orderConfirmedMessage = By.cssSelector(".Order_ModalHeader__3FDaJ");

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

        @RunWith(Parameterized.class)
        public class testSamokatOrderLowerButton {

            private WebDriver driver;

            private final String userName;
            private final String userSurname;
            private final String userAddress;
            private final String userPhone;



            public testSamokatOrderLowerButton(String userName, String userSurname, String userAddress, String userPhone) {

                this.userName = userName;
                this.userSurname = userSurname;
                this.userAddress = userAddress;
                this.userPhone = userPhone;
            }

            @Parameterized.Parameters
            public static Object[][] fillTheFields() {

                return new Object[][] {
                        {"Евгения", "Бродская", "Москва",  "91100000000"},
                        //{"Маша", "Иванова", "Тюмень", "99999999999"},
                };
            }

            @Before
            public void startUp() {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            @Test
            public void checkActivity() {

                driver.get("https://qa-scooter.praktikum-services.ru/");

                OrderButtonClickMainPageLowerButton objOrderButton = new OrderButtonClickMainPageLowerButton(driver);
                objOrderButton.clickOrderButtonLower();

                FillInFormPersonalDetailsLowerButton objFillIn = new FillInFormPersonalDetailsLowerButton(driver);
                objFillIn.fillInFields(userName, userSurname, userAddress, userPhone);
                objFillIn.nextButtonClick();

                FillInRentingDetailsSecondFormLowerButton objFillInRentingDetails = new FillInRentingDetailsSecondFormLowerButton(driver);
                objFillInRentingDetails.fillInFields("comment");
                objFillInRentingDetails.orderButtonClick();

                OrderMessageAppearLowerButton objOrderMessageAppear = new OrderMessageAppearLowerButton(driver);
                objOrderMessageAppear.waitForConfirmationMessage();
                objOrderMessageAppear.confirmationButtonYesClick();
                objOrderMessageAppear.orderWasConfirmedMessage();
            }


            @After
            public void teardown() {
                driver.quit();
            }
    }


