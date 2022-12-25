package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ChooseCountryPage;
import pages.HomePage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

import static pages.Strings.*;

public class ChooseCountryTest extends BaseTest{

    /**
     * Choose country
     * steps:
     * 1. Navigate to home page
     * 2. Click country icon
     * 3. On the next page choose country
     * <p>
     * Expected result:
     * 4. Verify that the right country url is shown
     */

    @Test
    public void chooseCountry() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickCountryIcon();
            ChooseCountryPage chooseCountryPage = new ChooseCountryPage(driver);
            chooseCountryPage.clickChooseCountryButton();
            assert isCurrentURLEqualTo(driver,SL_PAGE_URL) : "User is NOT on expected page. " +
                    "Expected: " + SL_PAGE_URL + " . Actual: " + driver.getCurrentUrl();

        } finally {
            driver.quit();
        }
    }
}
