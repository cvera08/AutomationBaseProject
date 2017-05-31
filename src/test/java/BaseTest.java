import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;

/**
 * Created by carlosvera on 5/31/17.
 */
public class BaseTest {

    WebDriver webDriver = null;
    Driver.Browser webBrowser;

    @BeforeTest
    @Parameters("browser")
    public void setup(@Optional("CHROME") String browser) {
        if (browser.equals(Driver.Browser.FIREFOX.toString()))
            webBrowser = Driver.Browser.FIREFOX;
        else if (browser.equals(Driver.Browser.CHROME.toString())) //In order to avoid exceptions when is CHROME as parameter in TestNG.XML
            webBrowser = Driver.Browser.CHROME;
        else
            throw new UnsupportedOperationException("Unsupported Browser type. Browser parameter : " + browser + ". Expected values CHROME or FIREFOX."); //Including Internet Explorer (just for testing purposes)
        Reporter.log("Opening browser : " + browser);
        webDriver = new Driver().start(webBrowser);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit(); // close the browser at the end
    }
}
