package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class GooglePage extends BasePage {

    public GooglePage(String title, URL domain) {
        super(title, domain);
    }

    /**
     * Search in google (enter search criteria + press search button)
     *
     * @param webDriver : contains browser session
     * @param search : search criteria
     */
    public void searchInGoogle(WebDriver webDriver, String search) {
        System.out.println("Entering searh criteria : " + search);
        webDriver.findElement(By.name("q")).sendKeys(search); //type search query
        System.out.println("Pressing Search button");
        webDriver.findElement(By.name("btnG")).click();// click search
    }

    /**
     * Verify if results of google page contains the parameter url
     *
     * @param webDriver
     * @return
     */
    public boolean firstPageContainsQAANet(final WebDriver webDriver, String url) {
        // Wait for search to complete
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("resultStats")) != null;
            }
        });
        return webDriver.findElement(By.className("_Rm")).getText().contains(url);
    }

}
