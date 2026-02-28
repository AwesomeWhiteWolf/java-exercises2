package by.epam.airline.action;

import by.epam.airline.entity.Plane;
// Интерфейс для определения спецификации процессов для любого типа самолета.
public interface PlaneAction {
    void performTechnicalInspection(); // Пройти техосмотр
    void repair();                     // Отремонтировать
    void executeFlight();              // Осуществить рейс
    void refuel();                     // Заправить
}
