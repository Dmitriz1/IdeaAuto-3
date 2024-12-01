package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class CardOrderTest {
    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void shouldSubmitFormSuccessfully() {
        open("http://localhost:9999");

        $("#name").setValue("Иван Иванов");
        $("#phone").setValue("+79161234567");
        $("#agreement").click();

        $("#submit").click();
    }
}