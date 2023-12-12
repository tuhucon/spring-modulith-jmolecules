package com.example.springmodulithjmolecules.order.appcore.service;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductPriceUpdatedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {

    private Map<Long, Money> priceByProductIds = new ConcurrentHashMap<>();

    @ApplicationModuleListener
    public void updateCachedProductPrice(ProductPriceUpdatedEvent event) {
        priceByProductIds.put(event.getProductId(), event.getPrice());
    }

}
