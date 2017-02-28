package model;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public abstract class Database {
    private static DB db;
    private static ConcurrentMap map;
    
    public static void initialize() {
        db = DBMaker.fileDB("webpages.db").make();
        map = db.hashMap("map").createOrOpen();
    }
    
    public static void add(WebPage webPage) {
        map.put(webPage.getUrl(), webPage.toString());
    }
    
    public static void close() {
        db.close();
    }
    
    public static Set<Map.Entry<String, String>> getWebPages() {
        return map.entrySet();
    }
}
