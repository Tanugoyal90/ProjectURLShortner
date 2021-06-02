package com.security.oauth2.OAuth2Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//extend AuthorizationServerConfigurerAdapter to configure Authorization Server,
// specifying 2 clients a, b where client a having ROLE_A, ROLE_B etc…
// client b will be used to call oauth/check_token end point in the Resource Server
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
            .inMemory()
            .withClient("a")
            .secret(passwordEncoder().encode("pass"))
            .authorities("ROLE_A","ROLE_B","ROLE_TRUSTED_CLIENT")
            .scopes("all")
            .authorizedGrantTypes("client_credentials")
            .and()
            .withClient("b")
            .secret(passwordEncoder().encode("passcode"))
            .authorities("ROLE_C")
            .scopes("all")
            .authorizedGrantTypes("client_credentials");

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("hasAuthority('ROLE_C')");

    }

    @Bean      // Why making this as bean and why TokenStore
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Bean     // Why making this as bean and why PasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(4);
    }

}
