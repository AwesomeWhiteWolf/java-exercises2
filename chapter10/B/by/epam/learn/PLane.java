package by.epam.learn.PLane;
import java.io.*;
import java.util.*;

// Базовый класс самолета
abstract class Plane implements Serializable {
    private String model;
    private int range; // Дальность полета
    private int capacity;
    private double payload; 
    private double fuelConsumption; // Потребление горючего (л/час)
    
    private transient String currentStatus; 

    public Plane(String model, int range, int capacity, double payload, double fuelConsumption) {
        this.model = model;
        this.range = range;
        this.capacity = capacity;
        this.payload = payload;
        this.fuelConsumption = fuelConsumption;
    }

    public int getRange() { return range; }
    public int getCapacity() { return capacity; }
    public double getPayload() { return payload; }
    public double getFuelConsumption() { return fuelConsumption; }
    public String getModel() { return model; }

    @Override
    public String toString() {
        return String.format("%s: Дальность=%d, Мест=%d, Груз=%.1f, Расход=%.1f", 
                model, range, capacity, payload, fuelConsumption);
    }
}

// Конкретные типы самолетов
class PassengerPlane extends Plane {
    public PassengerPlane(String model, int range, int capacity, double payload, double fuelConsumption) {
        super(model, range, capacity, payload, fuelConsumption);
    }
}

class CargoPlane extends Plane {
    public CargoPlane(String model, int range, int capacity, double payload, double fuelConsumption) {
        super(model, range, capacity, payload, fuelConsumption);
    }
}
