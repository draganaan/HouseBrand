package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchForItemPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;


/**
 * Sorting item in descending order
 * <p>
 * Test steps:
 * 1. Navigate to Housebrand
 * 2. Enter an item name in search field
 * 3. From search results clik on sort button (Sortiraj od više cene ka nižoj)
 * <p>
 * Expected result:
 * 4. Verify that the item we searched is in the descending order
 */
public class SortingTest extends BaseTest {

    private static Logger logger = Logger.getLogger(SortingTest.class);
    @Test
    public void SortiranjeUOpadajucemNizu(String[] args) {

        logger.info("Helo");
        print("Hi");


        ChromeDriver driver = new ChromeDriver();
        try {

            print("1.Navigate to Housebrand");
            HomePage homePage = new HomePage(driver);
            driver.manage().window().maximize();

            print("2.Enter an item name in search field");
            homePage.searchAndSubmit("marama");

            SearchForItemPage searchForItemPage = new SearchForItemPage(driver);
            searchForItemPage.clickSort();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            searchForItemPage.clickSortButton();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//

            //sortiranje itema
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            List<WebElement> listaItemaNakonSortiranja = driver.findElements(By.xpath("//*[@class='hit-item__ProductInfo-cz15ax-2 gFMTte']"));

            ArrayList<Double> nizCena = new ArrayList<Double>();
            for (WebElement item : listaItemaNakonSortiranja) {
                String cena = item.findElement(By.xpath(".//div[@class='product-price__PromoPrice-sc-1ftsh9w-1 bDVVCG']")).getText();

                int currencyPosition = cena.indexOf("RSD");

                Double cenaKaoDecimalanBroj = Double.valueOf(cena.substring(0,currencyPosition).trim());
                nizCena.add(cenaKaoDecimalanBroj);
            }

            System.out.println("Niz cena : " + nizCena.toString());

            //provera da li je lista u opadajućem nizu

            for (int i = 0; i < nizCena.size() - 1; i++) {
                assert nizCena.get(i) >= nizCena.get(i + 1) : " Cena : " + nizCena.get(i) + " nije veća ili jednaka od cene " + nizCena.get(i + 1) + " narednog elementa!" ;
            }

        } finally {
            driver.quit();
        }
    }


}
