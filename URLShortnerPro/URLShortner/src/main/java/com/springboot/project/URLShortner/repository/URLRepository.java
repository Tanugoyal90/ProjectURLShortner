package com.springboot.project.URLShortner.repository;

import com.springboot.project.URLShortner.models.UrlPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface URLRepository extends JpaRepository<UrlPojo, Integer> {


    //@Query ("SELECT u.longURL FROM urlmap u where u.shorturl = ?1")    using method parameters
   // String findLongURLbyShortURL(String shorturl);

    @Query ("select longURL from UrlPojo where shorturl = :shorturl") // using named parameters
    String findLongURLbyShortURL(@Param("shorturl") String shorturl);

    @Query ("select longURL from UrlPojo where URLkey = :urlkey")
    String findLongURLbyKey(@Param("urlkey") String urlkey);

    @Transactional
    @Modifying
    @Query ("delete from UrlPojo where longURL = :longurl")
    void deteteUrlRow(@Param("longurl") String longurl);
}
