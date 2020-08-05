package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class GooglePage extends BasePage {

    public GooglePage(WebDriver webDriver) throws MalformedURLException {
        super("Google", new URL("http://www.google.com/"));
        Reporter.log("Opening url : " + this.getURL());
        webDriver.get(this.getURL());
    }

    /**
     * Search in google (enter search criteria + press search button)
     *
     * @param webDriver : contains browser session
     * @param search    : search criteria
     */
    public GooglePage searchInGoogle(WebDriver webDriver, String search) {
        Reporter.log("Entering search criteria : " + search);
        WebElement googleInput = webDriver.findElement(By.name("q"));
        googleInput.clear(); //clear search box
        googleInput.sendKeys(search); //type search query
        Reporter.log("Pressing Search button");
        webDriver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();// click search
        return this;
    }

    /**
     * Verify if results of google page contains the parameter url
     *
     * @param webDriver
     * @return
     */
    public GooglePage resultsPageContainsUrl(final WebDriver webDriver, String expectedUrl) {
        // Wait for search to complete
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                Reporter.log("\n Searching ...");
                return webDriver.findElement(By.id("result-stats")) != null;
            }
        });
        boolean found = false;
        try {
            found = webDriver.findElement(By.cssSelector("a[href*='" + expectedUrl + "']")).isDisplayed();
            Reporter.log("Expected url : " + expectedUrl + " found.");
        } catch (NoSuchElementException e) { //expectedUrl is not displayed. so, found keeps false
        } catch (Exception e) {
        }
        Assert.assertTrue(found, expectedUrl + " not found. Test Failed" + "\n");
        return this;
    }

}
