package com.example;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
        inventory.put("product1", 10);
        inventory.put("product2", 20);
        inventory.put("product3", 30);
    }

    public int getInventory(String productId) {
        return inventory.getOrDefault(productId, 0);
    }

    public boolean updateInventory(String productId, int quantity) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, inventory.get(productId) + quantity);
            return true;
        }
        return false;
    }
}
