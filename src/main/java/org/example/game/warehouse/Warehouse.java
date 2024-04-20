package org.example.game.warehouse;

import org.example.game.material.Material;
import org.example.game.material.MaterialType;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final String name;
    private final Map<MaterialType, Material> materials;

    public Warehouse(String name) {
        this.name = name;
        this.materials = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addMaterial(MaterialType materialType, int currentQuantity) {

        if(currentQuantity > materialType.getMaxCapacity() || currentQuantity < 0){
            throw new IllegalArgumentException("The amount of added material cannot be " +
                    "negative or exceed the maximum value");
        }
        Material material = materials.get(materialType);
        if(material == null) {
            material = new Material(materialType);
            materials.put(materialType,material);
        }

        int newQuantity = currentQuantity + material.getQuantity();
        if(newQuantity > materialType.getMaxCapacity()) {
            throw new RuntimeException("Cannot add more material ");
        }
        material.setQuantity(newQuantity);

    }

    public void removeMaterial(MaterialType materialType, int quantity)  {
        Material material = materials.get(materialType);
        if (material == null || material.getQuantity() < quantity || quantity < 0) {
            throw new RuntimeException("There are not so many items in warehouse " +
                    "or the amount of material cannot be negative");
        }
        material.setQuantity(material.getQuantity() - quantity);
    }


    public void moveInWarehouse(Warehouse warehouse, MaterialType materialType, int quantity) {
        removeMaterial(materialType, quantity);
        try {
            warehouse.addMaterial(materialType, quantity);
        } catch (RuntimeException e) {
            addMaterial(materialType, quantity);
            throw e;
        }
    }

    public int getAllMaterialQuantity(MaterialType materialType) {
        Material material = materials.get(materialType);
        if(material == null) {
            return  0;
        }
        return material.getQuantity();
    }

    public void printWarehouseData() {
        System.out.println("Warehouse Data: " + getName());
        for (Map.Entry<MaterialType, Material> entry : materials.entrySet()) {
            Material material = entry.getValue();
            System.out.println(material.toString());
        }
    }
}
