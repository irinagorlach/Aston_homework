import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Tests {
    public WebDriver driver;
    @FindBy(className = "select__wrapper")
    private WebElement inscriptionsField;

    @FindBy(id = "connection-phone")
    private WebElement phoneInputField;

    @FindBy(id = "connection-sum")
    private WebElement sumInputField;

    @FindBy(id = "connection-email")
    private WebElement emailInputField;

    @FindBy(css = "#pay-connection .button")
    private WebElement continueButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickInscriptionsField() {
        inscriptionsField.click();
    }

    public void clickPhoneInputField() {
        phoneInputField.click();
    }

    public void inputPhone() {
        phoneInputField.sendKeys("297777777");
    }

    public void clickSumInputField() {
        sumInputField.click();
    }

    public void inputSum() {
        sumInputField.sendKeys("30");
    }

    public void clickEmailField() {
        emailInputField.click();
    }

    public void inputEmail() {
        emailInputField.sendKeys("345nameName@gmail.com");
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
