package com.pluralsight;

public class Drink extends MenuItem{

    private String size; // "Small", "Medium", "Large"

    public Drink(String size) {
        super(size + " Drink");
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.0;
        }
    }

    @Override
    public String toString() {
        return size + " Drink - $" + String.format("%.2f", getPrice());
    }
}
