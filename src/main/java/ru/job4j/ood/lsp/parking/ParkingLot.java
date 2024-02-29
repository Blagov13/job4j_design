package ru.job4j.ood.lsp.parking;

public interface ParkingLot {
    ParkingSpot getParkingSpotForVehicle(Vehicle vehicle);

    boolean parkVehicle(Vehicle vehicle);

    boolean leaveVehicle(Vehicle vehicle);
}
