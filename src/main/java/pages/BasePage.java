package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BasePage {


    // web elementi zajendički za sve strane
    @FindBy(xpath = "//button[@data-testid='search-open-button']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//p[normalize-space()='Nalog']")
    WebElement loginIcon;

    @FindBy(xpath = "//a[normalize-space()='Instagram']")
    WebElement instagramButton;

    @FindBy(xpath = "//img[@alt='store selector icon']")
    WebElement countryIcon;

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    WebElement cookieAcceptButton;


    //    constructor
    ChromeDriver driver;


    //    metode na stranici
    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickSearchAndSubmitButton() {
        print("clickSearchAndSubmitButton");
        searchButton.click();
    }

    public void enterTextIntoSearchField(String text) {
        print("enterTextIntoSearchField");
        searchField.sendKeys(text);
        waitForElement(searchField);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchAndSubmit(String text) {
        print("searchAndSubmit");
        clickSearchAndSubmitButton();
        enterTextIntoSearchField(text);

    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            print(e.getMessage());
            print("Element is not present on page");
            return false;
        }
    }

    public String getTextFromLoginIcon() {
        print("getTextFromLoginIcon()");
        return loginIcon.getText();
    }

    public void scrollToInstagramButton() {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].scrollIntoView(true);", instagramButton);
    }

    public void clickAcceptInCookie() {
        waitForElement(cookieAcceptButton);
        cookieAcceptButton.click();
    }

    public void clickInstagramButton() {
        print("clickInstagramButton()");
        assert instagramButton.isDisplayed() : "Instagram button is not present on page";
        instagramButton.click();
    }

    public void clickCountryIcon() {
        print("clickCountryIcon()");
        assert countryIcon.isDisplayed() : "Country button is not present on page";
        countryIcon.click();
    }

    public void clickLoginIcon() {
        print("clickLoginIcon");
        assert loginIcon.isDisplayed() : "Login icon is not present on page";
        loginIcon.click();
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actions.moveToElement(element).perform();
    }

    public void hoverClickOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actions.moveToElement(element).click().perform();
    }

    public void print(String s) {
        System.out.println(s);
    }

}




