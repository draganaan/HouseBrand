package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchForItemPage extends BasePage {

// web elementi


    @FindBy(xpath = "//div[@data-testid='products-results']")
    WebElement searchResultsDisplay;

    @FindBy(xpath = "//a[normalize-space()='Kaput na vezivanje crni']")
    WebElement itemName1;

    public SearchForItemPage(ChromeDriver driver) {
        super(driver);
    }

    public String getItemName1() {

        return itemName1.getText();}

        //    @param itemName
        public void clickOnItem(String itemName1){
            waitForElement(searchResultsDisplay);
            String customXpath = "//a[@class='" + itemName1 + "']";
            List<WebElement> elements = driver.findElements(By.xpath(customXpath));
            assert elements.size() != 0 : "Array is empty";
            elements.get(0).click();
            ItemPage itemPage = new itemPage(driver);
            String actualTitle = itemPage.getItemName2();
            assert actualTitle.contains((itemName1)) : "Error. Wrong title name. Exptected:" + itemName1 + " . Actual: " + actualTitle;
        }


    }

