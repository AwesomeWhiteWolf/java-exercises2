package by.epam.airline.entity.impl;

import by.epam.airline.entity.Plane;
import by.epam.airline.action.PlaneAction;

public class MilitaryPlane extends Plane implements PlaneAction {
    public MilitaryPlane(String model, String id) {
        super(model, id);
    }

    @Override
    public void performTechnicalInspection() {
        System.out.println("Военный осмотр систем вооружения самолета " + getId());
        setReadyForFlight(true);
    }

    @Override
    public void repair() {
        System.out.println("Ремонт брони и двигателей военного судна.");
    }

    @Override
    public void executeFlight() {
        if (isReadyForFlight()) {
            System.out.println("Выполнение боевой задачи...");
        }
    }

    @Override
    public void refuel() {
        System.out.println("Заправка высокооктановым топливом.");
    }

    public void patrol() {
        System.out.println("Самолет " + getModel() + " вышел на патрулирование границ.");
    }
}
