package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.repository.RentRepository;
import org.example.entity.Rent;
import org.example.exception.NotFoundException;

@Slf4j
public class RentService {

    private final RentRepository repository;

    public RentService(RentRepository repository) {
        this.repository = repository;
    }

    public Rent getRent(String id) {
        try {
            Rent rent = repository.findById(id);
            if (rent == null) {
                log.warn("Rent not found: {}", id);
                throw new NotFoundException("Rent " + id + " not found.");
            }
            return rent;
        }
        catch (Exception e) {
            log.error("Error in getRent({}): {}", id, e.getMessage(), e);
            throw e;
        }
    }

    public void addRent(Rent rent) {
        try {
            repository.save(rent);
            log.info("Rent added: {}", rent.getId());
        }
        catch (Exception e) {
            log.error("Error in addRent: {}", e.getMessage(), e);
            throw e;
        }
    }

    public void deleteRent(String id) {
        try {
            Rent rent = repository.findById(id);
            if (rent == null) {
                log.warn("Rent {} not found for deletion", id);
                throw new NotFoundException("Rent " + id + " not found.");
            }
            repository.delete(id);
            log.info("Rent deleted: {}", id);
        }
        catch (Exception e) {
            log.error("Error in deleteRent({}): {}", id, e.getMessage(), e);
            throw e;
        }
    }
}
