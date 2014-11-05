package br.com.rhonan.noxml.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(getUserQuery()).
            authoritiesByUsernameQuery(getAuthoritiesQuery());
        auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // the order matters
        http.authorizeRequests().antMatchers("/webjars/**").permitAll().
                and().authorizeRequests().antMatchers("/css/**").permitAll().
                and().authorizeRequests().antMatchers("/js/**").permitAll().
                and().authorizeRequests().antMatchers("/images/**").permitAll().
                and().formLogin().loginPage("/login").permitAll().
                and().logout().permitAll().
                and().authorizeRequests().antMatchers("/**").hasRole("USER").
                and().httpBasic().
                and().csrf().disable();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**", "/status");
    }

    private String getUserQuery() {
        return "SELECT `name` as `username`, `password` as `password`, `enabled` as `enabled` "
                + "FROM `user` "
                + "WHERE `name` = ?";
    }

    private String getAuthoritiesQuery() {
        return "SELECT DISTINCT `name` as `username`, 'ROLE_USER' AS `authority` "
                + "FROM `user` "
                + "WHERE `name` = ?";
    }

}