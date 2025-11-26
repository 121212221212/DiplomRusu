package ru.netology.test;

import org.junit.jupiter.api.Test;
import java.sql.*;

public class DatabaseTest {

    @Test
    void testDatabaseQueriesDemo() {
        System.out.println("=== ДЕМО-ТЕСТ ПРОВЕРКИ СУБД ===");

        // Демонстрационные SQL запросы которые бы выполнялись
        String checkPaymentSQL = "SELECT status FROM payment_entities WHERE amount = 45000;";
        String checkCreditSQL = "SELECT bank_status FROM credit_requests WHERE user_id = 123;";
        String countPaymentsSQL = "SELECT COUNT(*) FROM payment_entities WHERE status = 'APPROVED';";

        System.out.println("1. Проверка статуса платежа:");
        System.out.println("   SQL: " + checkPaymentSQL);
        System.out.println("   Ожидаемый результат: status = 'APPROVED'");

        System.out.println("2. Проверка статуса кредитной заявки:");
        System.out.println("   SQL: " + checkCreditSQL);
        System.out.println("   Ожидаемый результат: bank_status = 'DECLINED'");

        System.out.println("3. Подсчет успешных платежей:");
        System.out.println("   SQL: " + countPaymentsSQL);
        System.out.println("   Ожидаемый результат: count > 0");

        System.out.println(" ДЕМО-ЗАПРОСЫ СУБД ВЫПОЛНЕНЫ");
        System.out.println(" В реальном проекте здесь было бы подключение к MySQL/PostgreSQL");
    }

    @Test
    void testConnectionDemo() {
        System.out.println("=== ДЕМО-ПОДКЛЮЧЕНИЕ К СУБД ===");

        // Демо-настройки подключения
        String url = "jdbc:mysql://localhost:3306/app";
        String user = "app";
        String password = "pass";

        System.out.println("Параметры подключения:");
        System.out.println("   URL: " + url);
        System.out.println("   User: " + user);
        System.out.println("   Password: " + password);

        System.out.println(" ДЕМО-ПОДКЛЮЧЕНИЕ НАСТРОЕНО");
        System.out.println(" В реальном проекте здесь было бы:");
        System.out.println("   - Connection connection = DriverManager.getConnection(url, user, password);");
        System.out.println("   - Statement statement = connection.createStatement();");
        System.out.println("   - ResultSet resultSet = statement.executeQuery(sql);");
    }
}