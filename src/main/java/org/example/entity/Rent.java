package org.example.entity;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class Rent {
  private final String id;
  private final Client client;
  private final List<RentalItem> rentalItems;
  private final LocalDate startDate;
  private final LocalDate endDate;

  public double getTotalRentalPrice() {
    return rentalItems.stream()
        .mapToDouble(item -> item.calculateTotalDue(startDate, endDate))
        .sum();
  }
}
