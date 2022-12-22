package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@id='login[username]_id']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='login[password]_id']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@data-selen='login-submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='sc-eCstlR hOtxkI']")
    WebElement errorText;


    //metode nad drajverom
    ChromeDriver driver = null;

    //constructor

    public LoginPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "User is not on Login page";
    }
//             metode na stranici

    /**
     * This method clicks on a field and enters username
     *
     * @param name
     */
    public void enterUserName(String name) {
        assert userNameField.isDisplayed() : "Username field is not present";
        userNameField.click();
        userNameField.sendKeys(name);
    }

    /**
     * @param password
     */
    public void enterPassword(String password) {
        assert passwordField.isDisplayed() : "Password field is not present";
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        assert loginButton.isDisplayed() : "Login button is not present";
        loginButton.click();}


        /**
         * @param userName
         * @param password
         */
        public void logInUser(String userName, String password){
            enterUserName("username");
            enterPassword("password");
            clickLoginButton();
        }


        public String getSearchErrorMessage() {
            print("getSearchErrorMessage");
            return errorText.getText();

        }
    }




