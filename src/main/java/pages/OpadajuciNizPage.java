package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class OpadajuciNizPage extends BasePage {


//   web elementi
    @FindBy(xpath = "//*[@class='sc-kEjbQP gqMdWQ es-product']")
    WebElement listaItemaNakonSortiranja;

//  constructor
    public OpadajuciNizPage(ChromeDriver driver) {
        super(driver);
        assert driver.getCurrentUrl().equals(Strings.OPADAJUCI_NIZ_PAGE_URL) : "Wrong page. Expected "
                + Strings.OPADAJUCI_NIZ_PAGE_URL + " . Actual " + driver.getCurrentUrl();
    }
}
