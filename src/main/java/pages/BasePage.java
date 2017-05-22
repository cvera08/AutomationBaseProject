package pages;

import java.net.URL;

/**
 * Created by carlosvera on 5/15/17.
 */
public class BasePage {

    public String title;
    public URL domain;

    public BasePage() {
    }

    public BasePage(String title, URL url) {
        this.title = title;
        this.domain = url;
    }

    public String getURL() {
        return domain.toString();
    }

    public String getTitle() {
        return title;
    }
}
