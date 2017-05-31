import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.WikipediaPage;
import utils.CommonValidations;

import java.net.MalformedURLException;

/**
 * Created by carlosvera on 5/11/17.
 */
public class WikipediaTest extends BaseTest {


    @Test
    @Parameters("expectedTitle")
    public void wikipediaTest(String expectedTitle) throws MalformedURLException {
        WikipediaPage wikipediaPage = new WikipediaPage(webDriver); //Setting title, url domain and open wikipedia url in browser

        wikipediaPage.changeToEnglishLanguage(webDriver);

        CommonValidations.verifyTitleOfThePage(webDriver, expectedTitle);

    }


}
