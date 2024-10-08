package com.propdoc.springboot.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.propdoc.springboot.thymeleaf.service.LoginService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    	
        http.authorizeRequests()
                    .antMatchers(
                    		"/maintenance",
                    		"/app-assets/**",
                            "/assets/**",
                            "/gulp-tasks/**",
                            "/src/**",
                            "/css/**",
                            "/webjars/**",
                            "/ajax","/js/**","/","/index").permitAll()
                    .antMatchers("/rvsemp/**",
                    		"/docs/**",
                            "/employeeprofilephoto/**",
                    		"/employeeresume/**",
                    		"/employeecertification/**").access("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/**").access("hasRole('ROLE_ADMIN')")                    
                    
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                            .permitAll()
                .and()
                    .logout()
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error/401Unaut");
        
        
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(loginService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    
   
    
  
}
