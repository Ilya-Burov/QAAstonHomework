import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cookieAcceptButton = By.id("cookie-agree");
    private By dropdownButton = By.cssSelector(".select__header");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void сookie() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Окно cookie не появилось или уже было закрыто.");
        }
    }

    public void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();
    }

    public void selectServiceOption(String optionText) {
        By optionLocator = By.xpath("//p[text()='" + optionText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public String getBlockTitle() {
        By blockTitleLocator = By.cssSelector(".pay__wrapper h2");
        WebElement blockTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitleLocator));
        return blockTitleElement.getText().replace("\n", " ").replace("\u00A0", " ").trim();
    }
}