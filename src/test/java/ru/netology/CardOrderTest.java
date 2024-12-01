package ru.netology;

import com.WevDriverManager.chrome
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CardOrderTest {
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
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