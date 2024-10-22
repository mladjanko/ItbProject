package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BaseTest {

    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(css = "span[class='title'][data-test='title']")
    public WebElement pageTitle;

    @FindBy(className = "inventory_item")
    public List<WebElement> inventoryItems;

    @FindBy(className = "btn_inventory")
    public List<WebElement> addToCartButtons;

    //--------------------

    public void addProductsToCart(int productsNumber) {
        if (productsNumber <= addToCartButtons.size()) {
            for (int i = 0; i < productsNumber; i++) {
                addToCartButtons.get(i).click();
            }
        }
    }
}
