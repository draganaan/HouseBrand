package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class SearhForItemTest extends BaseTest {

    /**
     * Search for item and click on it
     * <p>
     * Test steps:
     * 1. Navigate to Housebrand
     * 2. Enter an item name in search field
     * 3. From search results find that item and click on it
     * <p>
     * Expected result:
     * 4. Verify that the same item you searched in previous step is shown on item page
     */
    @Test
    public void testSearch() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to Housebrand");
            HomePage homePage = new HomePage(driver);

            print("2.Enter an item name in search field");
            homePage.searchAndSubmit("kaput");


            print("3.From search results find that item and click on it");
            SearchForItemPage searchForItemPage = new SearchForItemPage(driver);
            searchForItemPage.clickOnItem("Kaput na vezivanje crni");
            ProductPage productPage = new ProductPage(driver, null);
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            productPage.clickCloseDiscountDialogButton();
            print("Verify that the same item you searched is shown on product page");
            String actualTitle = driver.findElement(By.xpath("//h1[@data-testid='product-name']")).getText();

            assert "Kaput na vezivanje crni".contains(actualTitle) : "Error. Expected title to be: " + " Kaput na vezivanje crni " + ".Actual: " + actualTitle;


        } finally {
            driver.quit();
        }
    }
        }


