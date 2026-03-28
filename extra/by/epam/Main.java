package by.epam;

public class Main {
    public static void main(String[] args) {
        String email = "user@mail.ru";
        
        // Используем метод из нашей библиотеки
        if (RegexUtils.isValidEmail(email)) {
            System.out.println("Email " + email + " действителен!");
        } else {
            System.out.println("Ошибка в email.");
        }
    }
}
