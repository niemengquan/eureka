package com.nmq.eurekaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 聂孟泉
 * @create 2018-03-16
 * @modifyUser
 * @modifyDate
 */
@RestController
public class DiscoveryService {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/discovery")
    private String doDiscoveryService(){
        StringBuilder sb=new StringBuilder();
        List<String> serviceIds = discoveryClient.getServices();
        for(String serviceId:serviceIds){
            System.out.println(serviceId);
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
            if(!CollectionUtils.isEmpty(serviceInstances)){
                for(ServiceInstance si:serviceInstances){
                    sb.append("["+si.getServiceId() +" host=" +si.getHost()+" port="+si.getPort()+" uri="+si.getUri()+"]");
                }
            }else{
                sb.append("no service.");
            }
        }
        return sb.toString();
    }
}
