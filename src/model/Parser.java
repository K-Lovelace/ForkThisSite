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
        this.parse(this.base_url, 0, this.base_url.replaceAll("http(s)?://", "").replace('/', '.'));
    }
    
    private void parse(String url, int depth, String pretty_url) {
        if (depth > this.max_depth) return;
        this.parsed_urls.add(url);
        Document document;
        String webPageOutput = String.format("%s/%s", this.out, pretty_url).replace("//", "/");
        try {
            document = Jsoup.connect(url).get();
        } catch (Exception e) {
            System.out.println("Parsing WebPage " + url + " failed: " + e.getMessage());
            return;
        }
    
        try {
            Files.createDirectories(Paths.get(webPageOutput));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    
        //Styles
        document = this.parseStylesheets(document, pretty_url, webPageOutput);
        
        //Images and videos
        if (this.getImages) {
            document = this.parseImages(document, pretty_url, webPageOutput);
        }
    
        if (this.getVideos) {
            document = this.parseVideos(document, pretty_url, webPageOutput);
        }
        
        //Base url
        Element base = document.getElementsByTag("base").first();
        if(base == null) {
            base = document.getElementsByTag("head").first().prependElement("base");
        }
        base.attr("href", this.out);
        
        Elements links = document.getElementsByTag("a");
        for (Element link : links) {
            String absHref = link.attr("abs:href");
    
            if(absHref.isEmpty())
                continue;
            
            String link_pretty_url = absHref.replaceAll("http(s)?://", "").replace('/', '.');
            if(link_pretty_url.length() > 143)
                link_pretty_url = link_pretty_url.substring(0, 142);
    
            while(this.parsed_urls.contains(link_pretty_url))
                link_pretty_url = String.format("%s%f", link_pretty_url.substring(0, 141), Math.random());
            
            link.attr("href", String.format("/%s/index.html", link_pretty_url.replace("?", "%3F").replace(";", "%3B")));
    
    
            if (this.parsed_urls.contains(absHref))
                    continue;
            this.parse(absHref, depth + 1, link_pretty_url);
        }
        
        try {
            
            Files.write(Paths.get(webPageOutput + "/index.html"), document.outerHtml().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private Document parseStylesheets(Document document, String pretty_url, String webPageOutput) {
        for(Element stylesheet : document.getElementsByAttributeValueContaining("rel", "stylesheet")) {
            String location = stylesheet.attr("abs:href");
            String[] nameSplit = stylesheet.attr("href").split("/");
            String name = nameSplit[nameSplit.length - 1];
            String fileName = String.format("%s/%s", webPageOutput, name);
            stylesheet.attr("href", String.format("%s/%s", webPageOutput, name));
            //Open a WebPage Stream
            Connection.Response resultImageResponse;
            FileOutputStream out = null;
            try {
                resultImageResponse = Jsoup.connect(location).ignoreContentType(true).execute();
        
                // output here
                out = (new FileOutputStream(new java.io.File(fileName)));
                out.write(resultImageResponse.bodyAsBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(out != null)
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            
        }
        
        return document;
    }
    
    private Document parseVideos(Document document, String pretty_url, String outputDir) {
        
        return document;
    }
    
    private Document parseImages(Document document, String pretty_url, String outputDir) {
        for (Element img : document.getElementsByTag("img")) {
            String imageLocation = img.attr("abs:src");
            String[] imageNameSplit = img.attr("src").split("/");
            String name = imageNameSplit[imageNameSplit.length - 1];
            
            img.attr("src", String.format("/%s/%s", outputDir, name));
            //Open a WebPage Stream
            Connection.Response resultImageResponse;
            FileOutputStream out = null;
            try {
                resultImageResponse = Jsoup.connect(imageLocation).ignoreContentType(true).execute();
    
                // output here
                out = (new FileOutputStream(new java.io.File(String.format("%s/%s", outputDir, name))));
                out.write(resultImageResponse.bodyAsBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(out != null)
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        return document;
    }
    
    public static void main(String[] args) {
        Parser parser = new Parser("http://ceri.univ-avignon.fr",
                2,
                "/home/lovelacez/ForkThisSite.out/test2/",
                true,
                false);
        parser.parse();
    }
}
