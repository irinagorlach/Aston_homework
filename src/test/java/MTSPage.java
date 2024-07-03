import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MTSPage {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        WebElement buttonCookieAgree = driver.findElement(By.id("cookie-agree"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
        buttonCookieAgree.click();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testCheckInscriptionsInTheBlock() {
        WebElement inscriptions = driver.findElement(By.className("select__wrapper"));
        inscriptions.click();

        WebElement selectList = driver.findElement(By.className("select__list"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("select__list")));
        Assert.assertEquals(selectList.getText(), "Услуги связи\n" + "Домашний интернет\n" + "Рассрочка\n" + "Задолженность");
    }

    @Test
    @Order(2)
    public void testCheckDisplayPrice() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textPrice = driver.findElement(By.xpath("//span[contains(text(), '30.00 BYN')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        Assert.assertEquals(textPrice.getText(), "30.00 BYN");
    }

    @Test
    @Order(3)
    public void testCheckDisplayPriceOnButton() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//button[@type='submit']"), "Оплатить 30.00 BYN"));
        WebElement textPriceButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertEquals(textPriceButton.getText(), "Оплатить 30.00 BYN");
    }

    @Test
    @Order(4)
    public void testCheckDisplayPhone() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textPhoneNumber = driver.findElement(By.className("pay-description__text"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), 'Номер:375297777777')]"), "Оплата: Услуги связи Номер:375297777777"));
        Assert.assertEquals(textPhoneNumber.getText(), "Оплата: Услуги связи Номер:375297777777");
    }

    @Test
    @Order(5)
    public void testCheckСardNumber() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textCardNumber = driver.findElement(By.xpath("//*[contains(text(), 'Номер карты')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(), 'Номер карты')]"), "Номер карты"));
        Assert.assertEquals(textCardNumber.getText(), "Номер карты");
    }

    @Test
    @Order(6)
    public void testCheckСardValidity() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textCardNumber = driver.findElement(By.xpath("//*[contains(text(), 'Срок действия')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(), 'Срок действия')]"), "Срок действия"));
        Assert.assertEquals(textCardNumber.getText(), "Срок действия");
    }

    @Test
    @Order(7)
    public void testCheckСardCVC() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textCardNumber = driver.findElement(By.xpath("//*[contains(text(), 'CVC')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(), 'CVC')]"), "CVC"));
        Assert.assertEquals(textCardNumber.getText(), "CVC");
    }

    @Test
    @Order(8)
    public void testCheckСardNameHolder() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        WebElement textCardNumber = driver.findElement(By.xpath("//*[contains(text(), 'Имя держателя (как на карте)')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(), 'Имя держателя (как на карте)')]"), "Имя держателя (как на карте)"));
        Assert.assertEquals(textCardNumber.getText(), "Имя держателя (как на карте)");
    }

    @Test
    @Order(9)
    public void testPaymentSystemLogos() {
        driver.get("https://www.mts.by/");
        WebElement phoneInputField = driver.findElement(By.id("connection-phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.id("connection-sum"));
        sumInputField.click();
        sumInputField.sendKeys("30");

        WebElement emailField = driver.findElement(By.id("connection-email"));
        emailField.click();
        emailField.sendKeys("345nameName@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector("#pay-connection .button"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection .button")));
        continueButton.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));

        WebElement mastercardIcon = driver.findElement(By.xpath("//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        boolean mastercardIconPresent = mastercardIcon.isDisplayed();
        Assert.assertTrue(mastercardIconPresent);

        WebElement visaIcon = driver.findElement(By.xpath("//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        boolean visaIconPresent = visaIcon.isDisplayed();
        Assert.assertTrue(visaIconPresent);

        WebElement belkartIcon = driver.findElement(By.xpath("//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        boolean belkartIconPresent = belkartIcon.isDisplayed();
        Assert.assertTrue(belkartIconPresent);

        WebElement mirIcon = driver.findElement(By.xpath("//div[contains(@class, 'cards-brands__container')]/img[@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        boolean mirIconPresent = mirIcon.isDisplayed();
        Assert.assertTrue(mirIconPresent);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'cards-brands_random')]/img[@src='assets/images/payment-icons/card-types/maestro-system.svg']")));
        WebElement maestroIcon = driver.findElement(By.xpath("//div[contains(@class, 'cards-brands_random')]/img[@src='assets/images/payment-icons/card-types/maestro-system.svg']"));
        boolean maestroIconPresent = maestroIcon.isDisplayed();
        Assert.assertTrue(maestroIconPresent);
    }
}


