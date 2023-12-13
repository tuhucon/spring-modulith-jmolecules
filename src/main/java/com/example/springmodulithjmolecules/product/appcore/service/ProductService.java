package com.example.springmodulithjmolecules.product.appcore.service;

import com.example.springmodulithjmolecules.product.appcore.domain.model.Product;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
