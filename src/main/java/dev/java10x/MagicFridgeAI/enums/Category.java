package dev.java10x.MagicFridgeAI.enums;

public enum Category {

    FRUITS("Frutas"),
    VEGETABLES("Vegetais"),
    GRAINS("Grãos e Cereais"),
    PROTEINS("Proteínas"),
    DAIRY("Laticínios"),
    SWEETS("Doces"),
    SNACKS("Aperitivos"),
    CONDIMENTS("Condimentos"),
    BEVERAGES("Bebidas"),
    OTHERS("Outros");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
