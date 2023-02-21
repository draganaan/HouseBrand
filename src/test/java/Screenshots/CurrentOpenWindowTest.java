package Screenshots;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import tests.BaseTest;

@Test

    public class CurrentOpenWindowTest extends BaseTest {

        public static void main(String[] args)
                throws IOException {
            // TODO Auto-generated method stub

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();            //always write wait code after this
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//for page load
            driver.get("https://www.housebrand.com/rs/sr/");         //Testing webpage
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //for Implicit wait

            //Capturing the screenshot

            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File("C:\\Screenshots\\"));

            //screenshot copied from buffer is saved at the mentioned path.

            System.out.println("The Screenshot is captured.");

        }
    }


