package com.example.springmodulithjmolecules.product.presentation;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.product.appcore.domain.model.Product;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @Data
    public static class UpdatePriceBody {
        Double price;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products/{id}/updatePrice")
    public Product updatePrice(@PathVariable Long id, @RequestBody UpdatePriceBody priceBody) {
        Product p = productRepository.findById(id).get();
        p.updatePrice(new Money(priceBody.getPrice()));

        p = productRepository.save(p);
        return p;
    }
}