package com.ps;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership1 = new Dealership("dealership", "dallas, tx", "9137493313");
        UserInterface userInterface = new UserInterface(dealership1);

    }
}