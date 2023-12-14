package com.example.springmodulithjmolecules.order.appcore.service;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.order.appcore.domain.model.Order;
import com.example.springmodulithjmolecules.order.appcore.domain.model.OrderCode;
import com.example.springmodulithjmolecules.order.appcore.domain.model.OrderRepository;
import com.example.springmodulithjmolecules.product.appcore.domain.model.ProductPriceUpdatedEvent;
import com.example.springmodulithjmolecules.product.appcore.service.ProductInternalAPI;
import com.fasterxml.uuid.Generators;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductInternalAPI productAPI;

    private Map<Long, Money> priceByProductIds = new ConcurrentHashMap<>();

    @Data
    public static class OrderItem {
        Long productId;
        Integer quantity;
        Double discount;
    }

    public Order createOrder(List<OrderItem> orderItems) {
        Order order = new Order(new OrderCode(Generators.timeBasedEpochGenerator().generate().toString()));
        for (OrderItem item : orderItems) {
            Money price = priceByProductIds.get(item.getProductId());
            if (price == null) {
                price = productAPI.getPriceOfProduct(item.productId);
            }
            order.addOrderItem(item.getProductId(), item.getQuantity(), price, new Money(item.getDiscount()));
        }
        order = orderRepository.save(order);
        return order;
    }

    @ApplicationModuleListener
    public void updateCachedProductPrice(ProductPriceUpdatedEvent event) {
        priceByProductIds.put(event.getProductId(), event.getPrice());
    }

}
