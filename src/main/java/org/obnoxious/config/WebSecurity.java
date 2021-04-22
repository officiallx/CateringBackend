package org.obnoxious.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

import static org.obnoxious.config.SecurityConstants.LOGIN_URL;
import static org.obnoxious.config.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsServices;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public WebSecurity(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsServices = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @CrossOrigin(origins="https://cateringwebsite.herokuapp.com", allowedHeaders="*")
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
                .antMatchers("/api/users/{username}").permitAll()
                .antMatchers("/uploads/**").permitAll()
                //.antMatchers("/api/events","/api/events{eventId}/packages").permitAll()
                .anyRequest().authenticated()
                //.and().cors()
                //.and().headers().frameOptions().disable()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .httpBasic();
        http.cors();
        http.headers().cacheControl();
    }

    @Bean
    public CorsConfiguration getCorsConfiguration(final HttpServletRequest request) {
        return new CorsConfiguration().applyPermitDefaultValues();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServices).passwordEncoder(bCryptPasswordEncoder);
    }
}