package logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ChooseCountryPage;
import pages.HomePage;

import static pages.Strings.SL_PAGE_URL;

public class ChooseCountryTest extends BaseTest{

    private static final Logger logger = Logger.getLogger(logger.ChooseCountryTest.class);

    public static void main(String[] args) {
        logger.info(
                "1. Navigate to home page\n" +
                "2. Click country icon\n" +
                "3. On the next page choose country\n" +
                "<p>\n" +
                "Expected result:\n" +
                "4. Verify that the right country url is shown");
        System.out.println("ChooseCountryTest");
    }


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
