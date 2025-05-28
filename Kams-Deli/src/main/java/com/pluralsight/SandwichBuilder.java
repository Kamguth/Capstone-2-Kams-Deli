package com.pluralsight;

import java.util.Scanner;

public class SandwichBuilder {
    public static Sandwich buildSandwich() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();

        System.out.print("Choose bread (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine();

        System.out.print("Would you like it toasted? (y/n): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // === MEAT SELECTION ===
        String[] availableMeats = {
                "steak", "ham", "salami", "roast beef", "chicken", "bacon"
        };

        System.out.println("Add meats (type one at a time, type 'done' when finished):");
        for (String meat : availableMeats) {
            System.out.println("- " + meat);
        }

        while (true) {
            System.out.print("Enter meat (or 'done'): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) break;

            boolean valid = false;
            for (String meat : availableMeats) {
                if (meat.equalsIgnoreCase(input)) {
                    System.out.print("Is this extra meat? (y/n): ");
                    boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
                    sandwich.addMeat(new Topping(input, "meat", isExtra));
                    valid = true;
                    break;
                }
            }

            if (!valid) System.out.println("Invalid meat. Try again.");
        }

        // === CHEESE SELECTION ===
        String[] availableCheeses = {
                "american", "provolone", "cheddar", "swiss"
        };

        System.out.println("Add cheeses (type one at a time, type 'done' when finished):");
        for (String cheese : availableCheeses) {
            System.out.println("- " + cheese);
        }

        while (true) {
            System.out.print("Enter cheese (or 'done'): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) break;

            boolean valid = false;
            for (String cheese : availableCheeses) {
                if (cheese.equalsIgnoreCase(input)) {
                    System.out.print("Is this extra cheese? (y/n): ");
                    boolean isExtra = scanner.nextLine().equalsIgnoreCase("y");
                    sandwich.addCheese(new Topping(input, "cheese", isExtra));
                    valid = true;
                    break;
                }
            }

            if (!valid) System.out.println("Invalid cheese. Try again.");
        }

        // === REGULAR TOPPING SELECTION ===
        String[] availableRegulars = {
                "lettuce", "peppers", "onions", "tomatoes", "jalapeños", "cucumbers", "pickles", "guacamole", "mushrooms"
        };

        System.out.println("Add regular toppings (type one at a time, type 'done' when finished):");
        for (String topping : availableRegulars) {
            System.out.println("- " + topping);
        }

        while (true) {
            System.out.print("Enter topping (or 'done'): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) break;

            boolean valid = false;
            for (String topping : availableRegulars) {
                if (topping.equalsIgnoreCase(input)) {
                    sandwich.addRegularTopping(new Topping(input, "regular", false));
                    valid = true;
                    break;
                }
            }

            if (!valid) System.out.println("Invalid topping. Try again.");
        }

        // === SAUCE SELECTION ===
        String[] availableSauces = {
                "mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"
        };

        System.out.println("Add sauces (type one at a time, type 'done' when finished):");
        for (String sauce : availableSauces) {
            System.out.println("- " + sauce);
        }

        while (true) {
            System.out.print("Enter sauce (or 'done'): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("done")) break;

            boolean valid = false;
            for (String sauce : availableSauces) {
                if (sauce.equalsIgnoreCase(input)) {
                    sandwich.addSauce(new Topping(input, "sauce", false));
                    valid = true;
                    break;
                }
            }

            if (!valid) System.out.println("Invalid sauce. Try again.");
        }

        return sandwich;
    }
}


