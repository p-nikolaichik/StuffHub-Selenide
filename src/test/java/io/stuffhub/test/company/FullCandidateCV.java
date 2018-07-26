package io.stuffhub.test.company;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FullCandidateCV {

    public FullCandidateCV() {
        $("div.row.top-pan div p").shouldBe(visible);
    }

    public ArrayList<String> getArrayOfCandidateSkills() {
        List<SelenideElement> listOfSkills = new ArrayList<>($$(".skill-name.text-bold"));
        List<SelenideElement> listOfTechnologies = new ArrayList<>($$(byXpath("//div[contains(@class, 'other-skills')]/span")));
        listOfSkills.addAll(listOfTechnologies);

        ArrayList<String> skills = new ArrayList<>();
        for (SelenideElement element : listOfSkills) {
            skills.add(element.getText());
        }
        return skills;
    }

    public ExtendedSearch backToExtendedSearch() {
        $("span span").click();
        return new ExtendedSearch();
    }

}
