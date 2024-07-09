import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCreate extends Tests {
    public WebDriver driver;
    public WebDriverWait wait;

    public WaitCreate(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresenceOfElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitForTextToBe(By locator, String text) {
        return wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public WebElement waitForVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
