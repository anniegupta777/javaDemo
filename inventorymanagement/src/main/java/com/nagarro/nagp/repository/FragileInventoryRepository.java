package com.nagarro.nagp.repository;

import com.nagarro.nagp.Inventory;

public class FragileInventoryRepository {

    public void save(final Inventory inventory) {
        RepositoryHelper.saveFragile(inventory);
    }
}
