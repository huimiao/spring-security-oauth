package com.huimiao.weiboauth20demo.mvc;

import com.huimiao.weiboauth20demo.SecurityProperties;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeiboController {

    @Autowired
    private SecurityProperties securityProperties;

    @GetMapping("/")
    public Object getUserInfo(Principal principal){
        return  principal;
    }

    @GetMapping("/test")
    public SecurityProperties getSecurityProperties(){
        return securityProperties;
    }
}
