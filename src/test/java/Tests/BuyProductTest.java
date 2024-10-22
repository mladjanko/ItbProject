package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanBuyProduct() throws InterruptedException {
        logIn();
        Assert.assertTrue(inventoryPage.appLogo.isDisplayed());
        Assert.assertTrue(inventoryPage.pageTitle.getText().equalsIgnoreCase("products"));

        //ADDING PRODUCTS TO CART FOR TESTING OF EMPTYING CART
        if (!inventoryPage.inventoryItems.isEmpty()) {
            inventoryPage.addProductsToCart(3);
        }
        Thread.sleep(3000);

        inventoryPage.burgerMenuButton.click();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.logoutButton));
        inventoryPage.logoutButton.click();
        Thread.sleep(3000);

        logIn();
        Assert.assertTrue(inventoryPage.appLogo.isDisplayed());
        Assert.assertTrue(inventoryPage.pageTitle.getText().equalsIgnoreCase("products"));
        Thread.sleep(3000);

        inventoryPage.shoppingCartLink.click();
        Assert.assertTrue(cartPage.pageTitle.getText().equalsIgnoreCase("Your Cart"));
        Thread.sleep(3000);

        cartPage.emptyCart();
        Thread.sleep(3000);

        cartPage.continueShoppingButton.click();
        Assert.assertTrue(inventoryPage.pageTitle.getText().equalsIgnoreCase("products"));
        if (!inventoryPage.inventoryItems.isEmpty()) {
            inventoryPage.addProductsToCart(6);
        }
        Thread.sleep(3000);

        inventoryPage.shoppingCartLink.click();
        Assert.assertTrue(cartPage.pageTitle.getText().equalsIgnoreCase("Your Cart"));
        Thread.sleep(3000);

        cartPage.checkoutButton.click();
        Assert.assertTrue(checkoutStepOnePage.pageTitle.getText()
                .equalsIgnoreCase("Checkout: Your Information"));
        checkoutStepOnePage.inputFirstName(excelReader
                .getStringData("Sheet1", 1, 5));
        checkoutStepOnePage.inputLastName(excelReader
                .getStringData("Sheet1", 1, 6));
        checkoutStepOnePage.inputPostalCode(String.valueOf(excelReader
                .getIntegerData("Sheet1", 1, 7)));
        Thread.sleep(3000);

        checkoutStepOnePage.continueButton.click();
        Assert.assertTrue(checkoutStepTwoPage.pageTitle.getText()
                .equalsIgnoreCase("Checkout: Overview"));
        Assert.assertTrue(String.valueOf(checkoutStepTwoPage.cartItems.size())
                .equalsIgnoreCase(checkoutStepTwoPage.shoppingCartBadge
                        .getText()));
        Thread.sleep(3000);

        checkoutStepTwoPage.finishButton.click();
        Assert.assertTrue(checkoutCompletePage.pageTitle.getText().equalsIgnoreCase("Checkout: Complete!"));
        Assert.assertTrue(checkoutCompletePage.backHomeButton.isDisplayed());
        Thread.sleep(3000);

        checkoutCompletePage.backHomeButton.click();
        Assert.assertTrue(inventoryPage.pageTitle.getText().equalsIgnoreCase("products"));
        Thread.sleep(3000);

        inventoryPage.burgerMenuButton.click();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.logoutButton));
        inventoryPage.logoutButton.click();

        Assert.assertTrue(homepagePage.loginLogo.isDisplayed());
        Assert.assertTrue(homepagePage.loginButton.isDisplayed());
        Thread.sleep(3000);
    }
}
