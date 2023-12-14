package com.example.springmodulithjmolecules.order.presentation;

import com.example.springmodulithjmolecules.order.appcore.domain.model.Order;
import com.example.springmodulithjmolecules.order.appcore.domain.model.OrderRepository;
import com.example.springmodulithjmolecules.order.appcore.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderRepository orderRepository;

    @Data
    public static class CreateOrderBody {
        List<OrderService.OrderItem> orderItems;
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody CreateOrderBody orderBody) {
        Order order = orderService.createOrder(orderBody.getOrderItems());
        return order;
    }
}
