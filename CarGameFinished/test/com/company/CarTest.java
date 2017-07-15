package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pernilla on 2017-04-29.
 */
public class CarTest  {
    @Test
    public void testCreateCarWithParametersSpeedTripMeterAmountOfGasHasInitzialValues(){
        Car car = new Car(0, 0, 100);
        assertEquals(100.0, car.getGasAmountInTank(),0.01);
        assertEquals(0, car.getSpeed());
        assertEquals(0, car.getTripMeter());
        assertEquals(0.01, car.getGasEfficiency(), 0.01);
    }

    @Test
    public void testIfSpeedUpChangeSpeedAndGasEfficiency(){
        Car car = new Car( 0, 0, 100);
        assertEquals(0.01, car.getGasEfficiency(), 0.01);
        car.setSpeed(50);
        assertEquals(50, car.getSpeed());
        assertEquals(5.01, car.getGasEfficiency(), 0.01);

    }

    @Test
    public void testBrakeIfChangeSpeedAndGasEfficiency(){
        Car car = new Car( 10, 0, 100);
        assertEquals(10, car.getSpeed());
        assertEquals(1.01, car.getGasEfficiency(), 0.01);
        car.brake();
        assertEquals(0, car.getSpeed());
        assertEquals(0.01, car.getGasEfficiency(), 0.01);
    }

   @Test
    public void testDriveChangeTripMeterAndGasInTank() {
        Car car = new Car( 1, 0, 100);
        car.drive(50);
        assertEquals(50, car.getTripMeter());
        assertEquals(94.5, car.getGasAmountInTank(), 0.01);
    }

    @Test
    public void testCarDontDriveWithEmptyGasTankDrivesUntilTankIsEmpty(){
        Car car = new Car( 11, 0, 5);
        car.drive(100);
        assertTrue("Can´ drive on empty gas tank", car.getGasAmountInTank() >= 0);
        assertEquals(5, car.getTripMeter());
    }
     @Test(expected=NullPointerException.class)
    public void testAddingNegativeNumberInDriveMethod () {
        Car car = new Car( 10, 0, 100);
        car.drive(-1);
    }
    @Test (expected=NullPointerException.class)
    public void testDrivingWith0Speed (){
        Car car = new Car(0,0,100);
        car.drive(10);
    }


}