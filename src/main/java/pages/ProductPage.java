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

    @FindBy(xpath = "//button[@class='styled__closeButton-sc-habse-4 ivTqDP']")
    WebElement closeDiscountDialogButton;

    @FindBy(xpath = "//h1[@data-testid='product-name']")
    WebElement itemName2;


    // constructor
    public ProductPage(ChromeDriver driver, String pageURL) {
        super(driver);
        if(pageURL != null) {
            assert driver.getCurrentUrl().equals(pageURL) : "Wrong page. Expected "
                    + pageURL + " . Actual " + driver.getCurrentUrl();
        }
    }

    public String getItemName2() {
        return itemName2.getText();
    }

    public void clickSizeButton() {
        print("clickSizeButton");
        assert clickSizeIcon.isDisplayed() : "Size button is not present on page";
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

    public void clickCloseDiscountDialogButton() {
        print("closeDiscountDialogButton");
        assert closeDiscountDialogButton.isDisplayed() : "Discount dialog button is not present on page";
        closeDiscountDialogButton.click();
    }
}