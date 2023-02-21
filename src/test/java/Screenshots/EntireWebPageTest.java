/*
package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import tests.BaseTest;

public class EntireWebPageTest extends BaseTest {

    public static void main(String[] args) throws InterruptedException, IOException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();              //always write wait code after this
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
        driver.get("https://www.housebrand.com/rs/sr/");                          //Testing webpage
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //for Implicit wait

        WebElement auto = driver.findElement(By.xpath("//ul[@id='mega-menu-primary']/li[6]"));
        auto.click();                           //click Automation tab

        WebElement jmeter = driver.findElement(By.linkText("JMeter"));  //link to JMeter page
        jmeter.click();

        //scroll down to open a link among various links, in the Video Tutorials section of the page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)");           //scrolling downwards
        Thread.sleep(1500);

        WebElement udv = driver.findElement(By.linkText("User-Defined Variables"));
        udv.click();                                   //opening User-Defined Variables link
        Thread.sleep(1500);

        //Capturing the Screenshot with the help of  ashot()

        Screenshot screenshot=new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\Screenshots\\"));

        //The screenshot to be captured will be in .png image format and would be saved at above mentioned path.

        System.out.println("Screenshot for full page is captured successfully!");
    }
}
*/
