import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPage {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebElement buttonCookieAgree = driver.findElement(By.id("cookie-agree"));
        buttonCookieAgree.click();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blockTitle);

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.className("pay")));
        Assert.assertEquals(blockTitle.getText(), "Онлайн пополнение\n" + "без комиссии");
    }

    @Test
    @Order(2)
    public void testPaymentSystemLogos() {
        WebElement visaIcon = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']"));
        boolean visaIconPresent = visaIcon.isDisplayed();
        Assert.assertTrue(visaIconPresent);

        WebElement visaVerifiedIcon = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']"));
        boolean visaVerifiedIconPresent = visaVerifiedIcon.isDisplayed();
        Assert.assertTrue(visaVerifiedIconPresent);

        WebElement mastercardIcon = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']"));
        boolean mastercardIconPresent = mastercardIcon.isDisplayed();
        Assert.assertTrue(mastercardIconPresent);

        WebElement mastercardSecureIcon = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']"));
        boolean mastercardSecureIconPresent = mastercardSecureIcon.isDisplayed();
        Assert.assertTrue(mastercardSecureIconPresent);

        WebElement belkartIcon = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']"));
        boolean belkartIconPresent = belkartIcon.isDisplayed();
        Assert.assertTrue(belkartIconPresent);
    }

    @Test
    @Order(3)
    public void testMoreAboutServiceLink() {
        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreAboutServiceLink.click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", newUrl);
    }

    @Test
    @Order(4)
    public void testContinueButton() {
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

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("cc-number")));
        WebElement textSum = driver.findElement(By.xpath("//span[contains(text(), '30.00 BYN')]"));

        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.xpath("//span[contains(text(), '30.00 BYN')]"), "30.00 BYN"));
        Assert.assertEquals(textSum.getText(), "30.00 BYN");
    }
}
