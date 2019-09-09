package com.tw.vapasi;

import java.util.List;

public class ParkingLot {

    ParkingOwner parkingOwner;
    private int numberOfSlots;
    private List<Vehicle> parkingSlots;


    ParkingLot(int numberOfSlots, List<Vehicle> slots) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
    }

    public <Vehicles> ParkingLot(int numberOfSlots, List<Vehicle> slots, ParkingOwner parkowner) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
        this.parkingOwner = parkowner;
    }


    static Vehicle vehicle(String vehicleNumber) {
        return new Vehicle((vehicleNumber));
    }


    void park(Vehicle vehicle) throws CannotParkVehicle {

        if (vehicle == null && parkingLotIsFull()) {
            throw new CannotParkVehicle();
        }

        parkingSlots.add(vehicle);

    }


    void unPark(Vehicle vehicle)g throws CannotParkVehicle {
        if ((vehicle == null) && !isCarParked(vehicle)) {
            throw new CannotParkVehicle();
        }
        parkingSlots.remove(vehicle);
        parkingOwner.notifyParkingAvailable();
    }

    boolean isCarParked(Vehicle vehicle) {
        return parkingSlots.contains(vehicle);
    }

    boolean parkingLotIsFull() {
        boolean isParkingFull = false;
        if (parkingSlots.size() >= numberOfSlots) {
            isParkingFull = true;
            parkingOwner.notifyParkingFull();
        }
        if(parkingSlots.size()<=numberOfSlots)
        {
            isParkingFull = false;
            parkingOwner.notifyParkingAvailable();
        }

        return isParkingFull;
    }

}
