package com.ps;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

    // private static Dealership dealership;

    public static Dealership getDealership() {

        Dealership dealership = null;

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
               // return dealership; // to make sure an empty dealership isn't returned
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership; // to make sure an empty dealership isn't returned
    }

    public static void saveDealership(Dealership dealership) {

        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter("testinventory.csv"))) {
            // 'true' for appending
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();
            // Write vehicle details
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());

                writer.newLine();
            }

            writer.flush();
            System.out.println("Dealership and vehicles saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}