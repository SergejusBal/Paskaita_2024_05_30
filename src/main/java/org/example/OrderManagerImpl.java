package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderManagerImpl implements OrderManager {
    private List<Order> orders;

    public OrderManagerImpl() {
        this.orders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) return;
        if (orders.stream().noneMatch(o -> o.getId() == order.getId())) orders.add(order);
    }

    @Override
    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orders.stream()
                .filter(order -> order.getId() == orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getOrdersByCustomer(String customerId) {
        return orders.stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    @Override
    public double calculateTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
    }

    @Override
    public boolean updateOrderStatus(int orderId, String status) {
        Order order = getOrderById(orderId);
        if (order != null) {
            order.setStatus(status);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> filterOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersAboveCertainValue(double value) {
        return orders.stream()
                .filter(order -> order.getAmount() > value)
                .collect(Collectors.toList());
    }
}
