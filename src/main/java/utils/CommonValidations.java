package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Created by carlosvera on 5/23/17.
 */
public class CommonValidations {

    /**
     * The test is going to fail if the expected title is different
     *
     * @param webDriver     : driver
     * @param expectedTitle : title to match
     */
    public static void verifyTitleOfThePage(WebDriver webDriver, String expectedTitle) {
        Reporter.log("Checking page title");
        String actualTitle = webDriver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Wrong page title. Expected : " + expectedTitle + ". Found : " + actualTitle + "\n");
    }
}
