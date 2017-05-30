/**
 * Created by carlosvera on 5/11/17.
 */


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
    @Parameters({"expectedTitle", "search", "expectedUrl"})
    public void googleTest(String expectedTitle, String search, String expectedUrl) throws MalformedURLException {
        GooglePage googlePage = new GooglePage(webDriver); //Setting title, url domain and open google url in browser

        CommonValidations.verifyTitleOfThePage(webDriver, expectedTitle);

        googlePage
                .searchInGoogle(webDriver, search)
                .resultsPageContainsUrl(webDriver, expectedUrl);
    }

    @AfterTest
    public void closeBrowser() {
        webDriver.quit(); // close the browser at the end
    }

}
