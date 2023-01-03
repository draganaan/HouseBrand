package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    //web elementi
    @FindBy(xpath = "//span[normalize-space()='Ona']")
    WebElement onaMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuLink-sc-1q9icnp-0 cQIgWv'][contains(text(),'Džemperi')]")
    WebElement dzemperiSubSubMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuSubCategory-sc-1q9icnp-2 jWSgsd'][normalize-space()='Cipele & modni dodaci']")
    WebElement cipeleModniDodaciSubMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuLink-sc-1q9icnp-0 cQIgWv'][normalize-space()='Kape']")
    WebElement kapeSubSubMenuOptions;

    @FindBy(xpath = "//span[normalize-space()='On']")
    WebElement onMenuOptions;

    @FindBy(xpath = "//div[@class='dropdown__DropDown-sc-7wugq3-0 jFmpPt']//a[@class='menu-link__MenuLink-sc-1q9icnp-0 cQIgWv'][contains(text(),'Pidžame, kućni ogrtači')]")
    WebElement pidzameKucniOgrtaciSubMenuOptions;






    // constructor
    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.housebrand.com/rs/sr/");
        print("Home page");
        assert driver.getCurrentUrl().equals(Strings.HOME_PAGE_URL) : "Wrong page. Expected "
                + Strings.HOME_PAGE_URL + " . Actual " + driver.getCurrentUrl();
        this.clickAcceptInCookie();
    }

    public void chooseDzemperiFromSubMenu() {
        hoverOverElement(onaMenuOptions);
        hoverClickOverElement(dzemperiSubSubMenuOptions);
    }

    public void chooseKapeFromSubMenu() {
        hoverOverElement(onaMenuOptions);
        hoverClickOverElement(kapeSubSubMenuOptions);
    }

    public void choosePidzameKucniOgrtaciFromSubMenu() {
        hoverOverElement(onMenuOptions);
        hoverClickOverElement(pidzameKucniOgrtaciSubMenuOptions);
    }


//    public Select(WebElement element) {
//        String tagName = element.getTagName();
//        if null != tagName && "select"

    }

//    WebElement dropDownWebElement = driver.findElementByXPath("//select");
//    Select dropdown = new Select (dropDownWebElement);
//    dropdown.selectByVisibleText ("Džemperi")



