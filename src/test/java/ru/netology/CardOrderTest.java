package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class CardOrderTest {
    @BeforeAll
    static void setup() {
        Configuration.headless = true; // Если необходимо, изменить на false для отладки
        Configuration.baseUrl = "http://localhost:9999"; // Укажите базовый URL
    }

    @Test
    void shouldSubmitOrderSuccessfully() {
        open("/"); // Открываем главную страницу приложения

        // Заполняем поля формы
        $("input[name='surname']").setValue("Иванов");
        $("input[name='name']").setValue("Иван");
        $("input[name='phone']").setValue("+79001234567");
        $("input[name='agreement']").click(); // Устанавливаем флажок

        // Отправляем форму
        $("button[type='submit']").click();

        // Проверяем успешное сообщение
        $("div.notification__content").shouldHave(text("Заявка успешно отправлена"));
    }
}