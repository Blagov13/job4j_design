package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingLotTest {
    private SimpleParkingLot parkingLot;
    private Vehicle car;
    private Vehicle truck;
    private Vehicle largeTruck;

    public ParkingLotTest() {
        setUp();
    }

    public void setUp() {
        parkingLot = new SimpleParkingLot(5, 2);
        car = new Vehicle(Vehicle.TYPE_CAR, 1);
        truck = new Vehicle(Vehicle.TYPE_TRUCK, 1);
        largeTruck = new Vehicle(Vehicle.TYPE_TRUCK, 3);
    }

    @Test
    public void testParkCar_Success() {
        /*���������, ��� �������� ������ ����� ������� ������������*/
        boolean isParked = parkingLot.parkVehicle(car);
        Assertions.assertTrue(isParked);
    }

    @Test
    public void testParkTruck_Success() {
        /*���������, ��� �������� ����� ������� ������������ �� ����� ��� ����������*/
        boolean isParked = parkingLot.parkVehicle(truck);
        Assertions.assertTrue(isParked);
    }

    @Test
    public void testParkLargeTruck_Success() {
        /*������� ��������� �������� �����, ����� ���������,
        ��� ������� �������� ������ �������������� �� ���������� ������ ��� ��������*/
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(new Vehicle(Vehicle.TYPE_CAR, 1));

        boolean isParked = parkingLot.parkVehicle(largeTruck);
        Assertions.assertTrue(isParked);
    }
}