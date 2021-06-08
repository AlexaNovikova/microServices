package ru.geekbrains.hystrix.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.geekbrains.common.ProductDto;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient

public class HystrixApplication {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @HystrixCommand
    @GetMapping("/showProducts")
    public List<ProductDto> showAllProducts() {
        List<ProductDto> result = restTemplate.getForObject("http://eureka-client/products", ArrayList.class);
        return result;
    }

    @HystrixCommand
    @GetMapping("/abc")
    public ProductDto demo2() {
        ProductDto result = restTemplate.getForObject("http://eureka-client/abc", ProductDto.class);
        return result;
    }

    @HystrixCommand
    @GetMapping("/abcd")
    public String demo3() {
       String result = restTemplate.getForObject("http://eureka-client/abcd", String.class);
        return result;
    }
}
