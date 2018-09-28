package com.huimiao.qqauth20demo.config;

import com.huimiao.qqauth20demo.filter.QQAuthenticationManager;
import com.huimiao.qqauth20demo.filter.QQAuthentificationFiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager
            .createUser(User.withUsername("root").password("root").roles("USER").build());
        userDetailsManager
            .createUser(User.withUsername("anonymous").password("anonymous").roles("NONE").build());

        return userDetailsManager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasRole("USER")
            .and()
            .formLogin()
            .and()
            .httpBasic()
            .and()
            .rememberMe()
            .and()
            .csrf().disable();

        http.addFilterAt(getQQAuthentificationFiler(), UsernamePasswordAuthenticationFilter.class);
    }

    private QQAuthentificationFiler getQQAuthentificationFiler() {
        QQAuthentificationFiler qqAuthentificationFiler = new QQAuthentificationFiler("/login/qq");
        qqAuthentificationFiler.setAuthenticationManager(new QQAuthenticationManager());

        return qqAuthentificationFiler;
    }
}
