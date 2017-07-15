package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car(0,0,100);

        Scanner input = new Scanner(System.in);

        String gameControls = "D - drive\n" +
                "B - brake\n" +
                "S - change speed\n" +
                "G - fill tank with gas\n" +
                "Q - quit game";

        boolean quit = false;

        System.out.println("Welcome to Car Game!");
        while (true) {
            String carStatus = "\nCar status\n" +
                    "Speed: " + car.getSpeed() + "\n" +
                    "Amount of gas: " + car.getGasAmountInTank() + "\n" +
                    "Trip Meter: " + car.getTripMeter() +"\n" +
                    "Gas efficiency: " + car.getGasEfficiency() + "\n";

            if (!quit) {
                Thread.sleep(2000);
                System.out.println(carStatus);
                System.out.println("What would you like to do?");
                System.out.println(gameControls);
                String userInput = input.next().toLowerCase();
                switch (userInput) {

                    case "d":
                        System.out.println("How far would you like to drive?");
                        try { // TODO check bug in drive speed 100, amount of gas 100, want to drive 100, drove 1001.0, what went wrong?
                            car.drive(input.nextInt());
                        }
                        catch (NullPointerException e){

                            System.out.println(e.getMessage());
                            break;
                        }
                        catch (InputMismatchException e){
                            System.out.println("Only integers are accepted.");
                            break;
                        }
                        if (car.getGasAmountInTank()< 1) {
                            System.out.println("You have to refuel if you want to drive anymore.");
                        }
                        break;

                    case "b": System.out.println("The car is now standing still.");
                        break;

                    case "s": System.out.println("How fast would you like to drive?");
                        car.setSpeed(input.nextInt());
                        if (car.getSpeed()> 150) {
                            System.out.println("Hmm, ever heard about speedlimits?");
                        }
                        else if (car.getSpeed()< 30) {
                            System.out.println("This car can drive faster, come on grandma' ;-)");
                        }
                        else {
                            System.out.println("Can you hear the engine humming? :-)");
                        }
                        break;

                    case "g": System.out.println("How much gas would you like to add?");
                        car.setGasAmountInTank(input.nextInt());
                        break;

                    default:
                        quit = true;
                        break;
                }
            }
            else {
                break;
            }
        }
        System.out.println("Thank you for playing Car Game!");


    }
}
