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

        return itemName1.getText();
    }

    //    @param itemName
    public void clickOnItem(String itemName1) {
        waitForElement(searchResultsDisplay);

        List<WebElement> items = driver.findElements(By.xpath("//*[@class='hit-item__StyledHitItem-cz15ax-0 jJIhtX']"));
        for (WebElement item : items) {
            String curentItemName = item.findElement(By.xpath(".//*[@class='hit-item__Title-cz15ax-4 gVHAjV']")).getText();
            if (curentItemName.contains(itemName1)) {
                scrollToElement(item);
                item.click();
                break;
            }


        }
    }
}