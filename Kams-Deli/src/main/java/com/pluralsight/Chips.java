package com.pluralsight;

public class Chips extends MenuItem {

    public Chips() {
        super("Chips");
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips - $1.50";
    }
}
