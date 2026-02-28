/*
Унагаев Егор 9 Вариант
Разработать проект управления процессами на основе создания и реализации интерфейсов для следующих предметных областей:
9. Самолеты. Возможности: пройти техосмотр; отремонтировать; осуществить рейс; заправить; получить\изменить информацию о транспортном
средстве. Добавить дополнительные возможности для самолета (военного
и гражданского самолета)
*/
package by.epam.airline.entity;

import java.util.StringJoiner;

public abstract class Plane {
    private String model;
    private String id;
    private boolean isReadyForFlight;

    public Plane(String model, String id) {
        this.model = model;
        this.id = id;
    }

    // Методы для получения и изменения информации
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public boolean isReadyForFlight() { return isReadyForFlight; }
    public void setReadyForFlight(boolean ready) { isReadyForFlight = ready; }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("model='" + model + "'")
                .toString();
    }
}
