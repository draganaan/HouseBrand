package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DzemperiKardiganiPage extends BasePage {

    @FindBy(xpath = "//a[@href='https://www.housebrand.com/rs/sr/praznicni-dzemper-2326p-mlc']")
    public WebElement productName;

//    public DzemperiKardiganiPage(ChromeDriver driver) {
//        super(driver);
//    }

    public String productName() {

        return productName.getText();
    }


    public DzemperiKardiganiPage(ChromeDriver driver) {
        super(driver);
//                assert driver.getCurrentUrl().equals(Strings.CHECKOUT_PAGE_URL) : "User is not on Checkout page";

    }
        public void clickProductNameButton() {
            print("clickProductNameButton");
            assert productName.isDisplayed() : "Product name button is NOT present";
            productName.click();
        }
    }

