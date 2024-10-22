package Base;

import Pages.CartPage;
import Pages.HomepagePage;
import Pages.InventoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public HomepagePage homepagePage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public ExcelReader excelReader;
    public WebDriverWait wait;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        excelReader = new ExcelReader("./SaucedemoTestData.xlsx");

        homepagePage = new HomepagePage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void logIn() {
        String userName = excelReader.getStringData("Sheet1", 1, 0);
        String password = excelReader.getStringData("Sheet1", 1, 1);
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
