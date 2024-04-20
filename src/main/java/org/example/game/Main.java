package org.example.game;

import org.example.game.material.Material;
import org.example.game.material.MaterialType;
import org.example.game.warehouse.WarehouseSystem;

public class Main {
    public static void main(String[] args) {

        MaterialType iron =
                new MaterialType("iron","from craft equipment","img",2000);
        MaterialType stone =
                new MaterialType("stone","from craft house","img",3500);

        Material ironQuantity = new Material(iron);
        Material stoneQuantity = new Material(stone);

        WarehouseSystem warehouseSystem = new WarehouseSystem();
        warehouseSystem.createWarehouse("Bank");
        warehouseSystem.createWarehouse("Inventory");

        try {

            warehouseSystem.getWarehouse("Inventory").addMaterial(iron,1200);
            warehouseSystem.getWarehouse("Inventory").addMaterial(stone,2000);
            warehouseSystem.getWarehouse("Bank").addMaterial(iron,500);
            warehouseSystem.getWarehouse("Bank").addMaterial(stone,700);

            warehouseSystem.getWarehouse("Inventory").printWarehouseData();
            warehouseSystem.getWarehouse("Bank").printWarehouseData();

            warehouseSystem.getWarehouse("Inventory").removeMaterial(iron,200);
            warehouseSystem.getWarehouse("Inventory").printWarehouseData();

            warehouseSystem.getWarehouse("Inventory")
                    .moveInWarehouse(warehouseSystem.getWarehouse("Bank"),iron,150);
            warehouseSystem.getWarehouse("Inventory").printWarehouseData();
            warehouseSystem.getWarehouse("Bank").printWarehouseData();


        } catch (RuntimeException exp){
            System.out.println("Cannot add material because " + exp.getMessage());
        }

    }
}