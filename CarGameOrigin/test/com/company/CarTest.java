package com.company;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by pernilla on 2017-04-28.
 */
public class CarTest extends TestCase {

    @Test
    public void testThatTheCarAreNotMovingWhenCreated() {
        Car car = new Car();

        assertEquals(0, car.getTripMeter());
        assertEquals(0, car.getSpeedometer());
        assertEquals("Gas needs to be empty", 0.0, car.getGasInTank());
    }

    @Test
    public void testCreateCarWithGasInTank() {
        Car car = new Car(400);

        assertEquals(400.0, car.getGasInTank());
    }

    @Test
    public void testCheckThatTheCarOnlyGoesUntilTheTankIsEmpty() {

        // Assign
        Car car = new Car(10); // 100L
        car.setFuelEfficiency(0.8f); // 0.8L/mil

        // Act
        car.drive(20); // 200 mil

        // Assert
        assertTrue( car.getGasInTank() >= 0 );
        assertEquals(12, car.getTripMeter());
        assertTrue("Can´t compute ",Math.abs(0.4 - car.getGasInTank()) < 0.01);

    }

    @Test
    public void testCheckThatTripMeterEqualsTheDistanceDrivenWithEnoughFuel() {
        Car car = new Car(200);
        car.setFuelEfficiency(0.8f);
        car.drive(50);

        assertEquals(50, car.getTripMeter());
        assertTrue(Math.abs(160 - car.getGasInTank()) < 0.01);

    }
}