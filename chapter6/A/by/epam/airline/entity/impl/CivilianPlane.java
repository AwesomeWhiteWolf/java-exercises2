package by.epam.airline.entity.impl;

import by.epam.airline.entity.Plane;
import by.epam.airline.action.PlaneAction;

public class CivilianPlane extends Plane implements PlaneAction {
    public CivilianPlane(String model, String id) {
        super(model, id);
    }

    @Override
    public void performTechnicalInspection() {
        System.out.println("Проверка салона и систем жизнеобеспечения самолета " + getId());
        setReadyForFlight(true);
    }

    @Override
    public void repair() {
        System.out.println("Замена деталей шасси гражданского лайнера.");
    }

    @Override
    public void executeFlight() {
        if (isReadyForFlight()) {
            System.out.println("Осуществление регулярного рейса...");
        }
    }

    @Override
    public void refuel() {
        System.out.println("Стандартная заправка авиационным керосином.");
    }

    public void boardPassengers() {
        System.out.println("Идет посадка пассажиров в " + getModel());
    }
}
