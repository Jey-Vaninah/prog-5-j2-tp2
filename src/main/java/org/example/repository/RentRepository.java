package org.example.repository;

import org.example.entity.Rent;
import org.example.manager.RentManager;

public class RentRepository {
    private final RentManager manager = new RentManager();

    public Rent findById(String id) {
        return manager.find(id);
    }

    public void save(Rent rent) {
        manager.save(rent);
    }

    public void delete(String id) {
        manager.delete(id);
    }
}
