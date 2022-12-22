package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //web elementi
    @FindBy(xpath = "//span[@class='menu-link__MenuLink-sc-1q9icnp-0 crxiHB']")
    WebElement onaMenuOptions;

    @FindBy(xpath = "//a[@href='https://www.housebrand.com/rs/sr/ona/odeca']")
    WebElement odecaSubMenuOptions;

    @FindBy(xpath = "//a[@href='https://www.housebrand.com/rs/sr/ona/odeca/dzemperi-kardigani']")
    WebElement dzemperiSubSubMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuSubCategory-sc-1q9icnp-2 jWSgsd'][normalize-space()='Cipele & modni dodaci']")
    WebElement cipeleModniDodaciSubMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuLink-sc-1q9icnp-0 cQIgWv'][normalize-space()='Kape']")
    WebElement kapeSubSubMenuOptions;


    // constructor
    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.housebrand.com/rs/sr/");
        print("Home page");
        assert driver.getCurrentUrl().equals(Strings.HOME_PAGE_URL) : "Wrong page. Expected "
                + Strings.HOME_PAGE_URL + " . Actual " + driver.getCurrentUrl();
        this.clickAcceptInCookie();
    }

    public void hoverOnaMenuOptions() {
        hoverOverElement(onaMenuOptions);
    }

    public void chooseDzemperiFromSubMenu() {
        hoverOverElement(onaMenuOptions);
        hoverOverElement(odecaSubMenuOptions);
        hoverOverElement(dzemperiSubSubMenuOptions);
        dzemperiSubSubMenuOptions.click();

    }

    public void chooseKapeFromSubMenu(){
        hoverOverElement(onaMenuOptions);
        hoverOverElement(cipeleModniDodaciSubMenuOptions);
        hoverOverElement(kapeSubSubMenuOptions);
        kapeSubSubMenuOptions.click();

    }
}
