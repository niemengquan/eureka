package com.nmq.hellocustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 聂孟泉
 * @create 2018-03-16
 * @modifyUser
 * @modifyDate
 */
@RestController
public class CustomerController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello-customer")
    public String helloController(){
        return restTemplate.getForEntity("http://service-hi/hello",String.class).getBody();
    }

    @GetMapping("/login-customer")
    public String loginController(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "nimeq");
        map.put("password", "123456");
        return restTemplate.getForEntity("http://service-hi/login?name={name}&password={password}",String.class,map).getBody();
    }
}
