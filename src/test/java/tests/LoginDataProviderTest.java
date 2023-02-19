package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

public class LoginDataProviderTest extends BaseTest {

    @DataProvider(name="testData")
    public Object[][] testData(){
        return new Object[][] {
                {"korisnik1"}, {"lozinka1"},
                {"korisnik2"}, {"lozinka2"},
                {"korisnik3"}, {"lozinka3"}
        };
    }
    @Test(dataProvider = "testData")
    public void loginDataProviderTest(String email, String pwd) {
        print("Passed Parameters Is : " + email + "" + pwd);
        try {
            ChromeDriver driver = new ChromeDriver();
            print("Log into Housebrand");
            HomePage homePage = new HomePage(driver);
            homePage.clickLoginIcon();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName(email);
            loginPage.enterPassword(pwd);
            loginPage.clickLoginButton();

            print("Verify that the error message is shown");
            String actualText = loginPage.getSearchErrorMessage();
            assert actualText.equals(Strings.ERROR_MSG) : "Wrong text. " +
                    "Expected: " + Strings.ERROR_MSG + " Actual: " + actualText;
        } finally {
            driver.quit();
        }
    }
}