package com.company;

/**
 * Created by pernilla on 2017-04-28.
 */
public class Car {
    private float gasInTank;
    private int speedometer;
    private int tripMeter;
    private float fuelEfficiency;

    public Car (){
        this.gasInTank = 0;
        this.speedometer = 0;
        this.tripMeter = 0;
        this.fuelEfficiency = 0.8f;
    }
    public Car (int gasInTank){
        this.gasInTank = gasInTank;
        this.tripMeter = 0;
        this.fuelEfficiency = 0.8f;
    }
    public void refuelTank (){
        this.gasInTank = 100;
    }
    public void drive (int distance) {
        if (gasInTank <= 0) { // TODO where should the question to refuel be?
            System.out.println("Oh, no the fuel tank is empty.");
        } else {
            for (int i = 0; i < distance; i += 1) {
                float result = gasInTank - (fuelEfficiency * 1);
                if (result <= 0) {
                    System.out.println("Oh, no the fuel tank is empty. You drove " + i + " km out of " + distance + "km");
                    break;
                } else {
                    gasInTank = result;
                    this.tripMeter += 1;
                }
            }
        }
    }

    public double getGasInTank() {
        return gasInTank;
    }

    public int getTripMeter() {
        return tripMeter;
    }

    public int getSpeedometer() {
        return speedometer;
    }

    public void setFuelEfficiency(float _fuelEfficiency) {
        this.fuelEfficiency = _fuelEfficiency;
    }
    // public String statusAll(){


}
