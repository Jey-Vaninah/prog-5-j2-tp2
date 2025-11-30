package org.example.entity;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class RentalItem {
    private final Rental rental;
    private final double quantity;

    public double calculateTotalDue(LocalDate startDate, LocalDate endDate) {
        return rental.calculateTotalDue(startDate, endDate, quantity);
    }
}
