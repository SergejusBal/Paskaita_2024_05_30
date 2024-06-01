package org.example;

import java.util.List;

public interface OrderManager {
    void addOrder(Order order);
    void removeOrder(int orderId);
    Order getOrderById(int orderId);
    List<Order> getOrdersByCustomer(String customerId);
    double calculateTotalRevenue();
    boolean updateOrderStatus(int orderId, String status);
    List<Order> filterOrdersByStatus(String status);
    List<Order> getOrdersAboveCertainValue(double value);
}