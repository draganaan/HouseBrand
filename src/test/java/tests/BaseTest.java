package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Strings;

    public class BaseTest {

        WebDriver driver = null;
        public ChromeDriver openChromeDriver() {
            print("Openenig Chrome driver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--disable-popup-blocking"});
            options.addArguments(new String[]{"--incognito"});
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            ChromeDriver driver = new ChromeDriver(options);
            driver.get(Strings.HOME_PAGE_URL);
            return driver;
        }

        public void print(String text) {
            System.out.println(text);
        }

        public void sleep() {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            }


        public boolean isCurrentURLEqualTo(ChromeDriver driver, String expectedUrl) {
            print("isCurrentURLEqualTo ( " + expectedUrl + " )");
            String currentUrl = driver.getCurrentUrl();
            print("User is on " + currentUrl);
            boolean b = currentUrl.equals(expectedUrl);
            return b;
        }
    }