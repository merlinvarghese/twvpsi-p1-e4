package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ParkingOwnerTest {

    @Test
    void expectNotificationWhenPArkingFull() throws CannotParkVehicle {
        ParkingOwner parkingOwner = mock(ParkingOwner.class);
        ParkingLot parkingLot = new ParkingLot(1, new ArrayList<>(),parkingOwner);
        Vehicle vehicle = new Vehicle("KA0123");
        parkingLot.park(vehicle);

        verify(parkingOwner).notifyParkingFull();

    }

    @Test
    void expectNotificationWhenParkingAvailable() throws CannotParkVehicle {
        ParkingOwner parkingOwner = mock(ParkingOwner.class);
        ParkingLot parkingLot = new ParkingLot(1, new ArrayList<>(),parkingOwner);
        Vehicle vehicle = new Vehicle("KA0123");
        parkingLot.park(vehicle);
        parkingLot.unPark(vehicle);

        verify(parkingOwner).notifyParkingAvailable();

    }
}
