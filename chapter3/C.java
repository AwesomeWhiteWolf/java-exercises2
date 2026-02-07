/*
Унагаев Егор 9 Вариант
9. Определить класс Треугольник на плоскости, вершины которого имеют
тип Точка. Определить площадь и периметр треугольника. Создать массив/список/множество объектов и подсчитать количество треугольников
разного типа (равносторонний, равнобедренный, прямоугольный, произвольный). Определить для каждой группы наибольший и наименьший по
площади (периметру) объект.
*/

import java.util.*;
import java.util.stream.*;

class Point { double x, y; Point(double x, double y){this.x=x;this.y=y;} }

class Triangle {
    Point a,b,c;
    Triangle(Point a, Point b, Point c){ this.a=a; this.b=b; this.c=c; }
    private double d(Point p, Point q){ return Math.hypot(p.x-q.x, p.y-q.y); }
    double perimeter(){ return d(a,b)+d(b,c)+d(c,a); }
    double area(){
        // векторное произведение
        return Math.abs((b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x)) / 2.0;
    }
    private boolean eq(double u, double v){ return Math.abs(u-v) < 1e-9; }
    boolean isEquilateral(){
        double ab=d(a,b), bc=d(b,c), ca=d(c,a);
        return eq(ab,bc) && eq(bc,ca);
    }
    boolean isIsosceles(){
        double ab=d(a,b), bc=d(b,c), ca=d(c,a);
        return eq(ab,bc) || eq(bc,ca) || eq(ca,ab);
    }
    boolean isRight(){
        double ab=d(a,b), bc=d(b,c), ca=d(c,a);
        double[] s = {ab*ab, bc*bc, ca*ca};
        Arrays.sort(s);
        return eq(s[0]+s[1], s[2]);
    }
    String type(){
        if (isEquilateral()) return "Равносторонний";
        if (isRight()) return "Прямоугольный";
        if (isIsosceles()) return "Равнобедренный";
        return "Неравносторонний";
    }
    @Override public String toString(){
        return String.format("T(площадь=%.3f, периметр=%.3f, тип=%s)", area(), perimeter(), type());
    }
}

public class Main {
    public static void main(String[] args){
        List<Triangle> list = Arrays.asList(
                new Triangle(new Point(0,0), new Point(1,0), new Point(0.5, Math.sqrt(3)/2)), // equilateral side=1
                new Triangle(new Point(0,0), new Point(2,0), new Point(1,0)), // degenerate (area 0) -> scalene by sides but area 0
                new Triangle(new Point(0,0), new Point(3,0), new Point(0,4)), // right 3-4-5
                new Triangle(new Point(0,0), new Point(2,0), new Point(1,2)), // isosceles
                new Triangle(new Point(0,0), new Point(1,0), new Point(0,2))  // scalene
        );

        Map<String, List<Triangle>> groups = list.stream().collect(Collectors.groupingBy(Triangle::type));

        for (String type : Arrays.asList("Равносторонний", "Прямой", "Равнобедренный", "Разносторонний")) {
            List<Triangle> g = groups.getOrDefault(type, Collections.emptyList());
            System.out.println("Тип: " + type + " Количество: " + g.size());
            if (!g.isEmpty()) {
                Triangle maxArea = Collections.max(g, Comparator.comparingDouble(Triangle::area));
                Triangle minArea = Collections.min(g, Comparator.comparingDouble(Triangle::area));
                Triangle maxPer = Collections.max(g, Comparator.comparingDouble(Triangle::perimeter));
                Triangle minPer = Collections.min(g, Comparator.comparingDouble(Triangle::perimeter));
                System.out.println("  Макс площадь: " + maxArea);
                System.out.println("  Мин площадь: " + minArea);
                System.out.println("  Макс периметр:  " + maxPer);
                System.out.println("  Мин периметр:  " + minPer);
            }
        }
    }
}
