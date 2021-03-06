package ru.geekbrains.eureka.client.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.eureka.client.models.Category;
import ru.geekbrains.eureka.client.repositories.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByTitle(String title){
        return categoryRepository.findByTitle(title);
    }
}
