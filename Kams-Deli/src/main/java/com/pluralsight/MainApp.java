package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to Kam's Deli ---");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
                    boolean ordering = true;

                    while (ordering) {
                        System.out.println("\n1) Add Sandwich");
                        System.out.println("2) Add Drink");
                        System.out.println("3) Add Chips");
                        System.out.println("4) Checkout");
                        System.out.println("0) Cancel Order");
                        System.out.print("Choice: ");
                        String orderChoice = scanner.nextLine();

                        switch (orderChoice) {
                            case "1":
                                Sandwich sandwich = SandwichBuilder.buildSandwich();
                                order.addItem(sandwich);
                                break;
                            case "2":
                                System.out.print("Enter drink size (Small/Medium/Large): ");
                                String drinkSize = scanner.nextLine();
                                order.addItem(new Drink(drinkSize));
                                break;
                            case "3":
                                order.addItem(new Chips());
                                break;
                            case "4":
                                System.out.println(order);
                                System.out.print("Confirm order? (y/n): ");
                                if (scanner.nextLine().equalsIgnoreCase("y")) {
                                    Receipt.save(order);
                                    ordering = false;
                                }
                                break;
                            case "0":
                                System.out.println("Order canceled.");
                                ordering = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Thanks for visiting DELI-cious!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

