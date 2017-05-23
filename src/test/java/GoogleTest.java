/**
 * Created by carlosvera on 5/11/17.
 */


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.Driver;

import java.net.MalformedURLException;

public class GoogleTest {

    @Test
    public void googleTest() throws MalformedURLException {
        GooglePage googlePage = new GooglePage();
        String title = googlePage.getTitle();

        WebDriver webDriver = new Driver().start(Driver.Browser.CHROME);
        webDriver.get(googlePage.getURL());

        Reporter.log("Checking google title");
        Assert.assertTrue(webDriver.getTitle().contains(title), "Wrong page title " + title); //test fails if the title is wrong
        
        googlePage.searchInGoogle(webDriver, "qa automation");

        boolean result = false;
        try {
            result = googlePage.firstPageContainsQAANet(webDriver, "www.qaautomation.net");
        } catch (Exception e) { //if test fails print the exception & keep open
            e.printStackTrace();
        } finally {
            Reporter.log("\n Test " + (result ? "passed." : "failed."));
            webDriver.quit(); // close the browser at the end
        }
    }


}
