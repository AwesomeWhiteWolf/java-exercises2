package by.epam.airline.entity;
public class PassengerPlane extends Plane {
    private int comfortLevel; // Дополнительный атрибут

    public PassengerPlane(String model, int range, int cap, double load, double fuel, int comfort) {
      super(model, range, cap, load, fuel);
      this.comfortLevel = comfort;
    }
}
