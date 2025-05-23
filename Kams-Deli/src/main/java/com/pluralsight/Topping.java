package com.pluralsight;

public class Topping {
    private String name;
    private String type; // "meat", "cheese", "regular", or "sauce"
    private boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type.toLowerCase(); // ensure consistency
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public String getType() {
        return type;
    }

    public double getPrice(String size) {
        double price = 0.0;

        if (type.equals("meat")) {
            if (size.equals("4\"")) price = 1.00;
            else if (size.equals("8\"")) price = 2.00;
            else if (size.equals("12\"")) price = 3.00;

            if (isExtra) {
                if (size.equals("4\"")) price += 0.50;
                else if (size.equals("8\"")) price += 1.00;
                else if (size.equals("12\"")) price += 1.50;
            }
        }

        else if (type.equals("cheese")) {
            if (size.equals("4\"")) price = 0.75;
            else if (size.equals("8\"")) price = 1.50;
            else if (size.equals("12\"")) price = 2.25;

            if (isExtra) {
                if (size.equals("4\"")) price += 0.30;
                else if (size.equals("8\"")) price += 0.60;
                else if (size.equals("12\"")) price += 0.90;
            }
        }

        return price;
    }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : ""); //Ternary Op similar to if else
    }
}


