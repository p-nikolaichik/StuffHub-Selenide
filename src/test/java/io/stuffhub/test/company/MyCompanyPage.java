package io.stuffhub.test.company;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MyCompanyPage {

    private SelenideElement editButton = $(".control-link");

    public MyCompanyPage() {
        editButton.shouldBe(visible);
    }

    public EditCompanyPage openEditCompanyPage() {
        editButton.click();
        return new EditCompanyPage();
    }
}
