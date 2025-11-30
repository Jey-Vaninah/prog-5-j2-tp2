package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Rent;
import org.example.service.RentService;

@Slf4j
public class RentController
{

    private final RentService service;

    public RentController(RentService service)
    {
        this.service = service;
    }

    public void addRent(Rent rent)
    {
        service.addRent(rent);
        log.info("Rent added: {}", rent.getId());
    }

    public void getRent(String id)
    {
        Rent rent = service.getRent(id);

        if (rent != null)
        {
            log.info("Result: {}", rent);
        }
        else
        {
            log.warn("Error: Rent {} not found.", id);
        }
    }

    public void deleteRent(String id)
    {
        Rent rent = service.getRent(id);

        if (rent != null)
        {
            service.deleteRent(id);
            log.info("Rent deleted: {}", id);
        }
        else
        {
            log.warn("Error: Rent {} not found.", id);
        }
    }
}
