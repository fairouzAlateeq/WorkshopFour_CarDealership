package com.ps;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static List<Vehicle> getVehicleByPrice(double minPrice, double maxPrice){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(minPrice<= vehicle.getPrice() && maxPrice>= vehicle.getPrice())
                vehicles.add(vehicle);
        }
        return vehicles;
    }
    public static List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()))
                vehicles.add(vehicle);
        }
        return vehicles;
    }
    public static List<Vehicle> getVehicleByYear(int minYear, int maxYear){
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if(vehicle.getYear()>=minYear && vehicle.getYear()<=maxYear)
                vehicles.add(vehicle);
        }
        return vehicles;
      }
    public static List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle :inventory)
            if(color.equalsIgnoreCase(vehicle.getColor()))
            {
                vehicles.add(vehicle);
            }
        return vehicles;
    }

    public static List<Vehicle> getVehicleByMilage(int minMile, int maxMile){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle :inventory)
            if(vehicle.getOdometer()>= minMile && vehicle.getOdometer()<=maxMile)
            {
                vehicles.add(vehicle);
            }
        return vehicles;
          //  if(vehicle.getOdometer()>= minMile && vehicle.getOdometer()<=maxMile)
    }

    public void getVehicleByType(String vehicleType){
        for(Vehicle vehicle :inventory)
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                System.out.println(vehicle);
    }

    public void getAllVehicles(){
        for(Vehicle vehicle :inventory)
            System.out.println(vehicle); // check to see if its returning the actual values or memo location

    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);


    }

    public void removeVehicle(int vin){
        for(Vehicle vehicle :inventory)
            if(vehicle.getVin() == vin)
                inventory.remove(vehicle);

    }

    public void setInventory(ArrayList<Vehicle> vehicles) {
        this.inventory = vehicles;
    }

}
