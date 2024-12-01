package ru.netology;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CardOrderTest {
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.headless = true; // Установите headless режим
        Configuration.baseUrl = "http://localhost:9999"; // или 7777 в случае использования другого порта
    }

    @Test
    public void shouldSubmitFormSuccessfully() {
        open("/"); // Открываем главную страницу

        // Заполнение полей
        $("#name").setValue("Иван Иванов");
        $("#phone").setValue("+79161234567");
        $("#agreement").click(); // Согласие

        // Отправка формы
        $("#submit").click();

        // Проверка сообщения об успехе
        $(".notification").shouldHave(text("Заявка отправлена успешно"));
    }
}