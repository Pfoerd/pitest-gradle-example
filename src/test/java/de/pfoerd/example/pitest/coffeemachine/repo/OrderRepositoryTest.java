package de.pfoerd.example.pitest.coffeemachine.repo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderRepositoryTest {
  private static final Order MOCHA = new Order("mocha", of(2024, 1, 12));
  private static final Order LATTE = new Order("cappuccino", of(2024, 3, 25));
  private static final Order COFFEE     = new Order("coffee", of(2023, 12, 24));
  private static final Order ESPRESSO   = new Order("espresso", of(2023, 11, 11));

  @Test
  public void testFindRecentOrders() {
    // given
    OrderRepository repository = new OrderRepository();
    LocalDate minOrderDate = of(2024,1,1);

    // when
    List<Order> result = repository.findRecentOrders(minOrderDate,
        List.of(MOCHA, LATTE, COFFEE, ESPRESSO));

    // then
    assertThat(result).hasSize(2);
    assertThat(result).contains(MOCHA, LATTE);
  }
}