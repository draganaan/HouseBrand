
package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultInvalidPage extends BasePage {

//    web elementi
    @FindBy(xpath = "div@class='search-content open full']")
    WebElement searchResultInvalid;

    @FindBy(xpath = "div@data-testid='products-results']")
    WebElement searchErrorMessage;


// constructor
    public SearchResultInvalidPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isSearchResultsPresent() {
        print("isSearchResultsPresent");
        return isElementPresent(searchResultInvalid);
    }

    public String getSearchErrorMessage() {
        print("getSearchErrorMessage");
        return searchErrorMessage.getText();
    }
}
