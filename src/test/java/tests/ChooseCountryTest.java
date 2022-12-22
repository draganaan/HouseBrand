package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ChooseCountryPage;
import pages.HomePage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

import static pages.Strings.*;

public class ChooseCountryTest extends BaseTest{

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
