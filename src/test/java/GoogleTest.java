/**
 * Created by carlosvera on 5/11/17.
 */

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.Driver;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {

    @Test
    public void googleTest() throws MalformedURLException {
        GooglePage googlePage = new GooglePage("Google", new URL("http://www.google.com/"));
        String title = googlePage.getTitle();

        WebDriver webDriver = new Driver().start(Driver.Browser.CHROME);
        webDriver.get(googlePage.getURL());

        Assert.assertTrue("Wrong page title " + title, webDriver.getTitle().contains(title)); //test fails if the title is wrong
        googlePage.searchInGoogle(webDriver, "qa automation\n");

        boolean result = false;
        try {
            result = googlePage.firstPageContainsQAANet(webDriver, "www.qaautomation.net");
        } catch (Exception e) { //if test fails print the exception & keep open
            e.printStackTrace();
        } finally {
            System.out.println("Test " + (result ? "passed." : "failed."));
            webDriver.quit(); // close the browser at the end
        }
    }


}
