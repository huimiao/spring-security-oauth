package com.huimiao.weiboauth20demo.filter;

import com.huimiao.weiboauth20demo.SecurityProperties;
import com.huimiao.weiboauth20demo.domain.WeiboToken;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WeiboAuthentificationFilter extends AbstractAuthenticationProcessingFilter {

    private SecurityProperties securityProperties;

    private static final Logger logger = LoggerFactory.getLogger(WeiboAuthentificationFilter.class);

    private static final String CODE = "code";


    public WeiboAuthentificationFilter(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response)

        throws AuthenticationException {

        if (null == securityProperties) {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);
            securityProperties = webApplicationContext.getBean(SecurityProperties.class);
        }

        String authorize_code = request.getParameter(CODE);

        logger.info("Authorize Code is " + authorize_code);

        if (null != authorize_code) {
            WeiboToken weiboToken = getToken(String
                .format(securityProperties.getAccess_token_url(), securityProperties.getClient_id(),
                    securityProperties.getClient_security(), securityProperties.getGrant_type(),
                    authorize_code,
                    securityProperties.getRedirect_uri()));

            logger.info("Weibo Token: " + weiboToken);

            if (null != weiboToken.getAccess_token() && null != weiboToken.getUid()) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(weiboToken.getAccess_token(),
                    weiboToken.getUid());

                return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
            }
        }
        return null;
    }

    private WeiboToken getToken(String token_url) {
        logger.info(token_url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeiboToken> responseEntity = restTemplate
            .postForEntity(token_url, null, WeiboToken.class);
        WeiboToken weiboToken = responseEntity.getBody();

        return weiboToken;
    }
}
