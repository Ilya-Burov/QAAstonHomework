import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By closeButton = By.cssSelector(".header__close-button svg-icon[src='assets/images/icons/x.svg']");
    private By dropdownButton = By.cssSelector(".select__header");
    private By cookieAcceptButton = By.id("cookie-agree");
    private By blockTitleLocator = By.cssSelector(".pay__wrapper h2");
    private By logoContainer = By.cssSelector(".pay__partners ul");
    private By visaLogo = By.cssSelector("img[alt='Visa']");
    private By mastercardLogo = By.cssSelector("img[alt='MasterCard']");
    private By belkartLogo = By.cssSelector("img[alt='Белкарт']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void acceptCookies() {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Всплывающее окно cookie не появилось или уже было закрыто.");
        }
    }
    private void clickUsingJavaScript(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void openDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();
    }
    public void selectServiceOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Увеличено время ожидания
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='" + optionText + "']")));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Failed to click the element. Trying with JavascriptExecutor");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
    public void selectInternetOption() {
        selectServiceOption("Домашний интернет");
    }
    public void selectInstallmentOption() {
        selectServiceOption("Рассрочка");
    }
    public void selectDebtOption() {
        WebElement debtOption = driver.findElement(By.xpath("//p[text()='Задолженность']"));
        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", debtOption);
        // Клик по элементу с использованием JavascriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", debtOption);
    }
    public String getBlockTitle() {
        WebElement blockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitleLocator));
        return blockElement.getText().replace("\n", " ").replace("\u00A0", " ").trim();
    }
    public boolean isVisaLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(visaLogo) != null;
    }
    public boolean isMastercardLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(mastercardLogo) != null;
    }
    public boolean isBelkartLogoDisplayed() {
        WebElement logosElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logoContainer));
        return logosElement.findElement(belkartLogo) != null;
    }
}