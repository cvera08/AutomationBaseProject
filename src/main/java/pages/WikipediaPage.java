package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class WikipediaPage extends BasePage {

    public WikipediaPage() throws MalformedURLException {
        super("Wikipedia, la enciclopedia libre", new URL("https://es.wikipedia.org/")); //Open Wikipedia in Spanish version
    }

    public void changeToEnglishLanguage(WebDriver webDriver) {
        System.out.println("Changing language to English");
        webDriver.findElement(By.cssSelector("a[title='inglés']")).click();

        // Wait for change to English version
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Waiting for English Wikipedia page ...");
                return webDriver.getCurrentUrl().contains("https://en.wikipedia.org/");
            }
        });
    }

    public boolean itsInEnglishVersion(WebDriver webDriver) {
        System.out.println("Verifying title of page is in English");
        return webDriver.getTitle().contains("Wikipedia, the free encyclopedia");
    }
}
