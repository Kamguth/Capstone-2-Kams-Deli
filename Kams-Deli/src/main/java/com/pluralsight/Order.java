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
        //interesting code
        @Override
        public String toString() {
            StringBuilder summary = new StringBuilder(); //.append adding to StringBuilder
            summary.append("Order Summary:\n");

            for (MenuItem item : items) { //loops thru every item and adds -
                summary.append("- ").append(item.toString()).append("\n");
            }

            summary.append("Total: $")
                    .append(String.format("%.2f", getTotalPrice()));

            return summary.toString();

            //Order Summary:
            //- 8" Sandwich on wheat (Toasted) ...
            //- Medium Drink - $2.50
            //- Chips - $1.50
            //Total: $15.25
        }
    }


