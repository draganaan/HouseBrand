package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ModniDodaciPage;

import java.util.ArrayList;
import java.util.List;

import static pages.Strings.MODNI_DODACI_PAGE_URL;
import static pages.Strings.SL_PAGE_URL;

public class SortingTest extends BaseTest {

    @Test
    public void SortiranjeUOpadajucemNizu() {
        ChromeDriver driver = new ChromeDriver();
        try {

            print("1.Navigate to Housebrand");
            HomePage homePage = new HomePage(driver);
            homePage.hoverOnaMenuOptions();
            homePage.chooseKapeFromSubMenu();
            assert isCurrentURLEqualTo(driver, MODNI_DODACI_PAGE_URL) : "User is NOT on expected page. " +
                    "Expected: " + MODNI_DODACI_PAGE_URL + " . Actual: " + driver.getCurrentUrl();

            ModniDodaciPage modniDodaciPage = new ModniDodaciPage(driver);
            modniDodaciPage.clickSort();
            modniDodaciPage.chooseOptionOpadajuce();
            modniDodaciPage.clickSortButton();
//            Select dropDownWebElement = new Select();
//            dropDownWebElement.selectByVisibleText("Cena opadajuće");


//            ModniDodaciPage.selectRadioButton1();
//            ModniDodaciPage.selectRadioButton2();


            //sortiranje itema


            List<WebElement> listaItemaNakonSortiranja = driver.findElements(By.xpath("//*[@class='sc-kEjbQP gqMdWQ es-product']"));

            ArrayList<Double> nizCena = new ArrayList<Double>();
            for (WebElement item : listaItemaNakonSortiranja) {
                String cena = item.findElement(By.xpath(".//p[@class='es-final-price']")).getText().replace("RSD", "");
                Double cenaKaoDecimalanBroj = Double.valueOf(cena);
                nizCena.add(cenaKaoDecimalanBroj);
            }

            System.out.println("Niz cena : " + nizCena.toString());

            //provera da li je niz padajući

            for (int i = 0; i < nizCena.size() - 1; i++) {
                assert nizCena.get(i) >= nizCena.get(i + 1) : " Prvi : " + nizCena.get(i) + " nije veći ili jednak od drugog " + nizCena.get(i + 1);
            }

        } finally {
            driver.quit();
        }
    }
}
