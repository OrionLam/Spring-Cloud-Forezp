package me.sc.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceRibbonApplication.class, args );
    }
    
    /**
     * 定义一个HTTP请求客户端，返回restful数据，并且这个客户端有负载均衡的功能<br/>
     * 使用以下方法，用这个客户端调用HTTP服务器端URL
     * @see RestTemplate#getForObject(java.net.URI, Class)
     * @return restful 接口客户端 
     * @author Orion
     * 2018年12月17日
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
