package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage {


    // web elementi zajendički za sve strane
    @FindBy(xpath = "//a[@data-testid='brand-logo-button']")
    WebElement logoButton;

    @FindBy(xpath = "//button[@data-testid='search-open-button']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@data-selen='cart-button']")
    WebElement cartButton;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;


//    @FindBy(xpath = "//div[@id='cookieBannerOverlay']")
//    public
//    WebElement loginDropDown;
    //label[text() = 'Sortiraj po']

    @FindBy(xpath = "//p[normalize-space()='Nalog']")
    WebElement loginIcon;

    @FindBy(xpath = "//ul[@data-testid='category-list']")
    WebElement mainMenuBar;


    @FindBy(xpath = "//a[normalize-space()='Instagram']")
    WebElement instagramButton;

    @FindBy(xpath = "//img[@alt='store selector icon']")
    WebElement countryIcon;

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    WebElement cookieAcceptButton;


    //    constructor
    ChromeDriver driver = null;


    //    metode na stranici
    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickShoppingCartIcon() {
        print("clickShoppingCartIcon()");
        assert cartButton.isDisplayed() : "Cart button is not present on page";
        cartButton.click();

    }

    public void hoverOverElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].mouseOver()", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void clickSearchAndSubmitButton() {
        print("clickSearchAndSubmitButton");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOf(searchButton));
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
            boolean isPresent = element.isDisplayed();
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            print("Element is not present on page");
            return false;
        }
    }

    public String getTextFromLoginIcon() {
        print("getTextFromLoginIcon()");
        String text = loginIcon.getText();
        return text;
    }

    public void clickOnMainMenuBar(String linkText) {
        print("clickOnMainMenuBar ( " + linkText + " )");
        List<WebElement> list = mainMenuBar.findElements(By.xpath(".//li[@data-testid='category-link']"));
        for (WebElement item : list) {
            String itemText = item.getText();
            if (itemText.equals(linkText)) {
                print("Clicking on " + linkText);
                item.click();
                break;
            }
        }
    }

    public void scrollToInstagramButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
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
        public void print(String s){
            System.out.println(s);
        }

    }




