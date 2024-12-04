package ru.netology;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CardOrderTest {
    @Test
    public void testOrderForm() {
        // Открытие страницы приложения
        open("http://localhost:9999");

        $("input[name='name']").setValue("Иван Иванов");
        $("input[name='phone']").setValue("+71231231234");
        $("[data-test-id='agreement']").click();
        $(By.className("button")).click();

        $("[data-test-id='order-success']").shouldHave(text("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));
    }
}
