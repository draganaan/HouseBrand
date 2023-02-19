package Screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FacebookScreenshotTest {

    // Create Webdriver reference
    WebDriver driver;

    @Test
    public void captureScreenshot() throws Exception {

// Initiate Firefox browser
            driver = new ChromeDriver();

// Maximize the browser
            driver.manage().window().maximize();

// Pass application url
            driver.get("https://www.facebook.com/");

// Here we are forcefully passing wrong id so that it will fail our testcase
            driver.findElement(By.xpath("//input[@id='email']")).sendKeys("xxxx");
            driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("zzzzz");
            driver.findElement(By.xpath("//button[@name='login']")).click();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            String currentUrl = driver.getCurrentUrl();

            assert currentUrl.equals("https://www.facebook.com");

        }

    // It will execute after every test execution
    @AfterMethod
    public void tearDown(ITestResult result) {

// Here will compare if test is failing then only it will enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
// Create refernce of TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

// Call method to capture screenshot
                File source = ts.getScreenshotAs(OutputType.FILE);

// Copy method  specific location here it will save all screenshot in our project home directory and
// result.getName() will return name of test case so that screenshot name will be same
                try {
                    FileHandler.copy(source, new File("C:\\Screenshots\\" + result.getName()+ Math.random() + ".png"));
                    System.out.println("Screenshot taken");
                } catch (Exception e) {
                    System.out.println("Exception while taking screenshot " + e.getMessage());
                }
            }
// close application
            finally {
                driver.quit();
            }
        }
    }
}
