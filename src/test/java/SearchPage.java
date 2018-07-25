import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private static int countOfSkills = 0;
    public static String city;
    public static ArrayList<String> skills;

    public SearchPage() {
        $("div h1").shouldBe(visible);
        skills = new ArrayList<>();
    }

    public SearchPage addSkill(String skill) {
        $(by("role", "combobox")).setValue(skill);
        $(".btn.btn-secondary").click();
        $$(".col.co-skills").shouldHaveSize(++countOfSkills);
        skills.add(skill);
        return this;
    }

    public SearchPage addCity(String city) {
        $(byName("city")).setValue(city);
        return this;
    }

    public ExtendedSearch searchProfile() {
        $(by("type", "submit")).click();
        return new ExtendedSearch();
    }
}
