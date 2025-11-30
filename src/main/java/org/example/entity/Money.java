package org.example.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Money extends AbstractRental {
    private static final int MONEY_RENTAL_VALUE = 1;
    private final double interest;

    public Money(String id, String name, double interest) {
        super(id, name, getInterestRentalValue(interest));
        this.interest = interest;
    }

    private static double getInterestRentalValue(double interest) {
        return MONEY_RENTAL_VALUE + interest / 100;
    }

    @Override
    public double calculateTotalDue(LocalDate startDate, LocalDate endDate, double quantity) {
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        if (months < 1) months = 1;
        return quantity * getInterestRentalValue(interest) * months;
    }
}
