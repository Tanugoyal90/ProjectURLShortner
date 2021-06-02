package com.security.oauth2.OAuth2Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerResourceConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
    //http.authorizeRequests().antMatchers("/account").hasAuthority("ROLE_A");
    http.authorizeRequests().antMatchers("/account").permitAll().anyRequest().anonymous();    }


}
