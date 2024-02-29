package ru.job4j.ood.lsp.parking;

import java.util.List;

public class CombinedParkingSpot implements ParkingSpot {
    private List<ConcreteParkingSpot> spots;

    public CombinedParkingSpot(List<ConcreteParkingSpot> spots) {
        this.spots = spots;
    }

    @Override
    public boolean canFit(Vehicle vehicle) {
        return (vehicle.isTruck() && spots.size() == vehicle.getSize());
    }

    public void park(Vehicle vehicle) {
        for (ConcreteParkingSpot spot : spots) {
            spot.park(vehicle);
        }
    }

    public void leave() {
        for (ConcreteParkingSpot spot : spots) {
            spot.leave();
        }
    }

    public boolean isAvailable() {
        return spots.stream().allMatch(ConcreteParkingSpot::isAvailable);
    }

    public List<ConcreteParkingSpot> getSpots() {
        return spots;
    }
}
