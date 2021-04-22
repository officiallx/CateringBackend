package org.obnoxious.controllers;

import org.obnoxious.Service.OrderService;
import org.obnoxious.entities.ApplicationUser;
import org.obnoxious.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://cateringwebsite.herokuapp.com", allowedHeaders = "*")
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @DeleteMapping("/order/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping("/order/{orderId}")
    public void updateOrder(@RequestBody Order order, @PathVariable Long orderId) {
        orderService.updateOrder(orderId, order);
    }

    @PostMapping("/order")
    public Order addOrders(@RequestBody Order order) {
       return orderService.addOrder(order);
    }
}
