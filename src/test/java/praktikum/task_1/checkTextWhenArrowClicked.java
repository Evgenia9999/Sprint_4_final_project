package praktikum.task_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Parameterized.class)
public class checkTextWhenArrowClicked {


    private static WebDriver driver;
    private String arrow;
    private String textFromArrow;
    private String text;

    public checkTextWhenArrowClicked(String arrow, String textFromArrow, String text) {

        this.arrow = arrow;
        this.textFromArrow = textFromArrow;
        this.text = text;
    }

    @Parameterized.Parameters
    public static Object[][] checkTextFromArrow() {

        String[] arrowsXPath = {".//div[@id='accordion__heading-0']", ".//div[@id='accordion__heading-1']", ".//div[@id='accordion__heading-2']", ".//div[@id='accordion__heading-3']", ".//div[@id='accordion__heading-4']", ".//div[@id='accordion__heading-5']", ".//div[@id='accordion__heading-6']", ".//div[@id='accordion__heading-7']"};
        String[] arrowsTextAfterClickId = {"accordion__panel-0","accordion__panel-1", "accordion__panel-2", "accordion__panel-3", "accordion__panel-4","accordion__panel-5", "accordion__panel-6", "accordion__panel-7"};

        return new Object[][] {
                {arrowsXPath[0], arrowsTextAfterClickId[0], "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {arrowsXPath[1], arrowsTextAfterClickId[1], "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {arrowsXPath[2], arrowsTextAfterClickId[2], "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {arrowsXPath[3], arrowsTextAfterClickId[3], "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {arrowsXPath[4], arrowsTextAfterClickId[4], "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {arrowsXPath[5], arrowsTextAfterClickId[5], "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {arrowsXPath[6], arrowsTextAfterClickId[6], "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {arrowsXPath[7], arrowsTextAfterClickId[7], "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        ClickArrowGetTextAndCompare objArrowClicked = new ClickArrowGetTextAndCompare(driver);
        objArrowClicked.clickArrowAndGetText(arrow, textFromArrow, text);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

