package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutStepTwoPage extends BaseTest {

    public CheckoutStepTwoPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='title'][data-test='title']")
    public WebElement pageTitle;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shoppingCartBadge;

    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;
}
