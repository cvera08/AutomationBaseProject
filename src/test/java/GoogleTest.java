/**
 * Created by carlosvera on 5/11/17.
 */


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.CommonValidations;

import java.net.MalformedURLException;

public class GoogleTest extends BaseTest {

    @Test
    @Parameters({"expectedTitle", "search", "expectedUrl"})
    public void googleTest(String expectedTitle, String search, String expectedUrl) throws MalformedURLException {
        GooglePage googlePage = new GooglePage(webDriver); //Setting title, url domain and open google url in browser

        CommonValidations.verifyTitleOfThePage(webDriver, expectedTitle);

        googlePage
                .searchInGoogle(webDriver, search)
                .resultsPageContainsUrl(webDriver, expectedUrl);
    }

}
