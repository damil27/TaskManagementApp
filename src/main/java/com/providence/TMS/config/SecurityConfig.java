package com.providence.TMS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select email as principal, password as credentials, true From user Where email=? ")
                .authoritiesByUsernameQuery("Select user.email as principal, role.name as role From user_roles inner join user on user.public_id = user_roles.user_id inner     join role on role.public_id = user_roles.role_id Where user.email=?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_") ;
    }

    @Bean

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers("/","/register","/*.css","/img/**","/webjars/**").permitAll()
                .anyRequest().authenticated().and().formLogin().loginPage("/login")
                .permitAll().defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
    }




}
