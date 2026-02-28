package by.epam.airline.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
public class Airline {
    private List<Plane> fleet = new ArrayList<>(); // Использование коллекций

    public void addPlane(Plane plane) {
        fleet.add(plane);
    }

    public List<Plane> getFleet() {
        return List.copyOf(fleet); // Защита от модификации извне
    }
}
