package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='title'][data-test='title']")
    public WebElement pageTitle;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    @FindBy(className = "btn_small")
    public List<WebElement> removeButtons;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    //----------------------

    public void emptyCart() {
        if (!cartItems.isEmpty()) {
            for (int i = removeButtons.size() - 1; i >= 0; i--) {
                removeButtons.get(i).click();
            }
        }
    }
}
