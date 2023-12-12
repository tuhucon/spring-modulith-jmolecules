package com.example.springmodulithjmolecules.product;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.product.appcore.domain.model.Product;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductPriceUpdatedEvent;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.AssertablePublishedEvents;
import org.springframework.modulith.test.PublishedEvents;

@ApplicationModuleTest
public class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void verifyProductPriceUpdatedEvent(AssertablePublishedEvents events) {
        Product p = new Product();
        p.setName("test product");
        p.setDescription("test description");
        p.updatePrice(new Money(10.00));
        productRepository.save(p);
        Assertions.assertThat(events)
                .contains(ProductPriceUpdatedEvent.class)
                .matching(ProductPriceUpdatedEvent::getSource, p);
    }

}
