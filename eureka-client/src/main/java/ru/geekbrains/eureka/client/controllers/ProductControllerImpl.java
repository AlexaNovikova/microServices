package ru.geekbrains.eureka.client.controllers;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.common.ProductDto;
import ru.geekbrains.eureka.client.services.ProdService;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl {
private final ProdService productService;
    private final EurekaClient eurekaClient;

    @GetMapping("/products")
    public ArrayList<ProductDto> getAllProducts() {
        return new ArrayList<>(productService.findAll());
    }

    @GetMapping("/abc")
    public ProductDto ABC() {
        return productService.findById(1L);
    }

    @GetMapping("/demo")
    public String ABCD() {
        return "ABCD";
    }
}
