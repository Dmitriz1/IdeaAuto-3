package ru.netology;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void testOrderForm() {
        // Открытие страницы приложения
        open("http://localhost:9999");

        $("input[name='name']").setValue("Иван Иванов");
        $("input[name='phone']").setValue("+71231231234");
        $("[data-test-id='agreement']").click();
        $(By.className("button")).click();

        String text = $(By.className("alert-success")).getText();
        assertEquals("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }
}
