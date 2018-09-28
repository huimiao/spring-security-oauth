package com.huimiao.weiboauth20demo.config;

import com.huimiao.weiboauth20demo.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("security.properties")
@EnableConfigurationProperties(SecurityProperties.class)
public class RootConfig {

}
