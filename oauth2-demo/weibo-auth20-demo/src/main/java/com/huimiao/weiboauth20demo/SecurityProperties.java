package com.huimiao.weiboauth20demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "security.weibo")
@Data
public class SecurityProperties {

    private String client_id;
    private String client_security;
    private String access_token_url;
    private String grant_type;
    private String redirect_uri;
    private String user_info_url;
    private String default_filter_processes_url;
}
