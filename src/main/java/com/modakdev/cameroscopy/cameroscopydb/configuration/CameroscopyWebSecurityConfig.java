package com.modakdev.cameroscopy.cameroscopydb.configuration;

import com.modakdev.cameroscopy.cameroscopydb.filter.CsrfRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;


@Configuration
@EnableWebSecurity
public class CameroscopyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/home").hasAuthority("USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/create").hasAuthority("USER")
                .antMatchers("/delete").hasAuthority("USER")
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/id/{id}").hasAuthority("USER")
                .anyRequest().authenticated().and().httpBasic();*/

        http.httpBasic();

        http.addFilterAfter(new CsrfRequestFilter(), CsrfFilter.class);

     //   http.csrf().disable();
    }
}
