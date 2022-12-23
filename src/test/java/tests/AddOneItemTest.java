package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.DzemperiKardiganiPage;
import pages.HomePage;
import pages.ProductPage;



public class AddOneItemTest extends BaseTest {


    /**
     * Buy one item
     * <p>
     * Steps:
     * 1. Navigate to home page
     * 2. Click Ona button in menu options and choose dzemperi
     * 3. Scrool to product name on DzemperiKardigani page
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
            homePage.hoverOnaMenuOptions();
            homePage.chooseDzemperiFromSubMenu();

            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals("https://www.housebrand.com/rs/sr/ona/odeca/dzemperi-kardigani") : "Wrong url. Actual " + currentUrl;


            print("Scrool and click product link and navigate to product page");
            DzemperiKardiganiPage dzemperiKardiganiPage = new DzemperiKardiganiPage(driver);
            dzemperiKardiganiPage.scrollToElement(dzemperiKardiganiPage.productName);
            dzemperiKardiganiPage.clickProductNameButton();

            print("Click on size of the product and add to cart");
            ProductPage productPage = new ProductPage(driver);
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


