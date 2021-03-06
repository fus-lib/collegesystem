package com.collegesystem.web.controller;

import com.collegesystem.web.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SignController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/signup")
    @ResponseBody
    public String signUp(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "password") String password){
        System.out.println("注册");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9000/account-svc/v1/account/create";

        Map<String,String> map = new HashMap<>();
        map.put("email",email);
        map.put("password", password);
        //String result = restTemplate.getForObject(url, String.class,map);
        String result = restTemplate.postForObject(url,map, String.class);
        if("success".equalsIgnoreCase(result)){
            return "ok";
        }
        return "error";
    }
    @RequestMapping("/signup2")
    @ResponseBody
    public String signUp(Account account){
        System.out.println("注册");
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "http://localhost:9000/account-svc/v1/account/create";
        HttpEntity<Account> body = new HttpEntity<>(account);
        //String result = restTemplate.getForObject(url, String.class,map);
        String result = restTemplate.postForObject(url,body, String.class);
        if("success".equalsIgnoreCase(result)){
            return "ok";
        }
        return "error";
    }
}
