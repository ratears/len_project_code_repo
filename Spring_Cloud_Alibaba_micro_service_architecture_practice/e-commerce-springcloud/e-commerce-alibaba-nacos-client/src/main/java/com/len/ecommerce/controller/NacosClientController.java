package com.len.ecommerce.controller;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.len.ecommerce.service.NacosClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>Nacos Client Controller</h1>
 */
@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    @Autowired
    private NacosClientService nacosClientService;

    /**
     * <h2>根据 serviceId 获取服务所有实例</h2>
     * @param serviceId
     * @return
     */
    @GetMapping("service-instance")
    public List<ServiceInstance> logNacosClientInfo(@RequestParam(defaultValue = "e-commerce-nacos-client") String serviceId){
        log.info("coming in log Nacos Client info [{}]",serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }


}
