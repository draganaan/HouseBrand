package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    //web elementi

    @FindBy(xpath = "//span[@class='size-name']")
    WebElement clickSizeIcon;

    @FindBy(xpath = "//span[@class='add-to-cart-textstyled__AddToCartText-sc-1r0djzu-0 fvazqB']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@data-testid='cart-confirmation-go-to-cart']")
    WebElement productAddedToCart;


    // constructor
    public ProductPage(ChromeDriver driver) {
        super(driver);
        assert driver.getCurrentUrl().equals(Strings.PRODUCT_PAGE_URL) : "Wrong page. Expected "
                + Strings.PRODUCT_PAGE_URL + " . Actual " + driver.getCurrentUrl();
    }

    public void clickSizeButton() {
        print("clickSizeButton");
        assert clickSizeIcon.isDisplayed() : "Click size button is not present on page";
        clickSizeIcon.click();
    }

    public void addToCartButton() {
        print("addToCartButton");
        assert addToCartButton.isDisplayed() : "Add to cart button is not present on page";
        addToCartButton.click();
    }

    public void clickConfirmationtButton() {
        print("clickConfirmationButton");
        waitForElement(productAddedToCart);
        assert productAddedToCart.isDisplayed() : "Product is not present in the cart";
        productAddedToCart.click();
    }
}