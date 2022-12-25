package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ModniDodaciPage extends BasePage {

//    web elementi

    @FindBy(xpath = "//label[normalize-space()='Sortiraj po']")
    WebElement sortDropDown;

    @FindBy(xpath = "//label[@for='sortBy-1']//span[@class='radio__RadioMock-frao3x-1 eGTROP radio-mock']")
    WebElement optionOpadajuce;

    @FindBy(xpath = "//button[normalize-space()='Sort']")
    WebElement sortButton;

    @FindBy(xpath = "//a[normalize-space()='Crna vunena beretka']")
    WebElement prviItem;

    @FindBy(xpath = "//p[@class='es-final-price']")
    WebElement cenaItema;





    public ModniDodaciPage(ChromeDriver driver) {
        super(driver);
        assert driver.getCurrentUrl().equals(Strings.MODNI_DODACI_PAGE_URL) : "User is not on Checkout page";
    }

//    metode

    public void clickSort() {
        print("clickSort");
        assert sortDropDown.isDisplayed() : "Sort dropdown is not present on page";
        sortDropDown.click();
    }

    public void chooseOptionOpadajuce() {
        print("ChooseOptionOpadajuće");
        assert optionOpadajuce.isDisplayed() : "Option opadajuce is not present on page";
        optionOpadajuce.click();
    }

    public void clickSortButton() {
        print("ClickSortButton");
        assert sortButton.isDisplayed() : "Option opadajuce is not present on page";
        sortButton.click();
    }

//    public void selectRadioButton1() {
//        print("SelectRadioButton1");
//        radioButton1.click();}
//
//    public void selectRadioButton2() {
//        print("SelectRadioButton2");
//        radioButton2.click();}

}
