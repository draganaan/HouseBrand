package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultInvalidPage;
import pages.Strings;

public class InvalidProductTest extends BaseTest{

    /**
     * Search for invalid brand
     * steps:
     * 1. Navigate to home page
     * 2. enter invalid brand name into search field
     * 3. click search and submit button
     * <p>
     * Expected result:
     * 3. Verify that the there are NOT search results and that is shown Error message
     */


    @Test
    public void searchInvalidBrandTest() {
        ChromeDriver driver = openChromeDriver();
        String invalidBrand = "tralala";
        String expectedSearchErrorMSG = Strings.SEARCH_ERROR_MSG.replace("„%TEXT%”", invalidBrand);
        try {
            HomePage homePage = new HomePage(driver);
            sleep();
            homePage.searchAndSubmit(invalidBrand);
            SearchResultInvalidPage searchResultPage = new SearchResultInvalidPage(driver);
            sleep();
            assert !searchResultPage.isSearchResultsPresent() : "There should be no results, but there ARE";
            String actualErrorMessage = searchResultPage.getSearchErrorMessage();
            assert actualErrorMessage.equals(expectedSearchErrorMSG) : "Error. Wrong message" +
                    "Expected: " + expectedSearchErrorMSG + " .Actual " + actualErrorMessage;

        } finally {
            driver.quit();
        }
    }
}