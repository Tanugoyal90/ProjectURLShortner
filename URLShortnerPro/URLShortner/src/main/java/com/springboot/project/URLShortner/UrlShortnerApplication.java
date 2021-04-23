
package com.springboot.project.URLShortner;

//import com.springboot.project.URLShortner.security.UserRespository;
import com.springboot.project.URLShortner.DAO.UrlDao;
import com.springboot.project.URLShortner.models.UrlPojo;
import com.springboot.project.URLShortner.repository.URLRepository;
import com.springboot.project.URLShortner.service.StaticURLDaoImpl;
import com.springboot.project.URLShortner.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.URL;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
//@ComponentScan ("com.springboot.project.URLShortner.security")
@ComponentScan (basePackages = "com.springboot.project.URLShortner")
//@ComponentScan ("com.springboot.project.URLShortner.DAO")
@EnableJpaRepositories (basePackages = "com.springboot.project.URLShortner.repository")
//@EnableJpaRepositories(basePackageClasses = URLRespository.class)
public class UrlShortnerApplication {


	//@Autowired
   //UrlDao urlDao;

   //public void addUrlShortnerApplication(){
	 //  new URLService().addURLService();
  // }

	public static void main(String[] args) throws NoSuchAlgorithmException {
		ApplicationContext applicationContext = SpringApplication.run(UrlShortnerApplication.class, args);

		//StaticURLDaoImpl staticURLDao = applicationContext.getBean(StaticURLDaoImpl.class);
		//staticURLDao.insertURL();
		URLService urlService = applicationContext.getBean(URLService.class);
		//urlService.addURLService();

		//UrlPojo urlPojo = new UrlPojo("https://www.educative.io/courses/grokking-the-object-oriented-design-interview/gxM3gRxmr8Z", "https://www.educative.io", "dbhgdwbsjm34");
		//new StaticURLDaoImpl().insertURL(urlPojo);
		//new UrlShortnerApplication().addUrlShortnerApplication();




	}


}
