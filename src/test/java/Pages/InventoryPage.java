package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public WebElement dataTestTitle;

}
