package org.example.restaurantmanager.Controller;

/**
 * @author DOAN VY VY on 12/1/2024
 */

import org.example.restaurantmanager.Model.Order;
import org.example.restaurantmanager.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String kitchenDashboard(Model model) {
        List<Order> orders = orderService.getAllOrders();
        for (Order order : orders) {
            if (order.getCreatedAt() == null) {
                order.setCreatedAt(LocalDateTime.now());
            }
        }
        model.addAttribute("orders", orders);
        model.addAttribute("newOrder", new Order());
        return "kitchen";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order newOrder) {
        orderService.addOrder(newOrder);
        return "redirect:/kitchen";
    }

    @PostMapping("/update")
    public String updateOrderStatus(@RequestParam Long orderId, @RequestParam String newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
        return "redirect:/kitchen";
    }
}