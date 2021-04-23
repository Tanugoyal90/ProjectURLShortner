package com.springboot.project.URLShortner.service;


import com.springboot.project.URLShortner.DAO.UrlDao;
import com.springboot.project.URLShortner.models.UrlPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class URLService {

    @Autowired
    UrlDao urldao;
    @Autowired
    KeyGeneratorService keyGeneratorService;

    public String getLongUrl(String shortUrl){
           return urldao.getLongURLByShortURL(shortUrl);

    }

    public String getLongUrlByKey(String key){
           return urldao.getLongURLByKey(key);

    }


    public void addShortURL(UrlPojo urlPojo) throws NoSuchAlgorithmException {
        urlPojo.setURLKey(keyGeneratorService.createKey(urlPojo.getLongURL()));
        urlPojo.setShortURL(urlPojo.getBaseURL(), urlPojo.getURLKey());
        urldao.insertURL(urlPojo);
    }

    public void deleteURL(String longurl){
        urldao.deteteURL(longurl);

    }
}
