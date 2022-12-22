package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {


    // web elementi
//    @FindBy(xpath = "//small[@class='badge__BadgeComponent-kyo77g-0 dvstvf']")
//    WebElement cartBadgeQuantity;

    @FindBy(xpath = "//span[@data-selen='minicart-count']")
    WebElement cartBadgeCount;

    public CheckOutPage(ChromeDriver driver) {
        super(driver);
        assert driver.getCurrentUrl().equals(Strings.CHECKOUT_PAGE_URL) : "User is not on Checkout page";
    }

    public String getNumberFromCartBadgeCount() {
        print("getNumberFromCartBadgeCount");
        String number = cartBadgeCount.getText();
        return number;
    }

    public void clickCartBadgeQuantity() {
        print("clickCartBadgeQuantity");
        assert cartBadgeCount.isDisplayed() : "Cart badge count is not present on page";
        cartBadgeCount.click();
    }
}


