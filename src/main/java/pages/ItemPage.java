package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemPage extends BasePage {

    //web elementi

    @FindBy(xpath = "//h1[@data-testid='product-name']")
    WebElement itemName2;

    public String getItemName2() {
        return itemName2.getText();
    }

        // constructor
    public ItemPage(ChromeDriver driver) {
            super(driver);
            assert driver.getCurrentUrl().equals(Strings.ITEM_PAGE_URL) : "Wrong page. Expected "
                    + Strings.ITEM_PAGE_URL + " . Actual " + driver.getCurrentUrl();
        }
    }


