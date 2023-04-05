package qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


    public static void logger(Level level, String message ){
        Logger logger = Logger.getAnonymousLogger();
        logger.log(level, message);
    }
    /**
     * This method is used to initialize the thradlocal driver on the basis of given
     * browser
     *
     * @param browser
     * @return this will return tldriver.
     */
    public WebDriver init_driver(String browser) {


        logger(Level.INFO,"browser value is: "+browser);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver(options));
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
              ///////// headless for jenkins
            FirefoxOptions o = new FirefoxOptions();
            o.setHeadless(true);
            tlDriver.set(new FirefoxDriver(o));
            ///////
            // not headless
          // tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            logger(Level.WARNING,"Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
