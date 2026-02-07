/*
Унагаев Егор 9 Вариант
Создать приложение, удовлетворяющее требованиям, приведенным в задании. Наследование применять только в тех заданиях, в которых это логически
обосновано. Аргументировать принадлежность классу каждого создаваемого
метода и корректно переопределить для каждого класса методы equals(),
hashCode(), toString().
9. Создать объект класса Круг, используя классы Точка, Окружность. Методы:
задание размеров, изменение радиуса, определение принадлежности точки
данному кругу.
*/

import java.util.Objects;

class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    // Правила для корректного сравнения точек
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Точка(%.3f, %.3f)", x, y);
    }
}

/**
 * Окружность (Circle) с центром в точке и радиусом.
 */
class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(double centerX, double centerY, double radius) {
        this(new Point(centerX, centerY), radius);
    }
    public Point getCenter() { return center; }
    public double getRadius() { return radius; }

    public void setCenter(Point center) {
        this.center = center;
    }
    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Радиус должен быть неотрицательным");
        this.radius = radius;
    }

    public boolean contains(Point p) {
        double dx = p.getX() - center.getX();
        double dy = p.getY() - center.getY();
        double dist = Math.hypot(dx, dy);
        return dist <= radius + 1e-9;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2.0 * Math.PI * radius;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                Objects.equals(center, circle.center);
    }
    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
    @Override
    public String toString() {
        return String.format("Окружность{центр=%s, радиус=%.3f, площадь=%.3f, окружность=%.3f}",
                center, radius, area(), circumference());
    }
}

//Пример применения: создание круга, изменение радиуса, проверка принадлежности точки.
public class Main {
    public static void main(String[] args) {
        Point center = new Point(0.0, 0.0);
        Circle circle = new Circle(center, 5.0);

        System.out.println("Начальная окружность: " + circle);
        circle.setRadius(3.0);
        System.out.println("После изменения радиуса: " + circle);
        circle.setCenter(new Point(1.0, 2.0));
        System.out.println("После перемещения центра: " + circle);
        Point pInside = new Point(2.0, 2.0);
        System.out.println("Точка " + pInside + (circle.contains(pInside) ? " принадлежит" : " не принадлежит") + " окружности.");
    }
}
