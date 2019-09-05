package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {


    @Nested
    class ParkTest {
        @Test
        void ableToParkCar() throws  CannotParkVehicle{
            ParkingLot parkingLot = new ParkingLot(2, new ArrayList<>());
            Vehicle vehicle = new Vehicle("KA0123");

            try {
                parkingLot.park(vehicle);
            }
            catch (CannotParkVehicle e)
            {
                fail("Exception should not occur. pls check logic");
            }

        }
        @Test
        void notAbleToParkCar() throws CannotParkVehicle {
            ParkingLot parkingLot = new ParkingLot(2, new ArrayList<>());
            Vehicle vehicle = new Vehicle("");
            try {
                parkingLot.park(vehicle);
            }
            catch (CannotParkVehicle e)
            {
                fail("Vehicle not present");
            }
        }

    }

    @Nested
    class UnParkTest
    {
        @Test
        void ableToUnParkCar()
        {
            ParkingLot parkingLot = new ParkingLot(2, new ArrayList<>());
            Vehicle vehicle = new Vehicle("KA3503");
            try {
                parkingLot.unPark(vehicle);
            }
            catch (CannotParkVehicle e)
            {
                fail("Exception should not thrown ,please check logic");
            }
        }

        @Test
        void notAbleToUParkCarWhenVehicleNotParked() throws CannotParkVehicle {
            ParkingLot parkingLot = new ParkingLot(2, new ArrayList<>());
            Vehicle vehicle = new Vehicle("");
            try {
                parkingLot.unPark(vehicle);
            }
            catch (CannotParkVehicle e)
            {
                fail("Vehicle not present");
            }
        }

    }
}
