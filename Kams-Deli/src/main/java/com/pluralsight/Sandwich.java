package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends MenuItem {
    private String size;          // "4\"", "8\"", "12\""
    private String breadType;     // "white", "wheat", "rye", "wrap"
    private boolean toasted;

    private List<Topping> meats = new ArrayList<>();
    private List<Topping> cheeses = new ArrayList<>();
    private List<Topping> regularToppings = new ArrayList<>();
    private List<Topping> sauces = new ArrayList<>();

    public Sandwich(String size, String breadType, boolean toasted) {
        super(size + " Sandwich");
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    //Add toppings
    public void addMeat(Topping topping) {
        meats.add(topping);
    }

    public void addCheese(Topping topping) {
        cheeses.add(topping);
    }

    public void addRegularTopping(Topping topping) {
        regularToppings.add(topping);
    }

    public void addSauce(Topping topping) {
        sauces.add(topping);
    }

    //Calculate total price
    @Override
    public double getPrice() {
        double basePrice = getBasePrice();

        double meatPrice = meats.stream().mapToDouble(t -> t.getPrice(size)).sum();
        double cheesePrice = cheeses.stream().mapToDouble(t -> t.getPrice(size)).sum();

        return basePrice + meatPrice + cheesePrice;
    }

    private double getBasePrice() {
        switch (size) {
            case "4\"": return 5.50;
            case "8\"": return 7.00;
            case "12\"": return 8.50;
            default: return 0.0;
        }
    }

    //Display details
    @Override
    public String toString() {
        return size + " sandwich on " + breadType +
                (toasted ? " (Toasted)" : "") +
                "\nMeats: " + listToString(meats) +
                "\nCheeses: " + listToString(cheeses) +
                "\nToppings: " + listToString(regularToppings) +
                "\nSauces: " + listToString(sauces) +
                "\nPrice: $" + String.format("%.2f", getPrice());
    }

    private String listToString(List<Topping> list) {
        return list.stream()
                .map(Topping::toString)
                .reduce((a, b) -> a + ", " + b)//combines all strings w a comma between all
                .orElse("None");
    }
}
