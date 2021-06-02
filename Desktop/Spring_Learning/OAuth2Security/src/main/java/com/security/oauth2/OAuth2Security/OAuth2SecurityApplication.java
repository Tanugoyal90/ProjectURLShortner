package com.security.oauth2.OAuth2Security;

//import com.security.oauth2.OAuth2Security.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class OAuth2SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SecurityApplication.class, args);
		//Student st = new Student();


	}

}
