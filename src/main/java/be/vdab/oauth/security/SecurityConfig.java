package be.vdab.oauth.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // use open authentication to use github login credentials (single sign on)
        http.oauth2Login();
        http.authorizeRequests(
                requests -> requests
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/secured").authenticated()
        );
    }
}
