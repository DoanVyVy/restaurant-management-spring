package org.example.restaurantmanager.Service;

/**
 * @author DOAN VY VY on 12/1/2024
 */

import org.example.restaurantmanager.Model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private long nextId = 1;

    public OrderService() {
        // Add some sample orders
        addOrder(new Order(null, "Phở bò", 2, "high"));
        addOrder(new Order(null, "Bún chả", 1, "medium"));
        addOrder(new Order(null, "Gỏi cuốn", 3, "low"));
    }

    public List<Order> getAllOrders() {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getPriority)
                        .thenComparing(Order::getCreatedAt))
                .collect(Collectors.toList());
    }

    public void addOrder(Order order) {
        order.setId(nextId++);
        order.setStatus("pending");
        orders.add(order);
    }

    public void updateOrderStatus(Long id, String newStatus) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                order.setStatus(newStatus);
                return;
            }
        }
    }
}