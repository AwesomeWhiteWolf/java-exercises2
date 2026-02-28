package package by.epam.airline.logic;

import by.epam.airline.entity.Airline;
import by.epam.airline.entity.Plane;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirlineService {
    // Подсчет общей вместимости через суммирование
    public int calculateTotalCapacity(Airline airline) {
        return airline.getFleet().stream()
                .mapToInt(Plane::getPassengerCapacity)
                .sum();
    }

    // Подсчет общей грузоподъемности
    public double calculateTotalPayload(Airline airline) {
        return airline.getFleet().stream()
                .mapToDouble(Plane::getPayload)
                .sum();
    }

    // Сортировка по дальности полета
    public List<Plane> sortByFlightRange(Airline airline) {
        return airline.getFleet().stream()
                .sorted(Comparator.comparingInt(Plane::getFlightRange))
                .collect(Collectors.toList());
    }

    // Поиск по диапазону потребления горючего
    public List<Plane> findByFuelRange(Airline airline, double min, double max) {
        return airline.getFleet().stream()
                .filter(p -> p.getFuelConsumption() >= min && p.getFuelConsumption() <= max)
                .collect(Collectors.toList());
    }
}
