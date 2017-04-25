package cn.joylau.cloud.eureka.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JoyLau on 4/14/2017.
 * cn.joylau.cloud.eureka.service
 * fa.liu@gtafe.com
 */
@Controller
public class HandlerController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    @ResponseBody
    public String add() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/info, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello , 您访问的主机是"+ instance.getHost() + instance.getPort() + "service_id是"+instance.getServiceId();
    }
}
