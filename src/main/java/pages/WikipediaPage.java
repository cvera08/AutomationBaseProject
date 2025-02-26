package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 * Page Object. Encapsulates Wikipedia Launch Page.
 */
public class WikipediaPage extends BasePage {

    @FindBy(css = "a[title='inglés']")
    WebElement enLanguage;

    public WikipediaPage(WebDriver webDriver) throws MalformedURLException {
        super("Wikipedia, la enciclopedia libre", new URL("https://es.wikipedia.org/")); //Open Wikipedia in Spanish version
        Reporter.log("Opening url : " + this.getURL());
        webDriver.get(this.getURL());
        PageFactory.initElements(webDriver, this);
    }

    public WikipediaPage changeToEnglishLanguage(WebDriver webDriver) {
        Reporter.log("Changing language to English");
        enLanguage.click();

        // Wait for change to English version
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                Reporter.log("\nWaiting for English Wikipedia page ...");
                return webDriver.getCurrentUrl().contains("https://en.wikipedia.org/");
            }
        });
        return this;
    }
}
