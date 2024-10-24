package com.ps;

import java.util.Scanner;

public class UserInterface {

    private static Dealership dealership;
    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void displayScreen() {
        int command;

            do {
                System.out.println("What do you want to do?");
                System.out.println("1. search by price");
                System.out.println("2. by make/model");
                System.out.println("3. by year");
                System.out.println("4. by color");
                System.out.println("5. by milage");
                System.out.println("6. by Type");
                System.out.println("7. view all of em");
                System.out.println("8. add a vehicle");
                System.out.println("9. remove a vehicle");
                System.out.println("99. Quit");

                command = commandScanner.nextInt();

                //switch

                switch (command) {
                    case 1:
                        System.out.println("enter mimimum price: ");
                        double min = inputScanner.nextDouble();
                        System.out.println("enter your max: ");
                        double max = inputScanner.nextDouble();
                        dealership.getVehicleByPrice(min, max);
                        break;
                    case 2:
                        System.out.println("whats the make? ");
                        String make = inputScanner.nextLine();
                        System.out.println("model? ");
                        String model = inputScanner.nextLine();
                        dealership.getVehicleByMakeModel(make, model);
                        break;
                    case 3:
                        System.out.println("enter your min year: ");
                        int year1 = inputScanner.nextInt();
                        System.out.println("enter your max year: ");
                        int year2 = inputScanner.nextInt();
                        dealership.getVehicleByYear(year1, year2);
                        break;
                    case 4:
                        System.out.println("What color are you looking for? ");
                        String col = inputScanner.nextLine();
                        dealership.getVehicleByColor(col);
                        break;
                    case 5:
                        System.out.println("min Milage: ");
                        int minMilage = inputScanner.nextInt();
                        System.out.println("max Milage");
                        int maxMilage = inputScanner.nextInt();
                        dealership.getVehicleByMilage(minMilage,maxMilage);
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    default:

                }

            }
            while (command != 99);


    }


}
