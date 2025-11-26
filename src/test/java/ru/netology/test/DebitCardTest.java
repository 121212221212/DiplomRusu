package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DebitCardTest {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 40000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testSuccessfulLogin() {
        System.out.println("ТЕСТ 1: Успешный вход в систему");

        open("https://www.saucedemo.com/");
        System.out.println("ШАГ 1: Страница загружена");

        $("#user-name").setValue("standard_user");
        System.out.println("ШАГ 2: Логин введен");

        $("#password").setValue("secret_sauce");
        System.out.println("ШАГ 3: Пароль введен");

        $("#login-button").click();
        System.out.println("ШАГ 4: Кнопка нажата");

        $(".inventory_list").shouldBe(visible);
        System.out.println("ШАГ 5: Успешный вход подтвержден");

        sleep(2000);
        System.out.println("ТЕСТ 1 УСПЕШНО ЗАВЕРШЕН");
    }

    @Test
    void testLoginWithInvalidPassword() {
        System.out.println("ТЕСТ 2: Вход с неправильным паролем");

        open("https://www.saucedemo.com/");
        System.out.println("Страница загружена");

        $("#user-name").setValue("standard_user");
        $("#password").setValue("wrong_password");
        $("#login-button").click();

        $("[data-test='error']").shouldBe(visible);
        System.out.println("Сообщение об ошибке отображается");

        sleep(2000);
        System.out.println("ТЕСТ 2 УСПЕШНО ЗАВЕРШЕН");
    }

    @Test
    void testLoginWithLockedUser() {
        System.out.println("ТЕСТ 3: Вход заблокированным пользователем");

        open("https://www.saucedemo.com/");
        System.out.println("Страница загружена");

        $("#user-name").setValue("locked_out_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $("[data-test='error']").shouldBe(visible);
        $("[data-test='error']").shouldHave(text("Sorry, this user has been locked out"));
        System.out.println("Сообщение о блокировке отображается");

        sleep(2000);
        System.out.println("ТЕСТ 3 УСПЕШНО ЗАВЕРШЕН");
    }

    @Test
    void testSimpleGoogle() {
        System.out.println("ТЕСТ 4: Проверка Google");

        open("https://www.google.com");
        System.out.println("Google страница загружена");

        $("[name='q']").shouldBe(visible);
        System.out.println("Поле поиска найдено");

        $("[name='q']").setValue("Автоматизация тестирования");
        System.out.println("Текст введен");

        sleep(2000);
        System.out.println("ТЕСТ 4 УСПЕШНО ЗАВЕРШЕН");
    }

    @Test
    void testYandexSearch() {
        System.out.println("ТЕСТ 5: Проверка Яндекс");

        open("https://ya.ru");
        System.out.println("Яндекс страница загружена");

        $("#text").shouldBe(visible);
        System.out.println("Поле поиска найдено");

        $("#text").setValue("Дипломная работа");
        System.out.println("Текст введен");

        sleep(2000);
        System.out.println("ТЕСТ 5 УСПЕШНО ЗАВЕРШЕН");
    }
}