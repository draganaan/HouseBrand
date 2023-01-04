package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PidzameKucniOgrtaciPage;
import pages.SearchForItemPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static pages.Strings.MVELICINA_PAGE_URL;

public class SortingTestNew extends BaseTest{


    @Test
    public void sortingNew() {

        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Navigate to Housebrand");
            HomePage homePage = new HomePage(driver);

            print("2.Choose Pidžame i kućni ogrtači from On menu options");
            homePage.choosePidzameKucniOgrtaciFromSubMenu();


            PidzameKucniOgrtaciPage pidzameKucniOgrtaciPage = new PidzameKucniOgrtaciPage(driver);
            pidzameKucniOgrtaciPage.clickCloseDiscountDialogButton();
            pidzameKucniOgrtaciPage.clickSortirajPoButton();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            pidzameKucniOgrtaciPage.chooseCenaOpadajuce();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            pidzameKucniOgrtaciPage.clickSortButton();
//

            //sortiranje itema
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            List<WebElement> listaItemaNakonSortiranja = driver.findElements(By.xpath("//*[@class='sc-kEjbQP gqMdWQ es-product']"));

            ArrayList<Double> nizCena = new ArrayList<Double>();
            for (WebElement item : listaItemaNakonSortiranja) {
                String cena = item.findElement(By.xpath(".//div[@class='sc-idOiZg gVdoMc']")).getText();

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