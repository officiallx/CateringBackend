package org.obnoxious.Service;

import org.obnoxious.entities.Order;
import org.obnoxious.entities.Staff;
import org.obnoxious.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder(){
        return (List<Order>) orderRepository.findAll();
    }

    public Optional<Order> getOrder(Long orderId){
        return orderRepository.findById(orderId);
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public void updateOrder(Long orderId, Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
