package org.kevin.demo0212.config.security;

import org.kevin.demo0212.model.BlogUser;
import org.kevin.demo0212.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Kevin.Z
 * @version 2020-03-14
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private BlogUserService blogUserService;

//    @Autowired
//    private CustomUserDetailService userDetailService;

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailService);
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/selectCursor").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/inserts").permitAll()
                .antMatchers("/updates").permitAll()
                .antMatchers("/app/**").permitAll() // to test interceptor
                .antMatchers("/mongodb/**").permitAll() // to test mongoDB
                .antMatchers("/indexer/**").permitAll() // to test mongoDB
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .loginProcessingUrl("/toLogin")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Bean
    @Override // 这个方法里的 username 是在哪里传进来的？
    public UserDetailsService userDetailsService() {
        return username -> {
            BlogUser user = blogUserService.findOneByUsername(username);
            String pwd = user.getPassword();
            if(pwd == null){
                throw new UsernameNotFoundException("username not exist");
            }
//            PasswordEncoder pwdEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//            String pwdAfterEncoder = pwdEncoder.encode(pwd);

            UserDetails ud = User.withUsername(username).password(pwd).roles("ROLE").build();
            request.getSession().setAttribute("blogUser", user);
            return ud;
        };
    }
}
