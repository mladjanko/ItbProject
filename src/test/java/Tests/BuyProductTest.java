package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BuyProductTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanBuyProduct() {
        logIn();
        for (int i = 0; i < inventoryPage.addToCartButtons.size(); i++) {
            inventoryPage.addToCartButtons.get(i).click();
        }
        inventoryPage.shoppingCartLink.click();
        cartPage.emptyCart();
    }


}
