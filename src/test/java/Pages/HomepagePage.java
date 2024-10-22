package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_logo")
    public WebElement loginLogo;

    @FindBy(id = "user-name")
    public WebElement inputUserNameField;

    @FindBy(id = "password")
    public WebElement inputPasswordField;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    //------------------

    public void inputUserName(String userName) {
        inputUserNameField.clear();
        inputUserNameField.sendKeys(userName);
    }

    public void inputPassword(String password) {
        inputPasswordField.clear();
        inputPasswordField.sendKeys(password);
    }
}
