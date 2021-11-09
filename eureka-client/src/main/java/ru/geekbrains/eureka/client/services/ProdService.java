package ru.geekbrains.eureka.client.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.geekbrains.common.ProductDto;
import ru.geekbrains.eureka.client.models.Product;
import ru.geekbrains.eureka.client.repositories.ProductRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Component
@RequiredArgsConstructor
public class ProdService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(functionProductToDto).collect(Collectors.toList());
    }

    public ProductDto findById(Long id){
        Product product = productRepository.getOne(id);
        ProductDto productDto= new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setCategoryTitle(product.getCategory().getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    private final Function<Product, ProductDto> functionProductToDto = product -> {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryTitle(product.getCategory().getTitle());
        return productDto;
    };
}