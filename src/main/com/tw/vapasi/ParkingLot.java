package com.tw.vapasi;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot  {

    private int numberOfSlots;
    private List<Vehicle> parkingSlots;


     ParkingLot(int numberOfSlots, List<Vehicle> slots) {
        this.numberOfSlots = numberOfSlots;
        this.parkingSlots = slots;
    }

    static Vehicle vehicle(String vehicleNumber){
         return new Vehicle((vehicleNumber));
    }


     void park(Vehicle vehicle) throws CannotParkVehicle{

        if(vehicle == null)
        {
            throw new CannotParkVehicle();
        }

         parkingSlots.add(vehicle);

    }


    void  unPark(Vehicle vehicle) throws CannotParkVehicle{
        if((vehicle == null) && !carIsAlreadyParked(vehicle))
        {
            throw new CannotParkVehicle();
        }
        parkingSlots.remove(vehicle);

    }
    private boolean carIsAlreadyParked(Vehicle vehicle) {
        return parkingSlots.contains(vehicle);
    }

    private boolean parkingLotIsFull() {
        return parkingSlots.size() >= numberOfSlots;
    }

}
