package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void userCanLogInWithStandardUSerCredentials() {
        String userName = excelReader.getStringData("Sheet1", 1, 0);
        String password = excelReader.getStringData("Sheet1", 1, 1);
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();

        Assert.assertTrue(inventoryPage.appLogo.isDisplayed());
        Assert.assertEquals(inventoryPage.appLogo.getText(), "Swag Labs");
        Assert.assertTrue(inventoryPage.dataTestTitle.getText()
                .equalsIgnoreCase("Products"));
        Assert.assertTrue(inventoryPage.shoppingCartLink.isDisplayed());
        Assert.assertTrue(inventoryPage.burgerMenuButton.isDisplayed());
    }

    @Test
    public void userCanNotLogInWithInvalidUsername() {
        String userName = excelReader.getStringData("Sheet1", 1, 2);
        String password = excelReader.getStringData("Sheet1", 1, 1);
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();

        Assert.assertTrue(homepagePage.errorMessage.getText()
                .equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void userCanNotLogInWithInvalidPassword() {
        String userName = excelReader.getStringData("Sheet1", 1, 0);
        String password = excelReader.getStringData("Sheet1", 1, 3);
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();

        Assert.assertTrue(homepagePage.errorMessage.getText()
                .equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void userCanNotLogInWithEmptyCredentials() {
        String userName = "";
        String password = "";
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();

        Assert.assertTrue(homepagePage.errorMessage.getText()
                .equalsIgnoreCase("Epic sadface: Username is required"));
    }

    @Test
    public void userCanSuccessfullyLogOut() {
        String userName = excelReader.getStringData("Sheet1", 1, 0);
        String password = excelReader.getStringData("Sheet1", 1, 1);
        homepagePage.inputUserName(userName);
        homepagePage.inputPassword(password);
        homepagePage.clickOnLoginButton();
        inventoryPage.burgerMenuButton.click();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.logoutButton));
        inventoryPage.logoutButton.click();

        Assert.assertTrue(homepagePage.loginLogo.isDisplayed());
        Assert.assertTrue(homepagePage.loginButton.isDisplayed());
    }
}
