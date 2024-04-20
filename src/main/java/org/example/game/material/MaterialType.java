package org.example.game.material;


public class MaterialType {
    private final String name;
    private final String description;
    private final String icon;
    private final int maxCapacity;

    public MaterialType(String name, String description, String icon, int maxCapacity) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
