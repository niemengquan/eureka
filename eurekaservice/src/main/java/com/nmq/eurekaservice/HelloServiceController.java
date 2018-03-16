package com.nmq.eurekaservice;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 聂孟泉
 * @create 2018-03-16
 * @modifyUser
 * @modifyDate
 */
@RestController
public class HelloServiceController {
    private final Logger logger=Logger.getLogger(getClass());

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        ServiceInstance seriveInstance = discoveryClient.getLocalServiceInstance();
        logger.info("/hello , host:"+seriveInstance.getHost()+"/n"+"/service_id:"+seriveInstance.getServiceId());

        return "成功访问服务";
    }
}
