package de.adessi.feignclient;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeigenRestController {


    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private AdessiFeignInterface adessiFeignInterface;

    @GetMapping("/services")
    public String getServiceStatus() {

        Application application = eurekaClient.getApplication("adessi-mhock");
        List<InstanceInfo> instances = application.getInstances();


        return "Hostname=" + instances.get(0).getHostName() + ", Port=" + instances.get(0).getPort();
    }

    @GetMapping("/adessi/firstName")
    public String getFirstName() {
        AdessiFeignInterface target = Feign.builder().
                contract(new SpringMvcContract()).
                target(AdessiFeignInterface.class, "http://localhost:8082");

        return target.getFirstName();
    }

    @GetMapping("/adessi")
    public String getAdessi() {
        return adessiFeignInterface.getCompetenceCenter();
    }
}
