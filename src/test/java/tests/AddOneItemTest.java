package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AddOneItemTest extends BaseTest {


    /**
     * Buy one item
     * <p>
     * Steps:
     * 1. Navigate to home page
     * 2. Click Ona button in menu options and choose dzemperi
     * 3. Scroll to product name on DzemperiKardigani page
     * 4. Clik product name on DzemperiKardigani page
     * 5. Click size of product and add to cart
     * <p>
     * Expected result:
     * 6. Verify that the one item is shown on a cart badge
     */

    @Test


        public void addOneItemTest() {
        ChromeDriver driver = new ChromeDriver();

        print("Log into Housebrand");
        try {
            HomePage homePage = new HomePage(driver);
            driver.manage().window().maximize();
            homePage.chooseDzemperiFromSubMenu();
            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals("https://www.housebrand.com/rs/sr/ona/odeca/dzemperi-kardigani") : "Wrong url. Actual " + currentUrl;


            print("Scrool and click product link and navigate to product page");
            DzemperiKardiganiPage dzemperiKardiganiPage = new DzemperiKardiganiPage(driver);
            dzemperiKardiganiPage.scrollToElement(dzemperiKardiganiPage.productName);
            dzemperiKardiganiPage.clickProductNameButton();

            print("Click on size of the product and add to cart");
            ProductPage productPage = new ProductPage(driver, Strings.PRODUCT_PAGE_URL);
            productPage.clickCloseDiscountDialogButton();
            productPage.clickSizeButton();
            productPage.addToCartButton();
            productPage.clickConfirmationtButton();

            print("Verify that the item is bought (number 1) is shown on a cart badge");
            CheckOutPage checkOutPage = new CheckOutPage(driver);
            checkOutPage.clickCartBadgeQuantity();
            assert checkOutPage.getNumberFromCartBadgeCount().equals("1") : "Wrong number of items. Expected: 1, Actual " + checkOutPage.getNumberFromCartBadgeCount();
            checkOutPage.clickCartBadgeQuantity();



            }finally{
                driver.quit();
            }


        }
    }


