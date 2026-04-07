/*
Унагаев Егор Б763-2а 9 вариант
9. Во входном файле расположены два набора положительных чисел; между
наборами стоит отрицательное число. Построить два списка C1 и С2, элементы которых содержат соответственно числа 1­го и 2­го набора таким
образом, чтобы внутри одного списка числа были упорядочены по возрастанию. Затем объединить списки C1 и С2 в один упорядоченный список,
изменяя только значения полей ссылочного типа.
*/
import java.io.*;
import java.util.*;

public class Main {

    // Массивы ссылок
    static class Box {
        Integer[] a;
        Box(Integer[] a) { this.a = a; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        List<Integer> all = new ArrayList<>();

        while ((s = br.readLine()) != null) {
            s = s.trim();
            if (s.isEmpty()) continue;
            String[] parts = s.split("\\s+");
            for (String p : parts) all.add(Integer.parseInt(p));
        }

        int idxNeg = -1;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i) < 0) { idxNeg = i; break; }
        }

        List<Integer> set1 = all.subList(0, idxNeg);         
        List<Integer> set2 = all.subList(idxNeg + 1, all.size()); 

        // построить C1 и C2 
        Integer[] c1Arr = set1.toArray(new Integer[0]);
        Integer[] c2Arr = set2.toArray(new Integer[0]);
        Arrays.sort(c1Arr);
        Arrays.sort(c2Arr);

        // объединить в один упорядоченный список, изменяя только значения полей ссылочного типа
        Box b1 = new Box(c1Arr);
        Box b2 = new Box(c2Arr);

        Integer[] merged = new Integer[b1.a.length + b2.a.length];
        int i = 0, j = 0, k = 0;
        while (i < b1.a.length && j < b2.a.length) {
            if (b1.a[i] <= b2.a[j]) merged[k++] = b1.a[i++];
            else merged[k++] = b2.a[j++];
        }
        while (i < b1.a.length) merged[k++] = b1.a[i++];
        while (j < b2.a.length) merged[k++] = b2.a[j++];

        b1.a = merged;
        b2.a = new Integer[0];

        // Вывод по возрастанию
        StringBuilder out = new StringBuilder();
        for (int t = 0; t < b1.a.length; t++) {
            if (t > 0) out.append(' ');
            out.append(b1.a[t]);
        }
        System.out.print(out.toString());
    }
}
