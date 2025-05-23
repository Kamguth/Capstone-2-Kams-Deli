package com.pluralsight;

public class Drink extends MenuItem{

    private String size;   // "Small", "Medium", or "Large"
    private String flavor; // e.g., "Cola", "Lemonade", etc.

    public Drink(String size, String flavor) {
        super(size + " " + flavor + " Drink");
        this.size = size;
        this.flavor = flavor;
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
        return size + " " + flavor + " Drink - $" + String.format("%.2f", getPrice());
    }
}
