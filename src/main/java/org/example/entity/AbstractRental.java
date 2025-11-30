package org.example.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractRental implements Rental {
  private final String id;
  private final String name;
  private final double unitRentalValue;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public double getRentalValue() {
    return unitRentalValue;
  }

  public double calculateTotalDue(LocalDate startDate, LocalDate endDate, double quantity) {
    long days = ChronoUnit.DAYS.between(startDate, endDate);
    if (days < 1) days = 1;
    return unitRentalValue * quantity * days;
  }
}
