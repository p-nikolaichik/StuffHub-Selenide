package io.stuffhub.test.company;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CandidateCV {

    public CandidateCV() {
        $(".copy").shouldBe(visible);
    }

    public FullCandidateCV openFullCandidateCV() {
        $("span.full").click();
        return new FullCandidateCV();
    }


}
