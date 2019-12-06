package com.Vortex.Test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

    /*@Autowired
    DataSource dataSource;*/

    @Autowired
    MyUserDetailsService myUserDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // in memory authentication
        /*auth.inMemoryAuthentication()
                //.passwordEncoder(passwordEncoder)
                .withUser("user").password(passwordEncoder.encode("user")).roles("User")
                .and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("User", "Admin")
                .and()
                .withUser("test").password(passwordEncoder.encode("test")).roles();*/

        // Embedded sql authentication
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema() // if we give empty h2 [sql] database to spring security it can implement default schema
                .withUser(
                        User.withUsername("User")
                                    .password("userPas")
                                    .roles("User")
                )
                .withUser(
                User.withUsername("Admin")
                        .password("adminPas")
                        .roles("Admin", "User")
                )
                .withUser(
                        User.withUsername("test")
                                .password("test")
                                .roles()
                );*/

        // Authentication using a userdefined service
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        //return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/public/**").permitAll()
                .antMatchers("/admin").authenticated()//.hasRole("Admin")
                .antMatchers("/user").authenticated()//.hasAnyRole("User", "Admin")
                .antMatchers("/*").authenticated()
                .and()
                .formLogin()//enable form based authentication
                .loginPage("/login.html")//use a custom login URI
                .failureUrl("/login-error.html")
                .permitAll(true)//login URI can be accessed by anyone
                .and()
                .logout()//default logout handling
                .logoutSuccessUrl("/my-login?logout")//our new logout success url, we are not replacing other defaults.
                .permitAll();//allow all as it will be accessed when user is not logged in anymore
       /* http
                .authorizeRequests()
                .antMatchers( "/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .failureUrl("/login-error.html")
                .permitAll();  */
        /*http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic(); */
    }
}