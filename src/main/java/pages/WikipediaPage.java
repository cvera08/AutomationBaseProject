package pages;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class WikipediaPage extends BasePage {

    public WikipediaPage() throws MalformedURLException {
        super("Wikipedia, la enciclopedia libre", new URL("https://es.wikipedia.org/"));
    }
}
