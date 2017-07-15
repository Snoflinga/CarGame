package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Car car = new Car(500);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Car Game. What would you like to do?");
        while (true){
            System.out.println("Print the command you want the car to preform:");
            System.out.println("Drive");
            System.out.println("Brake");
            switch (input.next().toLowerCase()){
                case "drive": System.out.println("How far would you like to drive?");
                    System.out.println("Type distance in km with whole integers");
                    car.drive(input.nextInt());
                    break;

                case "brake":
                    break;

                default: break;

            }
        }
        // distance should be in km
        // kan jag göra en switch med case för olika funktioner tex att switchen baseras på input. Sträng med horn - tuta, sträng med break - bromsa, osv???
    }
}
