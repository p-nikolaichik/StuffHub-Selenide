package io.stuffhub.test.company;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class EditCompanyPage {

    public EditCompanyPage() {
        $(".avatar.avatar--full.avatar--no-border").shouldBe(visible);
    }

    public MyCompanyPage setCompanyInfo(String[] infoArray) {
        $(by("formcontrolname", "name")).setValue(infoArray[0]);
        $(by("ng-reflect-name", "website")).setValue(infoArray[1]);
        $(by("formcontrolname", "email")).setValue(infoArray[2]);
        $(by("formcontrolname", "phoneNumber")).setValue(infoArray[3]);
        $("textarea").setValue(infoArray[4]);
        $(by("placeholder", "Год")).setValue(infoArray[5]);
        $(by("formcontrolname", "employeeAmount")).setValue(infoArray[6]);
        $(by("formcontrolname", "technicalSpecialistsAmount")).setValue((infoArray[7]));
        $(by("formcontrolname", "specialization")).setValue((infoArray[8]));
        $(by("formcontrolname", "description")).setValue((infoArray[9]));
        $("div.form__row.ta-center button").click();
        return new MyCompanyPage();
    }
}
