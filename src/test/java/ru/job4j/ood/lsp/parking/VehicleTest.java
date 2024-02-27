package ru.job4j.ood.lsp.parking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class VehicleTest {
    /*Тест для проверки возможности размещения легковой машины на месте для грузовых машин*/
   /* @Test
    public void testParkVehicle_LightVehicleOnHeavySpot() {
        ParkingLot parkingLot = new ParkingLotImpl(5, 3);
        Vehicle lightVehicle = new Vehicle("Light", 1);
        assertFalse(parkingLot.parkVehicle(lightVehicle));
    }

    *//*Тест для проверки возможности размещения грузовой машины на
    месте для грузовых машин и на смежных местах для легковых машин*//*
    @Test
    public void testParkVehicle_HeavyVehicleOnHeavySpot() {
        ParkingLot parkingLot = new ParkingLotImpl(5, 3);
        Vehicle heavyVehicle = new Vehicle("Heavy", 2);
        assertTrue(parkingLot.parkVehicle(heavyVehicle));
    }*/
}