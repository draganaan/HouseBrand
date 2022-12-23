package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;

public class ScrollToInstagramTest extends BaseTest{

    @Test
    public void scrollToInstagram() {
        ChromeDriver driver = openChromeDriver();
        driver.manage().window().getPosition();
        try {
            HomePage homePage = new HomePage(driver);
            homePage.scrollToInstagramButton();
            homePage.clickInstagramButton();

            ArrayList<String> tabs = new ArrayList (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));


            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals("https://www.instagram.com/house_brand/#")  : "Wrong url. Actual " + currentUrl;

            driver.switchTo().window(tabs.get(0));

        } finally {
            driver.quit();
        }
    }
}

