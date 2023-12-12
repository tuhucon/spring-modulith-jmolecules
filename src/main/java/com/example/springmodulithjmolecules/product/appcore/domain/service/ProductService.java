package com.example.springmodulithjmolecules.product.appcore.domain.service;

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

    public Product createProduct(ProductController.CreateProductBody productBody) {
        Product p = new Product();
        p.setName(productBody.getName());
        p.setDescription(productBody.getDescription());
        p.updatePrice(new Money(productBody.getPrice()));

        productRepository.save(p);
        return p;
    }
}
