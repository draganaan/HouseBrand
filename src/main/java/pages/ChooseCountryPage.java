package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ChooseCountryPage extends BasePage {


//    web elementi

    @FindBy(xpath = "//a[normalize-space()='Slovenija / Slovenia']")
    WebElement chooseCountryButton;

    public ChooseCountryPage(ChromeDriver driver) {
        super(driver);
    }

    public void clickChooseCountryButton() {
        //print("clickChoseCountryButton()");
        assert chooseCountryButton.isDisplayed() : "Choose country button is not present on page";
        chooseCountryButton.click();
    }
}
