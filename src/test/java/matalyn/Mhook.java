package matalyn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Mhook {

    public static class Hooks {
        public static WebDriver driver;
        @Before
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            // driver = new FirefoxDriver();
            driver.get("https://www.matalan.co.uk");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        @After
        public void tearDown(){
            //driver.quit();
        }


    }

}
