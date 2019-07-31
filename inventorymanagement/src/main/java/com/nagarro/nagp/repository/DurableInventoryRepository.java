package com.nagarro.nagp.repository;

import com.nagarro.nagp.Inventory;

public class DurableInventoryRepository {
    public void save(final Inventory inventory) {
        RepositoryHelper.saveDurable(inventory);
    }
}
