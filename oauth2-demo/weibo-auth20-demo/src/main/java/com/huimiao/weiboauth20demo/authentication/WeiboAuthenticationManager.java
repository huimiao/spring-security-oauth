package com.huimiao.weiboauth20demo.authentication;

import com.huimiao.weiboauth20demo.domain.WeiboUser;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.client.RestTemplate;

public class WeiboAuthenticationManager implements AuthenticationManager {

    private static final Logger logger = LoggerFactory.getLogger(WeiboAuthenticationManager.class);
    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();
    private String userInfoUrl;

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public WeiboAuthenticationManager(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    @Override
    public Authentication authenticate(Authentication auth) {
        if (auth.getName() != null && auth.getCredentials() != null) {
            WeiboUser user = getUserInfo(auth.getName(), (String) (auth.getCredentials()));

            logger.info("User Info is " + user);
            return new UsernamePasswordAuthenticationToken(user,
                null, AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    private WeiboUser getUserInfo(String access_token, String uid) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeiboUser> responseEntity = restTemplate
            .getForEntity(String
                .format(userInfoUrl,
                    access_token, uid), WeiboUser.class);
        WeiboUser weiboUserInfo = responseEntity.getBody();

        return weiboUserInfo;
    }
}
