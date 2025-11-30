package org.example;

import java.time.LocalDate;
import java.util.List;
import org.example.controller.RentController;
import org.example.entity.*;
import org.example.repository.RentRepository;
import org.example.service.RentService;

public class Main {
  public static void main(String[] args) {
    RentController controller = new RentController(new RentService(new RentRepository()));

    List<Client> clients =
        List.of(new Client("C1", "Vaninah"), new Client("C2", "Jey"), new Client("C3", "Rakoto"));

    List<AbstractRental> rentals =
        List.of(
            new AbstractRental("V1", "Car", 5000),
            new AbstractRental("C1", "Chair", 3000),
            new AbstractRental("H1", "House", 300_000));

    RentalItem rentalItemVaninah = new RentalItem(rentals.get(0), 2);
    Rent rentVaninah =
        new Rent(
            "R1",
            clients.get(0),
            List.of(rentalItemVaninah),
            LocalDate.now(),
            LocalDate.now().plusDays(3));
    controller.addRent(rentVaninah);
    System.out.println("Total price for Vaninah: " + rentVaninah.getTotalRentalPrice() + " AR");

    Money moneyJey = new Money("M1", "Loan Money", 5);
    RentalItem rentalItemJey = new RentalItem(moneyJey, 50_000);
    Rent rentJey =
        new Rent(
            "R2",
            clients.get(1),
            List.of(rentalItemJey),
            LocalDate.now(),
            LocalDate.now().plusDays(5));
    controller.addRent(rentJey);
    System.out.println("Total price for Jey: " + rentJey.getTotalRentalPrice() + " AR");

    RentalItem rentalChairs = new RentalItem(rentals.get(1), 40);
    RentalItem rentalHouse = new RentalItem(rentals.get(2), 1);
    Money bigMoney = new Money("M2", "Money", 5);
    RentalItem rentalMoney = new RentalItem(bigMoney, 20_000_000.0);

    Rent rentRakoto =
        new Rent(
            "R3",
            clients.get(2),
            List.of(rentalChairs, rentalHouse, rentalMoney),
            LocalDate.now(),
            LocalDate.now().plusMonths(4));
    controller.addRent(rentRakoto);
    System.out.println("Total price for Rakoto: " + rentRakoto.getTotalRentalPrice() + " AR");
  }
}
