package com.security.oauth2.OAuth2Security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//using ResourceServerTokenServices bean which returns a RemoteTokenServices object to check token,
// note the client “b” is used to call oauth/check_token endpoint

@SpringBootApplication
@EnableResourceServer
@RestController
public class ResourceServerSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerSecurityApplication.class, args);
	}

	@GetMapping("/account")
	public String getAccount(){
		return "Here is requested Account";
	}

	@Bean
	public ResourceServerTokenServices tokenServices() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setClientId("b");
		remoteTokenServices.setClientSecret("passcode");
		remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8100/oauth/check_token");
		return remoteTokenServices;
	}
}
