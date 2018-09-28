package com.huimiao.qqauth20demo.filter;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;


public class QQAuthentificationFiler extends AbstractAuthenticationProcessingFilter {

    private static Pattern pattern = Pattern.compile("\"openid\":\"(.*?)\"");
    private static final Logger logger = LoggerFactory.getLogger(QQAuthentificationFiler.class);

    private static final String CODE = "code";
    private final static String accessTokenUri = "https://graph.qq.com/oauth2.0/token";

    /**
     * grant_type 由腾讯提供
     */
    private final static String grantType = "authorization_code";

    /**
     * client_id 由腾讯提供
     */
    static final String clientId = "101386962";

    /**
     * client_secret 由腾讯提供
     */
    private final static String clientSecret = "2a0f820407df400b84a854d054be8b6a";

    /**
     * redirect_uri 腾讯回调地址
     */
    private final static String redirectUri = "http://www.ictgu.cn/login/qq";

    /**
     * 获取 OpenID 的 API 地址
     */
    private final static String openIdUri = "https://graph.qq.com/oauth2.0/me?access_token=";

    /**
     * 获取 token 的地址拼接
     */
    private final static String TOKEN_ACCESS_API = "%s?grant_type=%s&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s";


    public QQAuthentificationFiler(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response)
        throws AuthenticationException, IOException, ServletException {
        String code = request.getParameter(CODE);

        logger.info("Code is " + code);

        String accessTokenApi = String.format(TOKEN_ACCESS_API, accessTokenUri, code, redirectUri);

        QQToken qqToken = getToken(accessTokenApi);

        logger.info("Token is " + JSON.toJSONString(qqToken));

        if (qqToken != null) {
            String openId = getOpenId(qqToken.getAccess_token());

            logger.info(openId);

            if (openId != null) {
                // 生成验证 authenticationToken
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                    qqToken.getAccess_token(), openId);
                // 返回验证结果
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }
        return null;
    }

    private QQToken getToken(String accessTokenUri) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(accessTokenUri, String.class);
        QQToken qqToken = JSON.parseObject(result, QQToken.class);

        return qqToken;
    }

    private String getOpenId(String accessToken) throws IOException {
        String url = openIdUri + accessToken;
        Document document = Jsoup.connect(url).get();
        String resultText = document.text();

        Matcher matcher = pattern.matcher(resultText);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }


    @Getter
    @Setter
    class QQToken {

        /**
         * token
         */
        private String access_token;

        /**
         * 有效期
         */
        private int expires_in;

        /**
         * 刷新时用的 token
         */
        private String refresh_token;

    }
}
