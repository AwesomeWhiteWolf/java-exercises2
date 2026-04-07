/*
Унагаев Егор Б763-2а 9 вариант
9. Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap.
*/
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> poly1 = new HashMap<>();
        poly1.put(3, 5);
        poly1.put(2, 4);
        poly1.put(0, 7);

        HashMap<Integer, Integer> poly2 = new HashMap<>();
        poly2.put(4, 3);
        poly2.put(2, 6);
        poly2.put(1, 2);

        HashMap<Integer, Integer> result = new HashMap<>(poly1);

        poly2.forEach((degree, coeff) ->
                result.merge(degree, coeff, Integer::sum));

        System.out.println(result);
    }
}
