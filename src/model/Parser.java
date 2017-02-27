package model;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;


public class Parser {
    private String out;
    private String base_url;
    private int max_depth;
    private TreeSet<String> parsed_urls;
    private Boolean getImages;
    private Boolean getVideos;
    
    /*
    * @param out: Have to finish by "/"
    **/
    public Parser(String base_url, int max_depth, String out, Boolean getImages, Boolean getVideos) {
        this.base_url = base_url;
        if (max_depth < 0) max_depth = 0;
        this.max_depth = max_depth;
        this.parsed_urls = new TreeSet<>();
        this.out = out;
        this.getImages = getImages;
        this.getVideos = getVideos;
    }
    
    public void parse() {
        this.parse(this.base_url, 0);
    }
    
    private void parse(String url, int depth) {
        if (depth > this.max_depth) return;
        this.parsed_urls.add(url);
        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Parsing WebPage " + url + " failed: " + e.getMessage());
            return;
        }
    
        String pretty_url = url.replaceAll("http(s*)://", "").replaceAll("/", ".");
        String webPageOutput = String.format("%s/%s", this.out, pretty_url).replace("//", "/");
        
        if (this.getImages) {
            document = this.parseImages(document, webPageOutput);
        }
    
        if (this.getVideos) {
            document = this.parseVideos(document, webPageOutput);
        }
    
        
        
        try {
            Files.createDirectories(Paths.get(webPageOutput));
            Files.write(Paths.get(webPageOutput + "/index.html"), document.outerHtml().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            String absHref = link.attr("abs:href");
            if (this.parsed_urls.contains(absHref))
                continue;
            this.parse(absHref, depth + 1);
        }
    }
    
    private Document parseVideos(Document document, String outputDir) {
        
        return document;
    }
    
    private Document parseImages(Document document, String outputDir) {
        for (Element img : document.getElementsByTag("img")) {
            String imageLocation = img.attr("abs:src");
            String[] imageNameSplit = img.attr("src").split("/");
            String name = imageNameSplit[imageNameSplit.length];
            
            //Open a WebPage Stream
            Connection.Response resultImageResponse = null;
            try {
                resultImageResponse = Jsoup.connect(imageLocation).ignoreContentType(true).execute();
                
                // output here
                FileOutputStream out = (new FileOutputStream(new java.io.File(String.format("%s/%s", outputDir, name))));
                out.write(resultImageResponse.bodyAsBytes());  // resultImageResponse.body() is where the image's contents are.
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return document;
    }
    
    public static void main(String[] args) {
        Parser parser = new Parser("http://ceri.francoiscapon.com",
                5,
                "/test1/",
                false,
                false);
        parser.parse();
    }
}
