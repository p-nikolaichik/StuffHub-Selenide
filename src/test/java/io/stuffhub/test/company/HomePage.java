package io.stuffhub.test.company;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public HomePage() {
        open("company/");
        $("div h1").shouldBe(visible);
    }

    public LoginPage openLoginPage() {
        $(by("type", "button")).click();
        return new LoginPage();
    }
}
