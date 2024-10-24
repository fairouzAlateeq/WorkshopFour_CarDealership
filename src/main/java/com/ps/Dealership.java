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

    public void getVehicleByPrice(double minPrice, double maxPrice){

    }
    public void getVehicleByMakeModel(String make, String model){

    }
    public void getVehicleByYear(int minYear, int maxYear){

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
