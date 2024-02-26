package ru.job4j.ood.lsp.parking;

public interface ParkingLot {
    /*Интерфейс для парковки*/
    ParkingSpot getParkingSpotForVehicle(Vehicle vehicle);
    boolean parkVehicle(Vehicle vehicle);
}
