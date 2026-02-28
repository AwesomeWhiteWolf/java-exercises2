package entity;
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

public class PassengerPlane extends Plane {
    private int comfortLevel; // Дополнительный атрибут

    public PassengerPlane(String model, int range, int cap, double load, double fuel, int comfort) {
        super(model, range, cap, load, fuel);
        this.comfortLevel = comfort;
    }
}

public class CargoPlane extends Plane {
    private double cargoVolume;

    public CargoPlane(String model, int range, int cap, double load, double fuel, double volume) {
        super(model, range, cap, load, fuel);
        this.cargoVolume = volume;
    }
}

public class Airline {
    private List<Plane> fleet = new ArrayList<>(); // Использование коллекций

    public void addPlane(Plane plane) {
        fleet.add(plane);
    }

    public List<Plane> getFleet() {
        return List.copyOf(fleet); // Защита от модификации извне
    }
}
