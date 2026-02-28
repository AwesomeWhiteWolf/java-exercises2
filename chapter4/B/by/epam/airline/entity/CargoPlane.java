package by.epam.airline.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
public class CargoPlane extends Plane {
    private double cargoVolume;

    public CargoPlane(String model, int range, int cap, double load, double fuel, double volume) {
        super(model, range, cap, load, fuel);
        this.cargoVolume = volume;
    }
}
