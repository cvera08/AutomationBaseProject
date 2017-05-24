package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class GooglePage extends BasePage {

    public GooglePage() throws MalformedURLException {
        super("Google", new URL("http://www.google.com/"));
    }

    /**
     * Search in google (enter search criteria + press search button)
     *
     * @param webDriver : contains browser session
     * @param search    : search criteria
     */
    public void searchInGoogle(WebDriver webDriver, String search) {
        Reporter.log("Entering searh criteria : " + search);
        webDriver.findElement(By.name("q")).sendKeys(search); //type search query
        Reporter.log("Pressing Search button");
        webDriver.findElement(By.name("btnG")).click();// click search
    }

    /**
     * Verify if results of google page contains the parameter url
     *
     * @param webDriver
     * @return
     */
    public boolean ResultsPageContainsQAAutoNet(final WebDriver webDriver, String titleQAAutoNet) {
        // Wait for search to complete
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                Reporter.log("\n Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });
        return webDriver.findElement(By.cssSelector("a[href*='www.qaautomation.net']")).getText().contains(titleQAAutoNet);
    }

}
