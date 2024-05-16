package de.pfoerd.example.pitest.coffeemachine.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

  public List<Order> findRecentOrders(LocalDate minOrderDate, List<Order> orders) {
    List<Order> result = new ArrayList<>();

    for (Order order : orders) {
      if (order.date().compareTo(minOrderDate) >= 0) {
        result.add(order);
      }
    }

    return result;
  }
}
