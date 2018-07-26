package io.stuffhub.test.company;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byName;

public class ExtendedSearch {

    private ElementsCollection CVContainer = $$(byXpath("//div[contains(@class, 'col-md-8')]/div/div"));
    private SelenideElement countFoundedCV = $("div.score-result p span");
    private ElementsCollection closeButtonContainer = $$("span.close");
    private ElementsCollection genderFilterContainer = $$(byXpath("//label/input[contains(@name, 'radioGender')]"));
    private ElementsCollection readyForTripContainer = $$(byName("radioTravel"));
    private ElementsCollection foreignLanguageFilter = $$(".ng-untouched.ng-pristine.ng-valid");

    public ExtendedSearch() {
        countFoundedCV.shouldBe(visible);
        CVContainer.shouldHaveSize(Integer.parseInt(countFoundedCV.getText()));
    }

    private CandidateCV openCV(int numberCVInList) {
        CVContainer.get(numberCVInList).click();
        return new CandidateCV();
    }

    public boolean checkResultOfSearching() {
        boolean result = false;
        for (int i = 0; i < CVContainer.size(); i++) {
            FullCandidateCV fullCandidateCV = openCV(i).openFullCandidateCV();
            ArrayList<String> arrayOfSkills = fullCandidateCV.getArrayOfCandidateSkills();
            for (int j = 0; j < SearchPage.skills.size(); j++) {
                String currentSkill = SearchPage.skills.get(j);
                for (int k = 0; k < arrayOfSkills.size(); k++) {
                    if (currentSkill.toLowerCase().contains(arrayOfSkills.get(k).toLowerCase())) {
                        result = true;
                        break;
                    }
                }
            }
            fullCandidateCV.backToExtendedSearch();
        }
        return result;
    }

}
