package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

public class PidzameKucniOgrtaciPage extends BasePage {

// web elementi

    @FindBy(xpath = "//section[@id='categoryProducts']")
    WebElement searchResults;
    @FindBy(xpath = "//label[contains(text(),'Veličine')]")
    WebElement velicineFilter;

    @FindBy(xpath = "//input[@id='sizes-m']")
    WebElement mVelicina;

    @FindBy(xpath = "//ul[@class='item__StyledItemWrapperComponent-sc-1b1qw41-1 bGeAIg sizes opened']//button[@type='submit'][normalize-space()='Filter']")
    WebElement filterButton;

    @FindBy(xpath = "//a[contains(text(),'Dvodelna pidžama Pokémon crna')]")
    WebElement pokemonPidzama;

    @FindBy(xpath = "//label[normalize-space()='Sortiraj po']")
    WebElement sortirajPoButton;

    @FindBy(xpath = "//label[@for='sortBy-1']//span[@class='radio__RadioMock-frao3x-1 eGTROP radio-mock']")
    WebElement cenaOpadajuce;

    @FindBy(xpath = "//button[normalize-space()='Sort']")
    WebElement sortButton;

    @FindBy(xpath = "//button[@class='styled__closeButton-sc-habse-4 ivTqDP']")
    WebElement closeDiscountDialogButton;

//    constructor

    public PidzameKucniOgrtaciPage(ChromeDriver driver) {
        super(driver);

    }

//    metode

    public void clickVelicineFilter() {
        waitForElement(velicineFilter);
        velicineFilter.click();

    }

    public void clickMvelicina() {
        waitForElement(mVelicina);
        mVelicina.click();

    }

    public void clickSearchFilterButton() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", filterButton);
        filterButton.click();
    }

    public void clickSortirajPoButton() {
        print("clickSortirajPoButton()");
        assert sortirajPoButton.isDisplayed() : "Sortiraj po button is not present on page";
        sortirajPoButton.click();


    }

    public void chooseCenaOpadajuce() {
        print("chooseCenaOpadajuce()");
        assert cenaOpadajuce.isDisplayed() : "Cena opadajuce is not present on page";
        cenaOpadajuce.click();}

    public void clickSortButton() {
        print("clickSortButton()");
        assert sortButton.isDisplayed() : "Sort button is not present on page";
        sortButton.click();}

    public void clickCloseDiscountDialogButton() {
        print("closeDiscountDialogButton");
        assert closeDiscountDialogButton.isDisplayed() : "Discount dialog button is not present on page";
        closeDiscountDialogButton.click();
    }

}
