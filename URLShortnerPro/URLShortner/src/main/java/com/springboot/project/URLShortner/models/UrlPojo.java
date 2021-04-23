package com.springboot.project.URLShortner.models;

import com.springboot.project.URLShortner.service.KeyGeneratorService;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "urlmap")
public class UrlPojo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String longURL;
    String baseURL = "http://localhost:8080/";
    String URLkey = "";
    String shortURL;

    public UrlPojo(){
    }

    public UrlPojo(String longURL) {
        this.longURL = longURL;
        setShortURL(baseURL, this.URLkey);
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String baseURL, String key) {
        this.shortURL = baseURL + key;
    }
    public void setURLKey( String urlKey){
        this.URLkey = urlKey;
    }
    public String getURLKey(){
        return this.URLkey;
    }
    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String longURL) {
       String firstStr[] = longURL.split("://", 2);    // https   www.google.com/xxx/xxxx/xxx
       String fqdn[] = firstStr[1].split("/", 2);      // www.google.com     xxx/xxxx/xxx
        //System.out.println(firstStr[0] + "://" + fqdn[0] + "/");
        this.baseURL = firstStr[0] + "://" + fqdn[0] + "/";
    }

    public void setMyAppBaseURL() {
        this.baseURL = "http://localhost:8080/";
    }

}