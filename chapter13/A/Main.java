/*
Унагаев Егор Б763-2а
Вариант 9
В каждом из заданий необходимо выполнить следующие действия:
• организацию соединения с базой данных вынести в отдельный класс, метод
которого возвращает соединение;
• создать БД. Привести таблицы к одной из нормальных форм;
• создать класс для выполнения запросов на извлечение информации из БД
с использованием компилированных запросов;
• создать класс на модификацию информации.

9. Магазин часов. В БД хранится информация о часах, продающихся в магазине.
Для часов необходимо хранить:
• марку;
• тип (кварцевые, механические);
• стоимость;
• количество;
• реквизиты производителя.
Для производителей необходимо хранить:
• название;
• страна.
• Вывести марки заданного типа часов.
• Вывести информацию о механических часах, стоимость которых не превышает заданную.
• Вывести марки часов, изготовленных в заданной стране.
• Вывести производителей, общая сумма часов которых в магазине не превышает заданную.
*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// --- 1. Класс организации соединения ---
class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/watch_shop";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

// --- 2. Класс для извлечения информации (Query) ---
class WatchQueryManager {
    
    // Вывести марки заданного типа часов
    public List<String> getBrandsByType(String type) throws SQLException {
        String sql = "SELECT brand FROM watches WHERE type = ?";
        List<String> brands = new ArrayList<>();
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                brands.add(rs.getString("brand"));
            }
        }
        return brands;
    }

    // Вывести информацию о механических часах, стоимость которых не превышает заданную
    public void printMechanicalWatchesUnderPrice(double maxPrice) throws SQLException {
        String sql = "SELECT * FROM watches WHERE type = 'механические' AND price <= ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, maxPrice);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("ID: %d | Марка: %s | Цена: %.2f | Кол-во: %d%n",
                        rs.getInt("id"), rs.getString("brand"), 
                        rs.getDouble("price"), rs.getInt("quantity"));
            }
        }
    }

    // Вывести марки часов, изготовленных в заданной стране
    public List<String> getBrandsByCountry(String country) throws SQLException {
        String sql = "SELECT w.brand FROM watches w " +
                     "JOIN manufacturers m ON w.manufacturer_id = m.id " +
                     "WHERE m.country = ?";
        List<String> brands = new ArrayList<>();
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, country);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                brands.add(rs.getString("brand"));
            }
        }
        return brands;
    }

    // Вывести производителей, общая сумма часов которых в магазине не превышает заданную
    public void printManufacturersWithTotalValueUnder(double maxTotalSum) throws SQLException {
        String sql = "SELECT m.name, SUM(w.price * w.quantity) as total_sum " +
                     "FROM manufacturers m " +
                     "JOIN watches w ON m.id = w.manufacturer_id " +
                     "GROUP BY m.id " +
                     "HAVING total_sum <= ?";
        
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, maxTotalSum);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Производитель: %s | Общая сумма: %.2f%n",
                        rs.getString("name"), rs.getDouble("total_sum"));
            }
        }
    }
}

// --- 3. Класс на модификацию информации ---
class WatchUpdateManager {

    public void addManufacturer(String name, String country) throws SQLException {
        String sql = "INSERT INTO manufacturers (name, country) VALUES (?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.executeUpdate();
        }
    }

    public void addWatch(String brand, String type, double price, int quantity, int mId) throws SQLException {
        String sql = "INSERT INTO watches (brand, type, price, quantity, manufacturer_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, brand);
            pstmt.setString(2, type);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, quantity);
            pstmt.setInt(5, mId);
            pstmt.executeUpdate();
        }
    }

    public void updatePrice(int watchId, double newPrice) throws SQLException {
        String sql = "UPDATE watches SET price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, watchId);
            pstmt.executeUpdate();
        }
    }

    public void deleteWatch(int watchId) throws SQLException {
        String sql = "DELETE FROM watches WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, watchId);
            pstmt.executeUpdate();
        }
    }
}

// --- Пример использования ---
public class Main {
    public static void main(String[] args) {
        WatchQueryManager queryManager = new WatchQueryManager();
        WatchUpdateManager updateManager = new WatchUpdateManager();

        try {
            System.out.println("--- Марки кварцевых часов ---");
            System.out.println(queryManager.getBrandsByType("кварцевые"));

            System.out.println("\n--- Механические до 50000 ---");
            queryManager.printMechanicalWatchesUnderPrice(50000);

            System.out.println("\n--- Часы из Швейцарии ---");
            System.out.println(queryManager.getBrandsByCountry("Швейцария"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
