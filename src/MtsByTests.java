import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage homePage;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        homePage = new MainPage(driver, wait);
    }

    @Test
    @DisplayName("Проверка заголовка блока 'Онлайн пополнение без комиссии'")
    public void testCheckBlockTitle() {
        homePage.сookie();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        String actualBlockTitle = homePage.getBlockTitle();
        String expectedBlockTitle = "Онлайн пополнение без комиссии";
        assertEquals(expectedBlockTitle, actualBlockTitle, "Заголовок блока не совпадает.");
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        homePage.сookie();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        By visaLogo = By.cssSelector("img[alt='Visa']");
        By mastercardLogo = By.cssSelector("img[alt='MasterCard']");
        By belkartLogo = By.cssSelector("img[alt='Белкарт']");

        assertTrue(isElementDisplayed(visaLogo), "Логотип Visa не найден.");
        assertTrue(isElementDisplayed(mastercardLogo), "Логотип MasterCard не найден.");
        assertTrue(isElementDisplayed(belkartLogo), "Логотип Белкарт не найден.");
    }

    @Test
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreAboutServiceLink() {
        homePage.сookie();;
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        By moreInfoLink = By.xpath("//a[text()='Подробнее о сервисе']");
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink));
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        linkElement.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl, "URL после нажатия на ссылку не соответствует ожидаемому.");
    }

    @Test
    @DisplayName("Проверка заполнения полей и работы кнопки 'Продолжить'")
    public void testOnlinePaymentForm() {
        homePage.сookie();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        By phoneInput = By.id("connection-phone");
        By sumInput = By.id("connection-sum");
        By emailInput = By.id("connection-email");
        By submitButton = By.cssSelector("#pay-connection .button__default");

        driver.findElement(phoneInput).sendKeys("297777777");
        driver.findElement(sumInput).sendKeys("30");
        driver.findElement(emailInput).sendKeys("test@mail.ru");

        WebElement submitButtonElement = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButtonElement);
        submitButtonElement.click();

        String expectedUrl = "https://www.mts.by/";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "URL после нажатия на кнопку не совпадает.");
    }

    @Test
    @DisplayName("Проверка текста плейсхолдеров полей ввода")
    public void testCheckPlaceholders() {
        homePage.сookie();
        homePage.openDropdown();
        homePage.selectServiceOption("Услуги связи");

        String actualPhonePlaceholder = getPlaceholderText(By.id("connection-phone"));
        String actualSumPlaceholder = getPlaceholderText(By.id("connection-sum"));
        String actualEmailPlaceholder = getPlaceholderText(By.id("connection-email"));

        assertEquals("Номер телефона", actualPhonePlaceholder, "Плейсхолдер поля телефона не совпадает.");
        assertEquals("Сумма", actualSumPlaceholder, "Плейсхолдер поля суммы не совпадает.");
        assertEquals("E-mail для отправки чека", actualEmailPlaceholder, "Плейсхолдер поля email не совпадает.");
    }

    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private String getPlaceholderText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getAttribute("placeholder");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}