package praktikum.task_2_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
                {"Маша", "Иванова", "Тюмень", "99999999999"},
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
