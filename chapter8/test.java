Вопрос 8.1.
Дан код:
public class A {
public static void main(String[] args){
String str = "Hello";
System.out.print(str);
doWork(str);
System.out.print(str);
}
public static void doWork(String value){
value = null;
}
}

Что будет результатом компиляции и запуска? (выбрать один)
Правильный ответ: a) Hello

Вопрос 8.2.
Дан код:
String s = new String("3");
System.out.println(1 + 2 + s + 4 + 5);
В результате будет выведено (выбрать один):
Правильный ответ: d) 339

Вопрос 8.3.
Какие из предложенных операторов дадут результат true? (выбрать два)
Варианты:
a) s1 == s2
b) s1 == s3
c) s2 == s4
d) s2 == s3
e) s2.equals(s1)
Правильные ответы: b) s1 == s3 и e) s2.equals(s1)

Вопрос 8.4.
Что будет выведено на консоль при компиляции и выполнении? (выбрать один)
Код:
String[] strings = new String[]{"a", "b", "c"};
int k = 0;
for (String element : strings) {
    strings[k].concat(String.valueOf(k));
    ++k;
}
System.out.print(Arrays.toString(strings));
Правильный ответ: a) [a, b, c]

Вопрос 8.5.
Дан фрагмент кода:
String st = "0";
StringBuffer sb = new StringBuffer("a");
// 1
// 2
System.out.print(st);
System.out.print(sb);
Какой из фрагментов кода (вместо комментария 1 и 2) выведет 01ab? (выбрать один)
Правильный ответ: a) st = st.concat("1");sb.append("b");
