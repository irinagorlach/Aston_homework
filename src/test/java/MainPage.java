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
    public static void setup() throws InterruptedException {
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
    public void testBlockTitle() throws InterruptedException {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", blockTitle);
        Assert.assertEquals(blockTitle.getText(), "Онлайн пополнение\n" + "без комиссии", "Название блока не соответствует ожидаемому");
    }

    @Test
    @Order(2)
    public void testPaymentSystemLogos() {
        WebElement blockTitle = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение ')]"));
        boolean isLogosPresent = !driver.findElements(By.xpath("//*[@class = 'pay__partners']")).isEmpty();
        Assert.assertEquals(true, isLogosPresent);
    }

    @Test
    @Order(3)
    public void testMoreAboutServiceLink() {
        WebElement moreAboutServiceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreAboutServiceLink.click();
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
        WebElement continueButton = driver.findElement(By.xpath("//*[@class = 'button button__default ']"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'button button__default ']")));
        continueButton.click();
//        WebElement text = driver.findElement(By.xpath("//*[contains(text(), 'Оплата: Услуги связи')]"));
//        Assert.assertEquals(text.getText(), "Оплата: Услуги связи", "Название блока не соответствует ожидаемому");

    }
}
