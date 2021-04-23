package com.springboot.project.URLShortner.DAO;

import com.springboot.project.URLShortner.models.UrlPojo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
//@Transactional
@Repository
public interface UrlDao {

    /*@PersistenceContext
    EntityManager entityManager;

    @Autowired UrlPojo urlPojo;

    public void insertKey(UrlPojo urlPojo){
        entityManager.persist(urlPojo);
    }*/

    void insertURL(UrlPojo urlPojo);
    //UrlPojo getURLbyId(int id);
    String getLongURLById(int id);
    String getLongURLByKey(String key);
    String getLongURLByShortURL(String shorturl);
    public void deteteURL(String longurl);

}
