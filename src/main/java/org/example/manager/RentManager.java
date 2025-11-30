package org.example.manager;

import java.util.*;
import org.example.entity.Rent;

public class RentManager {
  private final Map<String, Rent> storage = new HashMap<>();

  public void save(Rent rent) {
    storage.put(rent.getId(), rent);
  }

  public Rent find(String id) {
    return storage.get(id);
  }

  public void delete(String id) {
    storage.remove(id);
  }

  public List<Rent> findAll() {
    return new ArrayList<>(storage.values());
  }
}
