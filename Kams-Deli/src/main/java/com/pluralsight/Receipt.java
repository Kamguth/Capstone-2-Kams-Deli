package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {

    public static void save(Order order) {
        // Format: yyyyMMdd-HHmmss.txt
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String fileName = "receipt-" + timestamp + ".txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(order.toString());
            writer.close();
            System.out.println("Receipt saved as: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}

