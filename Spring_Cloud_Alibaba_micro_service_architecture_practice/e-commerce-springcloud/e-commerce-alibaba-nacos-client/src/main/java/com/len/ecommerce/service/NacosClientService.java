package com.len.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NacosClientService {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * <h2>打印 Nacos Client 信息到日志中</h2>
     * @param serviceId
     * @return
     */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {
        log.info("request nacos client to get service instance info [{}]",serviceId);
        return discoveryClient.getInstances(serviceId);
    }


}
