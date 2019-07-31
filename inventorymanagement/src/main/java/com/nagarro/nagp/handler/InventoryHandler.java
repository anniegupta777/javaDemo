package com.nagarro.nagp.handler;

import com.nagarro.nagp.Inventory;
import com.nagarro.nagp.domain.Category;
import com.nagarro.nagp.exception.InvalidRequestException;
import com.nagarro.nagp.repository.DurableInventoryRepository;
import com.nagarro.nagp.repository.FragileInventoryRepository;

public class InventoryHandler {

    private final FragileInventoryRepository fragileInventoryRepository;
    private final DurableInventoryRepository durableInventoryRepository;

    public InventoryHandler() {
        this.fragileInventoryRepository = new FragileInventoryRepository();
        this.durableInventoryRepository = new DurableInventoryRepository();
    }

    public Inventory createInventory(final Inventory inventory) {

        if (inventory.getCategory() == Category.FRAGILE) {
            fragileInventoryRepository.save(inventory);
        } else if (inventory.getCategory() == Category.DURABLE) {
            durableInventoryRepository.save(inventory);
        } else {
            throw new InvalidRequestException("Wrong inventory type");
        }
        return new Inventory(Category.FRAGILE);

    }
}
