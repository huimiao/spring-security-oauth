package com.huimiao.qqauth20demo.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huimiao.qqauth20demo.domin.QQUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class QQAuthenticationManager implements AuthenticationManager {

    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    /**
     * 获取 QQ 登录信息的 API 地址
     */
    private final static String userInfoUri = "https://graph.qq.com/user/get_user_info";

    /**
     * 获取 QQ 用户信息的地址拼接
     */
    private final static String USER_INFO_API = "%s?access_token=%s&oauth_consumer_key=%s&openid=%s";


    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_SUER"));
    }

    @Override
    public Authentication authenticate(Authentication auth)
        throws AuthenticationException {
        if (auth.getName() != null && auth.getCredentials() != null) {
            QQUser user = getUserInfo(auth.getName(), (String) (auth.getCredentials()));
            return new UsernamePasswordAuthenticationToken(user,
                null, AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    private QQUser getUserInfo(String token, String openId) {
        String url = String.format(USER_INFO_API, userInfoUri, token, openId);
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException("Cannot get user information.");
        }

        String resultText = document.text();
        JSONObject json = JSON.parseObject(resultText);

        QQUser user = new QQUser();
        user.setNickname(json.getString("nickname"));
        user.setGender(json.getString("gender"));
        user.setProvince(json.getString("province"));
        user.setYear(json.getString("year"));
        //user.setAvatar(json.getString("figureurl_qq_2"));

        return user;
    }
}
