package com.example.springmodulithjmolecules.product.appcore.service;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.product.appcore.domain.model.Product;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductRepository;
import com.example.springmodulithjmolecules.product.presentation.ProductController;
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
