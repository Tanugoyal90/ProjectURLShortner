package com.springboot.project.URLShortner.service;

import com.springboot.project.URLShortner.DAO.UrlDao;
import com.springboot.project.URLShortner.models.UrlPojo;
import com.springboot.project.URLShortner.repository.URLRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
//@Transactional
public class StaticURLDaoImpl implements UrlDao {

    Logger logger = LoggerFactory.getLogger(StaticURLDaoImpl.class);
    //@PersistenceContext
    //EntityManager entityManager;

   @Autowired
    URLRepository urlRepository;

   public StaticURLDaoImpl(){

   }
   public StaticURLDaoImpl(URLRepository urlRepository){
      this.urlRepository = urlRepository;
    }

    @Override
    public void insertURL(UrlPojo urlPojo){
        //UrlPojo urlPojo = new UrlPojo("https://www.educative.io/courses/grokking-the-object-oriented-design-interview/gxM3gRxmr8Z", "https://www.educative.io", "dbhgdwbsjm34");
        logger.info("URLPOJO" + urlPojo);
        urlRepository.save(urlPojo);
        //entityManager.getTransaction().begin();
        //logger.info("URLPOJO After Begin" + urlPojo);
        //entityManager.persist(urlPojo);

        //entityManager.getTransaction().commit();
        //logger.info("URLPOJO after commit" + urlPojo);
    }

    /*@Override
    public UrlPojo getURLbyId(int id) {
        return null;
    }

    @Override
    public String getShortURLById(int id) {
        return null;
    }*/
    @Override
    public String getLongURLById(int id){
        //Optional<UrlPojo> urlpojo = urlRepository.findById(id);
        //return urlRepository.findLongURLById(id);
        return "Tanu";
    }

    @Override
    public String getLongURLByKey(String urlkey){
        //Optional<UrlPojo> urlpojo = urlRepository.findById(id);
        //return urlRepository.findLongURLById(id);
        return urlRepository.findLongURLbyKey(urlkey);
    }



    @Override
    public String getLongURLByShortURL(String shorturl){
        return urlRepository.findLongURLbyShortURL(shorturl);

    }

    @Override
    public void deteteURL(String longurl){
        urlRepository.deteteUrlRow(longurl);

    }
}
