package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<MenuItem> items = new ArrayList<>();

        public void addItem(MenuItem item) {
            items.add(item);
        }

        public double getTotalPrice() {
            return items.stream()
                    .mapToDouble(MenuItem::getPrice)
                    .sum();
        }

        @Override
        public String toString() {
            StringBuilder summary = new StringBuilder();
            summary.append("Order Summary:\n");

            for (MenuItem item : items) {
                summary.append("- ").append(item.toString()).append("\n");
            }

            summary.append("Total: $")
                    .append(String.format("%.2f", getTotalPrice()));

            return summary.toString();
        }
    }


