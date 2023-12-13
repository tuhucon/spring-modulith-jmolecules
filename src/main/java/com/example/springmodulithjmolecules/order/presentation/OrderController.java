package com.example.springmodulithjmolecules.order.presentation;

import com.example.springmodulithjmolecules.common.model.Money;
import com.example.springmodulithjmolecules.order.appcore.domain.model.Order;
import com.example.springmodulithjmolecules.order.appcore.domain.model.OrderCode;
import com.example.springmodulithjmolecules.order.appcore.domain.model.OrderRepository;
import com.fasterxml.uuid.Generators;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @Data
    public static class CreateOrderBody {

        @Data
        public static class OrderItem {
            Long productId;
            Integer quality;
            Double price;
            Double discount;
        }

        List<OrderItem> orderItems;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody CreateOrderBody orderBody) {
        OrderCode orderCode = new OrderCode(Generators.timeBasedEpochGenerator().generate().toString());
        Order order = new Order(orderCode);
        for (CreateOrderBody.OrderItem item : orderBody.orderItems) {
            order.addOrderItem(item.getProductId(), item.getQuality(), new Money(item.getPrice()), new Money(item.getDiscount()));
        }

        order = orderRepository.save(order);
        return order;
    }
}
