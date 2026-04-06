package by.epam.learn.Airline;
import java.io.*;
import java.util.*;

// Агрегирует список самолетов
class Airline implements Serializable {
    private List<Plane> fleet = new ArrayList<>();

    public void addPlane(Plane plane) { fleet.add(plane); }
    public List<Plane> getFleet() { return fleet; }

    public int getTotalCapacity() {
        return fleet.stream().mapToInt(Plane::getCapacity).sum();
    }

    public double getTotalPayload() {
        return fleet.stream().mapToDouble(Plane::getPayload).sum();
    }

    public void sortByRange() {
        fleet.sort(Comparator.comparingInt(Plane::getRange));
    }

    public List<Plane> findByFuel(double min, double max) {
        return fleet.stream()
                .filter(p -> p.getFuelConsumption() >= min && p.getFuelConsumption() <= max)
                .toList();
    }
}
