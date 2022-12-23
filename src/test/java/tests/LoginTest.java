package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithInValidPassword() {
        ChromeDriver driver =  new ChromeDriver();
        try {
            HomePage homePage = new HomePage (driver);
            homePage.clickLoginIcon();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName("dragana.antonijevi@gmail.com");
            loginPage.enterPassword("pogresnalozinka");
            loginPage.clickLoginButton();

            print("Verify that the error message is shown");
            String actualText = loginPage.getSearchErrorMessage();
            assert actualText.equals(Strings.ERROR_MSG) : "Wrong text. " +
                    "Expected: " + Strings.ERROR_MSG + " Actual: " +actualText;


        }finally {
            driver.quit();
        }
    }
}
