package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebPage {
    private Date date;
    /*
        * The absolute url of the page
        * */
    private String url;
    
    public String getLocationFolder() {
        return locationFolder;
    }
    
    /*
        * The absolute path to the containing folder
        * */
    private String locationFolder;
    
    public WebPage(String url, String folder, Date date) {
        this.url = url;
        this.locationFolder = folder;
        this.date = date;
    }
    
    public WebPage(String url, String serialized) {
        this.url = url;
        String[] split = serialized.split(" ");
        this.locationFolder = split[0];
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy--HH:mm:ss");
        try {
            this.date = df.parse(split[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public String getUrl() {
        return url;
    }
    
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy--HH:mm:ss");
    
        return String.format("%s %s", this.locationFolder, df.format(this.date));
    }
}
