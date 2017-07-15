package com.company;

/**
 * Created by pernilla on 2017-04-29.
 */
public class Car {
    private int tripMeter;
    private int speed;
    private double gasEfficiency;
    private double amountOfGas;

    public Car(int speed, int tripMeter, double amountOfGas) {
        this.tripMeter = tripMeter;
        this.speed = speed;
        this.amountOfGas = amountOfGas;
        this.gasEfficiency = getGasEfficiency();
    }
    public int getTripMeter() {
        return tripMeter;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void brake() {
        this.speed = 0;
        this.gasEfficiency = 0.01;
    }
    public double getGasAmountInTank() {
        return this.amountOfGas;
    }
    public void setGasAmountInTank(double amountOfGas) {
        this.amountOfGas += amountOfGas;
    }
    public double getGasEfficiency() {
        double speed = this.speed;
        return this.gasEfficiency = 0.1 * speed + 0.01; // för varje ökning (1) av speed ökar bränsleförbrukningen med 0.1, bränsleförbrukningen startar på 0.01
    }
    public void drive(int distance) {
        if (distance <= 0 ) {
            throw new NullPointerException("Distance must be > 0");
        } else if (this.speed <= 0) {
            throw new NullPointerException("Speed must be > 0");
        } else {
            double gasRequired = gasConsumption(distance);
            double gasInTank = getGasAmountInTank();
            if (gasInTank >= gasRequired) {
                this.amountOfGas = gasInTank - gasRequired;
                this.tripMeter += distance;
            } else {
                double actualDistance = Math.round(calculateDistanceBasedOnFuel());
                this.amountOfGas = 0;
                this.tripMeter += actualDistance;
                System.out.println("The car don't have enough gas to drive that far. It can only drive: " + actualDistance);
            }
        }
    }
    public double gasConsumption(int distance) {
        return getGasEfficiency() * distance;
    }
    public double calculateDistanceBasedOnFuel() {

        return amountOfGas / getGasEfficiency();
    }
}

