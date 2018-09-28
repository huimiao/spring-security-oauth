package com.huimiao.weiboauth20demo.config;

import com.huimiao.weiboauth20demo.SecurityProperties;
import com.huimiao.weiboauth20demo.authentication.WeiboAuthenticationManager;
import com.huimiao.weiboauth20demo.filter.WeiboAuthentificationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.weibo.default_filter_processes_url}")
    private String default_filter_processes_url;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").authenticated();

        http.addFilterAt(getWeiboAuthentificationFiler(),
            UsernamePasswordAuthenticationFilter.class);

    }

    private WeiboAuthentificationFilter getWeiboAuthentificationFiler() {
        WeiboAuthentificationFilter weiboAuthentificationFiler = new WeiboAuthentificationFilter(
            default_filter_processes_url);
        weiboAuthentificationFiler.setAuthenticationManager(
            new WeiboAuthenticationManager(securityProperties.getUser_info_url()));

        return weiboAuthentificationFiler;
    }
}
