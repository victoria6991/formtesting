package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardFormTesting {

    @Test
    public void shouldSubmitForm() {
        open("http://localhost:9999/");
        SelenideElement form = $(".form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Иван Иванов");
        form.$("[data-test-id=phone] input").setValue("+79091233344");
        form.$(".checkbox__box").click();
        form.$("button").click();
        $(".paragraph.paragraph_theme_alfa-on-white").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
