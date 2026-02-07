/*
Унагаев Егор 9 Вариант
9. Определить класс Окружность на плоскости. Определить площадь и периметр. Создать массив/список/множество объектов и определить группы
окружностей, центры которых лежат на одной прямой. Определить наибольший и наименьший по площади (периметру) объект.
*/

import java.awt.geom.Point2D;
import java.util.*;
import java.util.stream.Collectors;

class Circle {
    Point2D.Double center;
    double radius;

    Circle(double x, double y, double r) {
        center = new Point2D.Double(x, y);
        radius = r;
    }

    double area() { return Math.PI * radius * radius; }
    double perimeter() { return 2 * Math.PI * radius; }

    @Override
    public String toString() {
        return String.format("Круг{центр=(%.2f,%.2f), радиус=%.2f, площадь=%.2f, периметр=%.2f}",
                center.x, center.y, radius, area(), perimeter());
    }
}

public class Main {
    private static boolean collinear(Point2D.Double a, Point2D.Double b, Point2D.Double c, double eps) {
        // произведение векторов (b-a) * (c-a) == 0
        double cross = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
        return Math.abs(cross) <= eps;
    }

    public static void main(String[] args) {
        List<Circle> circles = Arrays.asList(
                new Circle(0,0,1),
                new Circle(1,1,2),
                new Circle(2,2,0.5),
                new Circle(0,1,1.5),
                new Circle(3,3,1),
                new Circle(1,0,0.7)
        );

        double eps = 1e-6;
        List<Set<Circle>> groups = new ArrayList<>();
        boolean[] used = new boolean[circles.size()];

        for (int i = 0; i < circles.size(); i++) {
            if (used[i]) continue;
            Set<Circle> group = new LinkedHashSet<>();
            group.add(circles.get(i));
            for (int j = i+1; j < circles.size(); j++) {
                // проверка какие центры лежат на прямой через i и j
                Set<Circle> col = new LinkedHashSet<>();
                for (int k = 0; k < circles.size(); k++) {
                    if (collinear(circles.get(i).center, circles.get(j).center, circles.get(k).center, eps)) {
                        col.add(circles.get(k));
                    }
                }
                if (col.size() > 1) {
                    group.addAll(col);
                }
            }
            // пометка использованных
            for (int idx = 0; idx < circles.size(); idx++) {
                if (group.contains(circles.get(idx))) used[idx] = true;
            }
            groups.add(group);
        }

        System.out.println("Группы кругов, которых центр лежит на линии:");
        groups.forEach(g -> {
            g.forEach(c -> System.out.println("  " + c));
        });
        
        Circle maxArea = Collections.max(circles, Comparator.comparingDouble(Circle::area));
        Circle minArea = Collections.min(circles, Comparator.comparingDouble(Circle::area));
        Circle maxPer = Collections.max(circles, Comparator.comparingDouble(Circle::perimeter));
        Circle minPer = Collections.min(circles, Comparator.comparingDouble(Circle::perimeter));

        System.out.println("\nМаксимальная площадь: " + maxArea);
        System.out.println("Минимальная площадь: " + minArea);
        System.out.println("Максимальный периметр: " + maxPer);
        System.out.println("Минимальный периметр: " + minPer);
    }
}
