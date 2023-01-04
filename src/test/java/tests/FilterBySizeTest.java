package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PidzameKucniOgrtaciPage;

import java.util.concurrent.TimeUnit;
import static pages.Strings.MVELICINA_PAGE_URL;

public class FilterBySizeTest extends BaseTest{

    @Test
    public void filterBySize() {

        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to Housebrand");
            HomePage homePage = new HomePage(driver);

            print("2.Choose Pidžame i kućni ogrtači from On menu options");
            homePage.choosePidzameKucniOgrtaciFromSubMenu();


            print("3.From search results click on velicina button, choose size M, scrool and click on filter button");
            PidzameKucniOgrtaciPage pidzameKucniOgrtaciPage = new PidzameKucniOgrtaciPage(driver);

            pidzameKucniOgrtaciPage.clickCloseDiscountDialogButton();
            pidzameKucniOgrtaciPage.clickVelicineFilter();
            pidzameKucniOgrtaciPage.clickMvelicina();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            pidzameKucniOgrtaciPage.clickSearchFilterButton();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            print("Verify that we are on the right URL page");
            assert isCurrentURLEqualTo(driver, MVELICINA_PAGE_URL) : "User is NOT on expected page. " +
                    "Expected: " + MVELICINA_PAGE_URL + " . Actual: " + driver.getCurrentUrl();


        } finally {
            driver.quit();
        }
    }
}

