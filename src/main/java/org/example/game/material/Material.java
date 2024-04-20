package org.example.game.material;



public class Material {
    private final MaterialType materialType;
    private int quantity;

    public Material(MaterialType materialType) {
        this.materialType = materialType;
        this.quantity = 0;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialType=" + materialType.getName() +
                ", quantity=" + quantity +
                '}';
    }

}
