package com.springboot.project.URLShortner.controller;

import com.springboot.project.URLShortner.models.UrlPojo;
import com.springboot.project.URLShortner.service.KeyGeneratorService;
import com.springboot.project.URLShortner.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
public class URLRedirectController {

    @Autowired
    URLService urlService;

    @Autowired
    HttpServletRequest httpServletRequest;

        /*@PostMapping(value = "/redirect")
        public ResponseEntity<Void> redirect(@RequestParam Map<String,String> input){
            System.out.println(input);
            tring longURL = urlService.getLongUrl(getURLValue(httpServletRequest));S
            System.out.println(longURL);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
    }*/

   /* @RequestMapping(value = "*")
    public ResponseEntity<Void> getRequestURL(HttpServletRequest httpServletRequest){
           //httpServletRequest.getRequestURI();
        String requestShortURL = httpServletRequest.getRequestURL().toString() + "?" + httpServletRequest.getQueryString();
        System.out.println("printing Request URL as shorturl:" + requestShortURL);
        requestShortURL = "http://localhost:8080/ftfax";
        String longURL = urlService.getLongUrl(requestShortURL);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();


        //return requestShortURL;

    }*/


    @RequestMapping(value = "/{key}")
    public ResponseEntity<Void> redirectToLongURL(@PathVariable("key") String key){
        String longURL = urlService.getLongUrlByKey(key);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
    }

    @PostMapping( path = "/api/v1/url", produces = "application/json")
    public ResponseEntity<String> createShortURL(@RequestParam("longurl") String longurl) throws NoSuchAlgorithmException {
        UrlPojo urlPojo = new UrlPojo(longurl);
        urlService.addShortURL(urlPojo);
        //return urlPojo.getShortURL();
        // it should return response successful creation
        return ResponseEntity.status(HttpStatus.CREATED).body("Short URL: "+urlPojo.getShortURL()+ " is created");
    }

    @DeleteMapping (path = "/api/v1/longurl")
    public ResponseEntity<String> deleteURL(@RequestParam("longurl") String longurl) {
        //UrlPojo urlPojo = new UrlPojo(longurl);
        urlService.deleteURL(longurl);
        //return urlPojo.getShortURL();
        // it should return response successful creation
        return ResponseEntity.status(HttpStatus.OK).body("URL: " +longurl+ " is deleted");
    }


    /*@GetMapping("/{key}")    // it should return long url and if not found a 404 response
    public ResponseEntity<Void> getLongURLByShortURL(@PathVariable("id") String key){
        String longURL = urlService.getLongUrlByKey(key);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
    }*/
    /*@GetMapping("/api/v1/url/{shorturlkey}")
    public ResponseEntity<String> getLongURLByKey(@PathVariable("shorturlkey") String shorturlkey){
        String longURL = urlService.getLongUrlByKey(shorturlkey);
        //return new ResponseEntity<>(longURL)ResponseEntity<longURL>;
        //return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
    }*/

    @GetMapping("/api/v1/url/{id}")
    public ResponseEntity<Void> getLongURLById(@PathVariable("id") String key){
        String longURL = urlService.getLongUrlByKey(key);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longURL)).build();
    }



}
