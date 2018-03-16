package com.nmq.eurekaservice;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 聂孟泉
 * @create 2018-03-16
 * @modifyUser
 * @modifyDate
 */
@RestController
public class LoginServiceController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name,@RequestParam("password") String password){
        System.out.println("logon name:"+name+",password:"+password);
        return "name:"+name+",登录成功";
    }
}
