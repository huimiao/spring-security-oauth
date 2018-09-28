package com.huimiao.clientcredentials.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPoints {

    @GetMapping(value = "/product/{id}")
    public String getProduct(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Product id " + id;
    }

    @GetMapping(value = "/order/{id}")
    public String getOrder(@PathVariable String id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Order id " + id;
    }

}
