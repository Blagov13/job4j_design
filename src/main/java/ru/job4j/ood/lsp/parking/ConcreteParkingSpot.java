package ru.job4j.ood.lsp.parking;

public class ConcreteParkingSpot implements ParkingSpot {
    private Vehicle vehicle;
    private final String type;

    public ConcreteParkingSpot(String type) {
        this.type = type;
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        if (vehicle.getType().equals(Vehicle.TYPE_TRUCK)) {
            return type.equals(Vehicle.TYPE_TRUCK) || (type.equals(Vehicle.TYPE_CAR) && vehicle.getSize() == 1);
        } else {
            return type.equals(Vehicle.TYPE_CAR);
        }
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void leave() {
        this.vehicle = null;
    }
}
