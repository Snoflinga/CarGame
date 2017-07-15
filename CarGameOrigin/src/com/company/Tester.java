package com.company;

/**
 * Created by pernilla on 2017-04-28.
 */
public class Tester {
    public static void main(String[] args) {
        Car car = new Car(10);
        car.drive(13);
        System.out.println(car.getTripMeter());
        car.drive(3);
        System.out.println(car.getTripMeter());
        System.out.println(car.getGasInTank());
    }
}
