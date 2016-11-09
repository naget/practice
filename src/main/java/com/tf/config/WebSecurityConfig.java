package com.tf.config;

import com.tf.server.ServerImp.UserServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by t on 2016/10/22.
 */
@Configuration
@EnableWebSecurity
//通过@EnableWebMvcSecurity注解开启Spring Security的功能
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    UserDetailsService customUserServer(){
        return new UserServer();
    }
    //继承WebSecurityConfigurerAdapter，并重写它的方法来设置一些web安全的细节
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserServer());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/hello",true)
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }
    //configure(HttpSecurity http)方法
//    通过authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
// 例如以上代码指定了/和/home不需要任何认证就可以访问，其他的路径都必须通过身份验证。
//    通过formLogin()定义当需要用户登录时候，转到的登录页面。


}
