package org.example.entity;

import java.time.LocalDate;

public interface Rental {
  String getId();

  String getName();

  double getRentalValue();

  double calculateTotalDue(LocalDate startDate, LocalDate endDate, double quantity);
}
