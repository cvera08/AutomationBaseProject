/**
 * Created by carlosvera on 5/11/17.
 */


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.CommonValidations;
import utils.Driver;

import java.net.MalformedURLException;

public class GoogleTest {

    WebDriver webDriver;

    @BeforeTest
    public void setup() {
        webDriver = new Driver().start(Driver.Browser.CHROME);
    }

    @Test
    public void googleTest() throws MalformedURLException {
        GooglePage googlePage = new GooglePage();
        String title = googlePage.getTitle();

        webDriver.get(googlePage.getURL());

        CommonValidations.verifyTitleOfThePage(webDriver, title);

        googlePage.searchInGoogle(webDriver, "qa automation");

        Assert.assertTrue(googlePage.ResultsPageContainsQAAutoNet(webDriver, "QA Automation"), "qaautomation.net not found. Test Failed"  + "\n");
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit(); // close the browser at the end
    }

}
