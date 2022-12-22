package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Strings;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
            Select dropDown = new Select(homePage.loginDropDown);
            dropDown.selectByVisibleText("Nalog");
            assert homePage.getTextFromLoginIcon().equals("Nalog") : "Wrong text on icon. Expected: Nalog, Actual " + homePage.getTextFromLoginIcon();
            homePage.clickLoginIcon();
            assert isCurrentURLEqualTo(driver, Strings.LOGIN_PAGE_URL) : "User is NOT on expected page. " +
                    "Expected: " + Strings.LOGIN_PAGE_URL + " . Actual: " + driver.getCurrentUrl();

        } finally {
            driver.quit();
        }
    }
}

