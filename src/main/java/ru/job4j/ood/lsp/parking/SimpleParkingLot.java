package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleParkingLot implements ParkingLot {
    private List<ConcreteParkingSpot> carSpots;
    private List<ConcreteParkingSpot> truckSpots;

    public SimpleParkingLot(int carSpotCount, int truckSpotCount) {
        carSpots = new ArrayList<>(Collections.nCopies(carSpotCount, new ConcreteParkingSpot(Vehicle.TYPE_CAR)));
        truckSpots = new ArrayList<>(Collections.nCopies(truckSpotCount, new ConcreteParkingSpot(Vehicle.TYPE_TRUCK)));
    }

    @Override
    public ParkingSpot getParkingSpotForVehicle(Vehicle vehicle) {
        if (vehicle.isCar()) {
            return carSpots.stream().filter(spot -> spot.isAvailable()).findFirst().orElse(null);
        } else if (vehicle.isTruck()) {
            for (ConcreteParkingSpot spot : truckSpots) {
                if (spot.isAvailable()) {
                    return spot;
                }
            }
            int spotsNeeded = vehicle.getSize();
            for (int i = 0; i < carSpots.size(); i++) {
                int spotsFound = 0;
                for (int j = i; j < carSpots.size() && spotsFound < spotsNeeded; j++) {
                    if (carSpots.get(j).isAvailable()) {
                        spotsFound++;
                    } else {
                        break;
                    }
                }
                if (spotsFound == spotsNeeded) {
                    return new CombinedParkingSpot(carSpots.subList(i, i + spotsNeeded));
                }
            }
        }
        return null;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = getParkingSpotForVehicle(vehicle);
        if (spot != null) {
            if (spot instanceof ConcreteParkingSpot) {
                ((ConcreteParkingSpot) spot).park(vehicle);
            } else if (spot instanceof CombinedParkingSpot) {
                ((CombinedParkingSpot) spot).park(vehicle);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean leaveVehicle(Vehicle vehicle) {
        for (ConcreteParkingSpot spot : carSpots) {
            if (vehicle.equals(spot.getVehicle())) {
                spot.leave();
                return true;
            }
        }
        for (ConcreteParkingSpot spot : truckSpots) {
            if (vehicle.equals(spot.getVehicle())) {
                spot.leave();
                return true;
            }
        }
        return false;
    }
}
