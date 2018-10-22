package com.aaa.sigiep.config;

//import com.aaa.sigiep.authentication.AuthenticationService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
//extends WebSecurityConfigurerAdapter
public class WebSecurityConfig {
    
    @Autowired
    DataSource dataSource;
    
//    @Autowired
//    AuthenticationService authenticationService;
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(authenticationService);
//    }
       
//    @Bean
//    public static PasswordEncoder passwordEncoder(){ 
//        return NoOpPasswordEncoder.getInstance(); 
//    } 
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {        
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
//        http.authorizeRequests().antMatchers("/home", "/welcome").access("hasAnyRole('ROLE_USUARIO', 'ROLE_ADMINISTRADOR')");
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//        http.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/j_spring_security_check")
//                .loginPage("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//                .usernameParameter("txtNombre")
//                .passwordParameter("txtContrasena")                
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
//    }           
}
