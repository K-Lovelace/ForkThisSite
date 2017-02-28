package model;

import java.util.Date;

public class WebPage {
    private final Date date;
    /*
        * The absolute url of the page
        * */
    private String url;
    /*
    * The absolute path to the containing folder
    * */
    private String locationFolder;
    
    public WebPage(String url, String folder, Date date) {
        this.url = url;
        this.locationFolder = folder;
        this.date = date;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String toString() {
        return String.format("%s %s", this.locationFolder, this.date.toString());
    }
}
