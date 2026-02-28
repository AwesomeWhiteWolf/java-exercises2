package by.epam.airline.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// Базовый класс иерархии
public abstract class Plane extends Entity {
    private String model;
    private int flightRange;      // Дальность полета
    private int passengerCapacity; // Вместимость
    private double payload;        // Грузоподъемность (кг)
    private double fuelConsumption; // Потребление (л/100 км)

    public Plane(String model, int flightRange, int passengerCapacity, double payload, double fuelConsumption) {
        this.model = model;
        this.flightRange = flightRange;
        this.passengerCapacity = passengerCapacity;
        this.payload = payload;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() { return model; }
    public int getFlightRange() { return flightRange; }
    public int getPassengerCapacity() { return passengerCapacity; }
    public double getPayload() { return payload; }
    public double getFuelConsumption() { return fuelConsumption; }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("model='" + model + "'")
                .add("range=" + flightRange)
                .add("capacity=" + passengerCapacity)
                .add("payload=" + payload)
                .add("fuel=" + fuelConsumption)
                .toString();
    }
}
