import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Tests {
    private static MainPage mainPage;
    private static WaitCreate waitCreate;
    private static WebDriver driver;

    private static String[][] iconsLocator = {
            {"//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']", "Mastercard"},
            {"//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/visa-system.svg']", "Visa"},
            {"//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/belkart-system.svg']", "Belkart"},
            {"//div[contains(@class, 'cards-brands_random')]/img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']", "Mir"},
            {"//div[contains(@class, 'cards-brands_random')]/img[@src='assets/images/payment-icons/card-types/maestro-system.svg']", "Maestro"}
    };

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        mainPage = new MainPage(driver);
        waitCreate = new WaitCreate(driver, 5);

        WebElement buttonCookieAgree = driver.findElement(By.id("cookie-agree"));
        waitCreate.waitForElementToBeClickable(By.id("cookie-agree"));
        buttonCookieAgree.click();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи, домашний интернет, рассрочка, задолженность")
    @Description("Открыть сайт mts.by. Проскроллить страницу до блока 'Онлайн пополнение без комиссии' и проверить все варианты оплаты услуг в выпадающем списке: услуги связи, домашний интернет, рассрочка, задолженность")
    @Owner("Ирина Горлач")
    @Issue("IOP-123")
    public void testCheckInscriptionsInTheBlock() {
        mainPage.clickInscriptionsField();

        WebElement selectList = driver.findElement(By.className("select__list"));
        waitCreate.waitForPresenceOfElement(By.className("select__list"));
        Assert.assertEquals(selectList.getText(), "Услуги связи\n" + "Домашний интернет\n" + "Рассрочка\n" + "Задолженность");
    }

    @Test
    public void testCheckDisplayPrice() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textPrice = driver.findElement(By.xpath("//span[contains(text(), '30.00 BYN')]"));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        Assert.assertEquals(textPrice.getText(), "30.00 BYN");
    }

    @Test
    public void testCheckDisplayPriceOnButton() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//button[@type='submit']"), "Оплатить 30.00 BYN");
        WebElement textPriceButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertEquals(textPriceButton.getText(), "Оплатить 30.00 BYN");
    }

    @Test
    public void testCheckDisplayPhone() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textPhoneNumber = driver.findElement(By.className("pay-description__text"));
        Assert.assertEquals(textPhoneNumber.getText(), "Оплата: Услуги связи Номер:375297777777");
    }

    @Test
    public void testCheckСardNumber() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textCardNumber = driver.findElement(By.xpath("//*[contains(text(), 'Номер карты')]"));
        Assert.assertEquals(textCardNumber.getText(), "Номер карты");
    }

    @Test
    public void testCheckСardValidity() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textСardValidity = driver.findElement(By.xpath("//*[contains(text(), 'Срок действия')]"));
        Assert.assertEquals(textСardValidity.getText(), "Срок действия");
    }

    @Test
    public void testCheckСardCVC() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textСardCVC = driver.findElement(By.xpath("//*[contains(text(), 'CVC')]"));
        Assert.assertEquals(textСardCVC.getText(), "CVC");
    }

    @Test
    public void testCheckСardNameHolder() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");
        WebElement textСardNameHolder = driver.findElement(By.xpath("//*[contains(text(), 'Имя держателя (как на карте)')]"));
        Assert.assertEquals(textСardNameHolder.getText(), "Имя держателя (как на карте)");
    }

    @Test
    public void testPaymentSystemLogos() {
        mainPage.clickPhoneInputField();
        mainPage.inputPhone();

        mainPage.clickSumInputField();
        mainPage.inputSum();

        mainPage.clickEmailField();
        mainPage.inputEmail();

        mainPage.clickContinueButton();

        waitCreate.waitForPresenceOfElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        waitCreate.waitForTextToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN");

        for (String[] icon : iconsLocator) {
            waitCreate.waitForVisibilityOfElementLocated(By.xpath(icon[0]));
            WebElement iconElement = driver.findElement(By.xpath(icon[0]));
            boolean iconPresent = iconElement.isDisplayed();
            Assert.assertTrue(iconPresent);
        }
    }
}
