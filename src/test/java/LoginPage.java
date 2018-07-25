import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.by;

/**
 * Created by Admin2 on 24.07.2018.
 */
public class LoginPage {

    private SelenideElement emailField = $("#co-email"),
                            passwordField = $("#co-password"),
                            submitButton = $(by("type", "submit"));

    public LoginPage() {
        $("div h1").shouldBe(visible);
    }

    public CompanyPage login(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password).pressEnter();
        return new CompanyPage();
    }
}
