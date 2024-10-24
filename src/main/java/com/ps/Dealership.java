package com.ps;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<>();

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

    public void getVehicleByPrice(double minPrice, double maxPrice){
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice()>minPrice && vehicle.getPrice()>maxPrice)
                System.out.println(vehicle);

        }

    }
    public void getVehicleByMakeModel(String make, String model){
        for(Vehicle vehicle : inventory) {
            if(make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()))
                System.out.println(vehicle);
        }
    }
    public void getVehicleByYear(int minYear, int maxYear){
        for(Vehicle vehicle :inventory)
            if(vehicle.getYear()>minYear && vehicle.getYear()<maxYear)
                System.out.println(vehicle);

    }
    public void getVehicleByColor(String color){

    }

    public void getVehicleByMilage(int minMile, int maxMile){

    }

    public void getVehicleByType(String vehicleType){

    }

    public void getAllVehicles(){

    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);

    }


}
