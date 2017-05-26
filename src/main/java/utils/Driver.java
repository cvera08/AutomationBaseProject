package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by carlosvera on 5/11/17.
 */
public class Driver {

    /**
     * Web driver initialization according to the browser parameter
     * It has public access in order to be accessed by others classes/objects
     *
     * @param browserName : CHROME, FIREFOX, EXPLORER, OTHER;
     * @return webDriver instance
     */
    public WebDriver start(Browser browserName) {
        WebDriver webDriver;
        if (browserName.equals(Browser.CHROME)) {
            webDriver = driverChrome(); //Make sure you have installed Chrome in your computer
        } else if (browserName.equals(Browser.FIREFOX)) {
            webDriver = driverFirefox(); //Make sure you have installed Firefox in your computer
        } else {
            throw new UnsupportedOperationException("Unsupported Browser type"); //Including Internet Explorer (just for testing purposes)
        }
        new WebDriverWait(webDriver, 30);
        return webDriver;
    }

    public enum Browser {
        CHROME,
        FIREFOX,
        EXPLORER,
        OTHER;
    }

    /**
     * Start Chrome browser
     * just can be accessed by objects of this class
     *
     * @return @return webDriver instance
     */
    private WebDriver driverChrome() {
        String OS = System.getProperty("os.name").toLowerCase();
        File file;
        if (OS.contains("mac os x"))
            file = new File("chromedriver-mac-64bit"); //you need to have located "chromedriver-mac-64bit" file in the root project directory
        else if(OS.contains("windows"))
            file = new File("chromedriver.exe");
        else if(OS.contains("linux"))
            file = new File("chromedriver_linux32"); //Change to chromedriver_linux64 if you have installed this version in your computer
        else
            throw new UnsupportedOperationException("Unsupported Operating System type");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    /**
     * Start Firefox browser
     * just can be accessed by objects of this class
     *
     * @return webDriver instance
     */
    private WebDriver driverFirefox() {
        WebDriver driver = new FirefoxDriver(); //For Mac OS: make sure you have the "geckodriver" file in the root project directory
        return driver;
    }

}
