package com.ps;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

   // private static Dealership dealership;

    public Dealership getDealership() {

        Dealership dealership;

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.csv"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] dealershipDetails = line.split("\\|");
                String name = dealershipDetails[0];
                String address = dealershipDetails[1];
                String phone = dealershipDetails[2];
                dealership = new Dealership(name, address, phone);

                // now vehicles loading

                while ((line = reader.readLine()) != null) {
                    // data is vehicle's data
                    String[] data = line.split("\\|");
                    if (data.length == 8) {
                        int vin = Integer.parseInt(data[0]);
                        int year = Integer.parseInt(data[1]);
                        String make = data[2];
                        String model = data[3];
                        String vehicleType = data[4];
                        String color = data[5];
                        int odometer = Integer.parseInt(data[6]);
                        double price = Double.parseDouble(data[7]);

                        // Create a new Vehicle object
                        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                        vehicles.add(vehicle);
                    }
                }
                reader.close();
                dealership.setInventory(vehicles); // may have to change it position
                return dealership; // to make sure an empty dealership isn't returned
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // to make sure an empty dealership isn't returned
    }

    public static void saveDealership(Dealership newDealership) {
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter("testinventory.csv", true))) {
            // 'true' for appending
            writer.write(newDealership.getName() + "|" + newDealership.getAddress() + "|" + newDealership.getPhone());
            writer.close();
            // writer.newLine(); // Add a new line after writing

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* public void loadInventory(){
       ArrayList<Vehicle> vehicles = new ArrayList<>();

       try (

           BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {
           String line;
           while ((line = br.readLine()) != null) {
               // Assuming the file format is "make,model,year,price"
               String[] data = line.split("\\|");
               if (data.length == 8) {
                   int vin = Integer.parseInt(data[0]);
                   int year = Integer.parseInt(data[1]);
                   String make = data[2];
                   String model = data[3];
                   String vehicleType = data[4];
                   String color = data[5];
                   int odometer = Integer.parseInt(data[6]);
                   double price = Double.parseDouble(data[7]);

                   // Create a new Vehicle object
                   Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer,  price);
                   vehicles.add(vehicle);
               }
           }
       } catch (IOException e) {
           System.out.println("Error loading inventory: " + e.getMessage());
       }


   }
*/
    public void saveInventory() {

    }

    public void removeFromInventory() {

    }


}