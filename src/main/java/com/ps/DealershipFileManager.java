package com.ps;
import java.io.*;
import java.io.IOException;

public class DealershipFileManager {

    Dealership dealership;

    public Dealership getDealership(){
        try (
            BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] details = line.split("\\|"); // Split by '|'
                String name = details[0];
                String address = details[1];
                String phone = details[2];
                dealership = new Dealership(name, address, phone);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv", true))) { // 'true' for appending
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine(); // Add a new line after writing
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

