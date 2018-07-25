import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byXpath;

public class CandidateCV {

    public CandidateCV() {
        $(".copy").shouldBe(visible);
    }

    public FullCandidateCV openFullCandidateCV() {
        $("span.full").click();
        return new FullCandidateCV();
    }


}
