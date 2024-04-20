package org.example.game.warehouse;

import java.util.HashMap;
import java.util.Map;

public class WarehouseSystem {
    private final Map<String,Warehouse> warehouse;

    public WarehouseSystem() {
        warehouse = new HashMap<>();
    }

    public Map<String, Warehouse> getWarehouses() {
        return warehouse;
    }

    public Warehouse getWarehouse(String name) {
        return warehouse.get(name);
    }

    public void createWarehouse(String warehouseName){
        warehouse.put(warehouseName,new Warehouse(warehouseName));
    }


}
